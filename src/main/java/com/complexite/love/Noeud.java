package com.complexite.love;

import java.util.ArrayList;

public class Noeud {
	int couleurCourante;
	int numeroNoeud;
	int degresDeSaturation;
	int degres;
	ArrayList<Integer> listeCouleurDejaUtilisee = new ArrayList<Integer>();
	ArrayList<Integer> listeCouleurTaboue = new ArrayList<Integer>();
	ArrayList<CompteurIteration> listeCompteur = new ArrayList<CompteurIteration>();
	int dureeDuTabou=10;
	
	public ArrayList<CompteurIteration> getListeCompteur() {
		return listeCompteur;
	}

	public void setListeCompteur(ArrayList<CompteurIteration> listeCompteur) {
		this.listeCompteur = listeCompteur;
	}

	public int getDureeDuTabou() {
		return dureeDuTabou;
	}

	public void setDureeDuTabou(int dureeDuTabou) {
		this.dureeDuTabou = dureeDuTabou;
	}

	public ArrayList<Integer> getListeCouleurTaboue() {
		return listeCouleurTaboue;
	}

	public void setListeCouleurTaboue(ArrayList<Integer> listeCouleurTaboue) {
		this.listeCouleurTaboue = listeCouleurTaboue;
	}
	
	public void addCouleurTaboue(int couleur){
		this.getListeCouleurTaboue().add(couleur);
		CompteurIteration ci = new CompteurIteration();
		ci.setCouleur(couleur);
		ci.setNbIteration(0);
		this.listeCompteur.add(ci);
	}
	public void incrementAllCompteur(){
		int tampon;
		for (int j=0;j<this.listeCompteur.size();j++){
		
			
			tampon = this.listeCompteur.get(j).getNbIteration();
			tampon++;
			if(tampon<dureeDuTabou)
				this.listeCompteur.get(j).setNbIteration(tampon);
				
			else{
				System.out.println("j'ai remove des compteurs lol");
				this.listeCouleurTaboue.remove(new Integer(listeCompteur.get(j).getCouleur()));
				this.listeCompteur.remove(j);
				
			}
		}
	}
	
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
