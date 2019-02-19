package LC400_16_UnionFind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Gary on 2019-01-22.
 */
public class LC305 {
    private int[] islands;
    private int root(int island) {
        while (islands[island] != island) {
            islands[island] = islands[islands[island]];
            island = islands[island];
        }
        return island;
    }

    // 左右上下 四个方向
    private int[] dx = {0, 0, -1, 1};
    private int[] dy = {-1, 1, 0, 0};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        islands = new int[m * n];
        Arrays.fill(islands, -1);
        int island = 0;
        List<Integer> nums = new ArrayList<>();
        for (int[] position : positions) {
            int x = position[0];
            int y = position[1];
            int id = x * n + y;
            islands[id] = id;
            island++;
            for (int j = 0; j < 4; j++) {
                int newX = x + dx[j];
                int newY = y + dy[j];
                int newId = newX * n + newY;
                if (newX >= 0 && newX < m
                        && newY >= 0 && newY < n
                        && islands[newId] != -1) {
                    int root = root(newId);
                    if (root != id) {
                        islands[root] = id;
                        island--;
                    }
                }
            }
            nums.add(island);
        }
        return nums;
    }
}
