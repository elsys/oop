package org.elsys.reflection;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Interpreter {

	private Map<String, Command> commands = new HashMap<>();
	
	public static void main(String[] args) {
		Interpreter interpreter = new Interpreter();
		interpreter.addCommand(new ClassExists());
		interpreter.addCommand(new MethodsOf());
		interpreter.addCommand(new ConstructorsOf());
		interpreter.addCommand(new IsMethodAbstract());
		interpreter.run();
	}

	public void addCommand(Command command) {
		commands.put(command.getToken(), command);
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("> ");
			String input = scanner.nextLine();
			// <command> <argument>
			String[] splittedInput = input.split(" ");
			Command command = commands.get(splittedInput[0]);
			if (command != null) {
				command.execute(splittedInput[1]);
			} else {
				System.err.println("Unknown command");
			}
		}
	}

	
}
