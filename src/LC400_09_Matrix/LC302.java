package LC400_09_Matrix;

/**
 * Created by Gary on 2019-02-27.
 */
public class LC302 {
    /**
     * time: O(m * log n + n * log m)   space: O(1)
     * 得出矩形的最小面积
     *
     * @param image 图片像素矩阵
     * @param x     其中一个黑色像素的x坐标
     * @param y     其中一个黑色像素的y坐标
     * @return
     */
    public int minArea(char[][] image, int x, int y) {
        int row = image.length;
        int col = image[0].length;
        // 最左边的位置
        int left = binarySearchLeft(image, 0, y, true);
        // 最右边的位置
        int right = binarySearchRight(image, y, col - 1, true);
        // 最上边的位置
        int top = binarySearchLeft(image, 0, x, false);
        // 最下边的位置
        int bottom = binarySearchRight(image, x, row - 1, false);
        // 矩形面积
        return (right - left + 1) * (bottom - top + 1);
    }

    /**
     * 找最右边
     *
     * @param image
     * @param left
     * @param right
     * @param isHo  true横着找，false竖着找
     * @return
     */
    private int binarySearchRight(char[][] image, int left, int right, boolean isHo) {
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (hasBlack(image, mid, isHo)) left = mid;
            else right = mid;
        }
        if (hasBlack(image, right, isHo)) return right;
        return left;
    }

    /**
     * 找最左边
     *
     * @param image
     * @param left
     * @param right
     * @param isHo  true横着找，false竖着找
     * @return
     */
    private int binarySearchLeft(char[][] image, int left, int right, boolean isHo) {
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;
            if (hasBlack(image, mid, isHo)) right = mid;
            else left = mid;
        }
        if (hasBlack(image, left, isHo)) return left;
        return right;
    }

    /**
     * 是否有黑色像素
     *
     * @param image
     * @param x
     * @param isHo  true横着找，false竖着找
     * @return
     */
    private boolean hasBlack(char[][] image, int x, boolean isHo) {
        if (isHo) {
            for (int i = 0; i < image.length; i++) {
                if (image[i][x] == '1') return true;
            }
        } else {
            for (int i = 0; i < image[0].length; i++) {
                if (image[x][i] == '1') return true;
            }
        }
        return false;
    }
}
