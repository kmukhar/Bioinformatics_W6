package com.mukhar;

import java.util.ArrayList;

public class GlobalAlignment {
    static int bLength = Blosum62.values().length;

    int penalty = 5;

    static int[][] blosum = new int[][] {
            { 4, 0, -2, -1, -2, 0, -2, -1, -1, -1, -1, -2, -1, -1, -1, 1, 0, 0, -3, -2 },
            { 0, 9, -3, -4, -2, -3, -3, -1, -3, -1, -1, -3, -3, -3, -3, -1, -1, -1, -2, -2 },
            { -2, -3, 6, 2, -3, -1, -1, -3, -1, -4, -3, 1, -1, 0, -2, 0, -1, -3, -4, -3 },
            { -1, -4, 2, 5, -3, -2, 0, -3, 1, -3, -2, 0, -1, 2, 0, 0, -1, -2, -3, -2 },
            { -2, -2, -3, -3, 6, -3, -1, 0, -3, 0, 0, -3, -4, -3, -3, -2, -2, -1, 1, 3 },
            { 0, -3, -1, -2, -3, 6, -2, -4, -2, -4, -3, 0, -2, -2, -2, 0, -2, -3, -2, -3 },
            { -2, -3, -1, 0, -1, -2, 8, -3, -1, -3, -2, 1, -2, 0, 0, -1, -2, -3, -2, 2 },
            { -1, -1, -3, -3, 0, -4, -3, 4, -3, 2, 1, -3, -3, -3, -3, -2, -1, 3, -3, -1 },
            { -1, -3, -1, 1, -3, -2, -1, -3, 5, -2, -1, 0, -1, 1, 2, 0, -1, -2, -3, -2 },
            { -1, -1, -4, -3, 0, -4, -3, 2, -2, 4, 2, -3, -3, -2, -2, -2, -1, 1, -2, -1 },
            { -1, -1, -3, -2, 0, -3, -2, 1, -1, 2, 5, -2, -2, 0, -1, -1, -1, 1, -1, -1 },
            { -2, -3, 1, 0, -3, 0, 1, -3, 0, -3, -2, 6, -2, 0, 0, 1, 0, -3, -4, -2 },
            { -1, -3, -1, -1, -4, -2, -2, -3, -1, -3, -2, -2, 7, -1, -2, -1, -1, -2, -4, -3 },
            { -1, -3, 0, 2, -3, -2, 0, -3, 1, -2, 0, 0, -1, 5, 1, 0, -1, -2, -2, -1 },
            { -1, -3, -2, 0, -3, -2, 0, -3, 2, -2, -1, 0, -2, 1, 5, -1, -1, -3, -3, -2 },
            { 1, -1, 0, 0, -2, 0, -1, -2, 0, -2, -1, 1, -1, 0, -1, 4, 1, -2, -3, -2 },
            { 0, -1, -1, -1, -2, -2, -2, -1, -1, -1, -1, 0, -1, -1, -1, 1, 5, 0, -2, -2 },
            { 0, -1, -3, -2, -1, -3, -3, 3, -2, 1, 1, -3, -2, -2, -3, -2, 0, 4, -3, -1 },
            { -3, -2, -4, -3, 1, -2, -2, -3, -3, -2, -1, -4, -4, -2, -3, -3, -2, -3, 11, 2 },
            { -2, -2, -3, -2, 3, -3, 2, -1, -2, -1, -1, -2, -3, -1, -2, -2, -2, -1, 2, 7 } };

    public int computeAlignment(String v, String w, ArrayList<String> alignment) {
        int[][] score = new int[v.length()][w.length()];
        Pointer[][] backtrack = new Pointer[v.length()][w.length()];

        for (int i = 1; i < v.length(); i++) {
            String vi = v.substring(i - 1, i);
            Blosum62 vIdx = Blosum62.valueOf(vi);
            for (int j = 1; j < w.length(); j++) {
                String wj = w.substring(j - 1, j);
                Blosum62 wIdx = Blosum62.valueOf(wj);
                int sDown = score[i - 1][j] - penalty;
                int sRight = score[i][j - 1] - penalty;
                int sDiag = score[i - 1][j - 1] + blosum[vIdx.ordinal()][wIdx.ordinal()];

                if (sDown >= sRight) {
                    score[i][j] = sDown;
                    backtrack[i][j] = Pointer.DOWN;
                } else {
                    score[i][j] = sRight;
                    backtrack[i][j] = Pointer.RIGHT;
                }

                if (sDiag > score[i][j]) {
                    score[i][j] = sDiag;
                    backtrack[i][j] = Pointer.DIAG;
                }
            }
        }

        outputLCS(backtrack, v, v.length() - 1, w.length() - 1);
        return score[v.length() - 1][w.length() - 1];
    }

    public void outputLCS(Pointer[][] backtrack, String v, int i, int j) {
        if (i == 0 || j == 0)
            return;
        if (backtrack[i][j] == Pointer.DOWN) {
            outputLCS(backtrack, v, i - 1, j);
            System.out.print(v.substring(i, i + 1));
        } else if (backtrack[i][j] == Pointer.RIGHT) {
            outputLCS(backtrack, v, i, j - 1);
            System.out.print("-");
        } else {
            outputLCS(backtrack, v, i - 1, j - 1);
            System.out.print(v.substring(i, i + 1));
        }
    }
}
