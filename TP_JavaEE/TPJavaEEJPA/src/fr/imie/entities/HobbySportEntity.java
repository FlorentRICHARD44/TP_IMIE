package fr.imie.entities;

import fr.imie.entities.HobbyEntity;

import java.io.Serializable;
import java.lang.Boolean;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: HobbySportEntity
 *
 */
@Entity
@Table(name="hobbysport")
@DiscriminatorValue(value="Sport")
public class HobbySportEntity extends HobbyEntity implements Serializable {

	/**
     */
    private static final long serialVersionUID = 3126366063930991077L;
    @Column(name="team", nullable=true)
    private Boolean team = false;

	public HobbySportEntity() {
		super();
	}   
	public Boolean getTeam() {
		return this.team;
	}

	public void setTeam(Boolean team) {
		this.team = team;
	}
   
}
