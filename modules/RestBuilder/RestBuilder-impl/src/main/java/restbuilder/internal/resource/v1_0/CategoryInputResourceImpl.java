package restbuilder.internal.resource.v1_0;

import com.liferay.sales.model.SaleCategory;
import com.liferay.sales.service.SaleCategoryService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import restbuilder.dto.v1_0.Category;
import restbuilder.dto.v1_0.CategoryInput;
import restbuilder.resource.v1_0.CategoryInputResource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * @author Wesley Roberts
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/category-input.properties",
	scope = ServiceScope.PROTOTYPE, service = CategoryInputResource.class
)
public class CategoryInputResourceImpl extends BaseCategoryInputResourceImpl {
	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'POST' 'http://localhost:8080/o/RestBuilder/v1.0/category/create' -d $'{"name": ___, "tax": ___}' --header 'Content-Type: application/json' -u 'test@liferay.com:test'
	 */
	@Consumes({"application/json", "application/xml"})
	@Override
	@Path("/category/create")
	@POST
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "CategoryInput")})
	public Category createCategory(CategoryInput categoryInput)
			throws Exception {
		SaleCategory saleCategory = _saleCategoryService.createSaleCategory(categoryInput.getName(),categoryInput.getTax());
		return _toCategoryDTO(saleCategory);
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