package webservice.film.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webservice.film.model.Film;
import webservice.film.model.FilmDAO;
import webservice.film.utils.FilmParser;

/**
 * Servlet implementation class GetFilm
 */
@WebServlet("/getfilm")
public class GetFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetFilm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FilmDAO filmDao = FilmDAO.getInstance();
		Film f = new Film();
		ArrayList<Film> flist = null;
		PrintWriter writer = response.getWriter();
		String option = request.getParameter("option");
		String search = request.getParameter("search");
		String format = request.getParameter("format");
		String address, data = "";
		
		if(option.equals("id")) {
			f = filmDao.getFilmByID(Integer.parseInt(search));
			if (f == null) {
				address = "/WEB-INF/view/unknown-film.jsp";
			} else if (format.equals("json")) {
				response.setContentType("application/json");
				data = FilmParser.parseJson(f);
				address = "/WEB-INF/view/film-json.jsp";
				request.setAttribute("data", data);
			} else if (format.equals("xml")) {
				response.setContentType("text/xml");
				data = FilmParser.parseXml(f);
				writer.println(data);
				address = "/WEB-INF/view/film-xml.jsp";
			} else {
				response.setContentType("text/plain");
				data = f.toString();
			    address = "/WEB-INF/view/film-string.jsp";
			    request.setAttribute("data", data);
			}
		}
		else {
			flist = (ArrayList<Film>) filmDao.retrieveFilm(search);
			if (flist == null) {
				address = "/WEB-INF/view/unknown-film.jsp";
			} else if (format.equals("json")) {
				response.setContentType("application/json");
				data = FilmParser.parseJson(flist);
				address = "/WEB-INF/view/film-json.jsp";
				request.setAttribute("data", data);
			} else if (format.equals("xml")) {
				response.setContentType("text/xml");
				data = FilmParser.parseXml(flist);
				writer.println(data);
				address = "/WEB-INF/view/film-xml.jsp";
			} else {
				response.setContentType("text/plain");
				data = flist.stream().map(Object::toString)
	                    .collect(Collectors.joining(","));
			    address = "/WEB-INF/view/film-string.jsp";
			    request.setAttribute("data", data);
			}
		}
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(address);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
