package com.complexite.love;

import java.util.ArrayList;

public class NoeudCouleur {
	int couleurCourante;
	int numeroNoeud;
	ArrayList<Integer> listeCouleurDejaUtilisee = new ArrayList<Integer>();
	
	public int getCouleurCourante() {
		return couleurCourante;
	}


	public void setCouleurCourante(int couleurCourante) {
		this.couleurCourante = couleurCourante;
		if(couleurCourante!=0)
			this.listeCouleurDejaUtilisee.add(couleurCourante);
	}


	public ArrayList<Integer> getListeCouleurDejaUtilisee() {
		return listeCouleurDejaUtilisee;
	}


	public void setListeCouleurDejaUtilisee(ArrayList<Integer> listeCouleurDejaUtilisee) {
		this.listeCouleurDejaUtilisee = listeCouleurDejaUtilisee;
	}

	
	
	
	public NoeudCouleur(int numeroCouleur, int numeroNoeud) {
		super();
		this.couleurCourante = numeroCouleur;
		this.numeroNoeud = numeroNoeud;
	}
	
	
	public NoeudCouleur() {
		this.couleurCourante=0;
	}


	
	public int getNumeroNoeud() {
		return numeroNoeud;
	}
	public void setNumeroNoeud(int numeroNoeud) {
		this.numeroNoeud = numeroNoeud;
	}

}