import java.util.Collection;

public class Main {
    public static void main(String[] args) throws NotImplementedException {
        Athlete ath = new Athlete("Pencho", "Penchov");

        ath.foo();
        ath.run(123);
        ath.jump();

        Human human = ath;
//        human.run();
        human.foo();

        Running runner = ath;
        runner = new Cat();
        runner.run(123);
//        runner.foo();

        Collection col; // = null;
    }
}
