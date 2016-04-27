package com.complexite.love;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.JComboBox;


public class App 
{
	static JScrollPane scrollPane = new JScrollPane();

    static JPanel fenetreCalcul = new JPanel();
    static int matrix1[][] =  {
    						   {0, 1, 0, 0, 1, 0, 1, 0, 0, 0},   
					    	   {1, 0, 1, 0, 0, 0, 0, 1, 0, 0},
					    	   {0, 1, 0, 1, 0, 0, 0, 0, 1, 0},   
					    	   {0, 0, 1, 0, 1, 0, 0, 0, 0, 1},
					    	   {1, 0, 0, 1, 0, 1, 0, 0, 0, 0},
					    	   {0, 0, 0, 0, 1, 0, 0, 1, 1, 0},
					    	   {1, 0, 0, 0, 0, 0, 0, 0, 1, 1},
					    	   {0, 1, 0, 0, 0, 1, 0, 0, 0, 1},
					    	   {0, 0, 1, 0, 0, 1, 1, 0, 0, 0},
					    	   {0, 0, 0, 1, 0, 0, 1, 1, 0, 0}
					    	   };
    
	static int matrix2[][] = { 
								{0, 1, 1, 1, 1, 1},
								{1, 0, 0, 0, 0, 0},
								{1, 0, 0, 0, 0, 0},
								{1, 0, 0, 0, 0, 0},
								{1, 0, 0, 0, 0, 0},
								{1, 0, 0, 0, 0, 0}    
							 };

    static int matrix3[][] =  {
							   {0, 1, 1, 0, 0, 0},   
					    	   {1, 0, 0, 1, 0, 0},
					    	   {1, 0, 0, 0, 1, 0},   
					    	   {0, 1, 0, 0, 0, 0},
					    	   {0, 0, 1, 0, 0, 1},
					    	   {0, 0, 0, 0, 1, 0}
    						  };
    

	
    public static void main( String[] args )
    {
    		
/**==================================================== Edition generale de la fenetre =================================================**/
    		// Création de la variable fenetre
    		JFrame fenetre = new JFrame();
    		
    	    //Titre de la fenetre
    	    fenetre.setTitle("Coloration de Graphe");
    	    
    	    // Taille de la fenetre
    	    fenetre.setSize(1000, 600);
    	    
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
    	    
    	    JLabel lblScenario = new JLabel("Scénario");
    	    panelConfirmer.add(lblScenario);
    	    
    	    final JComboBox comboBoxScenario = new JComboBox();
    	    comboBoxScenario.addItem(01);
    	    comboBoxScenario.addItem(02);
    	    comboBoxScenario.addItem(03);
    	    
    	    
    	    panelConfirmer.add(comboBoxScenario);
    	    
    	    JLabel lblEspaceVideScenario = new JLabel("               ");
    	    panelConfirmer.add(lblEspaceVideScenario);
    	    
    	    JLabel lblConfirmerLancement = new JLabel("Lancement               ");
    	    panelConfirmer.add(lblConfirmerLancement);
    	    
    	    JButton btnConfirmerBSC = new JButton("     BSC     ");
    	    btnConfirmerBSC.addMouseListener(new MouseAdapter() {
    	    	@Override
    	    	public void mouseClicked(MouseEvent arg0) {
    	    		System.out.println("get selected index "+comboBoxScenario.getSelectedIndex());
    	    		
    	    		if (comboBoxScenario.getSelectedIndex() == 0) {
    	    			Map<Integer, Noeud> noeuds = backtrackingSequentialColoring(matrix1);
    					drawGraph(matrix1,noeuds);
    					System.out.println("cas1 ");
    	    		}
    	    		
    	    		else if (comboBoxScenario.getSelectedIndex() == 1) {
    	    			Map<Integer, Noeud> noeuds1 = backtrackingSequentialColoring(matrix2);
    					drawGraph(matrix2,noeuds1);
    					System.out.println("cas2 ");
    	    		}
    	    		
    	    		else {
    	    			 Map<Integer, Noeud> noeuds2 = backtrackingSequentialColoring(matrix3);
	    				drawGraph(matrix3,noeuds2);System.out.println("cas3");
    	    		}
    	    		/*
    	    		switch(comboBoxScenario.getSelectedIndex()){
    	    		case 0 : Map<Integer, Noeud> noeuds = backtrackingSequentialColoring(matrix1);
    	    					drawGraph(matrix1,noeuds);
    	    					System.out.println("cas1 ");
    	    		case 1 : Map<Integer, Noeud> noeuds1 = backtrackingSequentialColoring(matrix2);
    	    					drawGraph(matrix2,noeuds1);
    	    					System.out.println("cas2 ");
    	    		case 2 : Map<Integer, Noeud> noeuds2 = backtrackingSequentialColoring(matrix3);
    	    					drawGraph(matrix3,noeuds2);System.out.println("cas3");
    	    		}
    	    		*/
    		   		
		    		
		    		
    	    	}
    	    });
    	    panelConfirmer.add(btnConfirmerBSC);
    	    
    	    JLabel lblConfirmerVide01 = new JLabel("               ");
    	    panelConfirmer.add(lblConfirmerVide01);
    	    
    	    JButton btnConfirmerDSATUR = new JButton(" DSATUR ");
    	    btnConfirmerDSATUR.addMouseListener(new MouseAdapter() {
    	    	@Override
    	    	public void mouseClicked(MouseEvent arg0) {
    	    		if (comboBoxScenario.getSelectedIndex() == 0) {
    	    			Map<Integer, Noeud> noeuds = dsature(matrix1);
    					drawGraph(matrix1,noeuds);
    					System.out.println("cas1 ");
    	    		}
    	    		
    	    		else if (comboBoxScenario.getSelectedIndex() == 1) {
    	    			Map<Integer, Noeud> noeuds1 = dsature(matrix2);
    					drawGraph(matrix2,noeuds1);
    					System.out.println("cas2 ");
    	    		}
    	    		
    	    		else {
    	    			 Map<Integer, Noeud> noeuds2 = dsature(matrix3);
	    				drawGraph(matrix3,noeuds2);System.out.println("cas3");
    	    		}
    	    	}
    	    });
    	    panelConfirmer.add(btnConfirmerDSATUR);
    	    
    	    JLabel lblConfirmerVide02 = new JLabel("               ");
    	    panelConfirmer.add(lblConfirmerVide02);
    	    
    	    JButton btnConfirmerTABUCOL = new JButton("TABUCOL");
    	    btnConfirmerTABUCOL.addMouseListener(new MouseAdapter() {
    	    	@Override
    	    	public void mouseClicked(MouseEvent e) {
    	     		if (comboBoxScenario.getSelectedIndex() == 0) {
    	    			Map<Integer, Noeud> noeuds = tabucol(matrix1);
    					drawGraph(matrix1,noeuds);
    					System.out.println("cas1 ");
    	    		}
    	    		
    	    		else if (comboBoxScenario.getSelectedIndex() == 1) {
    	    			Map<Integer, Noeud> noeuds1 = tabucol(matrix2);
    					drawGraph(matrix2,noeuds1);
    					System.out.println("cas2 ");
    	    		}
    	    		
    	    		else {
    	    			 Map<Integer, Noeud> noeuds2 = tabucol(matrix3);
	    				drawGraph(matrix3,noeuds2);System.out.println("cas3");
    	    		}
    	    	}
    	    });
    	    panelConfirmer.add(btnConfirmerTABUCOL);
    	    
    	    
    	    
    	    
    	    
    	   
    	    
    	    
/**==================================================== Edition fenetre Graphe ========================================================**/
    	    
    	  //Création de l'onglet fenetreGraphe
    	    JPanel fenetreGraphe = new JPanel();
    	    tabbedPane.addTab("Graphe", null, fenetreGraphe, null);
    		

    	    
    		// Affichage de la fenêtre
    		fenetre.setVisible(true);
    		  ArrayList<Long> valeurBacktracking = new ArrayList<Long>();
    	      	ArrayList<Long> valeurDsatur = new ArrayList<Long>();
    	      	ArrayList<Long> valeurTabucol = new ArrayList<Long>();
    	    		int [][]graph;
    	    		for(int i=5;i<50;i++){
    	    			System.out.println( "\n\n----------starrrt --------- nombre de noeuds ="+ i);
    	        		graph = creerUneMatriceAleatoire(i);
    	        		long startTime ;
    	        	 	long stopTime ;
    	        	 	long elapsedTime ;
    	        	 	
    	        	 	startTime = System.nanoTime();
    	        		backtrackingSequentialColoring(graph);
    	        		stopTime = System.nanoTime();
    	        		elapsedTime = stopTime - startTime;
    	        		valeurBacktracking.add(elapsedTime);
    	        		
    	        		
    	        	 	startTime = System.nanoTime();
    	        		dsature(graph);
    	        		stopTime = System.nanoTime();
    	        		elapsedTime = stopTime - startTime;
    	        		valeurDsatur.add(elapsedTime);
    	        		
    	        		
    	        	 	startTime = System.nanoTime();
    	        		tabucol(graph);
    	        		stopTime = System.nanoTime();
    	        		elapsedTime = stopTime - startTime;
    	        		valeurTabucol.add(elapsedTime);
    	        		System.out.println( "----------end---------\n\n");
    	        	}
    	            final XYSeries series1 = new XYSeries(" BSC ");
    	            for (int i=0;i<45;i++){
    	            	System.out.println(i);
    	            	double lol = valeurBacktracking.get(i).doubleValue();
    	    			series1.add( i  ,lol);
    	    		}
    	            
    	           
    	            final XYSeries series2 = new XYSeries(" Dsatur ");
    	            for (int i=0;i<45;i++){
    	            	double lol = valeurDsatur.get(i).doubleValue();
    	    			series2.add( i  ,lol);
    	    		}

    	            final XYSeries series3 = new XYSeries(" Tabucol ");
    	            for (int i=0;i<45;i++){
    	            	double lol = valeurTabucol.get(i).doubleValue();
    	    			series3.add(i ,lol );
    	    		}

    	            final XYSeriesCollection dataset = new XYSeriesCollection();
    	            dataset.addSeries(series1);
    	            dataset.addSeries(series2);
    	            dataset.addSeries(series3);
    	    		
    	    		
    	    		JFreeChart lineChart2 = ChartFactory.createXYLineChart(
    	         	         "Salut",
    	         	         "Years","Number of Schools",
    	         	         dataset,
    	         	         PlotOrientation.VERTICAL,
    	         	         true,true,false);
    	         	         
    	         	      ChartPanel chartPanel2 = new ChartPanel( lineChart2 );
    	         	      chartPanel2.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
    	         	      fenetreGraphe.add(chartPanel2);

   /*	
    		//Tamere
    		//Graphe  de Petersen
	   		Map<Integer, Noeud> noeuds;
    		noeuds = backtrackingSequentialColoring(coucou);
    		noeuds = dsature(coucou);

   ================================== CREATION D'UN GRAPHE ==========================================================    		
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
   /*=============================================================================================   		

		    
    		System.out.println("--------DSATURE--------");
    		noeuds = dsature(graphbizarre);
    		for(int i=0;i<noeuds.size();i++){
        		System.out.println("Couleur Du noeud"+i+" est :"+noeuds.get(i).getCouleurCourante());
        	}
    		//drawGraph(graphbizarre,noeuds);
    		System.out.println("--------TABUCOL--------");

    		noeuds = tabucol(graphbizarre);

    		for(int i=0;i<noeuds.size();i++){
        		System.out.println("Couleur Du noeud"+i+" est :"+noeuds.get(i).getCouleurCourante());
        	}
        	*/
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
    
    public static int[][] creerUneMatriceAleatoire(int nbNoeuds){
		int [][] coucou1 = new int[nbNoeuds][nbNoeuds] ; 
		int lol;
		for (int i=0;i<nbNoeuds;i++){
			for(int j=0;j<nbNoeuds;j++){
				lol = randInt(0,40);
				if(lol>19 )
					coucou1[i][j]=1;
				else
					coucou1[i][j]=0;
			}
		}
		for (int i=0;i<nbNoeuds;i++){
			for(int j=0;j<nbNoeuds;j++){
				if(coucou1[i][j]==1 )
					if(coucou1[j][i]==0){
						coucou1[j][i]=1;
					}
			}
		}
		for (int i=0;i<nbNoeuds;i++){
			for(int j=0;j<nbNoeuds;j++){
				if(coucou1[i][j]==0 )
					if(coucou1[j][i]==1){
						coucou1[j][i]=0;
					}
			}
		}
		return coucou1;
    }

public static int randInt(int min, int max) {

    // NOTE: This will (intentionally) not run as written so that folks
    // copy-pasting have to think about how to initialize their
    // Random instance.  Initialization of the Random instance is outside
    // the main scope of the question, but some decent options are to have
    // a field that is initialized once and then re-used as needed or to
    // use ThreadLocalRandom (if using at least Java 1.7).
    Random rand = new Random();

    // nextInt is normally exclusive of the top value,
    // so add 1 to make it inclusive
    int randomNum = rand.nextInt((max - min) + 1) + min;

    return randomNum;
}

    
    public static void drawGraph(int matriceAdjacence[][],Map<Integer, Noeud> noeuds){
    	fenetreCalcul.remove(scrollPane);
   		mxGraph graph = new mxGraph();
  	    Object parent = graph.getDefaultParent();
  	    HashMap hm = new HashMap();
  	    String edgeStyle = mxConstants.STYLE_ENDARROW + "=" + mxConstants.ARROW_OVAL;
  	    graph.getModel().beginUpdate();
		try {
		int x=20;
		int y=20;
		int indicateur_Position = 0;
		for(int i=0;i<noeuds.size();i++){
    		System.out.println("Couleur Du noeud"+i+" est :"+noeuds.get(i).getCouleurCourante());
    		
    		// Coloration des sommets du graphe
    		String colorVertex = new String();
    		switch (noeuds.get(i).getCouleurCourante()){
    		
    		   case 0:  colorVertex = mxConstants.STYLE_FILLCOLOR + "=#E2E1E1";
    		   			
    				    break;
        	   case 1:  colorVertex = mxConstants.STYLE_FILLCOLOR + "=#FE6868"; 
                		break;
		       case 2:  colorVertex = mxConstants.STYLE_FILLCOLOR + "=#9E87FB";
		                break;
		       case 3:  colorVertex = mxConstants.STYLE_FILLCOLOR + "=#8BFB87";
		                break;
		       case 4:  colorVertex = mxConstants.STYLE_FILLCOLOR + "=#FBF887";
		                break;
		       case 5:  colorVertex = mxConstants.STYLE_FILLCOLOR + "=#FBCD87";
		                break;
		       case 6:  colorVertex = mxConstants.STYLE_FILLCOLOR + "=#87FBF4";
		                break;
		       case 7:  colorVertex = mxConstants.STYLE_FILLCOLOR + "=#A18B6E";
		                break;
		       case 8:  colorVertex = mxConstants.STYLE_FILLCOLOR + "=#A492A4";
		                break;	
    		}
    		// Création d'un sommet du graphe
    		hm.put("v"+i, graph.insertVertex(null, null, i, x, y, 40, 40, colorVertex+";"+mxConstants.STYLE_SHAPE + "="+mxConstants.SHAPE_ELLIPSE+";"+mxConstants.STYLE_EDITABLE +"=0;" )); 
    		
    		
    		
    		// Modification du positionnement du prochain sommet
    		if (indicateur_Position==0){
    			y = 200;
    			 x = x + 75;
    			indicateur_Position = 1;
    		}
    		
    		else if(indicateur_Position==1){
    			y = 325;
   			 	x = x + 75;
   			 	indicateur_Position = 2;
    		}
    		
    		else if(indicateur_Position==2){
    			y = 425;
   			 	x = x + 75;
   			 	indicateur_Position = 3;
    		}
    		else{
    		   y = 20;
    		   x = x + 75;
    		    indicateur_Position = 0;
    		}
    		
    		
    		/* RANDOM Position
    		 * x = 40 + (int)(Math.random() * ((200 - 40) + 1));
    		y = 40 + (int)(Math.random() * ((200 - 40) + 1)); */
    		
    		// Création des arcs
    		for(int k=0;k<noeuds.size();k++){	
    			if (matriceAdjacence[i][k]== 1 ){ 
    				graph.insertEdge(null, null, "", (Object)hm.get("v"+i), (Object)hm.get("v"+k),edgeStyle+";"+mxConstants.STYLE_MOVABLE +"=0" );
    				graph.insertEdge(null, null, "", (Object)hm.get("v"+k), (Object)hm.get("v"+i),edgeStyle+";"+mxConstants.STYLE_MOVABLE +"=0" );
    			}
    		}
    	}
}
		
	     finally {
	      graph.getModel().endUpdate();
	    }   	 
		graph.setCellsEditable(false);
		graph.setCellsResizable(false);
		graph.setCellsDisconnectable(false);
		graph.setAllowDanglingEdges(false);
		graph.setCellsCloneable(false);
	    mxGraphComponent graphComponent = new mxGraphComponent(graph);
	    
	    scrollPane = new JScrollPane(graphComponent);
	    fenetreCalcul.add(scrollPane, BorderLayout.CENTER);
	    fenetreCalcul.revalidate();
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
 public static boolean isConflit(int matriceAdjacence[][],Map<Integer, Noeud> noeuds,int indexNoeud){
	int nbNoeud = matriceAdjacence[0].length;
 	for (int j=0;j<nbNoeud;j++){
    	
		if(matriceAdjacence[indexNoeud][j]==1&&indexNoeud !=j){
			
			if(noeuds.get(j).getCouleurCourante()==noeuds.get(indexNoeud).getCouleurCourante() ){
		
				return false;
				
			}
			
			
		}
	}
 	return true;
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
 	//Ne s'arrÃªte pas tant que tous les noeuds ne sont pas coloriÃ©s
 	
 	for (int i=0;i<noeuds.size();i++){
 	
 		
 		//On calcul le degres de saturation max courant pour les noeuds non coloriÃ©
 		degresDeSaturationMaxCourant=calculLeDegresDeSaturationMaxDuGraphEtDeChaqueNoeud(noeuds,matriceAdjacence);
 		
 		//Ensuite on rÃ©cupÃ¨re ces noeuds encore non coloriÃ©s qui possÃ¨de ce degres de saturation
 		noeudsParDegresDeSaturation=getNoeudsByDegresDeSaturation(noeuds,degresDeSaturationMaxCourant);
 		
 		//Si il y a des Ã©galitÃ©s (En gros si on rÃ©cupÃ¨re plus d'un noeud) : 
 		if(noeudsParDegresDeSaturation.size()>1){
 			//On priorise par degres le plus eleve
 			//Donc on calcul le degres le plus eleve des noeuds prÃ©sent dans la liste choisies 
 			degresLePlusEleve=calculDegresLePlusEleve(noeudsParDegresDeSaturation);
 			//Puis on choisi le premier noeud avec ce degres dans la liste
 			int indexNoeud=getIndexNoeudByDegres(noeudsParDegresDeSaturation,degresLePlusEleve); 
 			
 			//On rÃ©cupÃ¨re la couleur de ces voisins
 			couleursDesVoisins = getCouleursDesVoisins(noeuds,matriceAdjacence,indexNoeud); 
 			
 			//Puis on colorie avec la couleurs la plus petite disponible ( cette couleur est trouvÃ© par la fonction "getCouleurLaPlusPetiteDisponible")
 	
 			noeuds.get(indexNoeud).setCouleurCourante(getCouleurLaPlusPetiteDisponible(couleursDesVoisins,nbCouleurMax));

 			
 		}
 		//Sinon si il n'y a qu'un seul noeud
 		else if(noeudsParDegresDeSaturation.size()==1){
 			//Pas besoin de priorisÃ©, on calcul directement la couleur la plus petite disponible du noeuds et on le colorie avec cette derniÃ¨re.
 			int indexNoeud=noeudsParDegresDeSaturation.get(0).getNumeroNoeud();
 			couleursDesVoisins = getCouleursDesVoisins(noeuds,matriceAdjacence,indexNoeud); 
 			noeuds.get(indexNoeud).setCouleurCourante(getCouleurLaPlusPetiteDisponible(couleursDesVoisins,nbCouleurMax));
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
    	int noeudCourant;
    	int nbNoeud = matriceAdjacence[0].length;
    	boolean conditionRespectee;
    	//Le noeud courant est le 1er noeud rencontrÃ© qui possÃ¨de la couleur neutre : 0.
    	noeudCourant=getIndexPremierNoeudNonColorier(noeuds);

    	
    	//On regarde si la "liste des couleurs deja utilisÃ©e" du noeud courant est au max
    	//Si c'est le cas cela veut dire que toutes les couleurs ont deja Ã©taient tentÃ© sur ce noeuds sans succÃ¨s
    	//Il faut donc dÃ©colorer le noeuds d'avant et rappeler la fonction.
    	if(noeudCourant > 0 && noeuds.get(noeudCourant).getListeCouleurDejaUtilisee().size()==nbCouleurMax){
    		noeuds.get(noeudCourant-1).setCouleurCourante(0);
    		noeuds.get(noeudCourant).getListeCouleurDejaUtilisee().clear();
    		algoRecursifBacktracking(noeuds,matriceAdjacence,nbCouleurMax);
    		System.out.println(noeudCourant-1 + " C'est un noeud courant eheh");
    	}
    	
    	//Coloration du noeud courant avec une couleur qu'il n'a jamais rencontrÃ©
    	noeuds.get(noeudCourant).setCouleurCourante(getIndexPremiereCouleurNonDejaUtilise(noeuds,noeudCourant,nbCouleurMax));
    	
    	//tester si la condition de coloration est vÃ©rifiÃ©e
    	conditionRespectee=isConflit(matriceAdjacence,noeuds,noeudCourant);
    	//for (int j=0;j<nbNoeud;j++){
    	
    		//if(matriceAdjacence[noeudCourant][j]==1&&noeudCourant !=j){
    			
    			//if(noeuds.get(j).getCouleurCourante()==noeuds.get(noeudCourant).getCouleurCourante() ){
    		
    				//conditionRespectee=false;
    				
    			//}
    			
    			
    		//}
    	//}
    	
    	if(conditionRespectee==false){
    		//On dÃ©colore le noeud
    		noeuds.get(noeudCourant).setCouleurCourante(0);
    		//Et on le redonne Ã  manger Ã  l'algorithme rÃ©cursif.
    		algoRecursifBacktracking(noeuds,matriceAdjacence,nbCouleurMax);
    	}
    	else{
    		//Si c'est vrai on regarde si tous les noeuds sont coloriÃ©s
    		//Si c'est le cas, alors on sort de la boucle rÃ©cursive
    		if(areAllColored(noeuds)==true){
    			return;
    		}
    		//Sinon on rappelle la fonction rÃ©cursive.
    		algoRecursifBacktracking(noeuds,matriceAdjacence,nbCouleurMax);
    	}
    	
    	
		
    }


    public static Map<Integer, Noeud> tabucol(int matriceAdjacence[][]){
    	//Initialisation
    	Map<Integer, Noeud> noeuds = new HashMap<Integer, Noeud>();
    	int taille = matriceAdjacence[0].length;
    	int nbCouleurMax = calculNombreChromatique(matriceAdjacence);
    	int nbConflitCourant=0;
    	//Colorier les noeuds du graphe de maniÃ¨re arbitraire
    	int couleurAleatoire = 1;
    	for (int i=0;i<taille;i++){
    		Noeud noeud = new Noeud();
    		noeud.setNumeroNoeud(i);
    		noeud.setCouleurCourante(couleurAleatoire);
			noeuds.put(i, noeud);
		}
    	
    	//System.out.println("Nombre de conflit : "+ calculLeNombreDeConflit(noeuds,matriceAdjacence,nbCouleurMax));
    	long startTime = System.nanoTime();
    	nbConflitCourant = calculLeNombreDeConflit(noeuds,matriceAdjacence,nbCouleurMax);
    	int nbCompteurTaboue=0;
    	while(nbConflitCourant>0){
    		
    	if(nbCompteurTaboue==9){
    		for(int i=0;i<noeuds.size();i++){
        		noeuds.get(i).getListeCouleurTaboue().clear();
        	}
    	}
    	nbCompteurTaboue++;
  
    	
    	int couleurTampon;
    	int nbConflitCourant1;
    	LeMeilleurChoixPossible lmcp= new LeMeilleurChoixPossible();
    	for (int i=0;i<noeuds.size();i++){
    		nbConflitCourant1 = nombreDeConflitAssocieAuNoeud(noeuds.get(i),matriceAdjacence,noeuds);
    		if(nbConflitCourant1>0){
	    		lmcp.setCouleur(noeuds.get(i).getCouleurCourante());
	    		lmcp.setNbConflit(nbConflitCourant1);
	    		
	    		for(int j=1;j<=nbCouleurMax;j++){
	    				couleurTampon = noeuds.get(i).getCouleurCourante();
	    				if(!noeuds.get(i).getListeCouleurTaboue().contains(j)){
	    					noeuds.get(i).setCouleurCourante(j);
	    					nbConflitCourant1 = nombreDeConflitAssocieAuNoeud(noeuds.get(i),matriceAdjacence,noeuds);
	    					if(nbConflitCourant1<lmcp.getNbConflit()){
	    						lmcp.setNbConflit(nbConflitCourant1);
	    						lmcp.setCouleur(j);
	    						lmcp.setCouleurTampon(couleurTampon);
	    					}
	    				}
	    				
	        		}
	    		
	    		noeuds.get(i).setCouleurCourante(lmcp.getCouleur());
	    		noeuds.get(i).getListeCouleurTaboue().add(lmcp.getCouleurTampon());
    		}
        	}
    	nbConflitCourant=calculLeNombreDeConflit(noeuds,matriceAdjacence,nbCouleurMax);
    	}
    	
    	
    	
    	
    	
    	
    
    	//System.out.println("Le meilleur choix possible est de colorier le noeud :"+mcp.getNumeroNoeud()+" avec la couleur"+mcp.getCouleur()+", cela genÃ¨re "+mcp.getNbConflit()+" conflits");
          long stopTime = System.nanoTime();
	      long elapsedTime = stopTime - startTime;
	      System.out.println("tabucol = "+elapsedTime);
    	return noeuds;
    }



    
    
}

