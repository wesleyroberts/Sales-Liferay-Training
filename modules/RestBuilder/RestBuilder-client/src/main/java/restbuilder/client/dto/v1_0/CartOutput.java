package restbuilder.client.dto.v1_0;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

import restbuilder.client.dto.v1_0.ProductList;
import restbuilder.client.function.UnsafeSupplier;
import restbuilder.client.serdes.v1_0.CartOutputSerDes;

/**
 * @author Wesley Roberts
 * @generated
 */
@Generated("")
public class CartOutput implements Cloneable, Serializable {

	public static CartOutput toDTO(String json) {
		return CartOutputSerDes.toDTO(json);
	}

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
	public CartOutput clone() throws CloneNotSupportedException {
		return (CartOutput)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CartOutput)) {
			return false;
		}

		CartOutput cartOutput = (CartOutput)object;

		return Objects.equals(toString(), cartOutput.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return CartOutputSerDes.toJSON(this);
	}

}