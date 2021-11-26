package restbuilder.client.serdes.v1_0;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Stream;

import javax.annotation.Generated;

import restbuilder.client.dto.v1_0.CartOutput;
import restbuilder.client.dto.v1_0.ProductList;
import restbuilder.client.json.BaseJSONParser;

/**
 * @author Wesley Roberts
 * @generated
 */
@Generated("")
public class CartOutputSerDes {

	public static CartOutput toDTO(String json) {
		CartOutputJSONParser cartOutputJSONParser = new CartOutputJSONParser();

		return cartOutputJSONParser.parseToDTO(json);
	}

	public static CartOutput[] toDTOs(String json) {
		CartOutputJSONParser cartOutputJSONParser = new CartOutputJSONParser();

		return cartOutputJSONParser.parseToDTOs(json);
	}

	public static String toJSON(CartOutput cartOutput) {
		if (cartOutput == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (cartOutput.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(cartOutput.getId());
		}

		if (cartOutput.getProductList() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"productList\": ");

			sb.append("[");

			for (int i = 0; i < cartOutput.getProductList().length; i++) {
				sb.append(String.valueOf(cartOutput.getProductList()[i]));

				if ((i + 1) < cartOutput.getProductList().length) {
					sb.append(", ");
				}
			}

			sb.append("]");
		}

		if (cartOutput.getTotalValue() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"totalValue\": ");

			sb.append(cartOutput.getTotalValue());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		CartOutputJSONParser cartOutputJSONParser = new CartOutputJSONParser();

		return cartOutputJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(CartOutput cartOutput) {
		if (cartOutput == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (cartOutput.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(cartOutput.getId()));
		}

		if (cartOutput.getProductList() == null) {
			map.put("productList", null);
		}
		else {
			map.put("productList", String.valueOf(cartOutput.getProductList()));
		}

		if (cartOutput.getTotalValue() == null) {
			map.put("totalValue", null);
		}
		else {
			map.put("totalValue", String.valueOf(cartOutput.getTotalValue()));
		}

		return map;
	}

	public static class CartOutputJSONParser
		extends BaseJSONParser<CartOutput> {

		@Override
		protected CartOutput createDTO() {
			return new CartOutput();
		}

		@Override
		protected CartOutput[] createDTOArray(int size) {
			return new CartOutput[size];
		}

		@Override
		protected void setField(
			CartOutput cartOutput, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					cartOutput.setId(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "productList")) {
				if (jsonParserFieldValue != null) {
					cartOutput.setProductList(
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
					cartOutput.setTotalValue(
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