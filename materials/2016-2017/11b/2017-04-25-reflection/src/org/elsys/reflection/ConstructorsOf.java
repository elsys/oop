package org.elsys.reflection;

import java.lang.reflect.Constructor;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConstructorsOf extends AbstractCommand implements Command {

	@Override
	protected void execute(Class<?> clazz, String argument) {
		String result = Stream.of(clazz.getConstructors())
				.map(Constructor::toString)
				.collect(Collectors.joining(", "));
		System.out.println(result);
	}

}
