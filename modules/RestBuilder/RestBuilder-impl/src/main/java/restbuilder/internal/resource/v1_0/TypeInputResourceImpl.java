package restbuilder.internal.resource.v1_0;

import com.liferay.sales.model.SaleType;
import com.liferay.sales.service.SaleTypeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import restbuilder.dto.v1_0.Type;
import restbuilder.dto.v1_0.TypeInput;
import restbuilder.resource.v1_0.TypeInputResource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * @author Wesley Roberts
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/type-input.properties",
	scope = ServiceScope.PROTOTYPE, service = TypeInputResource.class
)
public class TypeInputResourceImpl extends BaseTypeInputResourceImpl {
	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'POST' 'http://localhost:8080/o/RestBuilder/v1.0/type/create' -d $'{"name": ___, "tax": ___}' --header 'Content-Type: application/json' -u 'test@liferay.com:test'
	 */
	@Consumes({"application/json", "application/xml"})
	@Override
	@Path("/type/create")
	@POST
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "TypeInput")})
	public Type createType(TypeInput typeInput) throws Exception {
		SaleType saleType =_saleTypeService.createSaleType(typeInput.getName(),typeInput.getTax());
		return _toTypeDTO(saleType);
	}

	private Type _toTypeDTO(SaleType saleType) {
		return new Type(){
			{
				id = (int)saleType.getTypeId();
				name = saleType.getName();
				tax = saleType.getTax();
			}
		};
	}

	@Reference
	SaleTypeService _saleTypeService;
}