package restbuilder.client.serdes.v1_0;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

import restbuilder.client.dto.v1_0.ProductList;
import restbuilder.client.json.BaseJSONParser;

/**
 * @author Wesley Roberts
 * @generated
 */
@Generated("")
public class ProductListSerDes {

	public static ProductList toDTO(String json) {
		ProductListJSONParser productListJSONParser =
			new ProductListJSONParser();

		return productListJSONParser.parseToDTO(json);
	}

	public static ProductList[] toDTOs(String json) {
		ProductListJSONParser productListJSONParser =
			new ProductListJSONParser();

		return productListJSONParser.parseToDTOs(json);
	}

	public static String toJSON(ProductList productList) {
		if (productList == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (productList.getCategory() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"category\": ");

			sb.append(String.valueOf(productList.getCategory()));
		}

		if (productList.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(productList.getId());
		}

		if (productList.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(productList.getName()));

			sb.append("\"");
		}

		if (productList.getPrice() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"price\": ");

			sb.append(productList.getPrice());
		}

		if (productList.getType() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"type\": ");

			sb.append(String.valueOf(productList.getType()));
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ProductListJSONParser productListJSONParser =
			new ProductListJSONParser();

		return productListJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(ProductList productList) {
		if (productList == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (productList.getCategory() == null) {
			map.put("category", null);
		}
		else {
			map.put("category", String.valueOf(productList.getCategory()));
		}

		if (productList.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(productList.getId()));
		}

		if (productList.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(productList.getName()));
		}

		if (productList.getPrice() == null) {
			map.put("price", null);
		}
		else {
			map.put("price", String.valueOf(productList.getPrice()));
		}

		if (productList.getType() == null) {
			map.put("type", null);
		}
		else {
			map.put("type", String.valueOf(productList.getType()));
		}

		return map;
	}

	public static class ProductListJSONParser
		extends BaseJSONParser<ProductList> {

		@Override
		protected ProductList createDTO() {
			return new ProductList();
		}

		@Override
		protected ProductList[] createDTOArray(int size) {
			return new ProductList[size];
		}

		@Override
		protected void setField(
			ProductList productList, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "category")) {
				if (jsonParserFieldValue != null) {
					productList.setCategory(
						CategorySerDes.toDTO((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					productList.setId(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					productList.setName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "price")) {
				if (jsonParserFieldValue != null) {
					productList.setPrice(
						Double.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "type")) {
				if (jsonParserFieldValue != null) {
					productList.setType(
						TypeSerDes.toDTO((String)jsonParserFieldValue));
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