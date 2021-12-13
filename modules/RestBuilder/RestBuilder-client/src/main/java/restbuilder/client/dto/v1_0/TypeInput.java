package restbuilder.client.dto.v1_0;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

import restbuilder.client.function.UnsafeSupplier;
import restbuilder.client.serdes.v1_0.TypeInputSerDes;

/**
 * @author Wesley Roberts
 * @generated
 */
@Generated("")
public class TypeInput implements Cloneable, Serializable {

	public static TypeInput toDTO(String json) {
		return TypeInputSerDes.toDTO(json);
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
	public TypeInput clone() throws CloneNotSupportedException {
		return (TypeInput)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof TypeInput)) {
			return false;
		}

		TypeInput typeInput = (TypeInput)object;

		return Objects.equals(toString(), typeInput.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return TypeInputSerDes.toJSON(this);
	}

}