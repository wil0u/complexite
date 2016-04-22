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
    		int coucou[][] =  {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    		System.out.println(calculNombreChromatique(coucou));
    		
    		
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
    
    
    public static ArrayList<String> backtrackingSequentialColoring(int matriceAdjacence[][]){
    	
    	return null;
    }
    
    
    
}

