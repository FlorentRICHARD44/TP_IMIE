package fr.imie.formation.poo.tpbases;

/** Class reprensenting the price of one photocopie in a tranche of prices.
 * @author imie
 *
 */
public class PhotocopPrice {
	/** Price for one photocopie.
	 */
	private Float price = 0.0f;
	/** Number of photocopies in the tranche.
	 */
	private Integer number = 0;
	
	/** Constructor.
	 * @param price price for one photocopie.
	 * @param number number of photocopies in this tranche.
	 */
	public PhotocopPrice(final Float price, final Integer number) {
		setPrice(price);
		setNumber(number);
	}

	/**
	 * @return the price
	 */
	public Float getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(Float price) {
		this.price = price;
	}

	/**
	 * @return the number
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}
}
