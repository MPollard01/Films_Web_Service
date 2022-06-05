package webservice.film.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webservice.film.model.FilmDAO;
import webservice.film.utils.FilmParser;
import webservice.film.model.Film;

/**
 * Servlet implementation class GetFilms
 */
@WebServlet("/getfilms")
public class GetFilms extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		FilmDAO f = FilmDAO.getInstance();
		ArrayList<Film> films = (ArrayList<Film>) f.listFilm();
		PrintWriter pw = response.getWriter();
		String format = request.getParameter("format");
		String address;
		String data = "";
		
		if (films == null) {
			address = "/WEB-INF/view/unknown-film.jsp";
		} else if (format.equals("json")) {
			response.setContentType("application/json");
			data = FilmParser.parseJson(films);
			address = "/WEB-INF/view/film-json.jsp";
			request.setAttribute("data", data);
		} else if (format.equals("xml")) {
			response.setContentType("text/xml");
			data = FilmParser.parseXml(films);
			pw.println(data);	
			address = "/WEB-INF/view/film-xml.jsp";
		} else {
			response.setContentType("text/plain");
			data = FilmParser.parseText(films);
		    address = "/WEB-INF/view/film-string.jsp";
		    request.setAttribute("data", data);
		}	
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
		
		pw.close();
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
