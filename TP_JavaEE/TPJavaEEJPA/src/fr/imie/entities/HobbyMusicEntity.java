package fr.imie.entities;

import fr.imie.entities.HobbyEntity;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: HobbyMusicEntity
 *
 */
@Entity
@DiscriminatorValue(value="Music")
public class HobbyMusicEntity extends HobbyEntity implements Serializable {

	
	/**
     * 
     */
    private static final long serialVersionUID = -549910089467303871L;
    @Column(name="genremusic", nullable=true)
    private String genremusic;

	public HobbyMusicEntity() {
		super();
	}   
	public String getGenremusic() {
		return this.genremusic;
	}

	public void setGenremusic(String genremusique) {
		this.genremusic = genremusique;
	}
   
}
