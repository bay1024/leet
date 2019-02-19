package LC400_15_Graph;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Gary on 2019-01-31.
 */
class Point {
    int x; int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a;y = b; }
}

public class LC149 {
    public int maxPoints(Point[] points) {
        int res = 0;
        for (int i = 0; i < points.length; i++) {
            int duplicate = 1; // 重复个数
            Map<String, Integer> map = new HashMap<>();
            for (int j = i + 1; j < points.length; j++) {
                int dx = points[j].x - points[i].x; // x轴坐标变化增量
                int dy = points[j].y - points[i].y; // y轴坐标变化增量
                // 两点相同， duplicate++ continue
                if (dx == 0 && dy == 0) {
                    duplicate++;
                    continue;
                }
                // 两点不同， 计算最大公约数
                int d = gcd(dx, dy);
                String slope = dx / d + "@" + dy / d; // 斜率表达式，防止出现浮点类型精确问题，用字符串作为key
                map.put(slope, map.getOrDefault(slope, 0) + 1);
            }
            // 更新结果
            res = Math.max(res, duplicate);

            for (Map.Entry<String, Integer> e : map.entrySet()) {
                res = Math.max(res, e.getValue() + duplicate);
            }
        }
        return res;
    }

    // 计算最大公约数
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
