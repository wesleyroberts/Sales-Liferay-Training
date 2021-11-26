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

import restbuilder.dto.v1_0.ProductOutput;
import restbuilder.resource.v1_0.CategoryResource;
import restbuilder.resource.v1_0.ProductOutputResource;
import restbuilder.resource.v1_0.TypeResource;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Wesley Roberts
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/product-output.properties",
	scope = ServiceScope.PROTOTYPE, service = ProductOutputResource.class
)
public class ProductOutputResourceImpl extends BaseProductOutputResourceImpl {

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'GET' 'http://localhost:8080/o/RestBuilder/v1.0/product/all'  -u 'test@liferay.com:test'
	 */
	@GET
	@Override
	@Path("/product/all")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "ProductOutput")})
	public Page<ProductOutput> getAllProducts() throws Exception {
		List<ProductOutput> productOutputList = new ArrayList<ProductOutput>();
		for (SaleProduct saleProduct:_saleProductService.getAllSaleProducts()) {
			productOutputList.add(_toProductOutput(saleProduct));
		}
		return Page.of(productOutputList);
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
	@Tags(value = {@Tag(name = "ProductOutput")})
	public ProductOutput getProductById(
			@NotNull @Parameter(hidden = true) @PathParam("productId") Integer
					productId)
			throws Exception {
		return _toProductOutput(_saleProductService.getSaleProductById(productId));
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
	@Tags(value = {@Tag(name = "ProductOutput")})
	public void deleteProductById(
			@NotNull @Parameter(hidden = true) @PathParam("productId") Integer
					productId)
			throws Exception {
		_saleProductService.deleteById(productId);
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