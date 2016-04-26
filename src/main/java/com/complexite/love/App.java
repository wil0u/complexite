package com.complexite.love;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import com.mxgraph.view.mxGraph;

import javax.swing.JButton;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.JScrollPane;


public class App 
{
	static JScrollPane scrollPane = new JScrollPane();
    static JPanel fenetreCalcul = new JPanel();
    public static void main( String[] args )
    {
    		
/**==================================================== Edition generale de la fenetre =================================================**/
    		// Création de la variable fenetre
    		JFrame fenetre = new JFrame();
    		
    	    //Titre de la fenetre
    	    fenetre.setTitle("Coloration de Graphe");
    	    
    	    // Taille de la fenetre
    	    fenetre.setSize(700, 400);
    	    
    	    //Positionnement de la fenetre au centre
    	    fenetre.setLocationRelativeTo(null);
    	    
    	    // Croix rouge de la fenetre effective
    	    fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	    
    	    // Permet à la fenetre d'accepter les onglets
    	    JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
    	    fenetre.getContentPane().add(tabbedPane, BorderLayout.CENTER);

 /**==================================================== Edition fenetre Calcul ========================================================**/    	    
    	    //Création de l'onglet fenetreCalcul

    	    tabbedPane.addTab("Calcul", null, fenetreCalcul, null);
    	    fenetreCalcul.setLayout(new BorderLayout(0, 0));
    	    
    	    
    	    // Panel permettant de faire un vide sur la gauche
    	    JPanel panelVideGauche = new JPanel();
    	    fenetreCalcul.add(panelVideGauche, BorderLayout.WEST); 	    
    	    JLabel lblVideGauche = new JLabel("                               ");
    	    panelVideGauche.add(lblVideGauche);
    	    
    	    
    	    // Panel permettant de faire un vide sur la droite
    	    JPanel panelVideDroite = new JPanel();
    	    fenetreCalcul.add(panelVideDroite, BorderLayout.EAST);    	    
    	    JLabel lblVideDroite = new JLabel("                               ");
    	    panelVideDroite.add(lblVideDroite);
    	    
    	    
    	    // Panel de lancement se trouvant en bas de la fenêtre
    	    JPanel panelConfirmer = new JPanel();
    	    fenetreCalcul.add(panelConfirmer, BorderLayout.SOUTH);
    	    
    	    JLabel lblConfirmerLancement = new JLabel("Lancement               ");
    	    panelConfirmer.add(lblConfirmerLancement);
    	    
    	    JButton btnConfirmerBSC = new JButton("     BSC     ");
    	    panelConfirmer.add(btnConfirmerBSC);
    	    
    	    JLabel lblConfirmerVide01 = new JLabel("               ");
    	    panelConfirmer.add(lblConfirmerVide01);
    	    
    	    JButton btnConfirmerDSATUR = new JButton(" DSATUR ");
    	    panelConfirmer.add(btnConfirmerDSATUR);
    	    
    	    JLabel lblConfirmerVide02 = new JLabel("               ");
    	    panelConfirmer.add(lblConfirmerVide02);
    	    
    	    JButton btnConfirmerTABUCOL = new JButton("TABUCOL");
    	    panelConfirmer.add(btnConfirmerTABUCOL);
    	    
    	    
    	    
    	    
    	    
    	   
    	    
    	    
/**==================================================== Edition fenetre Graphe ========================================================**/
    	    
    	  //Création de l'onglet fenetreGraphe
    	    JPanel fenetreGraphe = new JPanel();
    	    tabbedPane.addTab("Graphe", null, fenetreGraphe, null);
    		

    	    
    		// Affichage de la fenêtre
    		fenetre.setVisible(true);
    		
    		
    		//Tamere
    		//Graphe  de Petersen
    		
    		int coucou[][] =  {{0, 1, 0,0,1,0, 1, 0,0,0}   ,   {1, 0, 1,0,0,0, 0, 1,0,0}  ,   {0, 1, 0,1,0,0, 0, 0,1,0},   {0,0, 1,0,1,0, 0, 0,0,1},   {1, 0, 0,1,0,1, 0, 0,0,0},   {0, 0, 0,0,1,0, 0, 1,1,0},   {1, 0, 0,0,0,0,0,0,1,1},   {0, 1, 0,0,0,1, 0, 0,0,1},   {0, 0, 1,0,0,1, 1, 0,0,0},   {0, 0, 0,1,0,0, 1, 1,0,0}};
    		int graphbizarre[][] = { {0, 1, 1,1,1,1}   ,{1, 0, 0,0,0,0}   ,{1,0, 0,0,0,0}   ,{1, 0, 0,0,0,0}   ,{1, 0, 0,0,0,0}   ,{1, 0, 0,0,0,0}    };
    		Map<Integer, Noeud> noeuds;
    		noeuds = backtrackingSequentialColoring(coucou);
    		noeuds = dsature(graphbizarre);
    		drawGraph(graphbizarre,noeuds);
    /*================================== CREATION D'UN GRAPHE ==========================================================    		
    		mxGraph graph = new mxGraph();
      	    Object parent = graph.getDefaultParent();
      	    HashMap hm = new HashMap();
      	    String edgeStyle = mxConstants.STYLE_STARTARROW + "=" + mxConstants.NONE;
      	    graph.getModel().beginUpdate();
    		
    		System.out.println(calculNombreChromatique(coucou));
    		Map<Integer, Noeud> noeuds;
    		noeuds = backtrackingSequentialColoring(coucou);
    		System.out.println("--------BSC--------");
    		try {
    		int j = 20;
    		for(int i=0;i<noeuds.size();i++){
        		System.out.println("Couleur Du noeud"+i+" est :"+noeuds.get(i).getCouleurCourante());
        		
        		// Coloration des sommets du graphe
        		String colorVertex = new String();
        		switch (noeuds.get(i).getCouleurCourante()){
        		
        		   case 0:  colorVertex = mxConstants.STYLE_FILLCOLOR + "=#C7C8C8"; 
        				    break;
	        	   case 1:  colorVertex = mxConstants.STYLE_FILLCOLOR + "=#FE3232"; 
	                		break;
			       case 2:  colorVertex = mxConstants.STYLE_FILLCOLOR + "=#F132FE";
			                break;
			       case 3:  colorVertex = mxConstants.STYLE_FILLCOLOR + "=#3254FE";
			                break;
			       case 4:  colorVertex = mxConstants.STYLE_FILLCOLOR + "=#32F1FE";
			                break;
			       case 5:  colorVertex = mxConstants.STYLE_FILLCOLOR + "=#32FE69";
			                break;
			       case 6:  colorVertex = mxConstants.STYLE_FILLCOLOR + "=#FEFE32";
			                break;
			       case 7:  colorVertex = mxConstants.STYLE_FILLCOLOR + "=#FEA100";
			                break;
			       case 8:  colorVertex = mxConstants.STYLE_FILLCOLOR + "=#00F693";
			                break;	
        		}
        		// Création d'un sommet du graphe
        		hm.put("v"+i, graph.insertVertex(null, null, i, j, 20, 40, 40, colorVertex));  
        		j = j + 80;
        		
        		// Création des arcs
        		for(int k=0;k<noeuds.size();k++){	
	    			if (coucou[i][k]== 1 ){ 
	    				graph.insertEdge(null, null, "", (Object)hm.get("v"+i), (Object)hm.get("v"+k),edgeStyle);
	    				graph.insertEdge(null, null, "", (Object)hm.get("v"+k), (Object)hm.get("v"+i),edgeStyle);
	    			}
	    		}
        	}
 }
    		
		     finally {
		      graph.getModel().endUpdate();
		    }   	 
		    mxGraphComponent graphComponent = new mxGraphComponent(graph);
		    
		    scrollPane = new JScrollPane(graphComponent);
		    fenetreCalcul.add(scrollPane, BorderLayout.CENTER);*/
   /*============================================================================================= */  		

		    
    		System.out.println("--------DSATURE--------");
    		noeuds = dsature(graphbizarre);
    		for(int i=0;i<noeuds.size();i++){
        		System.out.println("Couleur Du noeud"+i+" est :"+noeuds.get(i).getCouleurCourante());
        	}
    		System.out.println("--------TABUCOL--------");

    		noeuds = tabucol(graphbizarre);

    		for(int i=0;i<noeuds.size();i++){
        		System.out.println("Couleur Du noeud"+i+" est :"+noeuds.get(i).getCouleurCourante());
        	}
    }	
    //--------------------------------------------------------------------------FONCTIONS UTILITAIRES-------------------------------------------------------------------------------------------------
    public static int calculNombreChromatique(int matriceAdjacence[][]){
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
    
    public static void drawGraph(int matriceAdjacence[][],Map<Integer, Noeud> noeuds){
   		mxGraph graph = new mxGraph();
  	    Object parent = graph.getDefaultParent();
  	    HashMap hm = new HashMap();
  	    String edgeStyle = mxConstants.STYLE_STARTARROW + "=" + mxConstants.NONE;
  	    graph.getModel().beginUpdate();
		try {
		int j = 20;
		for(int i=0;i<noeuds.size();i++){
    		System.out.println("Couleur Du noeud"+i+" est :"+noeuds.get(i).getCouleurCourante());
    		
    		// Coloration des sommets du graphe
    		String colorVertex = new String();
    		switch (noeuds.get(i).getCouleurCourante()){
    		
    		   case 0:  colorVertex = mxConstants.STYLE_FILLCOLOR + "=#C7C8C8"; 
    				    break;
        	   case 1:  colorVertex = mxConstants.STYLE_FILLCOLOR + "=#FE3232"; 
                		break;
		       case 2:  colorVertex = mxConstants.STYLE_FILLCOLOR + "=#F132FE";
		                break;
		       case 3:  colorVertex = mxConstants.STYLE_FILLCOLOR + "=#3254FE";
		                break;
		       case 4:  colorVertex = mxConstants.STYLE_FILLCOLOR + "=#32F1FE";
		                break;
		       case 5:  colorVertex = mxConstants.STYLE_FILLCOLOR + "=#32FE69";
		                break;
		       case 6:  colorVertex = mxConstants.STYLE_FILLCOLOR + "=#FEFE32";
		                break;
		       case 7:  colorVertex = mxConstants.STYLE_FILLCOLOR + "=#FEA100";
		                break;
		       case 8:  colorVertex = mxConstants.STYLE_FILLCOLOR + "=#00F693";
		                break;	
    		}
    		// Création d'un sommet du graphe
    		hm.put("v"+i, graph.insertVertex(null, null, i, j, 20, 40, 40, colorVertex));  
    		j = j + 80;
    		
    		// Création des arcs
    		for(int k=0;k<noeuds.size();k++){	
    			if (matriceAdjacence[i][k]== 1 ){ 
    				graph.insertEdge(null, null, "", (Object)hm.get("v"+i), (Object)hm.get("v"+k),edgeStyle);
    				graph.insertEdge(null, null, "", (Object)hm.get("v"+k), (Object)hm.get("v"+i),edgeStyle);
    			}
    		}
    	}
}
		
	     finally {
	      graph.getModel().endUpdate();
	    }   	 
	    mxGraphComponent graphComponent = new mxGraphComponent(graph);
	    
	    scrollPane = new JScrollPane(graphComponent);
	    fenetreCalcul.add(scrollPane, BorderLayout.CENTER);
    }
       
    //Fonction qui check si tous les noeuds du graphe sont coloriées, return true si c'est le cas, false sinon.
    public static boolean areAllColored(Map<Integer, Noeud> noeuds){
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
    public static int getIndexPremierNoeudNonColorier(Map<Integer, Noeud> noeuds){
    	for(int i=0;i<noeuds.size();i++){
    		if (noeuds.get(i).getCouleurCourante()==0){
    			return i;
    		}
    	}
    
    	return -1;
    }
    public static int getIndexPremiereCouleurNonDejaUtilise(Map<Integer, Noeud> noeuds, int noeudCourant,int nbCouleurMax){
    	for(int i=1;i<=nbCouleurMax;i++){
    		if (noeuds.get(noeudCourant).getListeCouleurDejaUtilisee().contains(i)==false){
    			return i;
    		}
    	}
    	return -1;
    
    }
    
    //Calcul le degres de saturation maximal courant du graphe representé par la matrice d'adjacence. 
    public static int calculLeDegresDeSaturationMaxDuGraphEtDeChaqueNoeud(Map<Integer, Noeud> noeuds,int matriceAdjacence[][]){
    	int degresDeSaturationMax=0;
    	int degresDeSaturationDuNoeud;
    	int degresDuNoeud;
    	for(int i=0;i<noeuds.size();i++){
    		degresDeSaturationDuNoeud=0;
    		degresDuNoeud=0;
    		for (int j=0;j<noeuds.size();j++){
    			//Si il y a un arc entre i et j et que i est différent de j alors
    			if(matriceAdjacence[i][j]==1 && i != j){
    				//Si le noeud j a une couleur 
    				degresDuNoeud++;
    				if(noeuds.get(j).getCouleurCourante()!= 0  ){
    					
    					degresDeSaturationDuNoeud++;
    				}
    			}
    		}
    		noeuds.get(i).setDegres(degresDuNoeud);
    		noeuds.get(i).setDegresDeSaturation(degresDeSaturationDuNoeud);
    		//Si le degres du noeud i est supérieur au degres max
    		if (degresDeSaturationDuNoeud>degresDeSaturationMax && noeuds.get(i).getCouleurCourante()==0){
    			degresDeSaturationMax=degresDeSaturationDuNoeud;
    		}
    	}
    	
    	return degresDeSaturationMax;
    }
    //Retourne le premier noeuds(index) rencontrer avec le degres donnée en paramètre
    public static int getIndexNoeudByDegres(ArrayList<Noeud> noeudsParDegresDeSaturation, int degres){
    	for(int i=0;i<noeudsParDegresDeSaturation.size();i++){
    		if (noeudsParDegresDeSaturation.get(i).getDegres()==degres){
    			return noeudsParDegresDeSaturation.get(i).getNumeroNoeud();
    		}
    	}
    
    	return -1;
    
    }
    
    //Récupère tous les noeuds non coloriés avec le degres de saturation donné en paramètre
    public static ArrayList<Noeud> getNoeudsByDegresDeSaturation(Map<Integer, Noeud> noeuds,int degresDeSaturationMax){
    	ArrayList<Noeud> noeudsDegresDeSaturation = new ArrayList<Noeud>();
    	for (int i=0;i<noeuds.size();i++){
    		if(noeuds.get(i).getDegresDeSaturation()==degresDeSaturationMax && noeuds.get(i).getCouleurCourante()==0){
    			
    			noeudsDegresDeSaturation.add(noeuds.get(i));
    		}
		}
    	
    	
    	return noeudsDegresDeSaturation;
    }
    //Calcul le degres de noeud le plus élevé dans la liste de noeud passé en parametre
    public static int calculDegresLePlusEleve(ArrayList<Noeud> noeudsParDegresDeSaturation){
    	int degresLePlusEleve=0;
    	
    	for (int i=0;i<noeudsParDegresDeSaturation.size();i++){    		
    			if(noeudsParDegresDeSaturation.get(i).getDegres()>degresLePlusEleve){
    				degresLePlusEleve=noeudsParDegresDeSaturation.get(i).getDegres();
    			}
    		}
    	return degresLePlusEleve;
    	}
    	
    
    //Renvoie une liste des couleurs des noeuds voisins du noeud passé en paramètre
    public static ArrayList<Integer> getCouleursDesVoisins(Map<Integer, Noeud> noeuds,int matriceAdjacence[][],int indexNoeud){
    	ArrayList<Integer> couleursDesVoisins = new ArrayList<Integer>();
    	for (int j=0;j<noeuds.size();j++){
    		
    		if(matriceAdjacence[indexNoeud][j]==1&& indexNoeud !=j && noeuds.get(j).getCouleurCourante()!=0){
    			couleursDesVoisins.add(noeuds.get(j).getCouleurCourante());
    			
    		}
    	}
    	
    	return couleursDesVoisins;
    }
    
    //Renvoie la première couleur (dans le range de couleur max ) qui n'est pas dans la liste passé en paramètre.
    public static int getCouleurLaPlusPetiteDisponible(ArrayList<Integer> couleursDesVoisins,int nbCouleurMax){
    	for(int i=1;i<=nbCouleurMax;i++){
    		if (!couleursDesVoisins.contains(i)){
    			return i;
    		}
    	}
    	return -1;
    
    }
    
    public static ArrayList<Conflit> calculLeNombreDeConflit(Map<Integer, Noeud> noeuds,int matriceAdjacence[][],int nbCouleurMax){
    	
    	ArrayList<Conflit> conflits = new ArrayList<Conflit>();
    	ArrayList<Integer> couleursDesVoisins = new ArrayList<Integer>();
    	for(int i=0;i<noeuds.size();i++){
    		for (int j=0;j<noeuds.size();j++){
    			couleursDesVoisins = getCouleursDesVoisins(noeuds,matriceAdjacence,i);
    			if(matriceAdjacence[i][j]==1 && i != j){
    				if(noeuds.get(j).getCouleurCourante()==noeuds.get(i).getCouleurCourante()  ){
    					Conflit conflit = new Conflit();
    					conflit.setNumeroNoeud1(j);
    					conflit.setNumeroNoeud2(i);
    					if(couleursDesVoisins.size()==nbCouleurMax){
    						conflit.setConflitDifficile(true);
    					}
    					if(!conflits.contains(new Conflit(i,j)) && !conflits.contains(new Conflit(j,i))){
    						conflits.add(conflit);
    					}
    				}
    			}
    		}
    	}
    	return conflits;
    }
 public static int getPremierVoisinsColoriable(int matriceAdjacence[][],Noeud noeud,int couleur,Map<Integer, Noeud> noeuds){
    	int nbNoeud = matriceAdjacence[0].length;
    	ArrayList<Conflit> conflits = new ArrayList<Conflit>();
    	ArrayList<Integer> couleursDesVoisins = new ArrayList<Integer>();
    	for(int i=0;i<nbNoeud;i++){
    		
    			couleursDesVoisins = getCouleursDesVoisins(noeuds,matriceAdjacence,i);
    			if(matriceAdjacence[noeud.getNumeroNoeud()][i]==1 && noeud.getNumeroNoeud() != i && !noeud.getListeCouleurTaboue().contains(couleur)&& !couleursDesVoisins.contains(couleur)){
    				return i;
    			}
    		
    	}
    	return -1;
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
 
 // ----------------------------------------------------------------------------------LES ALGOS ----------------------------------------------------------------------------------   
    
    public static Map<Integer, Noeud> dsature(int matriceAdjacence[][]){
    	//Initialisation
    	int degresDeSaturationMaxCourant=0;
    	int degresLePlusEleve=0;
    	ArrayList<Noeud> noeudsParDegresDeSaturation = new ArrayList<Noeud>();
    	ArrayList<Integer> couleursDesVoisins = new ArrayList<Integer>();
    	Map<Integer, Noeud> noeuds = new HashMap<Integer, Noeud>();
    	int taille = matriceAdjacence[0].length;
    	int nbCouleurMax = calculNombreChromatique(matriceAdjacence);
    	
    	for (int i=0;i<taille;i++){
    		Noeud noeud = new Noeud();
			noeud.setNumeroNoeud(i);
			noeuds.put(i, noeud);
		}
    	//Ne s'arrête pas tant que tous les noeuds ne sont pas coloriés
    	while (false == areAllColored(noeuds)){
    		
    		//On calcul le degres de saturation max courant pour les noeuds non colorié
    		degresDeSaturationMaxCourant=calculLeDegresDeSaturationMaxDuGraphEtDeChaqueNoeud(noeuds,matriceAdjacence);
    		
    		//Ensuite on récupère ces noeuds encore non coloriés qui possède ce degres de saturation
    		noeudsParDegresDeSaturation=getNoeudsByDegresDeSaturation(noeuds,degresDeSaturationMaxCourant);
    		
    		//Si il y a des égalités (En gros si on récupère plus d'un noeud) : 
    		if(noeudsParDegresDeSaturation.size()>1){
    			//On priorise par degres le plus eleve
    			//Donc on calcul le degres le plus eleve des noeuds présent dans la liste choisies 
    			degresLePlusEleve=calculDegresLePlusEleve(noeudsParDegresDeSaturation);
    			//Puis on choisi le premier noeud avec ce degres dans la liste
    			int indexNoeud=getIndexNoeudByDegres(noeudsParDegresDeSaturation,degresLePlusEleve); 
    			
    			//On récupère la couleur de ces voisins
    			couleursDesVoisins = getCouleursDesVoisins(noeuds,matriceAdjacence,indexNoeud); 
    			
    			//Puis on colorie avec la couleurs la plus petite disponible ( cette couleur est trouvé par la fonction "getCouleurLaPlusPetiteDisponible")
    			noeuds.get(indexNoeud).setCouleurCourante(getCouleurLaPlusPetiteDisponible(couleursDesVoisins,nbCouleurMax));
    		
    			
    		}
    		//Sinon si il n'y a qu'un seul noeud
    		else if(noeudsParDegresDeSaturation.size()==1){
    			//Pas besoin de priorisé, on calcul directement la couleur la plus petite disponible du noeuds et on le colorie avec cette dernière.
    			int indexNoeud=noeudsParDegresDeSaturation.get(0).getNumeroNoeud();
    			couleursDesVoisins = getCouleursDesVoisins(noeuds,matriceAdjacence,indexNoeud); 
    			noeuds.get(indexNoeud).setCouleurCourante(getCouleurLaPlusPetiteDisponible(couleursDesVoisins,indexNoeud));
    		}
    	}
    	
    	
    	
    	return noeuds;
    }
    
    public static Map<Integer, Noeud> backtrackingSequentialColoring(int matriceAdjacence[][]){
    	//Initialisation
    	Map<Integer, Noeud> noeuds = new HashMap<Integer, Noeud>();
    	int taille = matriceAdjacence[0].length;
    	int nbCouleurMax = calculNombreChromatique(matriceAdjacence);
    	
    	for (int i=0;i<taille;i++){
    		Noeud noeud = new Noeud();
			noeuds.put(i, noeud);
		}
    	
    
    		algoRecursifBacktracking(noeuds,matriceAdjacence,nbCouleurMax);
    
    	
    	
    	
    	return noeuds;
    }

    public static void   algoRecursifBacktracking(Map<Integer, Noeud> noeuds,int matriceAdjacence[][],int nbCouleurMax){
    	int noeudCourant=0;
    	int nbNoeud = matriceAdjacence[0].length;
  
    	//Le noeud courant est le 1er noeud rencontré qui possède la couleur neutre : 0.
    	noeudCourant=getIndexPremierNoeudNonColorier(noeuds);

    	
    	//On regarde si la "liste des couleurs deja utilisée" du noeud courant est au max
    	//Si c'est le cas cela veut dire que toutes les couleurs ont deja étaient tenté sur ce noeuds sans succès
    	//Il faut donc décolorer le noeuds d'avant et rappeler la fonction.
    	if(noeuds.get(noeudCourant).getListeCouleurDejaUtilisee().size()==nbCouleurMax){
    		noeuds.get(noeudCourant-1).setCouleurCourante(0);
    		noeuds.get(noeudCourant).getListeCouleurDejaUtilisee().clear();
    		algoRecursifBacktracking(noeuds,matriceAdjacence,nbCouleurMax);
    	}
    	
    	//Coloration du noeud courant avec une couleur qu'il n'a jamais rencontré
    	noeuds.get(noeudCourant).setCouleurCourante(getIndexPremiereCouleurNonDejaUtilise(noeuds,noeudCourant,nbCouleurMax));
    	
    	//tester si la condition de coloration est vérifiée
    	boolean conditionRespectee=true;
    	for (int j=0;j<nbNoeud;j++){
    		
    		if(matriceAdjacence[noeudCourant][j]==1&&noeudCourant !=j){
    			if(noeuds.get(j).getCouleurCourante()==noeuds.get(noeudCourant).getCouleurCourante() ){
    		
    				conditionRespectee=false;
    			}
    		}
    	}
    	
    	if(conditionRespectee==false){
    		//On décolore le noeud
    		noeuds.get(noeudCourant).setCouleurCourante(0);
    		//Et on le redonne à manger à l'algorithme récursif.
    		algoRecursifBacktracking(noeuds,matriceAdjacence,nbCouleurMax);
    	}
    	else{
    		//Si c'est vrai on regarde si tous les noeuds sont coloriés
    		//Si c'est le cas, alors on sort de la boucle récursive
    		if(areAllColored(noeuds)==true){
    			return;
    		}
    		//Sinon on rappelle la fonction récursive.
    		algoRecursifBacktracking(noeuds,matriceAdjacence,nbCouleurMax);
    	}
    	
    	
		
    }

    public static Map<Integer, Noeud> tabucol(int matriceAdjacence[][]){
    	//Initialisation
    	Map<Integer, Noeud> noeuds = new HashMap<Integer, Noeud>();
    	int taille = matriceAdjacence[0].length;
    	int nbCouleurMax = calculNombreChromatique(matriceAdjacence);
    	int nbConflitCourant=0;
    	int degresDuNoeud;
    	ArrayList<Conflit> conflitsCourants = new ArrayList<Conflit>();
    	ArrayList<Conflit> conflitsTampon = new ArrayList<Conflit>();
    	//Colorier les noeuds du graphe de manière arbitraire
    	Random random = new Random();
    	int couleurAleatoire = 1;
    	for (int i=0;i<taille;i++){
    		Noeud noeud = new Noeud();
    		noeud.setNumeroNoeud(i);
    		noeud.setCouleurCourante(couleurAleatoire);
			noeuds.put(i, noeud);
		}
    	for(int i=0;i<noeuds.size();i++){
    		
    		degresDuNoeud=0;
    		for (int j=0;j<noeuds.size();j++){
    			//Si il y a un arc entre i et j et que i est différent de j alors
    			if(matriceAdjacence[i][j]==1 && i != j){
    				degresDuNoeud++;
    			
    			}
    		}
    		noeuds.get(i).setDegres(degresDuNoeud);
    	}
    	for(int i=0;i<noeuds.size();i++){
    		System.out.println("Couleur aléatoire Du noeud"+i+" est :"+noeuds.get(i).getCouleurCourante());
    	}
    	//On recupère la liste des conflits ! 
    	conflitsCourants = calculLeNombreDeConflit(noeuds,matriceAdjacence,nbCouleurMax);
    	System.out.println("Nombre de conflit : "+ conflitsCourants.size()); 
    	nbConflitCourant = conflitsCourants.size();
    	while(nbConflitCourant!=0){
    		for(int i=0;i<noeuds.size();i++){
        		noeuds.get(i).incrementAllCompteur();
        	}
    	
    	int degresNoeud1;
    	int degresNoeud2;
    	
    	ArrayList<Integer> couleurVoisinNoeud1 = new ArrayList<Integer>();
    	ArrayList<Integer> couleurVoisinNoeud2 = new ArrayList<Integer>();
    	boolean contientConflitsDifficile=false;
    	int indiceConflitDifficile=0;
    	int nbConflitCourant1;
    	LeMeilleurChoixPossible lmcp;
    	//TODO : en modifiant la couleurs d'un noeud je modifie directement tous les autres conflits donc ma liste n'est forcément plus correcte
    	//TODO : il faut différencier les conflits qui génèrent des conflits à ce qui ne le font pas 
    	//TODO : l'idée serait de continuer la boucle for tant que le conflit est facile et qu'il n'engendre pas d'autre conflit
    	//TODO : si le ocnflit est difficile alors on break en dehors de la boucle et on le résoudd .
    	//TODO : mais qu'est ce qu'un conflit facile ? la suite in the next episode of coding for the noobs 
    	for (int i=0;i<noeuds.size();i++){
    		lmcp= new LeMeilleurChoixPossible();
    		lmcp.setCouleur(noeuds.get(i).getCouleurCourante());
    		lmcp.setNbConflit(nombreDeConflitAssocieAuNoeud(noeuds.get(i),matriceAdjacence,noeuds));
    		for(int j=1;j<=nbCouleurMax;j++){
    				if(!noeuds.get(i).getListeCouleurTaboue().contains(j)){
    					noeuds.get(i).setCouleurCourante(j);
    					nbConflitCourant1 = nombreDeConflitAssocieAuNoeud(noeuds.get(i),matriceAdjacence,noeuds);
    					if(nbConflitCourant1<lmcp.getNbConflit()){
    						lmcp.setNbConflit(nbConflitCourant1);
    						lmcp.setCouleur(j);
    						
    					}
    				}
    				
        		}
    		
    		noeuds.get(i).setCouleurCourante(lmcp.getCouleur());
    		noeuds.get(i).addCouleurTaboue(lmcp.getCouleur());
    	
        	}
    	nbConflitCourant=calculLeNombreDeConflit(noeuds,matriceAdjacence,nbCouleurMax).size();
    	}
    	
    	
    	
    	
    	
    	
    
    	//System.out.println("Le meilleur choix possible est de colorier le noeud :"+mcp.getNumeroNoeud()+" avec la couleur"+mcp.getCouleur()+", cela genère "+mcp.getNbConflit()+" conflits");
    	
    	return noeuds;
    }


    
    
}

