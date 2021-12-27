package restbuilder.internal.resource.v1_0;

import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.sales.model.SaleProduct;
import com.liferay.sales.model.SaleStock;
import com.liferay.sales.service.SaleStockService;
import com.liferay.sales.service.StockProductsListLocalService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import restbuilder.dto.v1_0.Product;
import restbuilder.dto.v1_0.Stock;
import restbuilder.resource.v1_0.CategoryResource;
import restbuilder.resource.v1_0.StockResource;
import restbuilder.resource.v1_0.TypeResource;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Wesley Roberts
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/stock.properties",
	scope = ServiceScope.PROTOTYPE, service = StockResource.class
)
public class StockResourceImpl extends BaseStockResourceImpl {

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'GET' 'http://localhost:8080/o/RestBuilder/v1.0/stock/all'  -u 'test@liferay.com:test'
	 */
	@GET
	@Override
	@Path("/stock/all")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Stock")})
	public Page<Stock> getAllStock() throws Exception {
		List<Stock> stockList = new ArrayList<Stock>();
		for (SaleStock stock:_saleStockService.getAllSaleStock()) {
			stockList.add(_toStock(stock));
		}
		return Page.of(stockList);
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'GET' 'http://localhost:8080/o/RestBuilder/v1.0/stock/getAllProductsBySotckId/{stockId}'  -u 'test@liferay.com:test'
	 */
	@GET
	@Override
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "stockId")})
	@Path("/stock/getAllProductsBySotckId/{stockId}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Stock")})
	public Page<Product> getAllProductsBySotckId(
			@NotNull @Parameter(hidden = true) @PathParam("stockId") Integer
					stockId)
			throws Exception {
		List<Product> productList = new ArrayList<Product>();
		for (SaleProduct product: _stockProductsListLocalService.getAllProductInStockByStockId(stockId)) {
			productList.add(_toProduct(product));
		}
		return Page.of(productList);

	}

	private Product _toProduct(SaleProduct saleProduct){
		return new Product(){
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

	private Stock _toStock(SaleStock stock) {
		return new Stock() {
			{
				try {
					category = _categoryResource.getCategoryById((int) stock.getCategoryId());
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					type = _typeResource.getTypeById((int) stock.getTypeId());
				} catch (Exception e) {
					e.printStackTrace();
				}
				id = (int) stock.getStockId();
				productName = stock.getName();
				price = stock.getPrice();
				quantity = stock.getQuantity();
			}
		};

	}

	@Reference
	SaleStockService _saleStockService;
	@Reference
	TypeResource _typeResource;
	@Reference
	CategoryResource _categoryResource;
	@Reference
	StockProductsListLocalService _stockProductsListLocalService;
}