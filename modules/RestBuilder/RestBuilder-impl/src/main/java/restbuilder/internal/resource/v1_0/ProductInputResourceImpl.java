package restbuilder.internal.resource.v1_0;

import com.liferay.sales.model.SaleProduct;
import com.liferay.sales.service.SaleProductService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import restbuilder.dto.v1_0.ProductInput;
import restbuilder.dto.v1_0.ProductOutput;
import restbuilder.resource.v1_0.CategoryResource;
import restbuilder.resource.v1_0.ProductInputResource;
import restbuilder.resource.v1_0.TypeResource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * @author Wesley Roberts
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/product-input.properties",
	scope = ServiceScope.PROTOTYPE, service = ProductInputResource.class
)
public class ProductInputResourceImpl extends BaseProductInputResourceImpl {

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'POST' 'http://localhost:8080/o/RestBuilder/v1.0/product/create' -d $'{"categoryId": ___, "name": ___, "price": ___, "typeId": ___}' --header 'Content-Type: application/json' -u 'test@liferay.com:test'
	 */
	@Consumes({"application/json", "application/xml"})
	@Override
	@Path("/product/create")
	@POST
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "ProductInput")})
	public ProductOutput createProduct(ProductInput productInput)
			throws Exception {
		return _toProductOutput(_saleProductService.createSaleProduct(
				productInput.getName(),
				productInput.getPrice(),
				productInput.getCategoryId(),
				productInput.getTypeId()
		));
	}

	private ProductOutput _toProductOutput(SaleProduct saleProduct){
		return new ProductOutput(){
			{
				try {
					category = _categoryResource.getCategoryById((int) saleProduct.getCategoryId());
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					type = _typeResource.getTypeById((int) saleProduct.getTypeId());
				} catch (Exception e) {
					e.printStackTrace();
				}
				id = (int)saleProduct.getProductId();
				name = saleProduct.getName();
				price = saleProduct.getPrice();
			}
		};
	}

	@Reference
	TypeResource _typeResource;
	@Reference
	CategoryResource _categoryResource;
	@Reference
	SaleProductService _saleProductService;
}