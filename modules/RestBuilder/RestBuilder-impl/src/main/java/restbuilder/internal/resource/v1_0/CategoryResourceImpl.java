package restbuilder.internal.resource.v1_0;

import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.sales.model.SaleCategory;
import com.liferay.sales.service.SaleCategoryService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import restbuilder.dto.v1_0.Category;
import restbuilder.resource.v1_0.CategoryResource;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Wesley Roberts
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/category.properties",
	scope = ServiceScope.PROTOTYPE, service = CategoryResource.class
)
public class CategoryResourceImpl extends BaseCategoryResourceImpl {
	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'GET' 'http://localhost:8080/o/RestBuilder/v1.0/category/all'  -u 'test@liferay.com:test'
	 */
	@GET
	@Override
	@Path("/category/all")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Category")})
	public Page<Category> getAllCategories() throws Exception {
		List<Category> listCategory = new ArrayList<Category>();
		for (SaleCategory e: _saleCategoryService.getAll()){
			listCategory.add(_toCategoryDTO(e));
		}
		return Page.of(listCategory);
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'GET' 'http://localhost:8080/o/RestBuilder/v1.0/category/{categoryName}'  -u 'test@liferay.com:test'
	 */
	@GET
	@Override
	@Parameters(
			value = {@Parameter(in = ParameterIn.PATH, name = "categoryName")}
	)
	@Path("/category/{categoryName}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Category")})
	public Category getCategoryByName(
			@NotNull @Parameter(hidden = true) @PathParam("categoryName") String
					categoryName)
			throws Exception {
		SaleCategory saleCategory = _saleCategoryService.getCategoryByName(categoryName);
		return _toCategoryDTO(saleCategory);
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'GET' 'http://localhost:8080/o/RestBuilder/v1.0/category/{categoryId}'  -u 'test@liferay.com:test'
	 */
	@GET
	@Override
	@Parameters(
			value = {@Parameter(in = ParameterIn.PATH, name = "categoryId")}
	)
	@Path("/category/{categoryId}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Category")})
	public Category getCategoryById(
			@NotNull @Parameter(hidden = true) @PathParam("categoryId") Integer
					categoryId)
			throws Exception {
		SaleCategory saleCategory = _saleCategoryService.getSaleCategoryById(categoryId);
		return _toCategoryDTO(saleCategory);
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'POST' 'http://localhost:8080/o/RestBuilder/v1.0/category/create' -d $'{"id": ___, "name": ___, "tax": ___}' --header 'Content-Type: application/json' -u 'test@liferay.com:test'
	 */
	@Consumes({"application/json", "application/xml"})
	@Override
	@Path("/category/create")
	@POST
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Category")})
	public Category createCategory(Category category) throws Exception {
		SaleCategory saleCategory = _saleCategoryService.createSaleCategory(category.getId(),category.getName(),category.getTax());
		return _toCategoryDTO(saleCategory);
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'DELETE' 'http://localhost:8080/o/RestBuilder/v1.0/category/delete/{categoryId}'  -u 'test@liferay.com:test'
	 */
	@DELETE
	@Override
	@Parameters(
			value = {@Parameter(in = ParameterIn.PATH, name = "categoryId")}
	)
	@Path("/category/delete/{categoryId}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Category")})
	public void deleteCategoryById(
			@NotNull @Parameter(hidden = true) @PathParam("categoryId") Integer
					categoryId)
			throws Exception {
		_saleCategoryService.deleCategoryById(categoryId);
	}

	private Category _toCategoryDTO(SaleCategory saleCategory){
		return new Category(){
			{
				id = (int)saleCategory.getCategoryId();
				name = saleCategory.getName();
				tax = saleCategory.getTax();
			}
		};
	}
	@Reference
	SaleCategoryService _saleCategoryService;
}