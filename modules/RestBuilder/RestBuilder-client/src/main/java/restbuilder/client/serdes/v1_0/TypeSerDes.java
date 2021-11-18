package restbuilder.client.serdes.v1_0;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

import restbuilder.client.dto.v1_0.Type;
import restbuilder.client.json.BaseJSONParser;

/**
 * @author Wesley Roberts
 * @generated
 */
@Generated("")
public class TypeSerDes {

	public static Type toDTO(String json) {
		TypeJSONParser typeJSONParser = new TypeJSONParser();

		return typeJSONParser.parseToDTO(json);
	}

	public static Type[] toDTOs(String json) {
		TypeJSONParser typeJSONParser = new TypeJSONParser();

		return typeJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Type type) {
		if (type == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (type.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(type.getId());
		}

		if (type.getName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"name\": ");

			sb.append("\"");

			sb.append(_escape(type.getName()));

			sb.append("\"");
		}

		if (type.getTax() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"tax\": ");

			sb.append(type.getTax());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		TypeJSONParser typeJSONParser = new TypeJSONParser();

		return typeJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Type type) {
		if (type == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (type.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(type.getId()));
		}

		if (type.getName() == null) {
			map.put("name", null);
		}
		else {
			map.put("name", String.valueOf(type.getName()));
		}

		if (type.getTax() == null) {
			map.put("tax", null);
		}
		else {
			map.put("tax", String.valueOf(type.getTax()));
		}

		return map;
	}

	public static class TypeJSONParser extends BaseJSONParser<Type> {

		@Override
		protected Type createDTO() {
			return new Type();
		}

		@Override
		protected Type[] createDTOArray(int size) {
			return new Type[size];
		}

		@Override
		protected void setField(
			Type type, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					type.setId(Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "name")) {
				if (jsonParserFieldValue != null) {
					type.setName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "tax")) {
				if (jsonParserFieldValue != null) {
					type.setTax(Double.valueOf((String)jsonParserFieldValue));
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