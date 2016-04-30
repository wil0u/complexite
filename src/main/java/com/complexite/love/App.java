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
import java.awt.GridLayout;

//Classe Main ! 
public class App 
{
	
	
	
	static JScrollPane scrollPane = new JScrollPane();
	static BackTrackingSequential bsc = new BackTrackingSequential();
	static Dsatur dsatur = new Dsatur();
	static Tabucol tabucol = new Tabucol();
    static JPanel fenetreCalcul = new JPanel();
	static JScrollPane scrollGraphe = new JScrollPane();
    //Déclaration des graphes d'exemples avec leur matrice d'adjacence
    
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
    	    fenetre.setSize(1200, 600);
    	    
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
    	    
    	    //Liste déroulante pour choisir un scénario
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
    	    
    	    
    	    //Fonction executer lorsque l'on clique sur le bouton BSC(Back Tracking Sequential)
    	    JButton btnConfirmerBSC = new JButton("     BSC     ");
    	    btnConfirmerBSC.addMouseListener(new MouseAdapter() {
    	    	@Override
    	    	public void mouseClicked(MouseEvent arg0) {
    	    		System.out.println("get selected index "+comboBoxScenario.getSelectedIndex());
    	    		
    	    		if (comboBoxScenario.getSelectedIndex() == 0) {
    	    			Map<Integer, Noeud> noeuds = bsc.calculer(matrix1);
    					drawGraph(matrix1,noeuds);
    					System.out.println("cas1 ");
    	    		}
    	    		
    	    		else if (comboBoxScenario.getSelectedIndex() == 1) {
    	    			Map<Integer, Noeud> noeuds1 = bsc.calculer(matrix2);
    					drawGraph(matrix2,noeuds1);
    					System.out.println("cas2 ");
    	    		}
    	    		
    	    		else {
    	    			 Map<Integer, Noeud> noeuds2 = bsc.calculer(matrix3);
	    				drawGraph(matrix3,noeuds2);System.out.println("cas3");
    	    		}
    	    		
    	    	}
    	    });
    	    panelConfirmer.add(btnConfirmerBSC);
    	    
    	    JLabel lblConfirmerVide01 = new JLabel("               ");
    	    panelConfirmer.add(lblConfirmerVide01);
    	    
    	    
    	    
    	    //Fonction executer lorsque l'on clique sur le bouton DSATUR
    	    JButton btnConfirmerDSATUR = new JButton(" DSATUR ");
    	    btnConfirmerDSATUR.addMouseListener(new MouseAdapter() {
    	    	@Override
    	    	public void mouseClicked(MouseEvent arg0) {
    	    		if (comboBoxScenario.getSelectedIndex() == 0) {
    	    			Map<Integer, Noeud> noeuds = dsatur.calculer(matrix1);
    					drawGraph(matrix1,noeuds);
    					System.out.println("cas1 ");
    	    		}
    	    		
    	    		else if (comboBoxScenario.getSelectedIndex() == 1) {
    	    			Map<Integer, Noeud> noeuds1 = dsatur.calculer(matrix2);
    					drawGraph(matrix2,noeuds1);
    					System.out.println("cas2 ");
    	    		}
    	    		
    	    		else {
    	    			 Map<Integer, Noeud> noeuds2 = dsatur.calculer(matrix3);
	    				drawGraph(matrix3,noeuds2);System.out.println("cas3");
    	    		}
    	    	}
    	    });
    	    panelConfirmer.add(btnConfirmerDSATUR);
    	    
    	    JLabel lblConfirmerVide02 = new JLabel("               ");
    	    panelConfirmer.add(lblConfirmerVide02);
    	    
    	    
    	  //Fonction executer lorsque l'on clique sur le bouton TABUCOL
    	    JButton btnConfirmerTABUCOL = new JButton("TABUCOL");
    	    btnConfirmerTABUCOL.addMouseListener(new MouseAdapter() {
    	    	@Override
    	    	public void mouseClicked(MouseEvent e) {
    	     		if (comboBoxScenario.getSelectedIndex() == 0) {
    	    			Map<Integer, Noeud> noeuds = tabucol.calculer(matrix1);
    					drawGraph(matrix1,noeuds);
    					System.out.println("cas1 ");
    	    		}
    	    		
    	    		else if (comboBoxScenario.getSelectedIndex() == 1) {
    	    			Map<Integer, Noeud> noeuds1 = tabucol.calculer(matrix2);
    					drawGraph(matrix2,noeuds1);
    					System.out.println("cas2 ");
    	    		}
    	    		
    	    		else {
    	    			 Map<Integer, Noeud> noeuds2 = tabucol.calculer(matrix3);
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
    		
    		// Début de la génération des valeurs pour l'études comparatives ! 
    		ArrayList<Long> valeurBacktracking = new ArrayList<Long>();
    	    ArrayList<Long> valeurDsatur = new ArrayList<Long>();
    	    ArrayList<Long> valeurTabucol = new ArrayList<Long>();
    	      
    	      
    	    int [][]graph;
    	    //La variable i de la boucle correspond au nombre de noeuds
    	    for(int i=3;i<15;i++){
    	    	//On créé un graph aléatoire avec un nombre de noeuds donné i !
    	        graph = creerUneMatriceAleatoire(i);
    	        
    	        long startTime ;
    	        long stopTime ;
    	        long elapsedTime ;
    	        	 	
    	        //Prise des mesures !	 	
    	        startTime = System.nanoTime();
    	        bsc.calculer(graph);
    	        stopTime = System.nanoTime();
    	        elapsedTime = stopTime - startTime;
    	        valeurBacktracking.add(elapsedTime);
    	        		
    	        		
    	        startTime = System.nanoTime();
    	        dsatur.calculer(graph);
    	        stopTime = System.nanoTime();
    	        elapsedTime = stopTime - startTime;
    	        valeurDsatur.add(elapsedTime);
    	        	
    	        		
    	        startTime = System.nanoTime();
    	        tabucol.calculer(graph);
    	        stopTime = System.nanoTime();
    	        elapsedTime = stopTime - startTime;
    	        valeurTabucol.add(elapsedTime);
    	        
    	        
    	    }
    	    
    	    //Génération des deux courbes pour l'étude comparative à l'aide des valeurs prises! 
    	    final XYSeries series1 = new XYSeries(" BSC ");
    	    
    	    for (int i=0;i<12;i++){
    	    	double lol = valeurBacktracking.get(i).doubleValue();
    	    	series1.add( i+3  ,lol);
    	    }
    	            
    	           
    	            final XYSeries series2 = new XYSeries(" Dsatur ");
    	            for (int i=0;i<12;i++){
    	            	double lol = valeurDsatur.get(i).doubleValue();
    	    			series2.add( i+3  ,lol);
    	    		}

    	            final XYSeries series3 = new XYSeries(" Tabucol ");
    	            for (int i=0;i<12;i++){
    	            	double lol = valeurTabucol.get(i).doubleValue();
    	    			series3.add(i+3 ,lol );
    	    		}

    	            final XYSeriesCollection dataset = new XYSeriesCollection();
    	            dataset.addSeries(series1);
    	            dataset.addSeries(series2);
    	            dataset.addSeries(series3);
    	    		
    	            final XYSeriesCollection dataset2 = new XYSeriesCollection();
    	            dataset2.addSeries(series2);
    	            dataset2.addSeries(series3);
    	    		
    	    		//Première courbe! 
    	    		JFreeChart lineChart2 = ChartFactory.createXYLineChart(
    	         	         "Etude comparative des 3 algorithmes",
    	         	         "Nombre de noeuds","Temps (en nano seconde)",
    	         	         dataset,
    	         	         PlotOrientation.VERTICAL,
    	         	         true,true,false);
    	         	         
    	         	      ChartPanel chartPanel2 = new ChartPanel( lineChart2 );
    	         	      chartPanel2.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
    	         	      
    	         	 //Deuxième courbe!      
    	         	 	JFreeChart lineChart3 = ChartFactory.createXYLineChart(
       	         	         "Zoom sur Dsatur et Tabucol",
       	         	         "Nombre de noeuds","Temps (en nano seconde)",
       	         	         dataset2,
       	         	         PlotOrientation.VERTICAL,
       	         	         true,true,false);
       	         	         
       	         	      ChartPanel chartPanel3 = new ChartPanel( lineChart3 );
       	         	      chartPanel3.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
    	         	     
       	         	      //Affichage des deux courbes !
       	         	      JPanel panneau = new JPanel();
       	         	      panneau.add(chartPanel2);
       	      	      	  panneau.add(chartPanel3);

       	         	      scrollGraphe = new JScrollPane (panneau);
       	         	      fenetreGraphe.add(scrollGraphe);
       	         	      
    	         	      System.out.println("Fin de la génération des graphiques !");
    	         	 
  
    }	
    //--------------------------------------------------------------------------FONCTIONS UTILITAIRES-------------------------------------------------------------------------------------------------
    
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

    Random rand = new Random();

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
    

}

