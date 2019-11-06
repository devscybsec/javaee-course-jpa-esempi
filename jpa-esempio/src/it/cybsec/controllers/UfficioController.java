package it.cybsec.controllers;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import it.cybsec.daos.UfficioDao;
import it.cybsec.models.Ufficio;

/**
 * Servlet implementation class DipendentiController
 */
@WebServlet(urlPatterns = { "/ufficio" })
public class UfficioController extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
    private final UfficioDao dao;  
	
    public UfficioController() {
        super();
        dao = new UfficioDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("ufficio", dao.recupera(Integer.parseInt(request.getParameter("id"))));
		request.getServletContext().getRequestDispatcher("/ufficio.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Ufficio ufficio = dao.recupera(Integer.parseInt(request.getParameter("id")));
			ufficio.setNome(request.getParameter("nome"));
			ufficio.setDimensioni(Integer.parseInt(request.getParameter("dimensioni")));
			dao.salva(ufficio);
			response.sendRedirect("./uffici");
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
