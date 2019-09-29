package org.elsys.reflection;

import java.util.Arrays;

public abstract class AbstractCommand implements Command {

	@Override
	public void execute(String argument) {
		try {
			// <command> org.elsys.Blabla::methodName
			String[] tokenized = argument.split("::");
			Class<?> clazz = Class.forName(tokenized[0]);
			if (tokenized.length > 1) {
				execute(clazz, Arrays.copyOfRange(tokenized, 1, tokenized.length));
			} else {
				execute(clazz);
			}
		} catch (ClassNotFoundException e) {
			System.err.println("Class not found");
		}
	}

	protected abstract void execute(Class<?> className, String... arguments);
	
	@Override
	public String getToken() {
		return getClass().getSimpleName().toLowerCase();
	}
}
