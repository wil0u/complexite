package com.complexite.love;

public class Conflit {
	int numeroNoeud1;
	int numeroNoeud2;
	boolean conflitDifficile=false;
	
	public boolean isConflitDifficile() {
		return conflitDifficile;
	}
	public void setConflitDifficile(boolean conflitDifficile) {
		this.conflitDifficile = conflitDifficile;
	}
	public int getNumeroNoeud1() {
		return numeroNoeud1;
	}
	public void setNumeroNoeud1(int numeroNoeud1) {
		this.numeroNoeud1 = numeroNoeud1;
	}
	public int getNumeroNoeud2() {
		return numeroNoeud2;
	}
	public void setNumeroNoeud2(int numeroNoeud2) {
		this.numeroNoeud2 = numeroNoeud2;
	}
	
	public Conflit(){
		
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numeroNoeud1;
		result = prime * result + numeroNoeud2;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conflit other = (Conflit) obj;
		if (numeroNoeud1 != other.numeroNoeud1)
			return false;
		if (numeroNoeud2 != other.numeroNoeud2)
			return false;
		return true;
	}
	public Conflit(int numeroNoeud1, int numeroNoeud2) {
		super();
		this.numeroNoeud1 = numeroNoeud1;
		this.numeroNoeud2 = numeroNoeud2;
	}

	

}
