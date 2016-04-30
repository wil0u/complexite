package com.complexite.love;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Dsatur {

	public Dsatur(){
		
	}
	
	public  Map<Integer, Noeud> calculer(int matriceAdjacence[][]){
	 	//Initialisation
	 	int degresDeSaturationMaxCourant=0;
	 	int degresLePlusEleve=0;
	 	ArrayList<Noeud> noeudsParDegresDeSaturation = new ArrayList<Noeud>();
	 	ArrayList<Integer> couleursDesVoisins = new ArrayList<Integer>();
	 	Map<Integer, Noeud> noeuds = new HashMap<Integer, Noeud>();
	 	int taille = matriceAdjacence[0].length;
	 	int couleurTrouvee;
	 	int indexNoeud;
	 	int nbCouleur=1;
	 	
	 	
	 	//On créer la liste de noeud tout en calculant le degres de chaque noeud
	 	int degresDuNoeud;
	 	for (int i=0;i<taille;i++){
	 		Noeud noeud = new Noeud();
	 		degresDuNoeud=0;
	 		for(int j=0;j<taille;j++){
	     		
	     		
	     		
	     			//Si il y a un arc entre i et j et que i est diffÃ©rent de j alors
	     			if(matriceAdjacence[i][j]==1 && i != j){
	     				degresDuNoeud++;
	     			}
	 		}
	 			noeud.setDegres(degresDuNoeud);
	 			noeud.setNumeroNoeud(i);
				noeuds.put(i, noeud);
			}
	 	
	 	
	 	
	 	//Pour chaque noeuds de la liste
	 	for (int i=0;i<noeuds.size();i++){
	 	
	 		
	 		//On calcul le degres de saturation max courant pour les noeuds non colorié
	 		degresDeSaturationMaxCourant=calculLeDegresDeSaturationMaxDuGraphEtDeChaqueNoeud(noeuds,matriceAdjacence);
	 		
	 		//Ensuite on récupère ces noeuds encore non colorié qui possède ce degres de saturation
	 		noeudsParDegresDeSaturation=getNoeudsByDegresDeSaturation(noeuds,degresDeSaturationMaxCourant);
	 		
	 		//Si il y a des égalités (En gros si on récupère plus d'un noeud) : 
	 		if(noeudsParDegresDeSaturation.size()>1){
	 			// Alors pn priorise par degres le plus eleve
	 			
	 			//Calcul du degres le plus eleve des noeuds présent dans la liste récupérées 
	 			degresLePlusEleve=calculDegresLePlusEleve(noeudsParDegresDeSaturation);
	 			//Puis on choisi le premier noeud avec ce degres dans la liste
	 			indexNoeud=getIndexNoeudByDegres(noeudsParDegresDeSaturation,degresLePlusEleve); 
	 			
	 			//On récupère la couleur de ces voisins 
	 			couleursDesVoisins = getCouleursDesVoisins(noeuds,matriceAdjacence,indexNoeud); 
	 			//Puis on choisi une couleur non encore utilisé par ses voisins 
	 			couleurTrouvee=getCouleurLaPlusPetiteDisponible(couleursDesVoisins,nbCouleur);
	 			//Si la couleur est égale a -1, donc qu'elle est inférieur a 0
	 			//Cela signifie que toutes les couleurs sont prises
	 			if(couleurTrouvee<0){
	 				//Il faut donc incrémenter le nombre de couleur
	 				nbCouleur++;
	 				//Et on colorie le noeud avec la couleur ajoutée 
	 				noeuds.get(indexNoeud).setCouleurCourante(nbCouleur);
	 			}else{
	 				//Sinon (si il existe une couleur disponible) alors
	 				//On colorie le noeud
	 				noeuds.get(indexNoeud).setCouleurCourante(couleurTrouvee);
	 			}
	 		}
	 		//Sinon si il n'y a qu'un seul noeud
	 		else if(noeudsParDegresDeSaturation.size()==1){
	 			//Pas besoin de priorisé, on fait directement le traitement.
	 			indexNoeud=noeudsParDegresDeSaturation.get(0).getNumeroNoeud();
	 			couleursDesVoisins = getCouleursDesVoisins(noeuds,matriceAdjacence,indexNoeud); 
	 			couleurTrouvee=getCouleurLaPlusPetiteDisponible(couleursDesVoisins,nbCouleur);
	 			
	 			if(couleurTrouvee<0){
	 				nbCouleur++;
	 				noeuds.get(indexNoeud).setCouleurCourante(nbCouleur);
	 			}else
	 				noeuds.get(indexNoeud).setCouleurCourante(couleurTrouvee);
	 		}
	 	
	 	}

	 	return noeuds;
	 }
	
    public static ArrayList<Integer> getCouleursDesVoisins(Map<Integer, Noeud> noeuds,int matriceAdjacence[][],int indexNoeud){
    	ArrayList<Integer> couleursDesVoisins = new ArrayList<Integer>();
    	for (int j=0;j<noeuds.size();j++){
    		
    		if(matriceAdjacence[indexNoeud][j]==1&& indexNoeud !=j && noeuds.get(j).getCouleurCourante()!=0){
    			couleursDesVoisins.add(noeuds.get(j).getCouleurCourante());
    			
    		}
    	}
    	
    	return couleursDesVoisins;
    }
	   public static int calculLeDegresDeSaturationMaxDuGraphEtDeChaqueNoeud(Map<Integer, Noeud> noeuds,int matriceAdjacence[][]){
	    	int degresDeSaturationMax=0;
	    	int degresDeSaturationDuNoeud;
	    	
	    	for(int i=0;i<noeuds.size();i++){
	    		degresDeSaturationDuNoeud=0;
	    		if(noeuds.get(i).getCouleurCourante()==0){
		    		for (int j=0;j<noeuds.size();j++){
		    			//Si il y a un arc entre i et j et que i est diffÃ©rent de j alors
		    			if(matriceAdjacence[i][j]==1 && i != j){
		    				//Si le noeud j a une couleur 
		    			
		    				if(noeuds.get(j).getCouleurCourante()!= 0  ){
		    					
		    					degresDeSaturationDuNoeud++;
		    				}
		    			}
		    		}
		    		noeuds.get(i).setDegresDeSaturation(degresDeSaturationDuNoeud);
		    		//Si le degres du noeud i est supÃ©rieur au degres max
		    		if (degresDeSaturationDuNoeud>degresDeSaturationMax ){
		    			degresDeSaturationMax=degresDeSaturationDuNoeud;
		    		}
	    		}
	    	}
	    	
	    	return degresDeSaturationMax;
	    }
	   
	   
	   public static ArrayList<Noeud> getNoeudsByDegresDeSaturation(Map<Integer, Noeud> noeuds,int degresDeSaturationMax){
	    	ArrayList<Noeud> noeudsDegresDeSaturation = new ArrayList<Noeud>();
	    	for (int i=0;i<noeuds.size();i++){
	    		if(noeuds.get(i).getDegresDeSaturation()==degresDeSaturationMax && noeuds.get(i).getCouleurCourante()==0){
	    			
	    			noeudsDegresDeSaturation.add(noeuds.get(i));
	    		}
			}
	    	
	    	
	    	return noeudsDegresDeSaturation;
	    }
	   
	    public static int calculDegresLePlusEleve(ArrayList<Noeud> noeudsParDegresDeSaturation){
	    	int degresLePlusEleve=0;
	    	
	    	for (int i=0;i<noeudsParDegresDeSaturation.size();i++){    		
	    			if(noeudsParDegresDeSaturation.get(i).getDegres()>degresLePlusEleve){
	    				degresLePlusEleve=noeudsParDegresDeSaturation.get(i).getDegres();
	    			}
	    		}
	    	return degresLePlusEleve;
	    	}
	    
	    public static int getIndexNoeudByDegres(ArrayList<Noeud> noeudsParDegresDeSaturation, int degres){
	    	for(int i=0;i<noeudsParDegresDeSaturation.size();i++){
	    		if (noeudsParDegresDeSaturation.get(i).getDegres()==degres){
	    			return noeudsParDegresDeSaturation.get(i).getNumeroNoeud();
	    		}
	    	}
	    
	    	return -1;
	    
	    }
	    public static int getCouleurLaPlusPetiteDisponible(ArrayList<Integer> couleursDesVoisins,int nbCouleurMax){
	    	for(int i=1;i<=nbCouleurMax;i++){
	    		if (!couleursDesVoisins.contains(i)){
	    			return i;
	    		}
	    	}
	    	return -1;
	    
	    }
	    	
}
