package org.elsys.reflection;

public class ClassExists implements Command {

	@Override
	public void execute(String argument) {
		try {
			Class.forName(argument);
			System.out.println(true);
		} catch (ClassNotFoundException e) {
			System.out.println(false);
		}
	}

	@Override
	public String getToken() {
		return "existsclass";
	}

}
