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

import restbuilder.resource.v1_0.CartResource;
import restbuilder.resource.v1_0.CategoryResource;
import restbuilder.resource.v1_0.ProductResource;
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
		Mutation.setCartResourceComponentServiceObjects(
			_cartResourceComponentServiceObjects);
		Mutation.setCategoryResourceComponentServiceObjects(
			_categoryResourceComponentServiceObjects);
		Mutation.setProductResourceComponentServiceObjects(
			_productResourceComponentServiceObjects);
		Mutation.setTypeResourceComponentServiceObjects(
			_typeResourceComponentServiceObjects);

		Query.setCartResourceComponentServiceObjects(
			_cartResourceComponentServiceObjects);
		Query.setCategoryResourceComponentServiceObjects(
			_categoryResourceComponentServiceObjects);
		Query.setProductResourceComponentServiceObjects(
			_productResourceComponentServiceObjects);
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
	private ComponentServiceObjects<CartResource>
		_cartResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<CategoryResource>
		_categoryResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<ProductResource>
		_productResourceComponentServiceObjects;

	@Reference(scope = ReferenceScope.PROTOTYPE_REQUIRED)
	private ComponentServiceObjects<TypeResource>
		_typeResourceComponentServiceObjects;

}