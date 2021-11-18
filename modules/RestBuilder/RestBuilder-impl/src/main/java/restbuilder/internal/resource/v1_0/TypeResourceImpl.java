package restbuilder.internal.resource.v1_0;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

import restbuilder.resource.v1_0.TypeResource;

/**
 * @author Wesley Roberts
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/type.properties",
	scope = ServiceScope.PROTOTYPE, service = TypeResource.class
)
public class TypeResourceImpl extends BaseTypeResourceImpl {
}