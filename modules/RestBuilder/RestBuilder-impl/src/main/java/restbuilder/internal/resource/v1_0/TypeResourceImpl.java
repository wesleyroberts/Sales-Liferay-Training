package restbuilder.internal.resource.v1_0;

import com.liferay.portal.vulcan.pagination.Page;
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
	properties = "OSGI-INF/liferay/rest/v1_0/type.properties",
	scope = ServiceScope.PROTOTYPE, service = TypeResource.class
)
public class TypeResourceImpl extends BaseTypeResourceImpl {
	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'GET' 'http://localhost:8080/o/RestBuilder/v1.0/type/all'  -u 'test@liferay.com:test'
	 */
	@GET
	@Override
	@Path("/type/all")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Type")})
	public Page<Type> getAllTypes() throws Exception {
		List<Type> listTypeDTO = new ArrayList<Type>();
		for(SaleType e: _saleTypeService.getAll()){
			listTypeDTO.add(_toTypeDTO(e));
		}
		return Page.of(listTypeDTO);
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'GET' 'http://localhost:8080/o/RestBuilder/v1.0/type/{typeId}'  -u 'test@liferay.com:test'
	 */
	@GET
	@Override
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "typeId")})
	@Path("/type/{typeId}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Type")})
	public Type getTypeById(
			@NotNull @Parameter(hidden = true) @PathParam("typeId") Integer
					typeId)
			throws Exception {
		SaleType saleType = _saleTypeService.getSaleTypeByID(typeId);
		return new Type();
	}

	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'POST' 'http://localhost:8080/o/RestBuilder/v1.0/type/create' -d $'{"id": ___, "name": ___, "tax": ___}' --header 'Content-Type: application/json' -u 'test@liferay.com:test'
	 */
	@Consumes({"application/json", "application/xml"})
	@Override
	@Path("/type/create")
	@POST
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Type")})
	public Type createType(Type type) throws Exception {
		SaleType saleType = _saleTypeService.
				createSaleType(
						type.getId(),
						type.getName(),
						type.getTax());

		return _toTypeDTO(saleType);
	}
	/**
	 * Invoke this method with the command line:
	 *
	 * curl -X 'DELETE' 'http://localhost:8080/o/RestBuilder/v1.0/type/delete/{typeId}'  -u 'test@liferay.com:test'
	 */
	@DELETE
	@Override
	@Parameters(value = {@Parameter(in = ParameterIn.PATH, name = "typeId")})
	@Path("/type/delete/{typeId}")
	@Produces({"application/json", "application/xml"})
	@Tags(value = {@Tag(name = "Type")})
	public void deleteTypeById(
			@NotNull @Parameter(hidden = true) @PathParam("typeId") Integer
					typeId)
			throws Exception {
		_saleTypeService.deleteTypeById(typeId);
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