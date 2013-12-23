package com.mukhar;

public class ManhattanTourist {
    public int findLongestPath(int n, int m, int[][] down, int[][] right) {
        int[][] path = new int[n + 1][m + 1];
        for (int i = 1; i < path.length; i++)
            for (int j = 1; j < path[i].length; j++) {
                // right then down
                int path1 = path[i - 1][j] + down[i - 1][j];
                // down then right
                int path2 = path[i][j - 1] + right[i][j - 1];
                path[i][j] = Math.max(path1, path2);
            }
        return path[n][m];
    }
}
