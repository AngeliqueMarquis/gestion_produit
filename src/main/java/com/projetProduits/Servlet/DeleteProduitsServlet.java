package com.projetProduits.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projetProduits.Bean.Produits;
import com.projetProduits.Dao.ProduitsDaoImpl;


/**
 * Servlet implementation class DeleteProduitsServlet
 */
@WebServlet("/DeleteProduitsServlet")
public class DeleteProduitsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public DeleteProduitsServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String idPdts = request.getParameter("delete");
		Integer idProduits = null;

		try {
			idProduits = Integer.parseInt(idPdts);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

		ProduitsDaoImpl dao = new ProduitsDaoImpl();
		dao.delete(idProduits);

		ArrayList<Produits> listeProduits = dao.getAll();

		request.setAttribute("listeProduits", listeProduits);

		this.getServletContext().getRequestDispatcher("/WEB-INF/EditProduits.jsp").forward(request, response);
	}

}
