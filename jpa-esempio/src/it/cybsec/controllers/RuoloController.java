package it.cybsec.controllers;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import it.cybsec.daos.RuoloDao;
import it.cybsec.models.Ruolo;

/**
 * Servlet implementation class DipendentiController
 */
@WebServlet(urlPatterns = { "/ruolo" })
public class RuoloController extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
    private final RuoloDao dao;  
	
    public RuoloController() {
        super();
        dao = new RuoloDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("ruolo", dao.recupera(Integer.parseInt(request.getParameter("id"))));
		request.getServletContext().getRequestDispatcher("/ruolo.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Ruolo ruolo = dao.recupera(Integer.parseInt(request.getParameter("id")));
			ruolo.setNome(request.getParameter("nome"));
			dao.salva(ruolo);
			response.sendRedirect("./ruoli");
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
