package org.elsys;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PersonUtils {

	public static List<Person> filterByAgeLessThan(
			List<Person> people, int age) {
		List<Person> result = new ArrayList<>();
		for (Person person : people) {
			if (person.getAge() < age) {
				result.add(person);
			}
		}
		return result;
	}
	
	public static List<Person> filterByAgeLessThanAndGender(
			List<Person> people, int age, Gender gender) {
		List<Person> result = new ArrayList<>();
		for (Person person : people) {
			if (person.getAge() < age && person.getGender() == gender) {
				result.add(person);
			}
		}
		return result;
	}
	
//	public static List<Person> filter(List<Person> people, Predicate<Person> filter) {
	public static List<Person> filter(List<Person> people, Filter filter) {
		List<Person> result = new ArrayList<>();
		for (Person person : people) {
			if (filter.matches(person)) {
				result.add(person);
			}
		}
		return result;
	}
	
}
