import java.util.ArrayList;
import java.util.List;

class Racer extends Human implements Racetime {
  public int speed;

  public Racer(String name, int speed) {
    super(name);
    this.speed = speed;
  }

  public void sayHello() {
    System.out.println("Hello, my name is " + name + " and I'm a racer");
  }

  public void addLapTime(int time) {
    System.out.println("Adding lap time: " + time);
  }

  public List<Integer> getAllTimes() {
    return new ArrayList<Integer>();
  }
}