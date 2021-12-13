package restbuilder.client.dto.v1_0;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

import restbuilder.client.function.UnsafeSupplier;
import restbuilder.client.serdes.v1_0.CategoryInputSerDes;

/**
 * @author Wesley Roberts
 * @generated
 */
@Generated("")
public class CategoryInput implements Cloneable, Serializable {

	public static CategoryInput toDTO(String json) {
		return CategoryInputSerDes.toDTO(json);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setName(UnsafeSupplier<String, Exception> nameUnsafeSupplier) {
		try {
			name = nameUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String name;

	public Double getTax() {
		return tax;
	}

	public void setTax(Double tax) {
		this.tax = tax;
	}

	public void setTax(UnsafeSupplier<Double, Exception> taxUnsafeSupplier) {
		try {
			tax = taxUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Double tax;

	@Override
	public CategoryInput clone() throws CloneNotSupportedException {
		return (CategoryInput)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CategoryInput)) {
			return false;
		}

		CategoryInput categoryInput = (CategoryInput)object;

		return Objects.equals(toString(), categoryInput.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return CategoryInputSerDes.toJSON(this);
	}

}