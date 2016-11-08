package donuttycoon;

public class Main {
    public static void main(String[] args) {
        new Db();
        new DonutController(new DonutService());
    }
}
