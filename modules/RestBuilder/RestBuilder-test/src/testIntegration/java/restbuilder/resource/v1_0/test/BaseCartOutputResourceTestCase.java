package restbuilder.resource.v1_0.test;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;

import com.liferay.petra.reflect.ReflectionUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.test.util.GroupTestUtil;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.odata.entity.EntityField;
import com.liferay.portal.odata.entity.EntityModel;
import com.liferay.portal.test.rule.Inject;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.vulcan.resource.EntityModelResource;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import java.text.DateFormat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Generated;

import javax.ws.rs.core.MultivaluedHashMap;

import org.apache.commons.beanutils.BeanUtilsBean;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;

import restbuilder.client.dto.v1_0.CartOutput;
import restbuilder.client.dto.v1_0.Type;
import restbuilder.client.http.HttpInvoker;
import restbuilder.client.pagination.Page;
import restbuilder.client.resource.v1_0.CartOutputResource;
import restbuilder.client.serdes.v1_0.CartOutputSerDes;

/**
 * @author Wesley Roberts
 * @generated
 */
@Generated("")
public abstract class BaseCartOutputResourceTestCase {

	@ClassRule
	@Rule
	public static final LiferayIntegrationTestRule liferayIntegrationTestRule =
		new LiferayIntegrationTestRule();

	@BeforeClass
	public static void setUpClass() throws Exception {
		_dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(
			"yyyy-MM-dd'T'HH:mm:ss'Z'");
	}

	@Before
	public void setUp() throws Exception {
		irrelevantGroup = GroupTestUtil.addGroup();
		testGroup = GroupTestUtil.addGroup();

		testCompany = CompanyLocalServiceUtil.getCompany(
			testGroup.getCompanyId());

		_cartOutputResource.setContextCompany(testCompany);

		CartOutputResource.Builder builder = CartOutputResource.builder();

		cartOutputResource = builder.authentication(
			"test@liferay.com", "test"
		).locale(
			LocaleUtil.getDefault()
		).build();
	}

	@After
	public void tearDown() throws Exception {
		GroupTestUtil.deleteGroup(irrelevantGroup);
		GroupTestUtil.deleteGroup(testGroup);
	}

	@Test
	public void testClientSerDesToDTO() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				enable(SerializationFeature.INDENT_OUTPUT);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		CartOutput cartOutput1 = randomCartOutput();

		String json = objectMapper.writeValueAsString(cartOutput1);

		CartOutput cartOutput2 = CartOutputSerDes.toDTO(json);

		Assert.assertTrue(equals(cartOutput1, cartOutput2));
	}

	@Test
	public void testClientSerDesToJSON() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper() {
			{
				configure(MapperFeature.SORT_PROPERTIES_ALPHABETICALLY, true);
				configure(
					SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
				setDateFormat(new ISO8601DateFormat());
				setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
				setSerializationInclusion(JsonInclude.Include.NON_NULL);
				setVisibility(
					PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
				setVisibility(
					PropertyAccessor.GETTER, JsonAutoDetect.Visibility.NONE);
			}
		};

		CartOutput cartOutput = randomCartOutput();

		String json1 = objectMapper.writeValueAsString(cartOutput);
		String json2 = CartOutputSerDes.toJSON(cartOutput);

		Assert.assertEquals(
			objectMapper.readTree(json1), objectMapper.readTree(json2));
	}

	@Test
	public void testEscapeRegexInStringFields() throws Exception {
		String regex = "^[0-9]+(\\.[0-9]{1,2})\"?";

		CartOutput cartOutput = randomCartOutput();

		String json = CartOutputSerDes.toJSON(cartOutput);

		Assert.assertFalse(json.contains(regex));

		cartOutput = CartOutputSerDes.toDTO(json);
	}

	@Test
	public void testGetAllCarts() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testGetCartById() throws Exception {
		CartOutput postCartOutput = testGetCartById_addCartOutput();

		CartOutput getCartOutput = cartOutputResource.getCartById(null);

		assertEquals(postCartOutput, getCartOutput);
		assertValid(getCartOutput);
	}

	protected CartOutput testGetCartById_addCartOutput() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLGetCartById() throws Exception {
		CartOutput cartOutput = testGraphQLCartOutput_addCartOutput();

		Assert.assertTrue(
			equals(
				cartOutput,
				CartOutputSerDes.toDTO(
					JSONUtil.getValueAsString(
						invokeGraphQLQuery(
							new GraphQLField(
								"cartById",
								new HashMap<String, Object>() {
									{
										put("cartId", null);
									}
								},
								getGraphQLFields())),
						"JSONObject/data", "Object/cartById"))));
	}

	@Test
	public void testGraphQLGetCartByIdNotFound() throws Exception {
		Integer irrelevantCartId = RandomTestUtil.randomInt();

		Assert.assertEquals(
			"Not Found",
			JSONUtil.getValueAsString(
				invokeGraphQLQuery(
					new GraphQLField(
						"cartById",
						new HashMap<String, Object>() {
							{
								put("cartId", irrelevantCartId);
							}
						},
						getGraphQLFields())),
				"JSONArray/errors", "Object/0", "JSONObject/extensions",
				"Object/code"));
	}

	@Test
	public void testGetTotalValueByCartId() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testCreateCart() throws Exception {
		CartOutput postCartOutput = testCreateCart_addCartOutput();

		CartOutput getCartOutput = cartOutputResource.createCart();

		assertEquals(postCartOutput, getCartOutput);
		assertValid(getCartOutput);
	}

	protected CartOutput testCreateCart_addCartOutput() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testGraphQLCreateCart() throws Exception {
		CartOutput cartOutput = testGraphQLCartOutput_addCartOutput();

		Assert.assertTrue(
			equals(
				cartOutput,
				CartOutputSerDes.toDTO(
					JSONUtil.getValueAsString(
						invokeGraphQLQuery(
							new GraphQLField(
								"createCart",
								new HashMap<String, Object>() {
									{
									}
								},
								getGraphQLFields())),
						"JSONObject/data", "Object/createCart"))));
	}

	@Test
	public void testGraphQLCreateCartNotFound() throws Exception {
		Assert.assertTrue(true);
	}

	@Test
	public void testAddProductToCart() throws Exception {
		Assert.assertTrue(false);
	}

	@Test
	public void testRemoveProductToCart() throws Exception {
		@SuppressWarnings("PMD.UnusedLocalVariable")
		CartOutput cartOutput = testRemoveProductToCart_addCartOutput();

		assertHttpResponseStatusCode(
			204,
			cartOutputResource.removeProductToCartHttpResponse(
				null, null, null));

		assertHttpResponseStatusCode(
			404,
			cartOutputResource.removeProductToCartHttpResponse(
				null, null, null));
	}

	protected CartOutput testRemoveProductToCart_addCartOutput()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	@Test
	public void testDeleteCartById() throws Exception {
		@SuppressWarnings("PMD.UnusedLocalVariable")
		CartOutput cartOutput = testDeleteCartById_addCartOutput();

		assertHttpResponseStatusCode(
			204, cartOutputResource.deleteCartByIdHttpResponse(null));

		assertHttpResponseStatusCode(
			404, cartOutputResource.getCartByIdHttpResponse(null));

		assertHttpResponseStatusCode(
			404, cartOutputResource.getCartByIdHttpResponse(null));
	}

	protected CartOutput testDeleteCartById_addCartOutput() throws Exception {
		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected CartOutput testGraphQLCartOutput_addCartOutput()
		throws Exception {

		throw new UnsupportedOperationException(
			"This method needs to be implemented");
	}

	protected void assertHttpResponseStatusCode(
		int expectedHttpResponseStatusCode,
		HttpInvoker.HttpResponse actualHttpResponse) {

		Assert.assertEquals(
			expectedHttpResponseStatusCode, actualHttpResponse.getStatusCode());
	}

	protected void assertEquals(
		CartOutput cartOutput1, CartOutput cartOutput2) {

		Assert.assertTrue(
			cartOutput1 + " does not equal " + cartOutput2,
			equals(cartOutput1, cartOutput2));
	}

	protected void assertEquals(
		List<CartOutput> cartOutputs1, List<CartOutput> cartOutputs2) {

		Assert.assertEquals(cartOutputs1.size(), cartOutputs2.size());

		for (int i = 0; i < cartOutputs1.size(); i++) {
			CartOutput cartOutput1 = cartOutputs1.get(i);
			CartOutput cartOutput2 = cartOutputs2.get(i);

			assertEquals(cartOutput1, cartOutput2);
		}
	}

	protected void assertEqualsIgnoringOrder(
		List<CartOutput> cartOutputs1, List<CartOutput> cartOutputs2) {

		Assert.assertEquals(cartOutputs1.size(), cartOutputs2.size());

		for (CartOutput cartOutput1 : cartOutputs1) {
			boolean contains = false;

			for (CartOutput cartOutput2 : cartOutputs2) {
				if (equals(cartOutput1, cartOutput2)) {
					contains = true;

					break;
				}
			}

			Assert.assertTrue(
				cartOutputs2 + " does not contain " + cartOutput1, contains);
		}
	}

	protected void assertValid(CartOutput cartOutput) throws Exception {
		boolean valid = true;

		if (cartOutput.getId() == null) {
			valid = false;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("productList", additionalAssertFieldName)) {
				if (cartOutput.getProductList() == null) {
					valid = false;
				}

				continue;
			}

			if (Objects.equals("totalValue", additionalAssertFieldName)) {
				if (cartOutput.getTotalValue() == null) {
					valid = false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		Assert.assertTrue(valid);
	}

	protected void assertValid(Page<CartOutput> page) {
		boolean valid = false;

		java.util.Collection<CartOutput> cartOutputs = page.getItems();

		int size = cartOutputs.size();

		if ((page.getLastPage() > 0) && (page.getPage() > 0) &&
			(page.getPageSize() > 0) && (page.getTotalCount() > 0) &&
			(size > 0)) {

			valid = true;
		}

		Assert.assertTrue(valid);
	}

	protected String[] getAdditionalAssertFieldNames() {
		return new String[0];
	}

	protected List<GraphQLField> getGraphQLFields() throws Exception {
		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (Field field :
				getDeclaredFields(restbuilder.dto.v1_0.CartOutput.class)) {

			if (!ArrayUtil.contains(
					getAdditionalAssertFieldNames(), field.getName())) {

				continue;
			}

			graphQLFields.addAll(getGraphQLFields(field));
		}

		return graphQLFields;
	}

	protected List<GraphQLField> getGraphQLFields(Field... fields)
		throws Exception {

		List<GraphQLField> graphQLFields = new ArrayList<>();

		for (Field field : fields) {
			com.liferay.portal.vulcan.graphql.annotation.GraphQLField
				vulcanGraphQLField = field.getAnnotation(
					com.liferay.portal.vulcan.graphql.annotation.GraphQLField.
						class);

			if (vulcanGraphQLField != null) {
				Class<?> clazz = field.getType();

				if (clazz.isArray()) {
					clazz = clazz.getComponentType();
				}

				List<GraphQLField> childrenGraphQLFields = getGraphQLFields(
					getDeclaredFields(clazz));

				graphQLFields.add(
					new GraphQLField(field.getName(), childrenGraphQLFields));
			}
		}

		return graphQLFields;
	}

	protected String[] getIgnoredEntityFieldNames() {
		return new String[0];
	}

	protected boolean equals(CartOutput cartOutput1, CartOutput cartOutput2) {
		if (cartOutput1 == cartOutput2) {
			return true;
		}

		for (String additionalAssertFieldName :
				getAdditionalAssertFieldNames()) {

			if (Objects.equals("id", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						cartOutput1.getId(), cartOutput2.getId())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("productList", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						cartOutput1.getProductList(),
						cartOutput2.getProductList())) {

					return false;
				}

				continue;
			}

			if (Objects.equals("totalValue", additionalAssertFieldName)) {
				if (!Objects.deepEquals(
						cartOutput1.getTotalValue(),
						cartOutput2.getTotalValue())) {

					return false;
				}

				continue;
			}

			throw new IllegalArgumentException(
				"Invalid additional assert field name " +
					additionalAssertFieldName);
		}

		return true;
	}

	protected boolean equals(
		Map<String, Object> map1, Map<String, Object> map2) {

		if (Objects.equals(map1.keySet(), map2.keySet())) {
			for (Map.Entry<String, Object> entry : map1.entrySet()) {
				if (entry.getValue() instanceof Map) {
					if (!equals(
							(Map)entry.getValue(),
							(Map)map2.get(entry.getKey()))) {

						return false;
					}
				}
				else if (!Objects.deepEquals(
							entry.getValue(), map2.get(entry.getKey()))) {

					return false;
				}
			}

			return true;
		}

		return false;
	}

	protected Field[] getDeclaredFields(Class clazz) throws Exception {
		Stream<Field> stream = Stream.of(
			ReflectionUtil.getDeclaredFields(clazz));

		return stream.filter(
			field -> !field.isSynthetic()
		).toArray(
			Field[]::new
		);
	}

	protected java.util.Collection<EntityField> getEntityFields()
		throws Exception {

		if (!(_cartOutputResource instanceof EntityModelResource)) {
			throw new UnsupportedOperationException(
				"Resource is not an instance of EntityModelResource");
		}

		EntityModelResource entityModelResource =
			(EntityModelResource)_cartOutputResource;

		EntityModel entityModel = entityModelResource.getEntityModel(
			new MultivaluedHashMap());

		Map<String, EntityField> entityFieldsMap =
			entityModel.getEntityFieldsMap();

		return entityFieldsMap.values();
	}

	protected List<EntityField> getEntityFields(EntityField.Type type)
		throws Exception {

		java.util.Collection<EntityField> entityFields = getEntityFields();

		Stream<EntityField> stream = entityFields.stream();

		return stream.filter(
			entityField ->
				Objects.equals(entityField.getType(), type) &&
				!ArrayUtil.contains(
					getIgnoredEntityFieldNames(), entityField.getName())
		).collect(
			Collectors.toList()
		);
	}

	protected String getFilterString(
		EntityField entityField, String operator, CartOutput cartOutput) {

		StringBundler sb = new StringBundler();

		String entityFieldName = entityField.getName();

		sb.append(entityFieldName);

		sb.append(" ");
		sb.append(operator);
		sb.append(" ");

		if (entityFieldName.equals("id")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("productList")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		if (entityFieldName.equals("totalValue")) {
			throw new IllegalArgumentException(
				"Invalid entity field " + entityFieldName);
		}

		throw new IllegalArgumentException(
			"Invalid entity field " + entityFieldName);
	}

	protected String invoke(String query) throws Exception {
		HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

		httpInvoker.body(
			JSONUtil.put(
				"query", query
			).toString(),
			"application/json");
		httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);
		httpInvoker.path("http://localhost:8080/o/graphql");
		httpInvoker.userNameAndPassword("test@liferay.com:test");

		HttpInvoker.HttpResponse httpResponse = httpInvoker.invoke();

		return httpResponse.getContent();
	}

	protected JSONObject invokeGraphQLMutation(GraphQLField graphQLField)
		throws Exception {

		GraphQLField mutationGraphQLField = new GraphQLField(
			"mutation", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(mutationGraphQLField.toString()));
	}

	protected JSONObject invokeGraphQLQuery(GraphQLField graphQLField)
		throws Exception {

		GraphQLField queryGraphQLField = new GraphQLField(
			"query", graphQLField);

		return JSONFactoryUtil.createJSONObject(
			invoke(queryGraphQLField.toString()));
	}

	protected CartOutput randomCartOutput() throws Exception {
		return new CartOutput() {
			{
				id = RandomTestUtil.randomInt();
				totalValue = RandomTestUtil.randomDouble();
			}
		};
	}

	protected CartOutput randomIrrelevantCartOutput() throws Exception {
		CartOutput randomIrrelevantCartOutput = randomCartOutput();

		return randomIrrelevantCartOutput;
	}

	protected CartOutput randomPatchCartOutput() throws Exception {
		return randomCartOutput();
	}

	protected CartOutputResource cartOutputResource;
	protected Group irrelevantGroup;
	protected Company testCompany;
	protected Group testGroup;

	protected class GraphQLField {

		public GraphQLField(String key, GraphQLField... graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(String key, List<GraphQLField> graphQLFields) {
			this(key, new HashMap<>(), graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			GraphQLField... graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = Arrays.asList(graphQLFields);
		}

		public GraphQLField(
			String key, Map<String, Object> parameterMap,
			List<GraphQLField> graphQLFields) {

			_key = key;
			_parameterMap = parameterMap;
			_graphQLFields = graphQLFields;
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder(_key);

			if (!_parameterMap.isEmpty()) {
				sb.append("(");

				for (Map.Entry<String, Object> entry :
						_parameterMap.entrySet()) {

					sb.append(entry.getKey());
					sb.append(": ");
					sb.append(entry.getValue());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append(")");
			}

			if (!_graphQLFields.isEmpty()) {
				sb.append("{");

				for (GraphQLField graphQLField : _graphQLFields) {
					sb.append(graphQLField.toString());
					sb.append(", ");
				}

				sb.setLength(sb.length() - 2);

				sb.append("}");
			}

			return sb.toString();
		}

		private final List<GraphQLField> _graphQLFields;
		private final String _key;
		private final Map<String, Object> _parameterMap;

	}

	private static final Log _log = LogFactoryUtil.getLog(
		BaseCartOutputResourceTestCase.class);

	private static BeanUtilsBean _beanUtilsBean = new BeanUtilsBean() {

		@Override
		public void copyProperty(Object bean, String name, Object value)
			throws IllegalAccessException, InvocationTargetException {

			if (value != null) {
				super.copyProperty(bean, name, value);
			}
		}

	};
	private static DateFormat _dateFormat;

	@Inject
	private restbuilder.resource.v1_0.CartOutputResource _cartOutputResource;

}