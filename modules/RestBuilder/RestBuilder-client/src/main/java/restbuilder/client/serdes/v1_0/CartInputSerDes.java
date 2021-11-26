package restbuilder.client.serdes.v1_0;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

import restbuilder.client.dto.v1_0.CartInput;
import restbuilder.client.json.BaseJSONParser;

/**
 * @author Wesley Roberts
 * @generated
 */
@Generated("")
public class CartInputSerDes {

	public static CartInput toDTO(String json) {
		CartInputJSONParser cartInputJSONParser = new CartInputJSONParser();

		return cartInputJSONParser.parseToDTO(json);
	}

	public static CartInput[] toDTOs(String json) {
		CartInputJSONParser cartInputJSONParser = new CartInputJSONParser();

		return cartInputJSONParser.parseToDTOs(json);
	}

	public static String toJSON(CartInput cartInput) {
		if (cartInput == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (cartInput.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(cartInput.getId());
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		CartInputJSONParser cartInputJSONParser = new CartInputJSONParser();

		return cartInputJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(CartInput cartInput) {
		if (cartInput == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (cartInput.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(cartInput.getId()));
		}

		return map;
	}

	public static class CartInputJSONParser extends BaseJSONParser<CartInput> {

		@Override
		protected CartInput createDTO() {
			return new CartInput();
		}

		@Override
		protected CartInput[] createDTOArray(int size) {
			return new CartInput[size];
		}

		@Override
		protected void setField(
			CartInput cartInput, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					cartInput.setId(
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