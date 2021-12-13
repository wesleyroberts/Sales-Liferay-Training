package restbuilder.internal.graphql.query.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.filter.Filter;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLTypeExtension;
import com.liferay.portal.vulcan.pagination.Page;

import java.util.Map;
import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

import restbuilder.dto.v1_0.CartOutput;
import restbuilder.dto.v1_0.Category;
import restbuilder.dto.v1_0.ProductInput;
import restbuilder.dto.v1_0.ProductOutput;
import restbuilder.dto.v1_0.Type;

import restbuilder.resource.v1_0.CartOutputResource;
import restbuilder.resource.v1_0.CategoryResource;
import restbuilder.resource.v1_0.ProductOutputResource;
import restbuilder.resource.v1_0.TypeResource;

/**
 * @author Wesley Roberts
 * @generated
 */
@Generated("")
public class Query {

	public static void setCartOutputResourceComponentServiceObjects(
		ComponentServiceObjects<CartOutputResource>
			cartOutputResourceComponentServiceObjects) {

		_cartOutputResourceComponentServiceObjects =
			cartOutputResourceComponentServiceObjects;
	}

	public static void setCategoryResourceComponentServiceObjects(
		ComponentServiceObjects<CategoryResource>
			categoryResourceComponentServiceObjects) {

		_categoryResourceComponentServiceObjects =
			categoryResourceComponentServiceObjects;
	}

	public static void setProductOutputResourceComponentServiceObjects(
		ComponentServiceObjects<ProductOutputResource>
			productOutputResourceComponentServiceObjects) {

		_productOutputResourceComponentServiceObjects =
			productOutputResourceComponentServiceObjects;
	}

	public static void setTypeResourceComponentServiceObjects(
		ComponentServiceObjects<TypeResource>
			typeResourceComponentServiceObjects) {

		_typeResourceComponentServiceObjects =
			typeResourceComponentServiceObjects;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {allCarts{items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public CartOutputPage allCarts() throws Exception {
		return _applyComponentServiceObjects(
			_cartOutputResourceComponentServiceObjects,
			this::_populateResourceContext,
			cartOutputResource -> new CartOutputPage(
				cartOutputResource.getAllCarts()));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {cartById(cartId: ___){id, totalValue, productList}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public CartOutput cartById(@GraphQLName("cartId") Integer cartId)
		throws Exception {

		return _applyComponentServiceObjects(
			_cartOutputResourceComponentServiceObjects,
			this::_populateResourceContext,
			cartOutputResource -> cartOutputResource.getCartById(cartId));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {totalValueByCartId(cartId: ___){}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public Integer totalValueByCartId(@GraphQLName("cartId") Integer cartId)
		throws Exception {

		return _applyComponentServiceObjects(
			_cartOutputResourceComponentServiceObjects,
			this::_populateResourceContext,
			cartOutputResource -> cartOutputResource.getTotalValueByCartId(
				cartId));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {createCart{id, totalValue, productList}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public CartOutput createCart() throws Exception {
		return _applyComponentServiceObjects(
			_cartOutputResourceComponentServiceObjects,
			this::_populateResourceContext,
			cartOutputResource -> cartOutputResource.createCart());
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {allCategories{items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public CategoryPage allCategories() throws Exception {
		return _applyComponentServiceObjects(
			_categoryResourceComponentServiceObjects,
			this::_populateResourceContext,
			categoryResource -> new CategoryPage(
				categoryResource.getAllCategories()));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {categoryByName(categoryName: ___){name, id, tax}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public Category categoryByName(
			@GraphQLName("categoryName") String categoryName)
		throws Exception {

		return _applyComponentServiceObjects(
			_categoryResourceComponentServiceObjects,
			this::_populateResourceContext,
			categoryResource -> categoryResource.getCategoryByName(
				categoryName));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {categoryById(categoryId: ___){name, id, tax}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public Category categoryById(@GraphQLName("categoryId") Integer categoryId)
		throws Exception {

		return _applyComponentServiceObjects(
			_categoryResourceComponentServiceObjects,
			this::_populateResourceContext,
			categoryResource -> categoryResource.getCategoryById(categoryId));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {allProducts{items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public ProductOutputPage allProducts() throws Exception {
		return _applyComponentServiceObjects(
			_productOutputResourceComponentServiceObjects,
			this::_populateResourceContext,
			productOutputResource -> new ProductOutputPage(
				productOutputResource.getAllProducts()));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {productById(productId: ___){name, id, category, type, price}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public ProductOutput productById(
			@GraphQLName("productId") Integer productId)
		throws Exception {

		return _applyComponentServiceObjects(
			_productOutputResourceComponentServiceObjects,
			this::_populateResourceContext,
			productOutputResource -> productOutputResource.getProductById(
				productId));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {allTypes{items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public TypePage allTypes() throws Exception {
		return _applyComponentServiceObjects(
			_typeResourceComponentServiceObjects,
			this::_populateResourceContext,
			typeResource -> new TypePage(typeResource.getAllTypes()));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {typeById(typeId: ___){name, id, tax}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public Type typeById(@GraphQLName("typeId") Integer typeId)
		throws Exception {

		return _applyComponentServiceObjects(
			_typeResourceComponentServiceObjects,
			this::_populateResourceContext,
			typeResource -> typeResource.getTypeById(typeId));
	}

	@GraphQLTypeExtension(ProductInput.class)
	public class GetTypeByIdTypeExtension {

		public GetTypeByIdTypeExtension(ProductInput productInput) {
			_productInput = productInput;
		}

		@GraphQLField
		public Type typeById() throws Exception {
			return _applyComponentServiceObjects(
				_typeResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				typeResource -> typeResource.getTypeById(
					_productInput.getTypeId()));
		}

		private ProductInput _productInput;

	}

	@GraphQLTypeExtension(ProductInput.class)
	public class GetCategoryByIdTypeExtension {

		public GetCategoryByIdTypeExtension(ProductInput productInput) {
			_productInput = productInput;
		}

		@GraphQLField
		public Category categoryById() throws Exception {
			return _applyComponentServiceObjects(
				_categoryResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				categoryResource -> categoryResource.getCategoryById(
					_productInput.getCategoryId()));
		}

		private ProductInput _productInput;

	}

	@GraphQLName("CartOutputPage")
	public class CartOutputPage {

		public CartOutputPage(Page cartOutputPage) {
			actions = cartOutputPage.getActions();

			items = cartOutputPage.getItems();
			lastPage = cartOutputPage.getLastPage();
			page = cartOutputPage.getPage();
			pageSize = cartOutputPage.getPageSize();
			totalCount = cartOutputPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<CartOutput> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("CategoryPage")
	public class CategoryPage {

		public CategoryPage(Page categoryPage) {
			actions = categoryPage.getActions();

			items = categoryPage.getItems();
			lastPage = categoryPage.getLastPage();
			page = categoryPage.getPage();
			pageSize = categoryPage.getPageSize();
			totalCount = categoryPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Category> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("ProductOutputPage")
	public class ProductOutputPage {

		public ProductOutputPage(Page productOutputPage) {
			actions = productOutputPage.getActions();

			items = productOutputPage.getItems();
			lastPage = productOutputPage.getLastPage();
			page = productOutputPage.getPage();
			pageSize = productOutputPage.getPageSize();
			totalCount = productOutputPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<ProductOutput> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("TypePage")
	public class TypePage {

		public TypePage(Page typePage) {
			actions = typePage.getActions();

			items = typePage.getItems();
			lastPage = typePage.getLastPage();
			page = typePage.getPage();
			pageSize = typePage.getPageSize();
			totalCount = typePage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Type> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	private <T, R, E1 extends Throwable, E2 extends Throwable> R
			_applyComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeFunction<T, R, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			return unsafeFunction.apply(resource);
		}
		finally {
			componentServiceObjects.ungetService(resource);
		}
	}

	private void _populateResourceContext(CartOutputResource cartOutputResource)
		throws Exception {

		cartOutputResource.setContextAcceptLanguage(_acceptLanguage);
		cartOutputResource.setContextCompany(_company);
		cartOutputResource.setContextHttpServletRequest(_httpServletRequest);
		cartOutputResource.setContextHttpServletResponse(_httpServletResponse);
		cartOutputResource.setContextUriInfo(_uriInfo);
		cartOutputResource.setContextUser(_user);
		cartOutputResource.setGroupLocalService(_groupLocalService);
		cartOutputResource.setRoleLocalService(_roleLocalService);
	}

	private void _populateResourceContext(CategoryResource categoryResource)
		throws Exception {

		categoryResource.setContextAcceptLanguage(_acceptLanguage);
		categoryResource.setContextCompany(_company);
		categoryResource.setContextHttpServletRequest(_httpServletRequest);
		categoryResource.setContextHttpServletResponse(_httpServletResponse);
		categoryResource.setContextUriInfo(_uriInfo);
		categoryResource.setContextUser(_user);
		categoryResource.setGroupLocalService(_groupLocalService);
		categoryResource.setRoleLocalService(_roleLocalService);
	}

	private void _populateResourceContext(
			ProductOutputResource productOutputResource)
		throws Exception {

		productOutputResource.setContextAcceptLanguage(_acceptLanguage);
		productOutputResource.setContextCompany(_company);
		productOutputResource.setContextHttpServletRequest(_httpServletRequest);
		productOutputResource.setContextHttpServletResponse(
			_httpServletResponse);
		productOutputResource.setContextUriInfo(_uriInfo);
		productOutputResource.setContextUser(_user);
		productOutputResource.setGroupLocalService(_groupLocalService);
		productOutputResource.setRoleLocalService(_roleLocalService);
	}

	private void _populateResourceContext(TypeResource typeResource)
		throws Exception {

		typeResource.setContextAcceptLanguage(_acceptLanguage);
		typeResource.setContextCompany(_company);
		typeResource.setContextHttpServletRequest(_httpServletRequest);
		typeResource.setContextHttpServletResponse(_httpServletResponse);
		typeResource.setContextUriInfo(_uriInfo);
		typeResource.setContextUser(_user);
		typeResource.setGroupLocalService(_groupLocalService);
		typeResource.setRoleLocalService(_roleLocalService);
	}

	private static ComponentServiceObjects<CartOutputResource>
		_cartOutputResourceComponentServiceObjects;
	private static ComponentServiceObjects<CategoryResource>
		_categoryResourceComponentServiceObjects;
	private static ComponentServiceObjects<ProductOutputResource>
		_productOutputResourceComponentServiceObjects;
	private static ComponentServiceObjects<TypeResource>
		_typeResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private BiFunction<Object, String, Filter> _filterBiFunction;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}