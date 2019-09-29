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

	private void addCommand(Command command) {
		commands.put(command.getToken(), command);
	}

	public void run() {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.print("> ");
			String input = scanner.nextLine();
			String[] tokenizedInput = input.split(" ");
			
			Command command = commands.get(tokenizedInput[0]);
			if (command != null) {
				command.execute(tokenizedInput[1]);
			} else {
				System.out.println("Unknown command");
			}
		}
	}
}








