import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args){
        List<Person> personList
                = createPersonFromCSV("persons.csv");

        List<String> womenUnder25 =
                personList.stream()
                .sorted((f, s) -> f.getNames().compareTo(s.getNames()))
                .filter(person -> person.getAge() < 25
                        && person.getGender() == Gender.FEMALE)
                .map(person -> person.getNames())
                .collect(Collectors.toList());

        womenUnder25.forEach(name -> System.out.println(name));

        String reducedNames = personList.stream()
                .map(person -> person.getNames())
                .reduce("", (l,r) -> l + ", " + r);
        System.out.printf(reducedNames);

        int ageSum = personList.stream()
                .map(person -> person.getAge())
                .reduce(0, (l, r) -> l + r);
        System.out.println(ageSum);

        Map<String, Gender> namesWithGender = personList.stream()
                .collect(Collectors.toMap(
                        (p -> p.getNames()),
                        (p -> p.getGender()),
                        ((l,r) -> l)
                ));

        namesWithGender.forEach((k,v) -> System.out.println(k + " " + v));

        //personList.forEach(p -> System.out.println(p));
    }

    private static List<Person>
        createPersonFromCSV(String filename){
        List<Person> result = new ArrayList<>();
        Path pathToFile = Paths.get(filename);

        try(BufferedReader br = Files.newBufferedReader(
                pathToFile, StandardCharsets.US_ASCII)){
            String line = br.readLine();
            while (line != null){
                String[] attributes
                        = line
                            .replace(" ", "")
                            .split(",");
                Person person = createPersonFromStringArray(attributes);
                result.add(person);
                line = br.readLine();
            }

        } catch (IOException ex){
            ex.printStackTrace();
        }

        return  result;
    }

    private static Person createPersonFromStringArray(String[] attributes){
        String firstName = attributes[0];
        String lastName = attributes[1];
        int age = Integer.parseInt(attributes[2]);
        Gender gender = attributes[3].equals("m")
                ? Gender.MALE : Gender.FEMALE;

        return new Person(firstName
                        ,lastName
                        ,age
                        ,gender);
    }
}
