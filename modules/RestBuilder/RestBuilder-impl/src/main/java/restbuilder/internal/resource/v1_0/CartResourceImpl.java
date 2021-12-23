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
import restbuilder.dto.v1_0.ProductList;
import restbuilder.resource.v1_0.CartResource;
import restbuilder.resource.v1_0.CategoryResource;
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
	properties = "OSGI-INF/liferay/rest/v1_0/cart.properties",
	scope = ServiceScope.PROTOTYPE, service = CartResource.class
)
public class CartResourceImpl extends BaseCartResourceImpl {
	/**
	 * Invoke this method with the command line:
	 * <p>
	 * curl -X 'GET' 'http://localhost:8080/o/RestBuilder/v1.0/cart/getAll'  -u 'test@liferay.com:test'
	 */
	@GET
	@Override
	@Path("/cart/getAll")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Cart")})
	public Page<Cart> getAllCarts() throws Exception {
		List<Cart> cartListDTO = new ArrayList<Cart>();
		for (SaleCart e: _saleCartService.getAllSaleCart()){
			cartListDTO.add(_toCartDTO(e));
		}
		return Page.of(cartListDTO);
	}

	/**
	 * Invoke this method with the command line:
	 * <p>
	 * curl -X 'GET' 'http://localhost:8080/o/RestBuilder/v1.0/cart/{cartId}'  -u 'test@liferay.com:test'
	 */
	@GET
	@Override
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "cartId")})
	@Path("/cart/{cartId}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Cart")})
	public Cart getCartById(
			@NotNull @Parameter(hidden = true) @PathParam("cartId") Integer
					cartId)
			throws Exception {

		return  _toCartDTO(_saleCartService.getSaleCartById(cartId));
	}

	/**
	 * Invoke this method with the command line:
	 * <p>
	 * curl -X 'GET' 'http://localhost:8080/o/RestBuilder/v1.0/cart/getTotalValue/{cartId}'  -u 'test@liferay.com:test'
	 */
	@GET
	@Override
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "cartId")})
	@Path("/cart/getTotalValue/{cartId}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Cart")})
	public Integer getTotalValueByCartId(
			@NotNull @Parameter(hidden = true) @PathParam("cartId") Integer
					cartId)
			throws Exception {

		return (int)_saleCartService.getSaleCartById(cartId).getTotalPrice();
	}

	/**
	 * Invoke this method with the command line:
	 * <p>
	 * curl -X 'GET' 'http://localhost:8080/o/RestBuilder/v1.0/cart/create'  -u 'test@liferay.com:test'
	 */
	@GET
	@Override
	@Path("/cart/create")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Cart")})
	public Cart createCart() throws Exception {
		SaleCart saleCart = _saleCartService.createSaleCartById();
		return _toCartDTO(saleCart);
	}

	/**
	 * Invoke this method with the command line:
	 * <p>
	 * curl -X 'PATCH' 'http://localhost:8080/o/RestBuilder/v1.0/addProductoCart/{cartID}/productID/{productID}'  -u 'test@liferay.com:test'
	 */
	@Override
	@Parameters(
			value = {
					@Parameter(in = ParameterIn.PATH, name = "cartID"),
					@Parameter(in = ParameterIn.PATH, name = "productID")
			}
	)
	@PATCH
	@Path("/addProductoCart/{cartID}/productID/{productID}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Cart")})
	public Cart addProductToCart(
			@NotNull @Parameter(hidden = true) @PathParam("cartID") Integer
					cartID,
			@NotNull @Parameter(hidden = true) @PathParam("productID") Integer
					productID)
			throws Exception {
		return _toCartDTO(_cartProductsListService.addProductToCartList(productID,cartID));
	}

	/**
	 * Invoke this method with the command line:
	 * <p>
	 * curl -X 'PATCH' 'http://localhost:8080/o/RestBuilder/v1.0/removeProductFromCart/{cartID}/ProductID/{productID}'  -u 'test@liferay.com:test'
	 */
	@Override
	@Parameters(
			value = {
					@Parameter(in = ParameterIn.PATH, name = "cartID"),
					@Parameter(in = ParameterIn.PATH, name = "productID")
			}
	)
	@PATCH
	@Path("/removeProductFromCart/{cartID}/ProductID/{productID}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Cart")})
	public Cart removeProductFromCart(
			@NotNull @Parameter(hidden = true) @PathParam("cartID") Integer
					cartID,
			@NotNull @Parameter(hidden = true) @PathParam("productID") Integer
					productID)
			throws Exception {
		try{
			_cartProductsListService.removeProductToCartList(productID,cartID);
			return _toCartDTO(_saleCartService.getSaleCartById(cartID));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Invoke this method with the command line:
	 * <p>
	 * curl -X 'DELETE' 'http://localhost:8080/o/RestBuilder/v1.0/cart/delete/{cartId}'  -u 'test@liferay.com:test'
	 */
	@DELETE
	@Override
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "cartId")})
	@Path("/cart/delete/{cartId}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Cart")})
	public void deleteCartById(
			@NotNull @Parameter(hidden = true) @PathParam("cartId") Integer
					cartId)
			throws Exception {
		_saleCartService.deleteSaleCartById(cartId);
	}

	private Cart _toCartDTO(SaleCart cart) {
		return new Cart() {
			{
				id = (int) cart.getCartId();
				totalValue = cart.getTotalPrice();
				productList = _ProductListDTO(cart.getCartId());
			}
		};
	}

	private ProductList _toProductDTO(SaleProduct saleProduct) {
		return new ProductList() {
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
				id = (int) saleProduct.getProductId();
				name = saleProduct.getName();
				price = saleProduct.getPrice();
			}
		};
	}

	private ProductList[] _ProductListDTO(long cartId) {
		List<SaleProduct> list = _cartProductsListService.getAllProductsByCarID(cartId);
		ProductList[] productListDTO = new ProductList[list.size()];
		for (int i = 0; i < list.size(); i++) {

			try {
				productListDTO[i] = _toProductDTO(list.get(i));
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
