package restbuilder.client.serdes.v1_0;

import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

import javax.annotation.Generated;

import restbuilder.client.dto.v1_0.Stock;
import restbuilder.client.json.BaseJSONParser;

/**
 * @author Wesley Roberts
 * @generated
 */
@Generated("")
public class StockSerDes {

	public static Stock toDTO(String json) {
		StockJSONParser stockJSONParser = new StockJSONParser();

		return stockJSONParser.parseToDTO(json);
	}

	public static Stock[] toDTOs(String json) {
		StockJSONParser stockJSONParser = new StockJSONParser();

		return stockJSONParser.parseToDTOs(json);
	}

	public static String toJSON(Stock stock) {
		if (stock == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (stock.getCategory() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"category\": ");

			sb.append(String.valueOf(stock.getCategory()));
		}

		if (stock.getId() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"id\": ");

			sb.append(stock.getId());
		}

		if (stock.getPrice() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"price\": ");

			sb.append(stock.getPrice());
		}

		if (stock.getProductName() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"productName\": ");

			sb.append("\"");

			sb.append(_escape(stock.getProductName()));

			sb.append("\"");
		}

		if (stock.getQuantity() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"quantity\": ");

			sb.append(stock.getQuantity());
		}

		if (stock.getType() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"type\": ");

			sb.append(String.valueOf(stock.getType()));
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		StockJSONParser stockJSONParser = new StockJSONParser();

		return stockJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(Stock stock) {
		if (stock == null) {
			return null;
		}

		Map<String, String> map = new TreeMap<>();

		if (stock.getCategory() == null) {
			map.put("category", null);
		}
		else {
			map.put("category", String.valueOf(stock.getCategory()));
		}

		if (stock.getId() == null) {
			map.put("id", null);
		}
		else {
			map.put("id", String.valueOf(stock.getId()));
		}

		if (stock.getPrice() == null) {
			map.put("price", null);
		}
		else {
			map.put("price", String.valueOf(stock.getPrice()));
		}

		if (stock.getProductName() == null) {
			map.put("productName", null);
		}
		else {
			map.put("productName", String.valueOf(stock.getProductName()));
		}

		if (stock.getQuantity() == null) {
			map.put("quantity", null);
		}
		else {
			map.put("quantity", String.valueOf(stock.getQuantity()));
		}

		if (stock.getType() == null) {
			map.put("type", null);
		}
		else {
			map.put("type", String.valueOf(stock.getType()));
		}

		return map;
	}

	public static class StockJSONParser extends BaseJSONParser<Stock> {

		@Override
		protected Stock createDTO() {
			return new Stock();
		}

		@Override
		protected Stock[] createDTOArray(int size) {
			return new Stock[size];
		}

		@Override
		protected void setField(
			Stock stock, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "category")) {
				if (jsonParserFieldValue != null) {
					stock.setCategory(
						CategorySerDes.toDTO((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "id")) {
				if (jsonParserFieldValue != null) {
					stock.setId(Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "price")) {
				if (jsonParserFieldValue != null) {
					stock.setPrice(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "productName")) {
				if (jsonParserFieldValue != null) {
					stock.setProductName((String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "quantity")) {
				if (jsonParserFieldValue != null) {
					stock.setQuantity(
						Integer.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "type")) {
				if (jsonParserFieldValue != null) {
					stock.setType(
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