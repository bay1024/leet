package LC400_18_Design;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.DoubleStream;
/**
 * Created by Gary on 2019-01-20.
 */
class SnakeGame {
    LinkedHashSet<Integer> snake;
    int n;
    int m;
    List<Integer> foods;
    int count;

    /**
     * Initialize your data structure here.
     *
     * @param width  - screen width
     * @param height - screen height
     * @param food   - A list of food positions
     *               E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0].
     */
    public SnakeGame(int width, int height, int[][] food) {
        this.n = height;
        this.m = width;

        this.snake = new LinkedHashSet<>();
        this.snake.add(0);

        this.foods = new ArrayList<>();
        for (int[] foo : food) {
            foods.add(code(foo[0], foo[1]));
        }
        this.count = 0;
    }

    /**
     * Moves the snake.
     *
     * @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     * @return The game's score after the move. Return -1 if game over.
     * Game over when snake crosses the screen boundary or bites its body.
     */
    public int move(String direction) {
        int tail = snake.iterator().next();
        int cur = snake.stream().skip(snake.size() - 1).findFirst().get();
        int x = cur / m;
        int y = cur % m;
        int nx = -1;
        int ny = -1;
        if ("U".equals(direction)) {
            nx = x - 1;
            ny = y;
            if (nx < 0) return -1;
        } else if ("L".equals(direction)) {
            nx = x;
            ny = y - 1;
            if (ny < 0) return -1;
        } else if ("R".equals(direction)) {
            nx = x;
            ny = y + 1;
            if (ny >= m) return -1;
        } else if ("D".equals(direction)) {
            nx = x + 1;
            ny = y;
            if (nx >= n) return -1;
        }
        int pos = code(nx, ny);
        if (foods.size() > 0 && foods.get(count) == pos) {
            if (snake.contains(pos)) return -1;
            snake.add(pos);
            // if foods are infinite
            // count = (count+1) % foods.size();
            count = count + 1;
            if (count == foods.size()) foods.clear();

        } else {
            snake.remove(tail);
            if (snake.contains(pos)) return -1;
            snake.add(pos);
        }
        return snake.size() - 1;
    }

    public int code(int x, int y) {
        return x * m + y;
    }

}

public class LC353 {
    public static void main(String[] args) {
//        LinkedHashSet<String> set = new LinkedHashSet<>();
//        set.add("abc");
//        set.add("def");
//        set.add("aed");
//        set.add("abc");
//        set.stream()
//                .filter(s -> s.startsWith("a"))
//                .map(String::toUpperCase)
//                .sorted()
//                .forEach(System.out::println);

        //IntStream.range(1, 4).forEach(System.out::println);
        double[] numbers = {1.3, 2.0, 3.0, 4.4, 5.5};
        DoubleStream.of(numbers).skip(2).forEach(System.out::println);
    }
}
