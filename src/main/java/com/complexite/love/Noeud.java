package com.complexite.love;

import java.util.LinkedList;
import java.util.ListIterator;

public class Noeud {
	   String nom;
	   public String getNom() {
	    return nom;
	   }

	   Graphe graphe;

	   public Noeud (String nom, Graphe graphe){
	    this.nom = nom;
	    this.graphe = graphe;
	    graphe.listeNoeuds.add(this);
	   }

	   public String toString(){
	    return new String("   noeud: "+ this.getNom());
	   }

	   public Object[] getChildren( Noeud noeud){
	    LinkedList<Noeud> children = new LinkedList<Noeud> ();
	    ListIterator<Arc> liArc = graphe.listeArcs.listIterator();
	    while (liArc.hasNext()){
	       Arc arcCourant = liArc.next();
	       if (arcCourant.getNoeudOrigine().getNom().equals(noeud.getNom())){
	        children.add(arcCourant.getNoeudExtremite());
	       }
	    }
	    return children.toArray();
	   }

	   public Boolean hasChildren(){
	    return (getChildren(this).length != 0 );
	   }
}
