package restbuilder.internal.resource.v1_0;

import com.liferay.sales.model.SaleType;
import com.liferay.sales.service.SaleTypeService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ServiceScope;

import restbuilder.dto.v1_0.Type;
import restbuilder.dto.v1_0.TypeInput;
import restbuilder.resource.v1_0.TypeInputResource;

import javax.validation.constraints.NotNull;
import javax.ws.rs.*;

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

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'PUT' 'http://localhost:8080/o/RestBuilder/v1.0/type/update/{typeId}' -d $'{"name": ___, "tax": ___}' --header 'Content-Type: application/json' -u 'test@liferay.com:test'
	 */
	@Consumes({"application/json", "application/xml"})
	@Override
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "typeId")})
	@Path("/type/update/{typeId}")
	@Produces({"application/json", "application/xml"})
	@PUT
	@Tags(value = {@Tag(name = "TypeInput")})
	public Type updateTypeById(
			@NotNull @Parameter(hidden = true) @PathParam("typeId") Integer
					typeId,
			TypeInput typeInput)
			throws Exception {
		SaleType saleType = _saleTypeService.updateSaleType(typeId.longValue(),typeInput.getName(),typeInput.getTax());
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