package org.elsys.reflection;

import java.lang.reflect.Constructor;
import java.util.stream.Stream;

public class ConstructorsOf extends AbstractCommand implements Command {

	@Override
	protected void execute(Class<?> className, String... arguments) {
		Constructor<?>[] constructors = className.getConstructors();

		System.out.println(Stream.of(constructors)
//				.map(method -> method.getName())
				.map(Constructor::toString)
				.reduce((n1, n2) -> n1 + ", " + n2)
				.orElse(""));
	}

}
