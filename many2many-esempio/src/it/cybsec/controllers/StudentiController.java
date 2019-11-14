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
@WebServlet(urlPatterns = { "/studenti" })
public class StudentiController extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
    private final StudenteDao dao;
	
    public StudentiController() {
        super();
        dao = new StudenteDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("studenti", dao.recupera());
		request.getServletContext().getRequestDispatcher("/studenti.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Studente studente = new Studente();
			studente.setNome(request.getParameter("nome"));
			studente.setCognome(request.getParameter("cognome"));
			studente.setDataNascita(DateFormatter.parse(request.getParameter("datanascita")));
			dao.nuovo(studente);
			response.sendRedirect("./studenti");
		} catch(Exception e) {
			request.setAttribute("errore", e.toString());
			request.getServletContext().getRequestDispatcher("/errore.jsp").forward(request, response);
		}
	}

}
