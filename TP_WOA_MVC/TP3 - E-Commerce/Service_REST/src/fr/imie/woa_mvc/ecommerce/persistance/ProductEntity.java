package fr.imie.woa_mvc.ecommerce.persistance;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "products" database table.
 * 
 */
@Entity
@Table(name="products")
@NamedQuery(name="ProductEntity.findAll", query="SELECT p FROM ProductEntity p ORDER BY p.id")
public class ProductEntity implements Serializable {

	/**
     */
    private static final long serialVersionUID = -3264045885846867878L;

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id = null;

	@Column(name="image_url")
	private String imageUrl = "";

	@Column(name="label")
	private String label = "";

	@Column(name="price")
	private double price = 0.00;

	public ProductEntity() {
	    super();
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getImageUrl() {
		return this.imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
