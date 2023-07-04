package hodi.karibu.model.product;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "PRODUCT_IDK")
public class Product {
	@Id
	private int id;
	private String description;
	private double price;

}
