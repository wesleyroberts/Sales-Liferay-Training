package restbuilder.client.dto.v1_0;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

import restbuilder.client.function.UnsafeSupplier;
import restbuilder.client.serdes.v1_0.TypeSerDes;

/**
 * @author Wesley Roberts
 * @generated
 */
@Generated("")
public class Type implements Cloneable, Serializable {

	public static Type toDTO(String json) {
		return TypeSerDes.toDTO(json);
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
	public Type clone() throws CloneNotSupportedException {
		return (Type)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Type)) {
			return false;
		}

		Type type = (Type)object;

		return Objects.equals(toString(), type.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return TypeSerDes.toJSON(this);
	}

}