package it.cybsec.controllers;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import it.cybsec.daos.*;
import it.cybsec.models.*;

/**
 * Servlet implementation class DipendentiController
 */
@WebServlet(urlPatterns = { "/corsi" })
public class CorsiController extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
    private final CorsoDao dao;
    private final ProfessoreDao daoProfessore;
    
    public CorsiController() {
        super();
        dao = new CorsoDao();
        daoProfessore = new ProfessoreDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("professori", daoProfessore.recupera());
		request.setAttribute("corsi", dao.recupera());
		request.getServletContext().getRequestDispatcher("/corsi.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Corso corso = new Corso();
			corso.setNome(request.getParameter("nome"));
			corso.setDescrizione(request.getParameter("descrizione"));
			corso.setProfessore(daoProfessore.recupera(Integer.parseInt(request.getParameter("professore"))));
			dao.nuovo(corso);
			response.sendRedirect("./corsi");
		} catch(Exception e) {
			request.setAttribute("errore", e.toString());
			request.getServletContext().getRequestDispatcher("/errore.jsp").forward(request, response);
		}
	}

}
