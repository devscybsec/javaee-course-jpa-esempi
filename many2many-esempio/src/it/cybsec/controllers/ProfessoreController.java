package it.cybsec.controllers;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import it.cybsec.daos.*;
import it.cybsec.models.*;
import it.cybsec.utils.DateFormatter;

/**
 * Servlet implementation class DipendentiController
 */
@WebServlet(urlPatterns = { "/professore" })
public class ProfessoreController extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
    private final ProfessoreDao dao;
	
    public ProfessoreController() {
        super();
        dao = new ProfessoreDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id != "" && id != null) {
			Professore professore = dao.recupera(Integer.parseInt(id));
			
			request.setAttribute("professore", professore);
			request.getServletContext().getRequestDispatcher("/professore.jsp").forward(request, response);
		} else {
			request.setAttribute("errore", "L'id del professore non può essere vuoto!");
			request.getServletContext().getRequestDispatcher("/errore.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Professore professore = dao.recupera(Integer.parseInt(request.getParameter("id")));
			professore.setNome(request.getParameter("nome"));
			professore.setCognome(request.getParameter("cognome"));
			professore.setDataNascita(DateFormatter.parse(request.getParameter("datanascita")));
			dao.salva(professore);
			response.sendRedirect("./professori");
		} catch(Exception e) {
		}
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			dao.elimina(dao.recupera(Integer.parseInt(request.getParameter("id"))));
		} catch(Exception e) {
		}
	}

}
