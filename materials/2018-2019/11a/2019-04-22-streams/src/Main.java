import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args){
        List<Person> personList = createPersonListFromCSV("persons.csv");

        System.out.println("---------------------------");

        List<String> namesUnder36
                = personList.stream()
                .filter(person -> person.getAge() <= 35
                        && person.getGender() == Gender.FEMALE)
                .map(person -> person.getFirstName()
                        + person.getLastName())
                .sorted((f,s) -> f.compareTo(s))
                .collect(Collectors.toList());
        namesUnder36.forEach(p -> System.out.println(p));

        String reducedNamesUnder36 = personList.stream()
                .filter(person -> person.getAge() <= 35
                        && person.getGender() == Gender.FEMALE)
                .map(person -> person.getFirstName()
                        + person.getLastName())
                .sorted((f,s) -> f.compareTo(s))
                .reduce("", (l,r) -> l + " " + r);
        System.out.println(reducedNamesUnder36);

        Map<String, Gender> namesWithGender =
                        personList.stream()
                .collect(Collectors.toMap(
                        (p-> p.getFirstName())
                        ,(p-> p.getGender())
                        ,(l, r) -> l));
        namesWithGender.forEach((k,v) -> System.out.printf(k));

        personList.forEach(p-> System.out.println(p));
    }

    private static List<Person> createPersonListFromCSV(String filename){
        List<Person> result = new ArrayList<>();
        Path pathToFile = Paths.get(filename);

        try(BufferedReader br = Files.newBufferedReader(
                pathToFile
                , StandardCharsets.US_ASCII)){
            String line = br.readLine();
            while(line != null){
                    String[] attributes = line
                            .replace(" ", "")
                            .split(",");
                    Person person = createPerson(attributes);
                    result.add(person);
                    line = br.readLine();
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        return result;
    }

    private static Person createPerson(String[] attributes){
        String firstName = attributes[0];
        String lastName = attributes[1];
        int age = Integer.parseInt(attributes[2]);
        Gender gender = attributes[3].equals("m")
                ? Gender.MALE : Gender.FEMALE;

        return new Person(firstName, lastName, age, gender);
    }
}
