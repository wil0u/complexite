package com.complexite.love;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JScrollPane;


public class App 
{

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
    	    JPanel fenetreCalcul = new JPanel();
    	    tabbedPane.addTab("Calcul", null, fenetreCalcul, null);
    	    fenetreCalcul.setLayout(new BorderLayout(0, 0));
    	    
    	    // Ajout de la partie permettant de selectionner Nb Noeud en haut de la fenetre
    	    JPanel panelNbNoeud = new JPanel();
    	    FlowLayout flowLayout = (FlowLayout) panelNbNoeud.getLayout();
    	    flowLayout.setAlignment(FlowLayout.LEFT);
    	    fenetreCalcul.add(panelNbNoeud, BorderLayout.NORTH);
    	    
    	    JLabel lblNbNoeud = new JLabel("          Nb Noeud : ");
    	    panelNbNoeud.add(lblNbNoeud);
    	    
    	    JTextField textNbNoeud = new JTextField();
    	    panelNbNoeud.add(textNbNoeud);
    	    textNbNoeud.setColumns(5);
    	    
    	    JButton btnNbNoeud = new JButton("Valider");
    	    panelNbNoeud.add(btnNbNoeud);
    	    
    	    
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
    	    
    	    JScrollPane scrollPane = new JScrollPane();
    	    fenetreCalcul.add(scrollPane, BorderLayout.CENTER);
    	    
    	    
/**==================================================== Edition fenetre Graphe ========================================================**/
    	    
    	  //Création de l'onglet fenetreGraphe
    	    JPanel fenetreGraphe = new JPanel();
    	    tabbedPane.addTab("Graphe", null, fenetreGraphe, null);
    		

    	    
    		// Affichage de la fenêtre
    		fenetre.setVisible(true);
    		
    		
    		//Tamere
    		//Graphe  de Petersen
    		int coucou[][] =  {{0, 1, 0,0,1,0, 1, 0,0,0}   ,   {1, 0, 1,0,0,0, 0, 1,0,0}  ,   {0, 1, 0,1,0,0, 0, 0,1,0},   {0,0, 1,0,1,0, 0, 0,0,1},   {1, 0, 0,1,0,1, 0, 0,0,0},   {0, 0, 0,0,1,0, 0, 1,1,0},   {1, 0, 0,0,0,0,0,0,1,1},   {0, 1, 0,0,0,1, 0, 0,0,1},   {0, 0, 1,0,0,1, 1, 0,0,0},   {0, 0, 0,1,0,0, 1, 1,0,0}};
    		System.out.println(calculNombreChromatique(coucou));
    		Map<Integer, NoeudCouleur> noeuds;
    		noeuds = backtrackingSequentialColoring(coucou);
    		System.out.println("--------BSC--------");
    		for(int i=0;i<noeuds.size();i++){
        		System.out.println("Couleur Du noeud"+i+" est :"+noeuds.get(i).getCouleurCourante());
        	}
    		System.out.println("--------DSATURE--------");
    		dsature(coucou);
    		for(int i=0;i<noeuds.size();i++){
        		System.out.println("Couleur Du noeud"+i+" est :"+noeuds.get(i).getCouleurCourante());
        	}
    }
    
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
    
    
    public static Map<Integer, NoeudCouleur> backtrackingSequentialColoring(int matriceAdjacence[][]){
    	//Initialisation
    	Map<Integer, NoeudCouleur> noeuds = new HashMap<Integer, NoeudCouleur>();
    	int taille = matriceAdjacence[0].length;
    	int nbCouleurMax = calculNombreChromatique(matriceAdjacence);
    	
    	for (int i=0;i<taille;i++){
			NoeudCouleur noeud = new NoeudCouleur();
			noeuds.put(i, noeud);
		}
    	
    
    		algoRecursifBacktracking(noeuds,matriceAdjacence,nbCouleurMax);
    
    	
    	
    	
    	return noeuds;
    }

    public static void   algoRecursifBacktracking(Map<Integer, NoeudCouleur> noeuds,int matriceAdjacence[][],int nbCouleurMax){
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
    		//Si c'est vrai on a juste à rappeler l'algo xD lol 
    		if(areAllColored(noeuds)==true){
    			return;
    		}
    		algoRecursifBacktracking(noeuds,matriceAdjacence,nbCouleurMax);
    	}
    	
    	
		
    }
    
    //Fonction qui check si tous les noeuds du graphe sont coloriées, return true si c'est le cas, false sinon.
    public static boolean areAllColored(Map<Integer, NoeudCouleur> noeuds){
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
    public static int getIndexPremierNoeudNonColorier(Map<Integer, NoeudCouleur> noeuds){
    	for(int i=0;i<noeuds.size();i++){
    		if (noeuds.get(i).getCouleurCourante()==0){
    			return i;
    		}
    	}
    
    	return -1;
    }
    public static int getIndexPremiereCouleurNonDejaUtilise(Map<Integer, NoeudCouleur> noeuds, int noeudCourant,int nbCouleurMax){
    	for(int i=1;i<=nbCouleurMax;i++){
    		if (noeuds.get(noeudCourant).getListeCouleurDejaUtilisee().contains(i)==false){
    			return i;
    		}
    	}
    	return -1;
    
    }
    
    //Calcul le degres de saturation maximal courant du graphe representé par la matrice d'adjacence. 
    public static int calculLeDegresDeSaturationMaxDuGraphEtDeChaqueNoeud(Map<Integer, NoeudCouleur> noeuds,int matriceAdjacence[][]){
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
    public static int getIndexNoeudByDegres(ArrayList<NoeudCouleur> noeudsParDegresDeSaturation, int degres){
    	for(int i=0;i<noeudsParDegresDeSaturation.size();i++){
    		if (noeudsParDegresDeSaturation.get(i).getDegres()==degres){
    			return noeudsParDegresDeSaturation.get(i).getNumeroNoeud();
    		}
    	}
    
    	return -1;
    
    }
    
    public static ArrayList<NoeudCouleur> getNoeudsByDegresDeSaturation(Map<Integer, NoeudCouleur> noeuds,int degresDeSaturationMax){
    	ArrayList<NoeudCouleur> noeudsDegresDeSaturation = new ArrayList<NoeudCouleur>();
    	for (int i=0;i<noeuds.size();i++){
    		if(noeuds.get(i).getDegresDeSaturation()==degresDeSaturationMax && noeuds.get(i).getCouleurCourante()==0){
    			
    			noeudsDegresDeSaturation.add(noeuds.get(i));
    		}
		}
    	
    	
    	return noeudsDegresDeSaturation;
    }
    
    public static int calculDegresLePlusEleve(ArrayList<NoeudCouleur> noeudsParDegresDeSaturation){
    	int degresLePlusEleve=0;
    	
    	for (int i=0;i<noeudsParDegresDeSaturation.size();i++){    		
    			if(noeudsParDegresDeSaturation.get(i).getDegres()>degresLePlusEleve){
    				degresLePlusEleve=noeudsParDegresDeSaturation.get(i).getDegres();
    			}
    		}
    	return degresLePlusEleve;
    	}
    	
    
    
    public static ArrayList<Integer> getCouleursDesVoisins(Map<Integer, NoeudCouleur> noeuds,int matriceAdjacence[][],int indexNoeud){
    	ArrayList<Integer> couleursDesVoisins = new ArrayList<Integer>();
    	for (int j=0;j<noeuds.size();j++){
    		
    		if(matriceAdjacence[indexNoeud][j]==1&& indexNoeud !=j && noeuds.get(j).getCouleurCourante()!=0){
    			couleursDesVoisins.add(noeuds.get(j).getCouleurCourante());
    			
    		}
    	}
    	
    	return couleursDesVoisins;
    }
    
    public static int getCouleurLaPlusPetiteDisponible(ArrayList<Integer> couleursDesVoisins,int nbCouleurMax){
    	for(int i=1;i<=nbCouleurMax;i++){
    		if (!couleursDesVoisins.contains(i)){
    			return i;
    		}
    	}
    	return -1;
    
    }
    
    
    public static Map<Integer, NoeudCouleur> dsature(int matriceAdjacence[][]){
    	//Initialisation
    	int degresDeSaturationMaxCourant=0;
    	int degresLePlusEleve=0;
    	ArrayList<NoeudCouleur> noeudsParDegresDeSaturation = new ArrayList<NoeudCouleur>();
    	ArrayList<Integer> couleursDesVoisins = new ArrayList<Integer>();
    	Map<Integer, NoeudCouleur> noeuds = new HashMap<Integer, NoeudCouleur>();
    	int taille = matriceAdjacence[0].length;
    	int nbCouleurMax = calculNombreChromatique(matriceAdjacence);
    	
    	for (int i=0;i<taille;i++){
			NoeudCouleur noeud = new NoeudCouleur();
			noeud.setNumeroNoeud(i);
			noeuds.put(i, noeud);
		}
    	//Ne s'arrête pas tant que tous les noeuds ne sont pas coloriés
    	while (false == areAllColored(noeuds)){
    		degresDeSaturationMaxCourant=calculLeDegresDeSaturationMaxDuGraphEtDeChaqueNoeud(noeuds,matriceAdjacence);
    		//System.out.println("Degres de Saturation max ="+degresDeSaturationMaxCourant);
    		noeudsParDegresDeSaturation=getNoeudsByDegresDeSaturation(noeuds,degresDeSaturationMaxCourant);
    		//System.out.println("nombre de noeuds dans la liste : "+ noeudsParDegresDeSaturation.size());
    		//Si il y a des égalités : 
    		if(noeudsParDegresDeSaturation.size()>1){
    			//On priorise
    			degresLePlusEleve=calculDegresLePlusEleve(noeudsParDegresDeSaturation);
    			int indexNoeud=getIndexNoeudByDegres(noeudsParDegresDeSaturation,degresLePlusEleve); 
    			
    			couleursDesVoisins = getCouleursDesVoisins(noeuds,matriceAdjacence,indexNoeud); 
    			noeuds.get(indexNoeud).setCouleurCourante(getCouleurLaPlusPetiteDisponible(couleursDesVoisins,nbCouleurMax));
    		
    			//et on colorie
    			
    		}
    		else if(noeudsParDegresDeSaturation.size()==1){
    			//Pas besoin de priorisé
    			int indexNoeud=noeudsParDegresDeSaturation.get(0).getNumeroNoeud();
    			couleursDesVoisins = getCouleursDesVoisins(noeuds,matriceAdjacence,indexNoeud); 
    			noeuds.get(indexNoeud).setCouleurCourante(getCouleurLaPlusPetiteDisponible(couleursDesVoisins,indexNoeud));
    		}
    	}
    	
    	
    	
    	return noeuds;
    }
    
    
    
    
    
}

