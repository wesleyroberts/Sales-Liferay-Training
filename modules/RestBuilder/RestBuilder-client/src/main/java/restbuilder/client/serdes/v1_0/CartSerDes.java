package restbuilder.client.serdes.v1_0;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Stream;

import javax.annotation.Generated;

import restbuilder.client.dto.v1_0.Cart;
import restbuilder.client.dto.v1_0.ProductList;
import restbuilder.client.json.BaseJSONParser;

/**
 * @author Wesley Roberts
 * @generated
 */
@Generated("")
public class CartSerDes {

	public static Cart toDTO(String json) {
		CartJSONParser cartJSONParser = new CartJSONParser();

		return cartJSONParser.parseToDTO(json);
	}

	public static Cart[] toDTOs(String json) {
		CartJSONParser cartJSONParser = new CartJSONParser();

		return cartJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Cart cart) {
		if (cart == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (cart.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(cart.getId());
		}

		if (cart.getProductList() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"productList\": ");

			sb.append("[");

			for (int i = 0; i < cart.getProductList().length; i++) {
				sb.append(String.valueOf(cart.getProductList()[i]));

				if ((i + 1) < cart.getProductList().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (cart.getTotalValue() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"totalValue\": ");

			sb.append(cart.getTotalValue());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		CartJSONParser cartJSONParser = new CartJSONParser();

		return cartJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Cart cart) {
		if (cart == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (cart.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(cart.getId()));
		}

		if (cart.getProductList() == null) {
			map.put("productList", null);
		}
		else {
			map.put("productList", String.valueOf(cart.getProductList()));
		}

		if (cart.getTotalValue() == null) {
			map.put("totalValue", null);
		}
		else {
			map.put("totalValue", String.valueOf(cart.getTotalValue()));
		}

		return map;
	}

	public static class CartJSONParser extends BaseJSONParser<Cart> {

		@Override
		protected Cart createDTO() {
			return new Cart();
		}

		@Override
		protected Cart[] createDTOArray(int size) {
			return new Cart[size];
		}

		@Override
		protected void setField(
			Cart cart, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					cart.setId(Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "productList")) {
				if (jsonParserFieldValue != null) {
					cart.setProductList(
						Stream.of(
							toStrings((Object[])jsonParserFieldValue)
						).map(
							object -> ProductListSerDes.toDTO((String)object)
						).toArray(
							size -> new ProductList[size]
						));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "totalValue")) {
				if (jsonParserFieldValue != null) {
					cart.setTotalValue(
						Double.valueOf((String)jsonParserFieldValue));
				}
			}
		}

	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		for (String[] strings : BaseJSONParser.JSON_ESCAPE_STRINGS) {
			string = string.replace(strings[0], strings[1]);
		}

		return string;
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

			Class<?> valueClass = value.getClass();

			if (value instanceof Map) {
				sb.append(_toJSON((Map)value));
			}
			else if (valueClass.isArray()) {
				Object[] values = (Object[])value;

				sb.append("[");

				for (int i = 0; i < values.length; i++) {
					sb.append("\"");
					sb.append(_escape(values[i]));
					sb.append("\"");

					if ((i + 1) < values.length) {
						sb.append(", ");
					}
				}

				sb.append("]");
			}
			else if (value instanceof String) {
				sb.append("\"");
				sb.append(_escape(entry.getValue()));
				sb.append("\"");
			}
			else {
				sb.append(String.valueOf(entry.getValue()));
			}

			if (iterator.hasNext()) {
				sb.append(", ");
			}
		}

		sb.append("}");

		return sb.toString();
	}

}