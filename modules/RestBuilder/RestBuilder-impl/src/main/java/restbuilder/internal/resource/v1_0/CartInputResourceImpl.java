package restbuilder.internal.resource.v1_0;

import com.liferay.sales.model.SaleCart;
import com.liferay.sales.model.SaleProduct;
import com.liferay.sales.service.CartProductsListService;
import com.liferay.sales.service.SaleCartService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;
import restbuilder.dto.v1_0.CartInput;
import restbuilder.dto.v1_0.CartOutput;
import restbuilder.dto.v1_0.ProductList;
import restbuilder.resource.v1_0.CartInputResource;
import restbuilder.resource.v1_0.CategoryResource;
import restbuilder.resource.v1_0.TypeResource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * @author Wesley Roberts
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/cart-input.properties",
	scope = ServiceScope.PROTOTYPE, service = CartInputResource.class
)
public class CartInputResourceImpl extends BaseCartInputResourceImpl {

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'POST' 'http://localhost:8080/o/RestBuilder/v1.0/cart/create' -d $'{"id": ___}' --header 'Content-Type: application/json' -u 'test@liferay.com:test'
	 */
	@Consumes({"application/json", "application/xml"})
	@Override
	@Path("/cart/create")
	@POST
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "CartInput")})
	public CartOutput createCart(CartInput cartInput) throws Exception {
		return _toCartDTO(_saleCartService.createSaleCartById(cartInput.getId()));
	}

	private CartOutput _toCartDTO(SaleCart cart){
		return new CartOutput(){
			{
				id = (int)cart.getCartId();
				totalValue = cart.getTotalPrice();
				productList = _ProductListDTO(cart.getCartId());
			}
		};
	}

	private ProductList _toProductDTO(SaleProduct saleProduct){
		return new ProductList(){
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

	private ProductList[] _ProductListDTO(long cartId){
		List<SaleProduct> list =  _cartProductsListService.getAllProductsByCarID(cartId);
		ProductList[] productListDTO = new ProductList[list.size()];
		for (int i = 0; i <  list.size(); i++) {

			try {
				productListDTO[i]= _toProductDTO(list.get(i));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return productListDTO;
	}

	@Reference
	CategoryResource _categoryResource;
	@Reference
	TypeResource _typeResource;
	@Reference
	CartProductsListService _cartProductsListService;
	@Reference
	SaleCartService _saleCartService;
}