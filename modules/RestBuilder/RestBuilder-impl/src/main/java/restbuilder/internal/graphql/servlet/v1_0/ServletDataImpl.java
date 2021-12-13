package restbuilder.internal.graphql.servlet.v1_0;

import com.liferay.portal.vulcan.graphql.servlet.ServletData;

import javax.annotation.Generated;

import org.osgi.framework.BundleContext;
import org.osgi.service.component.ComponentServiceObjects;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceScope;

import restbuilder.internal.graphql.mutation.v1_0.Mutation;
import restbuilder.internal.graphql.query.v1_0.Query;

import restbuilder.resource.v1_0.CartOutputResource;
import restbuilder.resource.v1_0.CategoryInputResource;
import restbuilder.resource.v1_0.CategoryResource;
import restbuilder.resource.v1_0.ProductInputResource;
import restbuilder.resource.v1_0.ProductOutputResource;
import restbuilder.resource.v1_0.TypeInputResource;
import restbuilder.resource.v1_0.TypeResource;

/**
 * @author Wesley Roberts
 * @generated
 */
@Component(immediate = true, service = ServletData.class)
@Generated("")
public class ServletDataImpl implements ServletData {

	@Activate
	public void activate(BundleContext bundleContext) {
		Mutation.setCartOutputResourceComponentServiceObjects(
			_cartOutputResourceComponentServiceObjects);
		Mutation.setCategoryResourceComponentServiceObjects(
			_categoryResourceComponentServiceObjects);
		Mutation.setCategoryInputResourceComponentServiceObjects(
			_categoryInputResourceComponentServiceObjects);
		Mutation.setProductInputResourceComponentServiceObjects(
			_productInputResourceComponentServiceObjects);
		Mutation.setProductOutputResourceComponentServiceObjects(
			_productOutputResourceComponentServiceObjects);
		Mutation.setTypeResourceComponentServiceObjects(
			_typeResourceComponentServiceObjects);
		Mutation.setTypeInputResourceComponentServiceObjects(
			_typeInputResourceComponentServiceObjects);

		Query.setCartOutputResourceComponentServiceObjects(
			_cartOutputResourceComponentServiceObjects);
		Query.setCategoryResourceComponentServiceObjects(
			_categoryResourceComponentServiceObjects);
		Query.setProductOutputResourceComponentServiceObjects(
			_productOutputResourceComponentServiceObjects);
		Query.setTypeResourceComponentServiceObjects(
			_typeResourceComponentServiceObjects);
	}

	@Override
	public Mutation getMutation() {
		return new Mutation();
	}

	@Override
	public String getPath() {
		return "/RestBuilder-graphql/v1_0";
	}

	@Override
	public Query getQuery() {
		return new Query();
	}

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<CartOutputResource>
		_cartOutputResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<CategoryResource>
		_categoryResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<CategoryInputResource>
		_categoryInputResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<ProductInputResource>
		_productInputResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<ProductOutputResource>
		_productOutputResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<TypeResource>
		_typeResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<TypeInputResource>
		_typeInputResourceComponentServiceObjects;

}