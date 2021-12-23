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

import restbuilder.dto.v1_0.Cart;
import restbuilder.dto.v1_0.Category;
import restbuilder.dto.v1_0.Product;
import restbuilder.dto.v1_0.ProductInput;
import restbuilder.dto.v1_0.Stock;
import restbuilder.dto.v1_0.Type;

import restbuilder.resource.v1_0.CartResource;
import restbuilder.resource.v1_0.CategoryResource;
import restbuilder.resource.v1_0.ProductResource;
import restbuilder.resource.v1_0.StockResource;
import restbuilder.resource.v1_0.TypeResource;

/**
 * @author Wesley Roberts
 * @generated
 */
@Generated("")
public class Query {

	public static void setCartResourceComponentServiceObjects(
		ComponentServiceObjects<CartResource>
			cartResourceComponentServiceObjects) {

		_cartResourceComponentServiceObjects =
			cartResourceComponentServiceObjects;
	}

	public static void setCategoryResourceComponentServiceObjects(
		ComponentServiceObjects<CategoryResource>
			categoryResourceComponentServiceObjects) {

		_categoryResourceComponentServiceObjects =
			categoryResourceComponentServiceObjects;
	}

	public static void setProductResourceComponentServiceObjects(
		ComponentServiceObjects<ProductResource>
			productResourceComponentServiceObjects) {

		_productResourceComponentServiceObjects =
			productResourceComponentServiceObjects;
	}

	public static void setStockResourceComponentServiceObjects(
		ComponentServiceObjects<StockResource>
			stockResourceComponentServiceObjects) {

		_stockResourceComponentServiceObjects =
			stockResourceComponentServiceObjects;
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
	public CartPage allCarts() throws Exception {
		return _applyComponentServiceObjects(
			_cartResourceComponentServiceObjects,
			this::_populateResourceContext,
			cartResource -> new CartPage(cartResource.getAllCarts()));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {cartById(cartId: ___){id, totalValue, productList}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public Cart cartById(@GraphQLName("cartId") Integer cartId)
		throws Exception {

		return _applyComponentServiceObjects(
			_cartResourceComponentServiceObjects,
			this::_populateResourceContext,
			cartResource -> cartResource.getCartById(cartId));
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
			_cartResourceComponentServiceObjects,
			this::_populateResourceContext,
			cartResource -> cartResource.getTotalValueByCartId(cartId));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {createCart{id, totalValue, productList}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public Cart createCart() throws Exception {
		return _applyComponentServiceObjects(
			_cartResourceComponentServiceObjects,
			this::_populateResourceContext,
			cartResource -> cartResource.createCart());
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
	public ProductPage allProducts() throws Exception {
		return _applyComponentServiceObjects(
			_productResourceComponentServiceObjects,
			this::_populateResourceContext,
			productResource -> new ProductPage(
				productResource.getAllProducts()));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {productById(productId: ___){name, id, category, type, price}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public Product productById(@GraphQLName("productId") Integer productId)
		throws Exception {

		return _applyComponentServiceObjects(
			_productResourceComponentServiceObjects,
			this::_populateResourceContext,
			productResource -> productResource.getProductById(productId));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {allStock{items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public StockPage allStock() throws Exception {
		return _applyComponentServiceObjects(
			_stockResourceComponentServiceObjects,
			this::_populateResourceContext,
			stockResource -> new StockPage(stockResource.getAllStock()));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -H 'Content-Type: text/plain; charset=utf-8' -X 'POST' 'http://localhost:8080/o/graphql' -d $'{"query": "query {allProductsBySotckId(stockId: ___){items {__}, page, pageSize, totalCount}}"}' -u 'test@liferay.com:test'
	 */
	@GraphQLField
	public StockPage allProductsBySotckId(
			@GraphQLName("stockId") Integer stockId)
		throws Exception {

		return _applyComponentServiceObjects(
			_stockResourceComponentServiceObjects,
			this::_populateResourceContext,
			stockResource -> new StockPage(
				stockResource.getAllProductsBySotckId(stockId)));
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

	@GraphQLTypeExtension(Cart.class)
	public class GetTotalValueByCartIdTypeExtension {

		public GetTotalValueByCartIdTypeExtension(Cart cart) {
			_cart = cart;
		}

		@GraphQLField
		public Integer totalValueByCartId() throws Exception {
			return _applyComponentServiceObjects(
				_cartResourceComponentServiceObjects,
				Query.this::_populateResourceContext,
				cartResource -> cartResource.getTotalValueByCartId(
					_cart.getId()));
		}

		private Cart _cart;

	}

	@GraphQLName("CartPage")
	public class CartPage {

		public CartPage(Page cartPage) {
			actions = cartPage.getActions();

			items = cartPage.getItems();
			lastPage = cartPage.getLastPage();
			page = cartPage.getPage();
			pageSize = cartPage.getPageSize();
			totalCount = cartPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Cart> items;

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

	@GraphQLName("ProductPage")
	public class ProductPage {

		public ProductPage(Page productPage) {
			actions = productPage.getActions();

			items = productPage.getItems();
			lastPage = productPage.getLastPage();
			page = productPage.getPage();
			pageSize = productPage.getPageSize();
			totalCount = productPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Product> items;

		@GraphQLField
		protected long lastPage;

		@GraphQLField
		protected long page;

		@GraphQLField
		protected long pageSize;

		@GraphQLField
		protected long totalCount;

	}

	@GraphQLName("StockPage")
	public class StockPage {

		public StockPage(Page stockPage) {
			actions = stockPage.getActions();

			items = stockPage.getItems();
			lastPage = stockPage.getLastPage();
			page = stockPage.getPage();
			pageSize = stockPage.getPageSize();
			totalCount = stockPage.getTotalCount();
		}

		@GraphQLField
		protected Map<String, Map> actions;

		@GraphQLField
		protected java.util.Collection<Stock> items;

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

	private void _populateResourceContext(CartResource cartResource)
		throws Exception {

		cartResource.setContextAcceptLanguage(_acceptLanguage);
		cartResource.setContextCompany(_company);
		cartResource.setContextHttpServletRequest(_httpServletRequest);
		cartResource.setContextHttpServletResponse(_httpServletResponse);
		cartResource.setContextUriInfo(_uriInfo);
		cartResource.setContextUser(_user);
		cartResource.setGroupLocalService(_groupLocalService);
		cartResource.setRoleLocalService(_roleLocalService);
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

	private void _populateResourceContext(ProductResource productResource)
		throws Exception {

		productResource.setContextAcceptLanguage(_acceptLanguage);
		productResource.setContextCompany(_company);
		productResource.setContextHttpServletRequest(_httpServletRequest);
		productResource.setContextHttpServletResponse(_httpServletResponse);
		productResource.setContextUriInfo(_uriInfo);
		productResource.setContextUser(_user);
		productResource.setGroupLocalService(_groupLocalService);
		productResource.setRoleLocalService(_roleLocalService);
	}

	private void _populateResourceContext(StockResource stockResource)
		throws Exception {

		stockResource.setContextAcceptLanguage(_acceptLanguage);
		stockResource.setContextCompany(_company);
		stockResource.setContextHttpServletRequest(_httpServletRequest);
		stockResource.setContextHttpServletResponse(_httpServletResponse);
		stockResource.setContextUriInfo(_uriInfo);
		stockResource.setContextUser(_user);
		stockResource.setGroupLocalService(_groupLocalService);
		stockResource.setRoleLocalService(_roleLocalService);
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

	private static ComponentServiceObjects<CartResource>
		_cartResourceComponentServiceObjects;
	private static ComponentServiceObjects<CategoryResource>
		_categoryResourceComponentServiceObjects;
	private static ComponentServiceObjects<ProductResource>
		_productResourceComponentServiceObjects;
	private static ComponentServiceObjects<StockResource>
		_stockResourceComponentServiceObjects;
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