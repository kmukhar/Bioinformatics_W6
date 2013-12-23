package com.mukhar;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.princeton.cs.introcs.In;

public class DagPathTest {

    private int source;

    private int sink;

    private ArrayList<int[]> edges;

    private int eLength;

    private String ePath;

    private DagPath dp;

    @Before
    public void setUp() throws Exception {
        dp = new DagPath();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testGetLongestPath() {
        readTestData("src/com/mukhar/dag_path_sample.txt");
        String[] path = new String[1];
        int length = dp.getLongestPath(source, sink, edges, path);
        assertEquals(eLength, length);
        assertEquals(ePath, path[0]);
    }

    @Test
    public void testGetLongestPath02() {
        readQuizData("src/com/mukhar/dataset_74_7.txt");
        
        for (int[] edge : edges)
            assertTrue(edge[0] < edge[1]);
        
        String[] path = new String[1];
        int length = dp.getLongestPath(source, sink, edges, path);
        System.out.println("Length: " + length);
        System.out.println("Path: " + path[0]);
    }

    public void readTestData(String name) {
        In in = new In(name);
        in.readLine(); // ignore "Input"
        source = in.readInt();
        sink = in.readInt();
        in.readLine();
        String s = in.readLine();
        edges = new ArrayList<>();
        while (!s.equals("Output")) {
            s = s.replace("-", "").replace(">", ",").replace(":", ",");
            String[] t = s.split(",");
            int[] e = new int[] { Integer.valueOf(t[0]), Integer.valueOf(t[1]),
                    Integer.valueOf(t[2]) };
            edges.add(e);
            s = in.readLine();
        }
        eLength = in.readInt();
        in.readLine();
        ePath = in.readLine();
    }

    public void readQuizData(String name) {
        In in = new In(name);
        source = in.readInt();
        sink = in.readInt();
        in.readLine();
        String s = in.readLine();
        edges = new ArrayList<>();
        while (s != null) {
            s = s.replace("-", "").replace(">", ",").replace(":", ",");
            String[] t = s.split(",");
            int[] e = new int[] { Integer.valueOf(t[0]), Integer.valueOf(t[1]),
                    Integer.valueOf(t[2]) };
            edges.add(e);
            s = in.readLine();
        }
    }
}
