package restbuilder.client.serdes.v1_0;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

import restbuilder.client.dto.v1_0.ProductOutput;
import restbuilder.client.json.BaseJSONParser;

/**
 * @author Wesley Roberts
 * @generated
 */
@Generated("")
public class ProductOutputSerDes {

	public static ProductOutput toDTO(String json) {
		ProductOutputJSONParser productOutputJSONParser =
			new ProductOutputJSONParser();

		return productOutputJSONParser.parseToDTO(json);
	}

	public static ProductOutput[] toDTOs(String json) {
		ProductOutputJSONParser productOutputJSONParser =
			new ProductOutputJSONParser();

		return productOutputJSONParser.parseToDTOs(json);
	}

	public static String toJSON(ProductOutput productOutput) {
		if (productOutput == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (productOutput.getCategory() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"category\": ");

			sb.append(String.valueOf(productOutput.getCategory()));
		}

		if (productOutput.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(productOutput.getId());
		}

		if (productOutput.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(productOutput.getName()));

			sb.append("\"");
		}

		if (productOutput.getPrice() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"price\": ");

			sb.append(productOutput.getPrice());
		}

		if (productOutput.getType() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"type\": ");

			sb.append(String.valueOf(productOutput.getType()));
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ProductOutputJSONParser productOutputJSONParser =
			new ProductOutputJSONParser();

		return productOutputJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(ProductOutput productOutput) {
		if (productOutput == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (productOutput.getCategory() == null) {
			map.put("category", null);
		}
		else {
			map.put("category", String.valueOf(productOutput.getCategory()));
		}

		if (productOutput.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(productOutput.getId()));
		}

		if (productOutput.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(productOutput.getName()));
		}

		if (productOutput.getPrice() == null) {
			map.put("price", null);
		}
		else {
			map.put("price", String.valueOf(productOutput.getPrice()));
		}

		if (productOutput.getType() == null) {
			map.put("type", null);
		}
		else {
			map.put("type", String.valueOf(productOutput.getType()));
		}

		return map;
	}

	public static class ProductOutputJSONParser
		extends BaseJSONParser<ProductOutput> {

		@Override
		protected ProductOutput createDTO() {
			return new ProductOutput();
		}

		@Override
		protected ProductOutput[] createDTOArray(int size) {
			return new ProductOutput[size];
		}

		@Override
		protected void setField(
			ProductOutput productOutput, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "category")) {
				if (jsonParserFieldValue != null) {
					productOutput.setCategory(
						CategorySerDes.toDTO((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					productOutput.setId(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					productOutput.setName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "price")) {
				if (jsonParserFieldValue != null) {
					productOutput.setPrice(
						Double.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "type")) {
				if (jsonParserFieldValue != null) {
					productOutput.setType(
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