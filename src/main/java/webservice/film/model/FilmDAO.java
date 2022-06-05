package webservice.film.model;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import webservice.film.utils.FilmInfo;

import java.sql.*;


public class FilmDAO implements FilmInfo {
	
	Film oneFilm = null;
	Connection conn = null;
    Statement stmt = null;
//    private final String USER = "pollarma";
//    private final String PASSWORD = "ankltonD7";
//    private final String URL = "jdbc:mysql://mudfoot.doc.stu.mmu.ac.uk:6306/"+USER;
	//private final String USER = "test";
    //private final String PASSWORD = "test";
    //private final String URL = "jdbc:mysql://34.105.191.225:3306/film_db";
    
    private final String USER = "root";
    private final String PASSWORD = "";
    private final String URL = "jdbc:mysql://localhost:3306/films";

	private FilmDAO() {}
	
	private static FilmDAO daoInstance;
	
	public static FilmDAO getInstance() {
		if(daoInstance == null) {
			return new FilmDAO();
		}
		return null;
	}

	
	private void openConnection(){
		// loading jdbc driver for mysql
		try{
		    Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch(Exception e) { System.out.println(e); }

		// connecting to database
		try{
			// connection string for demos database, username demos, password demos
 			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		    stmt = conn.createStatement();
		} catch(SQLException se) { System.out.println(se); }	   
    }
	private void closeConnection(){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private Film getNextFilm(ResultSet rs){
    	Film thisFilm=null;
		try {
			thisFilm = new Film(
					rs.getInt("id"),
					rs.getString("title"),
					rs.getInt("year"),
					rs.getString("director"),
					rs.getString("stars"),
					rs.getString("review"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return thisFilm;		
	}
	

   public Film getFilmByID(int id){
	   
		openConnection();
		oneFilm=null;
	    // Create select statement and execute it
		try{
		    String selectSQL = "select * from films where id="+id;
		    ResultSet rs1 = stmt.executeQuery(selectSQL);
	    // Retrieve the results
		    while(rs1.next()){
		    	oneFilm = getNextFilm(rs1);
		    }

		    stmt.close();
		    closeConnection();
		} catch(SQLException se) { System.out.println(se); }

	   return oneFilm;
   }


@Override
public void insertFilm(Film finfo) {
	openConnection();
	
	try {
		String sql = "INSERT INTO films(id,title,year,director,stars,review) "
				+ "VALUES ("+ finfo.getId() + ", '" + finfo.getTitle() + "', " + finfo.getYear()
				+ ", '" + finfo.getDirector() + "', '" + finfo.getStars() + "', '" + finfo.getReview()
				+ "')";
		
		stmt.executeUpdate(sql);
		stmt.close();
	    closeConnection();
	} catch(SQLException se) { System.out.println(se); }
	
}


@Override
public void updateFilm(Film finfo) {
	openConnection();
	
	try {
		String sql = "UPDATE films SET title = '"+ finfo.getTitle() +"', year = "+ finfo.getYear()
						+ ", director = '"+ finfo.getDirector() +"', stars = '"+ finfo.getStars()
						+ "', review = '"+ finfo.getReview() +"' WHERE id = "+ finfo.getId();
		
		stmt.executeUpdate(sql);
		stmt.close();
	    closeConnection();
	} catch(SQLException se) { System.out.println(se); }
	
}


@Override
public void deleteFilm(int FilmID) {
	openConnection();
	
	try {
		String sql = "DELETE FROM films WHERE id = "+ FilmID;
		
		stmt.executeUpdate(sql);
		stmt.close();
	    closeConnection();
	} catch(SQLException se) { System.out.println(se); }
	
}


@Override
public Collection<Film> listFilm() {
	ArrayList<Film> allFilms = new ArrayList<Film>();
	openConnection();
	
    // Create select statement and execute it
	try{
	    String selectSQL = "select * from films";
	    ResultSet rs1 = stmt.executeQuery(selectSQL);
    // Retrieve the results
	    while(rs1.next()){
	    	oneFilm = getNextFilm(rs1);
	    	allFilms.add(oneFilm);
	   }

	    stmt.close();
	    closeConnection();
	} catch(SQLException se) { System.out.println(se); }

   return allFilms;
}


@Override
public Collection<Film> retrieveFilm(String searchStr) {
	ArrayList<Film> allFilms = new ArrayList<Film>();
	openConnection();
	
    // Create select statement and execute it
	try{
	    String selectSQL = "select * from films where title='" + searchStr + "'";
	    ResultSet rs1 = stmt.executeQuery(selectSQL);
    // Retrieve the results
	    while(rs1.next()){
	    	oneFilm = getNextFilm(rs1);
	    	allFilms.add(oneFilm);
	   }

	    stmt.close();
	    closeConnection();
	} catch(SQLException se) { System.out.println(se); }

   return allFilms;
}
   
   
   
   
}
