package org.elsys.reflection;

public interface Command {

	void execute(String argument);

	String getToken();
}
