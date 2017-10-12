/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.vulcan.function;

import java.util.Objects;
import java.util.function.Function;

/**
 * Defines a {@code java.util.function.Function} that takes five input
 * parameters. This interface, like all function interfaces, receives several
 * arguments and returns one value of type {@code R}.
 *
 * <p>
 * This interface can be implemented with a lambda function.
 * </p>
 *
 * @author Alejandro Hernández
 * @author Jorge Ferrer
 */
@FunctionalInterface
public interface PentaFunction<A, B, C, D, E, R> {

	/**
	 * Returns the {@code PentaFunction} that first executes the current
	 * {@code PentaFunction} instance's {@code apply} method, then uses the
	 * result as input for the {@code afterFunction} parameter's {@code apply}
	 * method.
	 *
	 * @param  afterFunction the {@code PentaFunction} to execute after the
	 *         current instance
	 * @return the {@code PentaFunction} that executes the current instance's
 	 *         {@code apply} method, then uses the result as input for the
	 *         {@code afterFunction} parameter's {@code apply} method
	 */
	public default <V> PentaFunction<A, B, C, D, E, V> andThen(
		Function<? super R, ? extends V> afterFunction) {

		Objects.requireNonNull(afterFunction);

		return (A a, B b, C c, D d, E e) -> afterFunction.apply(
			apply(a, b, c, d, e));
	}

	/**
	 * Applies the current {@code PentaFunction} and returns a value of type
	 * {@code R}. This function can be implemented explicitly or with a lambda.
	 *
	 * @param  a the function's first argument
	 * @param  b the function's second argument
	 * @param  c the function's third argument
	 * @param  d the function's fourth argument
	 * @param  e the function's fifth argument
	 * @return the function's result, as a value of type {@code R}
	 */
	public R apply(A a, B b, C c, D d, E e);

}