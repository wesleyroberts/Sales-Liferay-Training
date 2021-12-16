package restbuilder.internal.resource.v1_0;

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
	public ProductOutput createProduct(ProductInput productInput)
			throws Exception {
		return _toProductOutput(_saleProductService.createSaleProduct(
				productInput.getName(),
				productInput.getPrice(),
				productInput.getCategoryId(),
				productInput.getTypeId(),
				productInput.getQuantity()
		));
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


	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'PATCH' 'http://localhost:8080/o/RestBuilder/v1.0/addProductInStock/product/products/{productId}/quantity/{quantity}'  -u 'test@liferay.com:test'
	 */
	@Override
	@Parameters(
			value = {
					@Parameter(in = ParameterIn.PATH, name = "productId"),
					@Parameter(in = ParameterIn.PATH, name = "quantity")
			}
	)
	@PATCH
	@Path("/addProductInStock/product/products/{productId}/quantity/{quantity}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "ProductInput")})
	public ProductOutput addProductInStock(
			@NotNull @Parameter(hidden = true) @PathParam("productId") Integer
					productId,
			@NotNull @Parameter(hidden = true) @PathParam("quantity") Integer
					quantity)
			throws Exception {
		_saleProductService.addSaleProductInStock(productId,quantity);
		SaleProduct saleProduct = _saleProductService.getSaleProductById(productId);
		return _toProductOutput(saleProduct);
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'PATCH' 'http://localhost:8080/o/RestBuilder/v1.0/removeProductFromStock/product/products/{productId}/quantity/{quantity}'  -u 'test@liferay.com:test'
	 */
	@Override
	@Parameters(
			value = {
					@Parameter(in = ParameterIn.PATH, name = "productId"),
					@Parameter(in = ParameterIn.PATH, name = "quantity")
			}
	)
	@PATCH
	@Path(
			"/removeProductFromStock/product/products/{productId}/quantity/{quantity}"
	)
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "ProductInput")})
	public void removeProductFromStock(
			@NotNull @Parameter(hidden = true) @PathParam("productId") Integer
					productId,
			@NotNull @Parameter(hidden = true) @PathParam("quantity") Integer
					quantity)
			throws Exception {
		_saleProductService.removeSaleProductInStock(productId,quantity);
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
				quantity = saleProduct.getQuantity();

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