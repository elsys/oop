package org.elsys;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
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
		people.forEach(person -> person.setFriends(people));
		
		// 1. Filter out OTHER
		// 2. Sort by age
		// 3. Return list of names
		List<Person> womenAndMen = new ArrayList<>();
		for (Person person : people) {
			if (person.getGender() != Gender.OTHER) {
				womenAndMen.add(person);
			}
		}
		womenAndMen.sort((p1, p2) -> p1.getAge() - p2.getAge());
		List<String> result = new ArrayList<>();
		for (Person person : people) {
			result.add(person.getNames());
		}
		System.out.println(result);
		
		List<String> names = people.stream()
				.filter(person -> person.getGender() != Gender.OTHER)
				.sorted((p1, p2) -> p1.getAge() - p2.getAge())
				.map(person -> person.getNames())
				.collect(Collectors.toList());
		
		String friends = people.stream()
				.flatMap(person -> person.getFriends().stream())
				.map(person -> person.getNames())
				.distinct()
				.reduce("", (left, right) -> left + ", " + right);
		System.out.println(friends);
		
		Set<Person> setOfPerson = people.stream()
				.collect(Collectors.toSet());
		people.stream()
				.collect(Collectors.toCollection(() -> new LinkedList<>()));
	}

}








