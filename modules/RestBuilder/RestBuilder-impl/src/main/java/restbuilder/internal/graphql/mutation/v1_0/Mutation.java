package restbuilder.internal.graphql.mutation.v1_0;

import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.petra.function.UnsafeFunction;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.vulcan.accept.language.AcceptLanguage;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLField;
import com.liferay.portal.vulcan.graphql.annotation.GraphQLName;

import java.util.function.BiFunction;

import javax.annotation.Generated;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.ws.rs.core.UriInfo;

import org.osgi.service.component.ComponentServiceObjects;

import restbuilder.dto.v1_0.Cart;
import restbuilder.dto.v1_0.Category;
import restbuilder.dto.v1_0.ProductInput;
import restbuilder.dto.v1_0.ProductOutput;
import restbuilder.dto.v1_0.Type;

import restbuilder.resource.v1_0.CartResource;
import restbuilder.resource.v1_0.CategoryResource;
import restbuilder.resource.v1_0.ProductInputResource;
import restbuilder.resource.v1_0.ProductOutputResource;
import restbuilder.resource.v1_0.TypeResource;

/**
 * @author Wesley Roberts
 * @generated
 */
@Generated("")
public class Mutation {

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

	public static void setProductInputResourceComponentServiceObjects(
		ComponentServiceObjects<ProductInputResource>
			productInputResourceComponentServiceObjects) {

		_productInputResourceComponentServiceObjects =
			productInputResourceComponentServiceObjects;
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

	@GraphQLField
	public Cart addProductToCart(
			@GraphQLName("cartId") Integer cartId,
			@GraphQLName("productId") Integer productId)
		throws Exception {

		return _applyComponentServiceObjects(
			_cartResourceComponentServiceObjects,
			this::_populateResourceContext,
			cartResource -> cartResource.addProductToCart(cartId, productId));
	}

	@GraphQLField
	public boolean removeProductToCart(
			@GraphQLName("cartId") Integer cartId,
			@GraphQLName("productId") Integer productId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_cartResourceComponentServiceObjects,
			this::_populateResourceContext,
			cartResource -> cartResource.removeProductToCart(
				cartId, productId));

		return true;
	}

	@GraphQLField
	public boolean deleteCartById(@GraphQLName("cartId") Integer cartId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_cartResourceComponentServiceObjects,
			this::_populateResourceContext,
			cartResource -> cartResource.deleteCartById(cartId));

		return true;
	}

	@GraphQLField
	public Category createCategory(@GraphQLName("category") Category category)
		throws Exception {

		return _applyComponentServiceObjects(
			_categoryResourceComponentServiceObjects,
			this::_populateResourceContext,
			categoryResource -> categoryResource.createCategory(category));
	}

	@GraphQLField
	public boolean deleteCategoryById(
			@GraphQLName("categoryId") Integer categoryId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_categoryResourceComponentServiceObjects,
			this::_populateResourceContext,
			categoryResource -> categoryResource.deleteCategoryById(
				categoryId));

		return true;
	}

	@GraphQLField
	public ProductOutput creatProduct(
			@GraphQLName("productInput") ProductInput productInput)
		throws Exception {

		return _applyComponentServiceObjects(
			_productInputResourceComponentServiceObjects,
			this::_populateResourceContext,
			productInputResource -> productInputResource.creatProduct(
				productInput));
	}

	@GraphQLField
	public boolean deleteProductById(
			@GraphQLName("productId") Integer productId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_productOutputResourceComponentServiceObjects,
			this::_populateResourceContext,
			productOutputResource -> productOutputResource.deleteProductById(
				productId));

		return true;
	}

	@GraphQLField
	public Type createType(@GraphQLName("type") Type type) throws Exception {
		return _applyComponentServiceObjects(
			_typeResourceComponentServiceObjects,
			this::_populateResourceContext,
			typeResource -> typeResource.createType(type));
	}

	@GraphQLField
	public boolean deleteTypeById(@GraphQLName("typeId") Integer typeId)
		throws Exception {

		_applyVoidComponentServiceObjects(
			_typeResourceComponentServiceObjects,
			this::_populateResourceContext,
			typeResource -> typeResource.deleteTypeById(typeId));

		return true;
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

	private <T, E1 extends Throwable, E2 extends Throwable> void
			_applyVoidComponentServiceObjects(
				ComponentServiceObjects<T> componentServiceObjects,
				UnsafeConsumer<T, E1> unsafeConsumer,
				UnsafeConsumer<T, E2> unsafeFunction)
		throws E1, E2 {

		T resource = componentServiceObjects.getService();

		try {
			unsafeConsumer.accept(resource);

			unsafeFunction.accept(resource);
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

	private void _populateResourceContext(
			ProductInputResource productInputResource)
		throws Exception {

		productInputResource.setContextAcceptLanguage(_acceptLanguage);
		productInputResource.setContextCompany(_company);
		productInputResource.setContextHttpServletRequest(_httpServletRequest);
		productInputResource.setContextHttpServletResponse(
			_httpServletResponse);
		productInputResource.setContextUriInfo(_uriInfo);
		productInputResource.setContextUser(_user);
		productInputResource.setGroupLocalService(_groupLocalService);
		productInputResource.setRoleLocalService(_roleLocalService);
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

	private static ComponentServiceObjects<CartResource>
		_cartResourceComponentServiceObjects;
	private static ComponentServiceObjects<CategoryResource>
		_categoryResourceComponentServiceObjects;
	private static ComponentServiceObjects<ProductInputResource>
		_productInputResourceComponentServiceObjects;
	private static ComponentServiceObjects<ProductOutputResource>
		_productOutputResourceComponentServiceObjects;
	private static ComponentServiceObjects<TypeResource>
		_typeResourceComponentServiceObjects;

	private AcceptLanguage _acceptLanguage;
	private com.liferay.portal.kernel.model.Company _company;
	private GroupLocalService _groupLocalService;
	private HttpServletRequest _httpServletRequest;
	private HttpServletResponse _httpServletResponse;
	private RoleLocalService _roleLocalService;
	private BiFunction<Object, String, Sort[]> _sortsBiFunction;
	private UriInfo _uriInfo;
	private com.liferay.portal.kernel.model.User _user;

}