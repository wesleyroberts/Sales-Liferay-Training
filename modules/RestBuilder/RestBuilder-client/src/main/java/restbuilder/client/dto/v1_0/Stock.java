package restbuilder.client.dto.v1_0;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

import restbuilder.client.dto.v1_0.Category;
import restbuilder.client.dto.v1_0.Type;
import restbuilder.client.function.UnsafeSupplier;
import restbuilder.client.serdes.v1_0.StockSerDes;

/**
 * @author Wesley Roberts
 * @generated
 */
@Generated("")
public class Stock implements Cloneable, Serializable {

	public static Stock toDTO(String json) {
		return StockSerDes.toDTO(json);
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public void setCategory(
		UnsafeSupplier<Category, Exception> categoryUnsafeSupplier) {

		try {
			category = categoryUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Category category;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setId(UnsafeSupplier<Integer, Exception> idUnsafeSupplier) {
		try {
			id = idUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer id;

	public Number getPrice() {
		return price;
	}

	public void setPrice(Number price) {
		this.price = price;
	}

	public void setPrice(
		UnsafeSupplier<Number, Exception> priceUnsafeSupplier) {

		try {
			price = priceUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Number price;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setProductName(
		UnsafeSupplier<String, Exception> productNameUnsafeSupplier) {

		try {
			productName = productNameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String productName;

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public void setQuantity(
		UnsafeSupplier<Integer, Exception> quantityUnsafeSupplier) {

		try {
			quantity = quantityUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Integer quantity;

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public void setType(UnsafeSupplier<Type, Exception> typeUnsafeSupplier) {
		try {
			type = typeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Type type;

	@Override
	public Stock clone() throws CloneNotSupportedException {
		return (Stock)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Stock)) {
			return false;
		}

		Stock stock = (Stock)object;

		return Objects.equals(toString(), stock.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return StockSerDes.toJSON(this);
	}

}