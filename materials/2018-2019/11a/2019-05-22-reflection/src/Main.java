import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        // getContent();

        System.out.println(serialize(new Value(3)));
    }

    public static void getContent(){
        Value val = new Value(3);

        Class<? extends Value> valClass = val.getClass();

        System.out.println(valClass.getSuperclass().getName());

        Arrays.stream(valClass.getInterfaces()).forEach(i -> System.out.println(i.getName()));

        Arrays.stream(valClass.getConstructors()).forEach(c -> {
            System.out.print(c.getName() + "(");
            List<String> collect = Arrays.stream(c.getParameters()).map(p -> p.getType().getName()).collect(Collectors.toList());
            System.out.print(String.join(",", collect));
            System.out.println(")");
        });

        Arrays.stream(valClass.getDeclaredFields()).forEach(field ->
                System.out.println(String.format("%s %s %s", Modifier.toString(field.getModifiers()), field.getType().getName(), field.getName()))
        );

        Arrays.stream(valClass.getDeclaredMethods()).forEach(method ->
                System.out.println(String.format("%s %s %s", Modifier.toString(method.getModifiers()), method.getReturnType().getName(), method.getName()))
        );
    }

    public static String serialize(Object object) {

        Class<?> objectClass = object.getClass();
        StringBuilder output = new StringBuilder();
        output.append(objectClass.getName() + "\n");

        Arrays.stream(objectClass.getDeclaredFields()).forEach(f -> {
            f.setAccessible(true);
            try {
                output.append(f.getName() + " = " + f.get(object) + "\n");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });

        output.append("/" + objectClass.getName() + "\n");

        return output.toString();
    }
}
