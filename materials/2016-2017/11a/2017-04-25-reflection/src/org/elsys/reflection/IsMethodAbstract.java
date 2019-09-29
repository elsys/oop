package org.elsys.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class IsMethodAbstract extends AbstractCommand implements Command {

	@Override
	protected void execute(Class<?> className, String... arguments) {
		for (Method method : className.getDeclaredMethods()) {
			if (method.getName().equals(arguments[0])) {
				System.out.println(Modifier.isAbstract(method.getModifiers()));
				return;
			}
		}
		System.out.println("Method not found");
	}


}
