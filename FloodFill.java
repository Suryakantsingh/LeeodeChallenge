package leetCodeChallenge.may;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FloodFill {
    int color = 0;
    int paint = 0;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        color = image[sr][sc];
        paint = newColor;
        boolean[][] traverse = new boolean[image.length][image[0].length];
        return flood(image, sr, sc,traverse);
    }

    public int[][] flood(int[][] image, int sr, int sc, boolean[][] traverse) {
        if (sr < 0 || sr > image.length - 1 || sc < 0 || sc > image[0].length - 1 ) {
            return null;
        }
        if(traverse[sr][sc]){
            return null;
        }
        if ((sr >= 0 && sr < image.length) && (sc >= 0 && sc < image[0].length)) {
            if(image[sr][sc] == color) {
                image[sr][sc] = paint;
                traverse[sr][sc] = true;
            }else{
                return null;
            }
        }

        flood(image, sr - 1, sc,traverse);
        flood(image, sr, sc - 1,traverse);
        flood(image, sr, sc + 1,traverse);
        flood(image, sr + 1, sc,traverse);

        return image;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        FloodFill flood = new FloodFill();
        System.out.println(flood.floodFill(arr, 1, 1, 2));
    }
}
