package restbuilder.internal.resource.v1_0;

import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.sales.model.SaleProduct;
import com.liferay.sales.service.SaleProductService;
import com.liferay.tax.TaxService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import restbuilder.dto.v1_0.Product;
import restbuilder.resource.v1_0.CategoryResource;
import restbuilder.resource.v1_0.ProductResource;
import restbuilder.resource.v1_0.TypeResource;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Wesley Roberts
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/product.properties",
	scope = ServiceScope.PROTOTYPE, service = ProductResource.class
)
public class ProductResourceImpl extends BaseProductResourceImpl {

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'GET' 'http://localhost:8080/o/RestBuilder/v1.0/product/all'  -u 'test@liferay.com:test'
	 */
	@GET
	@Override
	@Path("/product/all")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Product")})
	public Page<Product> getProductsAllPage() throws Exception {

		List<Product> productListDTO = new ArrayList<Product>();

		for (SaleProduct e: _saleProductService.getAllSaleProducts()){
			productListDTO.add(_toProductDTO(e));
		}

		return Page.of(productListDTO);
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'GET' 'http://localhost:8080/o/RestBuilder/v1.0/product/{productId}'  -u 'test@liferay.com:test'
	 */
	@GET
	@Override
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "productId")})
	@Path("/product/{productId}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Product")})
	public Product getProduct(
			@NotNull @Parameter(hidden = true) @PathParam("productId") Integer
					productId)
			throws Exception {
		return _toProductDTO( _saleProductService.getSaleProductById(productId));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'POST' 'http://localhost:8080/o/RestBuilder/v1.0/product/post' -d $'{"category": ___, "id": ___, "name": ___, "price": ___, "type": ___}' --header 'Content-Type: application/json' -u 'test@liferay.com:test'
	 */
	@Consumes({"application/json", "application/xml"})
	@Override
	@Path("/product/post")
	@POST
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Product")})
	public Product postProductPost(Product product) throws Exception {
		_saleProductService.createProduct(
				product.getName(),
				product.getPrice(),
				product.getId(),
				product.getCategory().getId(),
				product.getType().getId()
		);
		return product;
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'DELETE' 'http://localhost:8080/o/RestBuilder/v1.0/product/delete/{productId}'  -u 'test@liferay.com:test'
	 */
	@DELETE
	@Override
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "productId")})
	@Path("/product/delete/{productId}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Product")})
	public void deleteProductDeleteProduct(
			@NotNull @Parameter(hidden = true) @PathParam("productId") Integer
					productId)
			throws Exception {
		_saleProductService.deleteById(productId);
	}

	private Product _toProductDTO(SaleProduct saleProduct) throws Exception {
		return new Product(){
			{	category = _categoryResource.getCategory((int) saleProduct.getCategoryId());
				type = _typeResource.getType((int) saleProduct.getTypeId());
				id = (int)saleProduct.getProductId();
				name = saleProduct.getName();
				price = saleProduct.getPrice();
			}
		};
	}

	@Reference
	SaleProductService _saleProductService;
	@Reference
	CategoryResource _categoryResource;
	@Reference
	TypeResource _typeResource;

}