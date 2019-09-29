package org.elsys.reflection;

import java.lang.reflect.Method;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MethodsOf extends AbstractCommand implements Command {

	@Override
	protected void execute(Class<?> clazz, String argument) {
		Method[] declaredMethods = clazz.getDeclaredMethods();
		
		String result = Stream.of(declaredMethods)
//				.map(method -> method.getName())
				.map(Method::getName)
				.collect(Collectors.joining(", "));

		System.out.println(result);
	}
}
