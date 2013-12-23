package com.mukhar;

public class Sequencer {
    public int findLCS(String v, String w, Pointer[][] backtrack) {
        int[][] s = new int[v.length()][w.length()];
        for (int i = 0; i < v.length(); i++)
            s[i][0] = 0;
        for (int j = 0; j < w.length(); j++)
            s[0][j] = 0;
        for (int i = 1; i < v.length(); i++)
            for (int j = 1; j < w.length(); j++) {
                if (v.substring(i, i + 1).equals(w.substring(j, j + 1)))
                    s[i][j] = s[i - 1][j - 1] + 1;
                else
                    s[i][j] = Math.max(s[i - 1][j], s[i][j - 1]);

                if (s[i][j] == s[i - 1][j])
                    backtrack[i][j] = Pointer.DOWN;
                else if (s[i][j] == s[i][j - 1])
                    backtrack[i][j] = Pointer.RIGHT;
                else
                    // if (s[i][j] == s[i - 1][j - 1] + 1)
                    backtrack[i][j] = Pointer.DIAG;
            }
        return s[v.length() - 1][w.length() - 1];
    }

    public void outputLCS(Pointer[][] backtrack, String v, int i, int j) {
        if (i == 0 || j == 0)
            return;
        if (backtrack[i][j] == Pointer.DOWN)
            outputLCS(backtrack, v, i - 1, j);
        else if (backtrack[i][j] == Pointer.RIGHT)
            outputLCS(backtrack, v, i, j - 1);
        else {
            outputLCS(backtrack, v, i - 1, j - 1);
            System.out.print(v.substring(i, i + 1));
        }
    }

    public static String lcs(String a, String b) {
        int[][] lengths = new int[a.length() + 1][b.length() + 1];

        // row 0 and column 0 are initialized to 0 already

        for (int i = 0; i < a.length(); i++)
            for (int j = 0; j < b.length(); j++)
                if (a.charAt(i) == b.charAt(j))
                    lengths[i + 1][j + 1] = lengths[i][j] + 1;
                else
                    lengths[i + 1][j + 1] = Math.max(lengths[i + 1][j], lengths[i][j + 1]);

        // read the substring out from the matrix
        StringBuffer sb = new StringBuffer();
        for (int x = a.length(), y = b.length(); x != 0 && y != 0;) {
            if (lengths[x][y] == lengths[x - 1][y])
                x--;
            else if (lengths[x][y] == lengths[x][y - 1])
                y--;
            else {
                assert a.charAt(x - 1) == b.charAt(y - 1);
                sb.append(a.charAt(x - 1));
                x--;
                y--;
            }
        }

        return sb.reverse().toString();
    }
}
