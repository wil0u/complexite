package com.complexite.love;

import java.util.ArrayList;

public class Noeud {
	int couleurCourante;
	int numeroNoeud;
	int degresDeSaturation;
	int degres;
	ArrayList<Integer> listeCouleurDejaUtilisee = new ArrayList<Integer>();
	
	
	public int getDegres() {
		return degres;
	}

	public void setDegres(int degres) {
		this.degres = degres;
	}

	public int getCouleurCourante() {
		return couleurCourante;
	}

	public int getDegresDeSaturation() {
		return degresDeSaturation;
	}


	public void setDegresDeSaturation(int degresDeSaturation) {
		this.degresDeSaturation = degresDeSaturation;
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

	
	
	
	public Noeud(int numeroCouleur, int numeroNoeud) {
		super();
		this.couleurCourante = numeroCouleur;
		this.numeroNoeud = numeroNoeud;
	}
	
	
	public Noeud() {
		this.couleurCourante=0;
	}


	
	public int getNumeroNoeud() {
		return numeroNoeud;
	}
	public void setNumeroNoeud(int numeroNoeud) {
		this.numeroNoeud = numeroNoeud;
	}



}
