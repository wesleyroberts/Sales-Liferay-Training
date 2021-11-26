package restbuilder.client.serdes.v1_0;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

import restbuilder.client.dto.v1_0.ProductInput;
import restbuilder.client.json.BaseJSONParser;

/**
 * @author Wesley Roberts
 * @generated
 */
@Generated("")
public class ProductInputSerDes {

	public static ProductInput toDTO(String json) {
		ProductInputJSONParser productInputJSONParser =
			new ProductInputJSONParser();

		return productInputJSONParser.parseToDTO(json);
	}

	public static ProductInput[] toDTOs(String json) {
		ProductInputJSONParser productInputJSONParser =
			new ProductInputJSONParser();

		return productInputJSONParser.parseToDTOs(json);
	}

	public static String toJSON(ProductInput productInput) {
		if (productInput == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (productInput.getCategoryId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"categoryId\": ");

			sb.append(productInput.getCategoryId());
		}

		if (productInput.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(productInput.getId());
		}

		if (productInput.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(productInput.getName()));

			sb.append("\"");
		}

		if (productInput.getPrice() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"price\": ");

			sb.append(productInput.getPrice());
		}

		if (productInput.getTypeId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"typeId\": ");

			sb.append(productInput.getTypeId());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ProductInputJSONParser productInputJSONParser =
			new ProductInputJSONParser();

		return productInputJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(ProductInput productInput) {
		if (productInput == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (productInput.getCategoryId() == null) {
			map.put("categoryId", null);
		}
		else {
			map.put("categoryId", String.valueOf(productInput.getCategoryId()));
		}

		if (productInput.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(productInput.getId()));
		}

		if (productInput.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(productInput.getName()));
		}

		if (productInput.getPrice() == null) {
			map.put("price", null);
		}
		else {
			map.put("price", String.valueOf(productInput.getPrice()));
		}

		if (productInput.getTypeId() == null) {
			map.put("typeId", null);
		}
		else {
			map.put("typeId", String.valueOf(productInput.getTypeId()));
		}

		return map;
	}

	public static class ProductInputJSONParser
		extends BaseJSONParser<ProductInput> {

		@Override
		protected ProductInput createDTO() {
			return new ProductInput();
		}

		@Override
		protected ProductInput[] createDTOArray(int size) {
			return new ProductInput[size];
		}

		@Override
		protected void setField(
			ProductInput productInput, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "categoryId")) {
				if (jsonParserFieldValue != null) {
					productInput.setCategoryId(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					productInput.setId(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					productInput.setName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "price")) {
				if (jsonParserFieldValue != null) {
					productInput.setPrice(
						Double.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "typeId")) {
				if (jsonParserFieldValue != null) {
					productInput.setTypeId(
						Integer.valueOf((String)jsonParserFieldValue));
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