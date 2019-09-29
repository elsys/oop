package org.elsys.reflection;

public abstract class AbstractCommand implements Command {

	@Override
	public void execute(String argument) {
		try {
			String[] tokenized = argument.split("::");
			Class<?> clazz = Class.forName(tokenized[0]);
			if (tokenized.length == 1) {
				execute(clazz, null);
			} else {
				execute(clazz, tokenized[1]);
			}
		} catch (ClassNotFoundException e) {
			System.err.println("Class not found");
		}
	}

	protected abstract void execute(Class<?> clazz, String argument);

	@Override
	public String getToken() {
		return getClass().getSimpleName().toLowerCase();
	}

}
