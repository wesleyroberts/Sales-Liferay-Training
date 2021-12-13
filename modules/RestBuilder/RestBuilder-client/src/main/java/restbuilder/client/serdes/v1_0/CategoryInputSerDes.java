package restbuilder.client.serdes.v1_0;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

import restbuilder.client.dto.v1_0.CategoryInput;
import restbuilder.client.json.BaseJSONParser;

/**
 * @author Wesley Roberts
 * @generated
 */
@Generated("")
public class CategoryInputSerDes {

	public static CategoryInput toDTO(String json) {
		CategoryInputJSONParser categoryInputJSONParser =
			new CategoryInputJSONParser();

		return categoryInputJSONParser.parseToDTO(json);
	}

	public static CategoryInput[] toDTOs(String json) {
		CategoryInputJSONParser categoryInputJSONParser =
			new CategoryInputJSONParser();

		return categoryInputJSONParser.parseToDTOs(json);
	}

	public static String toJSON(CategoryInput categoryInput) {
		if (categoryInput == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (categoryInput.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(categoryInput.getName()));

			sb.append("\"");
		}

		if (categoryInput.getTax() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"tax\": ");

			sb.append(categoryInput.getTax());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		CategoryInputJSONParser categoryInputJSONParser =
			new CategoryInputJSONParser();

		return categoryInputJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(CategoryInput categoryInput) {
		if (categoryInput == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (categoryInput.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(categoryInput.getName()));
		}

		if (categoryInput.getTax() == null) {
			map.put("tax", null);
		}
		else {
			map.put("tax", String.valueOf(categoryInput.getTax()));
		}

		return map;
	}

	public static class CategoryInputJSONParser
		extends BaseJSONParser<CategoryInput> {

		@Override
		protected CategoryInput createDTO() {
			return new CategoryInput();
		}

		@Override
		protected CategoryInput[] createDTOArray(int size) {
			return new CategoryInput[size];
		}

		@Override
		protected void setField(
			CategoryInput categoryInput, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					categoryInput.setName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "tax")) {
				if (jsonParserFieldValue != null) {
					categoryInput.setTax(
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