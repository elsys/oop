package org.elsys;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExamples {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Ivan", Gender.MALE, 22),
				new Person("Ivanka", Gender.FEMALE, 34),
				new Person("Jan", Gender.OTHER, 41),
				new Person("John", Gender.MALE, 14),
				new Person("Jorge", Gender.MALE, 84),
				new Person("Jane", Gender.FEMALE, 4),
				new Person("Peter", Gender.OTHER, 66));
		
		// 1. Filter younger than 25
		// 2. Sort by age
		// 3. Return list of the names
		List<Person> youngerThan25 = new ArrayList<>();
		for (Person person : people) {
			if (person.getAge() < 25) {
				youngerThan25.add(person);
			}
		}
		youngerThan25.sort((p1, p2) -> p1.getAge() - p2.getAge());
		List<String> names = new ArrayList<>();
		for (Person person : youngerThan25) {
			names.add(person.getNames());
		}
		System.out.println(names);
		
		List<String> youngPeopleNames = people.stream()
				.filter(person -> person.getAge() < 25)
				.sorted((p1, p2) -> p1.getAge() - p2.getAge())
				.map(person -> person.getNames())
				.collect(Collectors.toList());
	}

}







