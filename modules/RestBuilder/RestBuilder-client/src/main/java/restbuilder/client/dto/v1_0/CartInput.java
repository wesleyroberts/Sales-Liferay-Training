package restbuilder.client.dto.v1_0;

import java.io.Serializable;

import java.util.Objects;

import javax.annotation.Generated;

import restbuilder.client.function.UnsafeSupplier;
import restbuilder.client.serdes.v1_0.CartInputSerDes;

/**
 * @author Wesley Roberts
 * @generated
 */
@Generated("")
public class CartInput implements Cloneable, Serializable {

	public static CartInput toDTO(String json) {
		return CartInputSerDes.toDTO(json);
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

	@Override
	public CartInput clone() throws CloneNotSupportedException {
		return (CartInput)super.clone();
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CartInput)) {
			return false;
		}

		CartInput cartInput = (CartInput)object;

		return Objects.equals(toString(), cartInput.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return CartInputSerDes.toJSON(this);
	}

}