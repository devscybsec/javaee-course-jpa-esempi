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
@WebServlet(urlPatterns = { "/uffici" })
public class UfficiController extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 1L;
    private final UfficioDao dao;  
	
    public UfficiController() {
        super();
        dao = new UfficioDao();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("uffici", dao.recupera());
		request.getServletContext().getRequestDispatcher("/uffici.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			dao.nuovo(new Ufficio(request.getParameter("nome"),Integer.parseInt(request.getParameter("dimensioni"))));
			response.sendRedirect("./uffici");
		} catch(Exception e) {
		}
	}

}
