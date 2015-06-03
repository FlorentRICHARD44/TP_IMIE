/**
 * 
 */
package fr.imie.formation.poo.tpbases;

/**
 * @author Florent RICHARD
 *
 */
public enum CategoryAge {
	NONE ("undefined", 0, 5),
	POUSSIN ("Poussin", 6, 7),
	PUPILLE ("Pupille", 8, 9),
	MINIME ("Minime", 10, 11),
	CADET ("Cadet", 12, 9999);
	
	private String name;
	private Integer min;
	private Integer max;
	
	private CategoryAge(final String name, final Integer min, final Integer max) {
		setName(name);
		setMin(min);
		setMax(max);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the min
	 */
	public Integer getMin() {
		return min;
	}

	/**
	 * @param min the min to set
	 */
	public void setMin(Integer min) {
		this.min = min;
	}

	/**
	 * @return the max
	 */
	public Integer getMax() {
		return max;
	}

	/**
	 * @param max the max to set
	 */
	public void setMax(Integer max) {
		this.max = max;
	}
	
	
}
