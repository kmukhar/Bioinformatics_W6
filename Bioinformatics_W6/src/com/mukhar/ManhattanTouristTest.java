package com.mukhar;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.princeton.cs.introcs.In;

public class ManhattanTouristTest {

    private int n;

    private int m;

    private int[][] down;

    private int[][] right;

    private int expected;

    private ManhattanTourist mt;

    @Before
    public void setUp() throws Exception {
        mt = new ManhattanTourist();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testFindLongestPath01() {
        readTestData("src/com/mukhar/tourist_sample.txt");
        assertEquals(expected, mt.findLongestPath(n + 1, m + 1, down, right));
    }

    @Test
    public void testFindLongestPath02() {
        readQuizData("src/com/mukhar/dataset_72_9.txt");
        System.out.println(mt.findLongestPath(n + 1, m + 1, down, right));
    }

    public void readTestData(String name) {
        In in = new In(name);
        in.readLine(); // ignore "Input"
        n = in.readInt();
        m = in.readInt();
        down = new int[n + 1][m + 2];
        for (int i = 1; i < n + 1; i++)
            for (int j = 1; j < m + 2; j++)
                down[i][j] = in.readInt();

        in.readLine(); // finish consuming line
        in.readLine(); // ignore "-" char

        right = new int[n + 2][m + 1];
        for (int i = 1; i < n + 2; i++)
            for (int j = 1; j < m + 1; j++)
                right[i][j] = in.readInt();

        in.readLine(); // finish consuming line
        in.readLine(); // ignore "Output"
        expected = in.readInt();
        in.close();
    }

    public void readQuizData(String name) {
        In in = new In(name);
        n = in.readInt();
        m = in.readInt();
        down = new int[n + 1][m + 2];
        for (int i = 1; i < n + 1; i++)
            for (int j = 1; j < m + 2; j++)
                down[i][j] = in.readInt();

        in.readLine(); // finish consuming line
        in.readLine(); // ignore "-" char

        right = new int[n + 2][m + 1];
        for (int i = 1; i < n + 2; i++)
            for (int j = 1; j < m + 1; j++)
                right[i][j] = in.readInt();

        in.readLine(); // finish consuming line
        in.close();
    }
}
