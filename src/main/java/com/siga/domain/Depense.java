package com.siga.domain;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("depense")
public class Depense extends MouvementTresorerie implements  Serializable {

	
}
