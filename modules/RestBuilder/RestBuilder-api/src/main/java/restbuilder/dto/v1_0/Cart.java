package restbuilder.dto.v1_0;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.liferay.petra.function.UnsafeSupplier;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.util.ObjectMapperUtil;

import io.swagger.v3.oas.annotations.media.Schema;

import java.io.Serializable;

import java.util.*;

import javax.annotation.Generated;

import javax.validation.Valid;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Wesley Roberts
 * @generated
 */
@Generated("")
@GraphQLName(description = "Cart", value = "Cart")
@JsonFilter("Liferay.Vulcan")
@XmlRootElement(name = "Cart")
public class Cart implements Serializable {

	public static Cart toDTO(String json) {
		return ObjectMapperUtil.readValue(Cart.class, json);
	}

	@Schema(description = "The Cart ID.")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@JsonIgnore
	public void setId(UnsafeSupplier<Integer, Exception> idUnsafeSupplier) {
		try {
			id = idUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "The Cart ID.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Integer id;

	@Schema
	public ProductList[] getProductList() {
		return productList;
	}

	public void setProductList(ProductList[] productList) {
		this.productList = productList;
	}

	@JsonIgnore
	public void setProductList(
		UnsafeSupplier<ProductList[], Exception> productListUnsafeSupplier) {

		try {
			productList = productListUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected ProductList[] productList;

	@Schema(description = "total payment amount.")
	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	@JsonIgnore
	public void setTotalValue(
		UnsafeSupplier<Double, Exception> totalValueUnsafeSupplier) {

		try {
			totalValue = totalValueUnsafeSupplier.get();
		}
		catch (RuntimeException re) {
			throw re;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@GraphQLField(description = "total payment amount.")
	@JsonProperty(access = JsonProperty.Access.READ_WRITE)
	protected Double totalValue;

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
		StringBundler sb = new StringBundler();

		sb.append("{");

		if (id != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(id);
		}

		if (productList != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"productList\": ");

			sb.append("[");

			for (int i = 0; i < productList.length; i++) {
				sb.append(String.valueOf(productList[i]));

				if ((i + 1) < productList.length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (totalValue != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"totalValue\": ");

			sb.append(totalValue);
		}

		sb.append("}");

		return sb.toString();
	}

	@Schema(
		accessMode = Schema.AccessMode.READ_ONLY,
		defaultValue = "restbuilder.dto.v1_0.Cart", name = "x-class-name"
	)
	public String xClassName;

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		return string.replaceAll("\"", "\\\\\"");
	}

	private static boolean _isArray(Object value) {
		if (value == null) {
			return false;
		}

		Class<?> clazz = value.getClass();

		return clazz.isArray();
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\": ");

			Object value = entry.getValue();

			if (_isArray(value)) {
				sb.append("[");

				Object[] valueArray = (Object[])value;

				for (int i = 0; i < valueArray.length; i++) {
					if (valueArray[i] instanceof String) {
						sb.append("\"");
						sb.append(valueArray[i]);
						sb.append("\"");
					}
					else {
						sb.append(valueArray[i]);
					}

					if ((i + 1) < valueArray.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof Map) {
				sb.append(_toJSON((Map<String, ?>)value));
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(value);
				sb.append("\"");
			}
			else {
				sb.append(value);
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}