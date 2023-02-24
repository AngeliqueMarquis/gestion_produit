package com.projetProduits.Bean;

public class Produits {
	private int idProduit;
	private String nomProduit;
	private float prixProduit;
	
	public int getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}
	public String getNomProduit() {
		return nomProduit;
	}
	public void setNomProduit(String nomProduit) {
		this.nomProduit = nomProduit;
	}
	public float getPrixProduit() {
		return prixProduit;
	}
	public void setPrixProduit(float prixProduit) {
		this.prixProduit = prixProduit;
	}
	@Override
	public String toString() {
		return "Produits [idProduit=" + idProduit + ", nomProduit=" + nomProduit + ", prixProduit=" + prixProduit + "]";
	}
	public Produits(int idProduit, String nomProduit, float prixProduit) {
		super();
		this.idProduit = idProduit;
		this.nomProduit = nomProduit;
		this.prixProduit = prixProduit;
	}
	public Produits() {
		// TODO Auto-generated constructor stub
	}
	
	

}
