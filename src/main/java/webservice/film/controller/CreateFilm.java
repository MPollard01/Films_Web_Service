package webservice.film.controller;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

import webservice.film.model.Film;
import webservice.film.model.FilmDAO;

/**
 * Servlet implementation class CreateFilm
 */
@WebServlet("/createfilm")
public class CreateFilm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateFilm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FilmDAO filmDao = FilmDAO.getInstance();
		InputStream is = new BufferedInputStream(request.getInputStream());
		String result = IOUtils.toString(is, "UTF-8");
		Gson g = new Gson();
		Film f = g.fromJson(result, Film.class);
		is.close();
		filmDao.insertFilm(f);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
