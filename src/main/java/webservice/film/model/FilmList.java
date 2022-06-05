package webservice.film.model;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(namespace = "model")
public class FilmList {
	
	@XmlElementWrapper(name = "filmlist")
    // XmlElement sets the name of the entities
    @XmlElement(name = "film")
    private ArrayList<Film> filmList;
    private String name;

    public void setFilmList(ArrayList<Film> filmList) {
        this.filmList = filmList;
    }

    public ArrayList<Film> getFilmsList() {
        return filmList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

	

}
