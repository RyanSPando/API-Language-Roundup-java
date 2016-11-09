package donuttycoon;
import donuttycoon.DonutController;
import donuttycoon.DonutService;

public class Main {
    public static void main(String[] args) {

        new DonutController(new DonutService());
    }
}
