import java.util.Random;


public class Point_ {
    static int SIZE = 11;
    public static Random rand = new Random();
    public int _x;
    public int _y;

    Point_() {
        _x = rand.nextInt(SIZE-1) + 1;
        _y = rand.nextInt(SIZE-1) + 1;
    }

    Point_(int x, int y) {
        _x = x;
        _y = y;
    }
}
