package restbuilder.client.dto.v1_0;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

import restbuilder.client.dto.v1_0.ProductList;
import restbuilder.client.function.UnsafeSupplier;
import restbuilder.client.serdes.v1_0.CartSerDes;

/**
 * @author Wesley Roberts
 * @generated
 */
@Generated("")
public class Cart implements Cloneable, Serializable {

	public static Cart toDTO(String json) {
		return CartSerDes.toDTO(json);
	}

	public Boolean getAble() {
		return able;
	}

	public void setAble(Boolean able) {
		this.able = able;
	}

	public void setAble(UnsafeSupplier<Boolean, Exception> ableUnsafeSupplier) {
		try {
			able = ableUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Boolean able;

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

	public ProductList[] getProductList() {
		return productList;
	}

	public void setProductList(ProductList[] productList) {
		this.productList = productList;
	}

	public void setProductList(
		UnsafeSupplier<ProductList[], Exception> productListUnsafeSupplier) {

		try {
			productList = productListUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected ProductList[] productList;

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	public void setTotalValue(
		UnsafeSupplier<Double, Exception> totalValueUnsafeSupplier) {

		try {
			totalValue = totalValueUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Double totalValue;

	@Override
	public Cart clone() throws CloneNotSupportedException {
		return (Cart)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Cart)) {
			return false;
		}

		Cart cart = (Cart)object;

		return Objects.equals(toString(), cart.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return CartSerDes.toJSON(this);
	}

}