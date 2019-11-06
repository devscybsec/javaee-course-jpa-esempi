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
@WebServlet(urlPatterns = { "/ruoli" })
public class RuoliController extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
    private final RuoloDao dao;  
	
    public RuoliController() {
        super();
        dao = new RuoloDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("ruoli", dao.recupera());
		request.getServletContext().getRequestDispatcher("/ruoli.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			dao.nuovo(new Ruolo(request.getParameter("nome")));
			response.sendRedirect("./ruoli");
		} catch(Exception e) {
		}
	}

}
