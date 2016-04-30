package com.complexite.love;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Tabucol {
	public Tabucol(){
		
	}
	public  Map<Integer, Noeud> calculer(int matriceAdjacence[][]){
    	//Initialisation
    	Map<Integer, Noeud> noeuds = new HashMap<Integer, Noeud>();
    	int taille = matriceAdjacence[0].length;
    	//int nbCouleurMax = calculNombreChromatique(matriceAdjacence);
    	int nbCouleur=1;
    	int nbConflitCourant=0;
    	boolean modification;
    	//Colorier les noeuds du graphe de maniÃ¨re arbitraire
    	int couleurAleatoire = 1;
    	for (int i=0;i<taille;i++){
    		Noeud noeud = new Noeud();
    		noeud.setNumeroNoeud(i);
    		noeud.setCouleurCourante(couleurAleatoire);
			noeuds.put(i, noeud);
		}
    	//On calcul le nombre de conflit présent dans le graphe créer aléatoirement
    	nbConflitCourant = calculLeNombreDeConflit(noeuds,matriceAdjacence,nbCouleur);
    	int nbCompteurTaboue=0;
    	int couleurTampon;
    	int nbConflitCourant1;
    	
    	//Et on commence la boucle itérative qui s'arrête quand il n'y a plus de conflits
    	while(nbConflitCourant>0){
    		
	    	//Si le compteur taboue atteint les 10 itérations alors on vide les liste de tabou de chaque noeuds	
	    	if(nbCompteurTaboue==10){
	    		for(int i=0;i<noeuds.size();i++){
	        		noeuds.get(i).getListeCouleurTaboue().clear();
	        	}
	    		//Et on incrémente le nombre de couleur
	    		nbCouleur++;
	    	}
	    	
	  
	    	
	    	
	    	modification=false;
	    	
	    	LeMeilleurChoixPossible lmcp= new LeMeilleurChoixPossible();
	    	//Pour chaque noeuds nous allons chercher le meilleur choix possible pour diminier le nombre de conflits
	    	for (int i=0;i<noeuds.size();i++){
	    		//On calcul le nombree de conflit présent sur le noeud i 
	    		nbConflitCourant1 = nombreDeConflitAssocieAuNoeud(noeuds.get(i),matriceAdjacence,noeuds);
	    		//Si ce nombre de conflit est supérieur a 0 
	    		if(nbConflitCourant1>0){
	    			//Alors on initialise le meilleur choix possible avec les valeurs courantes
		    		lmcp.setCouleur(noeuds.get(i).getCouleurCourante());
		    		lmcp.setNbConflit(nbConflitCourant1);
		    		//Pour chaque couleur 
		    		for(int j=1;j<=nbCouleur;j++){
		    			//On sauvegarde dans un tampon la couleur iniale du noeud pour pouvoir l'ajouter dans les couleurs tabou si il y à un changement
		    			couleurTampon = noeuds.get(i).getCouleurCourante();
		    			//On regarde si cette couleur j est dans les couleurs tabous du noeud
		    			if(!noeuds.get(i).getListeCouleurTaboue().contains(j)){
		    				//Si ce n'est pas le cas on test cette couleur sur ce noeud
		    				noeuds.get(i).setCouleurCourante(j);
		    				//Et on calcul le nombre de conflit
		    				nbConflitCourant1 = nombreDeConflitAssocieAuNoeud(noeuds.get(i),matriceAdjacence,noeuds);
		    				//Si le nombre de conflit avec cette couleur est inférieur au nombre de conflit du meilleur choix courant
		    				if(nbConflitCourant1<lmcp.getNbConflit()){
		    					//Alors on update le meilleur choix courant
		    					lmcp.setNbConflit(nbConflitCourant1);
		    					lmcp.setCouleur(j);
		    					lmcp.setCouleurTampon(couleurTampon);
		    					//On notifie qu'il y a eu une modification
		    					modification=true;
		    					}
		    				}
		    				
		        		}
		    		//lorsque l'on a fait cette procédure sur toutes les couleurs on modifie la couleur du noeud avec 
		    		noeuds.get(i).setCouleurCourante(lmcp.getCouleur());
		    		noeuds.get(i).getListeCouleurTaboue().add(lmcp.getCouleurTampon());
	        	}
	    	
	    	}
	    	//Si il n'y à pas eu de modification on incrémente le compteur taboue
	    	if(modification==false){
	    		nbCompteurTaboue++;	
	    	}
	    	//A la fin de cette itération on recalcul le nombre de conflits
	    	nbConflitCourant=calculLeNombreDeConflit(noeuds,matriceAdjacence,nbCouleur);
    	}
    	
    	
   
  	return noeuds;
    }
    public static int calculLeNombreDeConflit(Map<Integer, Noeud> noeuds,int matriceAdjacence[][],int nbCouleurMax){
    	int nbConflits=0;
   
    	ArrayList<Integer> couleursDesVoisins = new ArrayList<Integer>();
    	for(int i=0;i<noeuds.size();i++){
    		for (int j=0;j<noeuds.size();j++){
    			
    			if(matriceAdjacence[i][j]==1 && i != j){
    				if(noeuds.get(j).getCouleurCourante()==noeuds.get(i).getCouleurCourante()  ){
    					nbConflits++;
    			
    					
    				}
    			}
    		}
    	}
    	return nbConflits;
    }
    
    public static int nombreDeConflitAssocieAuNoeud(Noeud noeud,int matriceAdjacence[][],Map<Integer, Noeud> noeuds){
    	int nombreConflit=0;
    	int nbNoeud = matriceAdjacence[0].length;
     	for(int i=0;i<nbNoeud;i++){
     		if(matriceAdjacence[noeud.getNumeroNoeud()][i]==1 && noeud.getNumeroNoeud() != i){
    			if(noeud.getCouleurCourante()==noeuds.get(i).getCouleurCourante()  ){
    				nombreConflit++;
    			}
     		}
     	}
    	 return nombreConflit;
     }

}
