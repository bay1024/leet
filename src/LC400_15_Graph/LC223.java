package LC400_15_Graph;

/**
 * Created by Gary on 2019-01-31.
 */
public class LC223 {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int width = Math.min(C, G) - Math.max(A, E);
        int height = Math.min(D, H) - Math.max(B, F);
        int a = Math.abs(C - A) * Math.abs(D - B) + Math.abs(G - E) * Math.abs(H - F);
        if (C <= E || A >= G || B >= H || F >= D) {
            return a;
        }
        return a - Math.abs(width * height);
    }
}
