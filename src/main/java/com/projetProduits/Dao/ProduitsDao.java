package com.projetProduits.Dao;

import java.util.ArrayList;

import com.projetProduits.Bean.Produits;

public interface ProduitsDao {

	int add(Produits produit);

	int delete(int idProduits);

	int update(Produits produit, int idProduits);

	ArrayList<Produits> getAll();

	Produits getOne(int idProduits);
}
