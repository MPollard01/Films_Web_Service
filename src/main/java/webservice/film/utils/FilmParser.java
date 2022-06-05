package webservice.film.utils;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import webservice.film.model.Film;
import webservice.film.model.FilmList;

public class FilmParser {
	
	public static String parseXml(Film f) {
		StringWriter sw = new StringWriter();
		
		try {
	    	JAXBContext context = JAXBContext.newInstance(Film.class);
	        Marshaller m = context.createMarshaller();
	        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	        m.marshal(f, sw);
	       
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	  
		return sw.toString().replaceAll(">[\\s\r\n]*<", "><");
	}

	public static String parseJson(Film f) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonResult = gson.toJson(f);
		return jsonResult;
	}   
	
	public static String parseXml(ArrayList<Film> flist) {
		FilmList fl = new FilmList();
    	
    	fl.setFilmList(flist);
		StringWriter sw = new StringWriter();
		
		try {
	    	JAXBContext context = JAXBContext.newInstance(FilmList.class);
	        Marshaller m = context.createMarshaller();
	        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
	        m.marshal(fl, sw);
	       
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	  
		return sw.toString().replaceAll(">[\\s\r\n]*<", "><");
	}

	public static String parseJson(ArrayList<Film> flist) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String jsonResult = gson.toJson(flist);
		return jsonResult;
	}
	
	public static String parseText(ArrayList<Film> flist) {
		return flist.stream().map(Object::toString)
                .collect(Collectors.joining("\n"));
	}

}
