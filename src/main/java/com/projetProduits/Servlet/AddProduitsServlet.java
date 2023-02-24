package com.projetProduits.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projetProduits.Bean.Produits;
import com.projetProduits.Dao.ProduitsDaoImpl;

/**
 * Servlet implementation class AddProduitsServlet
 */
@WebServlet("/AddProduitsServlet")
public class AddProduitsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProduitsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		ProduitsDaoImpl dao = new ProduitsDaoImpl();
		ArrayList<Produits>ListeProduits=dao.getAll();
		request.setAttribute("listeProduits", ListeProduits);

		this.getServletContext().getRequestDispatcher("/WEB-INF/ListeProduits.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		boolean redirect = false; 
		//Le return de la méthode passe à true si on doit renvoyer au jsp ListeProduits
		
		String nomProduit = request.getParameter("nomProduit");
		if(nomProduit.equals("")) { //Si le champ nomProduit est vide
			request.setAttribute("erreur NomProduit", "Le champ nomProduit ne doit pas être vide");//on envoie l'erreur a l'index
			redirect = true;//on redirige vers l'index
		}
		
				
		String prixProduit = request.getParameter("prixProduit");
		if(prixProduit.equals("")) {
			request.setAttribute("erreur prixProduit", "Le champ prixProduit ne doit pas être vide");
			redirect=true;
		} else if (!Pattern.matches("^([0-9]+[.][0-9]{1,2})|([0-9]+)$", prixProduit)) {//si l'input ne correspond pas a un nombre (entier ou decimal avec 2 decimales max)
			request.setAttribute("erreur prixProduit", "Le champ salaire doit être un nombre decimal (2 decimales max)");
			redirect=true;
		}
		
				
		if (redirect) {// si on doit rediriger vers ajoutProduits
			request.setAttribute("defaultNomProduit", nomProduit);
			request.setAttribute("defaultPrixProduit", prixProduit);
			this.getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		}

		
		System.out.println("-Creation de l'objet Gestion des Produits");
		
		Produits produit = new Produits();
		String nomProduits = request.getParameter("nomProduit");
		float prixProduits = Float.parseFloat(request.getParameter("prixProduit"));
		
		produit.setNomProduit(nomProduits);
		produit.setPrixProduit(prixProduits);
		
		request.setAttribute("nomProduit", nomProduits);
		request.setAttribute("prixProduit", prixProduits);
		

		System.out.println("Creation de l'objet ProduitsDaoImpl");
		ProduitsDaoImpl ProduitsDao = new ProduitsDaoImpl();
		
		System.out.println("Appel de la methode add() sur ProduitsDaoImpl");
		int resultat = ProduitsDao.add(produit);
		
		System.out.println("Le nombre des lignes modifiées : " + resultat);

		this.getServletContext().getRequestDispatcher("/WEB-INF/ListeProduits.jsp").forward(request,response);
	}
	}


