package restbuilder.client.function;

import javax.annotation.Generated;

/**
 * @author Wesley Roberts
 * @generated
 */
@FunctionalInterface
@Generated("")
public interface UnsafeSupplier<T, E extends Throwable> {

	public T get() throws E;

}