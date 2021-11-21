package examples.domains;

import java.time.LocalDateTime;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;



@Entity
public class Product {
    @Id
    private String id;

    private String name;

    private Double price;

    private LocalDateTime manufacturingDate;

    @ManyToOne
    private Address manufacturingPlace;

    private Double weight;

    @Embedded
    private Dimension dimension;

    @ManyToOne
    private Distributor distributor;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Embeddable   
    public static class Dimension {
        private Double height;

        private Double width;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public LocalDateTime getManufacturingDate() {
		return manufacturingDate;
	}

	public void setManufacturingDate(LocalDateTime manufacturingDate) {
		this.manufacturingDate = manufacturingDate;
	}

	public Address getManufacturingPlace() {
		return manufacturingPlace;
	}

	public void setManufacturingPlace(Address manufacturingPlace) {
		this.manufacturingPlace = manufacturingPlace;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}

	public Distributor getDistributor() {
		return distributor;
	}

	public void setDistributor(Distributor distributor) {
		this.distributor = distributor;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}


}
