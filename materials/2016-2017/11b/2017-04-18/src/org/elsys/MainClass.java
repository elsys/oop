package org.elsys;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainClass {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Ivan", Gender.MALE, 22),
				new Person("Ivanka", Gender.FEMALE, 34),
				new Person("Jan", Gender.OTHER, 41),
				new Person("John", Gender.MALE, 14),
				new Person("Jorge", Gender.MALE, 84),
				new Person("Jane", Gender.FEMALE, 4),
				new Person("Peter", Gender.OTHER, 66));

		List<Person> youngPeople =
				PersonUtils.filterByAgeLessThan(people, 25);
		System.out.println(youngPeople);
		
		List<Person> youngWomen = PersonUtils
				.filterByAgeLessThanAndGender(youngPeople, 25, Gender.FEMALE);
		System.out.println(youngWomen);
		
		List<Person> elderWomen = PersonUtils.filter(people, new Filter() {
			@Override
			public boolean matches(Person person) {
				return person.getAge() > 25
						&& person.getGender() == Gender.FEMALE;
			}
		});
		System.out.println(elderWomen);
		
		PersonUtils.filter(people, person -> person.getAge() < 25);
		
		Collections.sort(people, (p1, p2) -> p1.getAge() - p2.getAge());
		Collections.sort(people, (p1, p2) -> {
			int delta = p1.getAge() - p2.getAge();
			return delta;
		});
		people.forEach(person -> {
			if (person.getAge() > 65) {
				System.out.printf("%s, 65+\n", person.getNames());
			} else {
				System.out.printf("%s, %d\n", person.getNames(), person.getAge());
			}
		});
		
	}

}






