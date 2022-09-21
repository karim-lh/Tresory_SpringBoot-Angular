package com.siga.domain;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("recette")
public class Recette extends MouvementTresorerie implements  Serializable {

}
