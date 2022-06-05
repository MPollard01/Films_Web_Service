package webservice.film.utils;

import java.util.Collection;

import webservice.film.model.Film;

public interface FilmInfo {
	
	 public void insertFilm (Film finfo);
	 public void updateFilm (Film finfo);
	 public void deleteFilm(int FilmID);
	 public Collection<Film> listFilm ();
	 public Collection<Film> retrieveFilm(String searchStr);

}
