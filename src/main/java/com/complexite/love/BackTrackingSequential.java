package com.complexite.love;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class BackTrackingSequential {

	
	
	public BackTrackingSequential(){
		
	}
	
	public Map<Integer, Noeud> calculer(int[][] matriceAdjacence){
		//On peut faire cela car il s'agit d'une matrice carré.
		int nbNoeuds = matriceAdjacence[0].length;
		//On calcul le nombre de couleur max du graphe définit par la matrice d'adjacence.
		int nbCouleurMax = calculNombreChromatiqueMax(matriceAdjacence);
		//Nombre de couleur de départ.
		int nbCouleurCourante = 1;
		//Liste qui va contenir les noeuds du graphe. On leur attribut une position dans la liste. En sortit de l'algorithme les noeuds contiendront une couleur.
		Map<Integer, Noeud> noeuds = new HashMap<Integer, Noeud>();
		//Initialisation de la liste de noeuds dans l'ordre de la matrice d'adjacence. (Le noeud 1 de la matrice d'adjacence est le noeud 1 de la liste.
		for (int i=0;i<nbNoeuds;i++){
    		Noeud noeud = new Noeud();
			noeuds.put(i,noeud);
		}
		//Ensuite on appelle récursivement l'algorithme 
		
		algoRecursifBacktracking2(noeuds,matriceAdjacence,nbCouleurCourante,nbCouleurMax);
			return noeuds;
		
		
	}
	
	

    public static void   algoRecursifBacktracking2(Map<Integer, Noeud> noeuds,int matriceAdjacence[][],int nbCouleurCourante,int nbCouleurMax){
		//On récupère l'index du noeud courant : Donc le noeud courant !
    	
    	
    	
    	//Retour arrière si il n'y à pas de solution.
    	while(areAllColored(noeuds)==false){
    		int indexNoeudCourant = getPremierNoeudNonColorier(noeuds);
	    	if(noeuds.get(indexNoeudCourant).getListeCouleurDejaUtilisee().size()>=nbCouleurCourante){
	    		
	    		if(indexNoeudCourant==0){
	    			
	    			//Celà veut dire que toutes les solution on étaient testé avec ce nombre de couleur sans succès, donc il faut incrémenter le nombre de couleur courante
	    			nbCouleurCourante++;
	    			
	    			//On vide la liste de couleurs deja utilisées pour le noeud 0
	    			noeuds.get(indexNoeudCourant).getListeCouleurDejaUtilisee().clear();
	    			//Puis on relance l'algorithme dans cette configuration.
	    			algoRecursifBacktracking2(noeuds,matriceAdjacence,nbCouleurCourante,nbCouleurMax);
	    			
	    		}
	    		if(indexNoeudCourant>0){	//Sinon on décolore le noeuds d'avant dans la liste
		    		noeuds.get(indexNoeudCourant-1).setCouleurCourante(0);
		    		//On vide la liste des couleur déjà utilisée du noeud courant
		    		noeuds.get(indexNoeudCourant).getListeCouleurDejaUtilisee().clear();
		    		//Puis on relance l'algorithme dans cette configuration.

	    		}
	    	}else{
    	
    	//On colorie le noeud avec la Première couleur non encore tester sur le noeud
	    	
	    	
	    	noeuds.get(indexNoeudCourant).setCouleurCourante(getNumeroCouleurNonEncoreUtilisee(noeuds,indexNoeudCourant,nbCouleurCourante));
	    	

        
    	    	//On regarde si après la coloration du noeud, la coloration est respectée.
    	if(isConditionRespectee(matriceAdjacence,noeuds,indexNoeudCourant)==false){

    		   		
    	    		//Si ce n'est pas le cas, on décolore le noeud.
    	    		noeuds.get(indexNoeudCourant).setCouleurCourante(0);
    	    		//Puis on relance l'algo récursif.
    	    		
    		}
		
    
    			
    	}	
    	}
    }
	
	 private static boolean areAllColored(Map<Integer, Noeud> noeuds) {
		 int compteurDeNoeudColorier=0;
	    	for (int i=0;i<noeuds.size();i++){
	    		//On check si la couleur est différente de la couleur neutre.
	    		if( noeuds.get(i).getCouleurCourante() > 0  ){
	    			compteurDeNoeudColorier++;
	    		}
	    	}
	    	//Si le nombre de noeuds est égale au compteur alors on renvoie true..
	    	if(compteurDeNoeudColorier==noeuds.size())
	    		return true;
	    	
	    	else
	    		return false;
	}

	private static boolean isConditionRespectee(int[][] matriceAdjacence, Map<Integer, Noeud> noeuds,
			int indexNoeudCourant) {
		 int nbNoeud = matriceAdjacence[0].length;
		 	for (int j=0;j<nbNoeud;j++){
		    	
				if(matriceAdjacence[indexNoeudCourant][j]==1&&indexNoeudCourant !=j){
					
					if(noeuds.get(j).getCouleurCourante()==noeuds.get(indexNoeudCourant).getCouleurCourante() ){
				
						return false;
						
					}
					
					
				}
			}
		 	return true;
	}

	private static int getPremierNoeudNonColorier(Map<Integer, Noeud> noeuds) {
		 if(noeuds.isEmpty()){
			 return -1;
		 }
		 for(int i=0;i<noeuds.size();i++){
			 if(noeuds.get(i).getCouleurCourante()==0){
				 return i;
			 }
		 }
		return -1;
	}
	 
	 
	 public static ArrayList<Noeud> getListeDeNoeudNonColorier(ArrayList<Noeud> noeuds){
		 if(!noeuds.isEmpty()){
			 return null;
		 }
		 for (int i=0;i<noeuds.size();i++ )
			 if(noeuds.get(i).getCouleurCourante() !=0)
				 noeuds.remove(noeuds.get(i));
		 return noeuds;
	 }
	 
	 
	public static int calculNombreChromatiqueMax(int matriceAdjacence[][]){
	    	int taille;
	    	int nombreChromatique=0;
	    	int degresLePlusEleve;
	    	//Recupère la taille de la ligne 0 de la matrice, étant donné qu'il s'agit d'une matrice carré : on recupère en fait la taille de la matrice. 
	    	taille = matriceAdjacence[0].length;
	    	
	    	for (int i=0;i<taille;i++){
	    		degresLePlusEleve=0;
	    		for (int j=0;j<taille;j++){
	    			if(matriceAdjacence[i][j]==1){
	    				degresLePlusEleve++;
	    			}
	    		}
	    		if(degresLePlusEleve>nombreChromatique)
	    			nombreChromatique=degresLePlusEleve;
	    	}
	    	
	    	
	    	return nombreChromatique;
	    }
	
	public static int getNumeroCouleurNonEncoreUtilisee(Map<Integer, Noeud> noeuds, int noeudCourant,int nbCouleurMax){
    	for(int i=1;i<=nbCouleurMax;i++){
    		if (noeuds.get(noeudCourant).getListeCouleurDejaUtilisee().contains(i)==false){
    			return i;
    		}
    	}
    	return -1;
    
    }
}
