package com.siga.web.rest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.siga.domain.ModePaiement;
import com.siga.domain.MouvementTresorerie;
import com.siga.domain.PiecePaiementMvt;
import com.siga.repository.ModePaiementRepository;
import com.siga.repository.MouvementTresorerieRepository;
import com.siga.repository.PiecePaiementMvtRepository;

@RestController
@RequestMapping("/api")
public class RestPiecePaiementController {


	@Autowired
	private PiecePaiementMvtRepository piecePaiementMvtRepository;
	@Autowired
	private MouvementTresorerieRepository mvtRepository;
	
	@Autowired
	private ModePaiementRepository modePaiementRepository;
	
	@GetMapping("/mode-paiement")
	public List<ModePaiement> getAllModePaiement()
	{
		try
		{
			return modePaiementRepository.findAll();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value="/piecePaiementMvt",method=RequestMethod.POST)
	public ResponseEntity <PiecePaiementMvt> savePiecePaiementMvt(@RequestBody PiecePaiementMvt piecePaiementMvt)
	{
		MouvementTresorerie mvt=piecePaiementMvt.getMouvementTresorerie();
		
		float montantDevise=piecePaiementMvt.getMontantDevise();
		float taux=mvt.getTauxChangeMouvement();
		float montantLocal=montantDevise*taux;
		piecePaiementMvt.setMontantdeviseLocal(montantLocal);
		
		float sold=mvt.getSold()-montantLocal;
		
		mvt.setSold(sold);
		mvtRepository.save(mvt);
		Date dateCreation=new Date();
		if (mvt.getDevise()!=null)
			piecePaiementMvt.setDevise(mvt.getDevise());
		piecePaiementMvt.setDateCreationPieceMVt(dateCreation);
		PiecePaiementMvt result= piecePaiementMvtRepository.save(piecePaiementMvt);
		return new ResponseEntity<PiecePaiementMvt>(result,HttpStatus.CREATED);
		
		
	}
	
	@RequestMapping(value="/piecePaiementMvt",method=RequestMethod.GET)
	public ResponseEntity<List<PiecePaiementMvt>> findAllPiecesPaiementMvt()
	{
		
		List <PiecePaiementMvt> societies=piecePaiementMvtRepository.findAll();
		return new ResponseEntity<List<PiecePaiementMvt>> (societies,HttpStatus.OK);
	}
	
	@RequestMapping(value="/piece-depense",method=RequestMethod.GET)
	public ResponseEntity<List<PiecePaiementMvt>> getALlPieceDepense()
	{
		
		List <PiecePaiementMvt> societies=piecePaiementMvtRepository.findAllByTypeMouvement("depense");
		return new ResponseEntity<List<PiecePaiementMvt>> (societies,HttpStatus.OK);
	}
	
	@RequestMapping(value="/piece-recette",method=RequestMethod.GET)
	public ResponseEntity<List<PiecePaiementMvt>> getALlPieceRecette()
	{
		
		List <PiecePaiementMvt> societies=piecePaiementMvtRepository.findAllByTypeMouvement("recette");
		return new ResponseEntity<List<PiecePaiementMvt>> (societies,HttpStatus.OK);
	}
	

	@RequestMapping(value="/piecePaiementMvt",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteAll()
	{
	
		piecePaiementMvtRepository.deleteAll();
		return new ResponseEntity<String>("All deleted succfully.",HttpStatus.ACCEPTED);
		
	}
	
	
	
	
	@RequestMapping(value="/piecePaiementMvt/{idPiecePaiementMvt}",method=RequestMethod.DELETE)
	public ResponseEntity<PiecePaiementMvt> deletePiecePaiementMvt(@PathVariable ("idPiecePaiementMvt")  Long idPiecePaiementMvt)
	{
		
		piecePaiementMvtRepository.delete(idPiecePaiementMvt);
		return new ResponseEntity<PiecePaiementMvt>(HttpStatus.ACCEPTED);
		
	}
	
	
	@RequestMapping(value="/piecePaiementMvt/{idPiecePaiementMvt}",method=RequestMethod.GET)
	public ResponseEntity <PiecePaiementMvt> findOne(@PathVariable ("idPiecePaiementMvt") Long idPiecePaiementMvt)
	{
		
		PiecePaiementMvt result=piecePaiementMvtRepository.findOne(idPiecePaiementMvt);
		return new ResponseEntity<PiecePaiementMvt>(result,HttpStatus.ACCEPTED);
	}
}
