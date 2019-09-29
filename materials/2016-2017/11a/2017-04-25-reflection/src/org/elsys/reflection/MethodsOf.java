package org.elsys.reflection;

import java.lang.reflect.Method;
import java.util.Optional;
import java.util.stream.Stream;

public class MethodsOf extends AbstractCommand implements Command {

	@Override
	protected void execute(Class<?> className, String... arguments) {
		Method[] methods = className.getDeclaredMethods();

		Optional<String> optional = Stream.of(methods)
//				.map(method -> method.getName())
				.map(Method::getName)
				.reduce((n1, n2) -> n1 + ", " + n2);

		String methodString = optional
				.orElse("");
		System.out.println(methodString);
	}

}
