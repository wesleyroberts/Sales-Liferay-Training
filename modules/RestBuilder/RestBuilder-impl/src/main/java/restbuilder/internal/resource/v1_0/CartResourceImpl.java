package restbuilder.internal.resource.v1_0;

import com.liferay.portal.vulcan.pagination.Page;
import com.liferay.sales.model.SaleCart;
import com.liferay.sales.model.SaleProduct;
import com.liferay.sales.service.CartProductsListService;
import com.liferay.sales.service.SaleCartService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import restbuilder.dto.v1_0.Cart;
import restbuilder.dto.v1_0.Product;
import restbuilder.dto.v1_0.ProductList;
import restbuilder.resource.v1_0.CartResource;
import restbuilder.resource.v1_0.CategoryResource;
import restbuilder.resource.v1_0.ProductResource;
import restbuilder.resource.v1_0.TypeResource;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import java.util.Collections;
import java.util.List;

/**
 * @author Wesley Roberts
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/cart.properties",
	scope = ServiceScope.PROTOTYPE, service = CartResource.class
)
public class CartResourceImpl extends BaseCartResourceImpl {
	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'GET' 'http://localhost:8080/o/RestBuilder/v1.0/cart/getAll'  -u 'test@liferay.com:test'
	 */
	@GET
	@Override
	@Path("/cart/getAll")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Cart")})
	public Page<Cart> getCartsGetAllPage() throws Exception {
		return Page.of(Collections.emptyList());
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'GET' 'http://localhost:8080/o/RestBuilder/v1.0/cart/{cartId}'  -u 'test@liferay.com:test'
	 */
	@GET
	@Override
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "cartId")})
	@Path("/cart/{cartId}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Cart")})
	public Cart getCart(
			@NotNull @Parameter(hidden = true) @PathParam("cartId") Integer
					cartId)
			throws Exception {

		return  _toCartDTO(_saleCartService.getSaleCartById(cartId));

	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'POST' 'http://localhost:8080/o/RestBuilder/v1.0cart/addProduct/carts/{cartId}/products/{productId}'  -u 'test@liferay.com:test'
	 */
	@Override
	@Parameters(
			value = {
					@Parameter(in = ParameterIn.PATH, name = "cartId"),
					@Parameter(in = ParameterIn.PATH, name = "productId")
			}
	)
	@Path("cart/addProduct/carts/{cartId}/products/{productId}")
	@POST
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Cart")})
	public Cart postCartAddProductCartProduct(
			@NotNull @Parameter(hidden = true) @PathParam("cartId") Integer
					cartId,
			@NotNull @Parameter(hidden = true) @PathParam("productId") Integer
					productId)
			throws Exception {
		_cartProductsListService.addProductToCartList(productId,cartId);
		return _toCartDTO(_saleCartService.getSaleCartById(cartId));
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'POST' 'http://localhost:8080/o/RestBuilder/v1.0/removeProduct/carts/{cartId}/products/{productId}'  -u 'test@liferay.com:test'
	 */
	@Override
	@Parameters(
			value = {
					@Parameter(in = ParameterIn.PATH, name = "cartId"),
					@Parameter(in = ParameterIn.PATH, name = "productId")
			}
	)
	@Path("/removeProduct/carts/{cartId}/products/{productId}")
	@POST
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Cart")})
	public void postRemoveProductCartProduct(
			@NotNull @Parameter(hidden = true) @PathParam("cartId") Integer
					cartId,
			@NotNull @Parameter(hidden = true) @PathParam("productId") Integer
					productId)
			throws Exception {
		_cartProductsListService.removeProductToCartList(productId,cartId);
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'DELETE' 'http://localhost:8080/o/RestBuilder/v1.0/cart/delete/{cartId}'  -u 'test@liferay.com:test'
	 */
	@DELETE
	@Override
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "cartId")})
	@Path("/cart/delete/{cartId}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Cart")})
	public void deleteCartDeleteCart(
			@NotNull @Parameter(hidden = true) @PathParam("cartId") Integer
					cartId)
			throws Exception {

		_saleCartService.deleteSaleCartById(cartId);
	}

	private Cart _toCartDTO(SaleCart cart) throws Exception {
		return new Cart(){
			{
				id = (int)cart.getCartId();
				totalValue = cart.getTotalPrice();
				productList = _ProductListDTO(cart.getCartId());
			}
		};
	}

	private ProductList _toProductDTO(SaleProduct saleProduct) throws Exception {
		return new ProductList(){
			{	category = _categoryResource.getCategory((int) saleProduct.getCategoryId());
				type = _typeResource.getType((int) saleProduct.getTypeId());
				id = (int)saleProduct.getProductId();
				name = saleProduct.getName();
				price = saleProduct.getPrice();
			}
		};
	}

	private ProductList[] _ProductListDTO(long cartId) throws Exception {
		ProductList[] productListsDTO = new ProductList[0];
		List<SaleProduct> list =  _cartProductsListService.getAllProductsByCarID(cartId);
		for (int i = 0; i <  list.size(); i++) {
			productListsDTO[i]= _toProductDTO(list.get(i));
		}
		return productListsDTO;
	}

	@Reference
	CategoryResource _categoryResource;
	@Reference
	TypeResource _typeResource;
	@Reference
	CartProductsListService _cartProductsListService;
	@Reference
	SaleCartService _saleCartService;
	@Reference
	ProductResource _productResource;

}