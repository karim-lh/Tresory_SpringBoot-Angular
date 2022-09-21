package com.siga.web.rest.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DecisionUtilMouvement extends Object{
	public static Map<String, Object> getSteps(String decision) {
		Map<String, Object> decisions = new HashMap<String, Object>(); 
		List<String> steps = new ArrayList<String>();
		if("Avis chef service trésorie".equalsIgnoreCase(decision))
		{
			steps.add("accord");
			steps.add("rejet");
			steps.add("ci");
			decisions.put("steps", steps);
			decisions.put("gateway", "decision");
		}
		else if("Signature directeur financier".equalsIgnoreCase(decision))
		{
			steps.add("signature");
			steps.add("rejet");
			steps.add("ci");
			decisions.put("steps", steps);
			decisions.put("gateway", "decision");
		}
		return decisions;
	}
	
	public static Status getStatus(String decision) {
		List<Status> status = Arrays.asList(new Status("E","Demande"),
				new Status("E","CI"), new Status("E","ACCORD"), 
				new Status("E","Retour ci"),
				new Status("E","Retour ci"), 
				new Status("R","REJET"), new Status("C","Signature"), new Status("C","CLOTURE"));

		Status result = status.stream()				   // Convert to steam
			.filter(x -> decision.equals(x.getLabel()))	// we want specific decision only
			.findAny()									// If 'findAny' then return found
			.orElse(null);
		return result;
	}
}
