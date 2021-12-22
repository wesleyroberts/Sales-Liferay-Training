package restbuilder.internal.resource.v1_0;

import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.sales.model.SaleProduct;
import com.liferay.sales.service.SaleProductService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
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

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

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
	 * curl -X 'POST' 'http://localhost:8080/o/RestBuilder/v1.0/product/create' -d $'{"categoryId": ___, "name": ___, "price": ___, "quantity": ___, "typeId": ___}' --header 'Content-Type: application/json' -u 'test@liferay.com:test'
	 */
	@Consumes({"application/json", "application/xml"})
	@Override
	@Path("/product/create")
	@POST
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "ProductInput")})
	public Page<ProductOutput> createProduct(ProductInput productInput)
			throws Exception {
		List<ProductOutput> productOutputList = new ArrayList<ProductOutput>();
		for (SaleProduct p: _saleProductService.createSaleProductInScale(productInput.getName(), productInput.getPrice(), productInput.getCategoryId(), productInput.getTypeId(), productInput.getQuantity())){
			productOutputList.add(_toProductOutput(p));
		}
		return Page.of(productOutputList);
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'PUT' 'http://localhost:8080/o/RestBuilder/v1.0/product/update/{productId}' -d $'{"categoryId": ___, "name": ___, "price": ___, "typeId": ___}' --header 'Content-Type: application/json' -u 'test@liferay.com:test'
	 */
	@Consumes({"application/json", "application/xml"})
	@Override
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "productId")})
	@Path("/product/update/{productId}")
	@Produces({"application/json", "application/xml"})
	@PUT
	@Tags(value = {@Tag(name = "ProductInput")})
	public ProductOutput updateProductById(
			@NotNull @Parameter(hidden = true) @PathParam("productId") Integer
					productId,
			ProductInput productInput)
			throws Exception {
		SaleProduct saleProduct = _saleProductService.
				updateSaleProduct(
						productId,
						productInput.getName(),
						productInput.getPrice(),
						productInput.getCategoryId(),
						productInput.getTypeId());


		return _toProductOutput(saleProduct);
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