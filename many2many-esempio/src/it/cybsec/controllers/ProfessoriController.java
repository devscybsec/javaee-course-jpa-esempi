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
@WebServlet(urlPatterns = { "/professori" })
public class ProfessoriController extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
    private final ProfessoreDao dao;
	
    public ProfessoriController() {
        super();
        dao = new ProfessoreDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("professori", dao.recupera());
		request.getServletContext().getRequestDispatcher("/professori.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Professore pofessore = new Professore();
			pofessore.setNome(request.getParameter("nome"));
			pofessore.setCognome(request.getParameter("cognome"));
			pofessore.setDataNascita(DateFormatter.parse(request.getParameter("datanascita")));
			dao.nuovo(pofessore);
			response.sendRedirect("./professori");
		} catch(Exception e) {
			request.setAttribute("errore", e.toString());
			request.getServletContext().getRequestDispatcher("/errore.jsp").forward(request, response);
		}
	}

}
