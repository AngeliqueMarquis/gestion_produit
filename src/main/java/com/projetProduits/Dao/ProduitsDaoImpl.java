package com.projetProduits.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.projetProduits.Bean.Produits;
import com.projetProduits.Connect.Connect;


public class ProduitsDaoImpl implements ProduitsDao{
	
	private Connect conn;
	
	public ProduitsDaoImpl() {
		this.conn = Connect.initConnection();}
		

		@Override
		public int add(Produits produit) {

			Connect connexion = this.conn;
			int rs = 0;
			String insert = "INSERT INTO produits ( nomproduits, prixproduits) VALUES (?,?)";

			try {
			Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}	System.out.print("Erreur");
			try {
				Connection conn = (Connection) DriverManager.getConnection(connexion.getUrl(), connexion.getUser(),
						connexion.getPassword()
			
				);
			
				PreparedStatement st = (PreparedStatement) conn.prepareStatement(insert);
				
				
				st.setString(1, produit.getNomProduit());
				st.setFloat(2, produit.getPrixProduit());
				
				
				rs = st.executeUpdate();
				System.out.println("- " + rs + " ligne ajouté");

				conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("-SQLException!");
				System.out.println(e.toString());
			}

			System.out.println("-return indice methode add()");
			return rs;
		
		}


		@Override
		public int delete(int idProduit) {
			// TODO Auto-generated method stub
			String supp = "DELETE FROM produits WHERE idProduits = ?;";
			Connect connexion = this.conn;
			int rs = 0;

			try {
				Class.forName("org.postgresql.Driver");
				} catch (ClassNotFoundException e) {
					throw new RuntimeException(e);
				}
				try {
					Connection conn = (Connection) DriverManager.getConnection(connexion.getUrl(), connexion.getUser(),
							connexion.getPassword()
					);
					
					PreparedStatement st = (PreparedStatement) conn.prepareStatement(supp);
					st.setInt(1, idProduit);

				rs = st.executeUpdate();
				System.out.println(rs + " ligne supprimes");
				conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("-SQLException!");
				System.out.println(e.toString());
			}

			System.out.println("-return indice methode delete()");
			return rs;

		}


		@Override
		public int update(Produits produit, int idProduit) {
			// TODO Auto-generated method stub
			String update = "UPDATE produits SET idProduits=?, nomProduit=?, prixProduit=?";
			Connect connexion = this.conn;
			int rs = 0;

			try {
				Class.forName("org.postgresql.Driver");
				} catch (ClassNotFoundException e) {
					throw new RuntimeException(e);
				}
				try {
					Connection conn = (Connection) DriverManager.getConnection(connexion.getUrl(), connexion.getUser(),
							connexion.getPassword()
					);
					
					PreparedStatement st = (PreparedStatement) conn.prepareStatement(update);
					st.setInt(1, produit.getIdProduit());
					st.setString(2, produit.getNomProduit());
					st.setFloat(3, produit.getPrixProduit());
					
					

				rs = st.executeUpdate();
				System.out.println(rs + " ligne maj");
				conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("-SQLException!");
				System.out.println(e.toString());
			}

			System.out.println("-return indice methode update()");
			return rs;
		}


		@Override
		public ArrayList<Produits> getAll() {
			// TODO Auto-generated method stub
			String read ="SELECT * FROM produits";

			System.out.println("-execution methode getAll()");
			Connect connexion = this.conn;
			//Méthode tableau
			ArrayList <Produits> ListeProduits = new ArrayList<>();

	        try {
	            System.out.println("-chargement driver JDBC");
	            Class.forName("org.postgresql.Driver");
	        } catch (ClassNotFoundException e) {
	            throw new RuntimeException(e);
	        }
	        PreparedStatement st;
	        try {
	            System.out.println("-Creation de la connection avec les parametres");
	            Connection conn = (Connection) DriverManager.getConnection(
	                   connexion.getUrl(), connexion.getUser(), connexion.getPassword()
	            );
	            System.out.println("-Préparation de la requete");
	            st = (PreparedStatement) conn.prepareStatement(read);
	            ResultSet result = st.executeQuery();

	            while(result.next()) {
	                int idProduit = result.getInt(1);
	                String nomProduit = result.getString(2);
	                float prixProduit  = Float.parseFloat(result.getString(3));
	                

	                Produits addProduits = new Produits(idProduit, nomProduit, prixProduit);

	                ListeProduits.add(addProduits);

	            }
	            System.out.println("-Cloture de la connection");
	            conn.close();

	        } catch (SQLException e) {
	            System.out.println("-SQLException!");
	        } 
	        return ListeProduits;
		}


		@Override
		public Produits getOne(int idProduits) {
			// TODO Auto-generated method stub
			String readOne ="SELECT * FROM produits WHERE idProduits =?;";

			System.out.println("-execution methode getAll()");
			Connect connexion = this.conn;
			
			Produits produits = new Produits();
	        try {
	            System.out.println("-chargement driver JDBC");
	            Class.forName("org.postgresql.Driver");
	        } catch (ClassNotFoundException e) {
	            throw new RuntimeException(e);
	        }
	        PreparedStatement st;
	        try {
	            System.out.println("-Creation de la connection avec les parametres");
	            Connection conn = (Connection) DriverManager.getConnection(
	                   connexion.getUrl(), connexion.getUser(), connexion.getPassword()
	            );
	            System.out.println("-Préparation de la requete");
	            st = (PreparedStatement) conn.prepareStatement(readOne);
	            ResultSet result = st.executeQuery();
	            while(result.next()) {
	                int idProduit = result.getInt(1);
	                String nomProduit = result.getString(2);
	                float prixProduit  = Float.parseFloat(result.getString(3));
	                
	                produits.setIdProduit(idProduit);
	                produits.setNomProduit(nomProduit);
	                produits.setPrixProduit(prixProduit);

	            }
	            System.out.println("-Cloture de la connection");
	            conn.close();

	        } catch (SQLException e) {
	            System.out.println("-SQLException!");
	        } 
	        return produits;
		}
	        


}
