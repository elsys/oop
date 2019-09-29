package org.elsys.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class IsMethodAbstract extends AbstractCommand implements Command {

	@Override
	protected void execute(Class<?> clazz, String argument) {
		for (Method method : clazz.getDeclaredMethods()) {
			if (method.getName().equals(argument)) {
				System.out.println(Modifier.isAbstract(method.getModifiers()));
				return;
			}
		}
		System.out.println("Method not found");
	}

}
