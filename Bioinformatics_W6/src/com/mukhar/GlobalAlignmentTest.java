package com.mukhar;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.sun.org.apache.bcel.internal.generic.NEWARRAY;

import edu.princeton.cs.introcs.In;

public class GlobalAlignmentTest {

    private String v;

    private String w;

    private int expScore;

    private String align1;

    private String align2;

    private GlobalAlignment ga;

    @Before
    public void setUp() throws Exception {
        ga = new GlobalAlignment();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testComputeAlignment01() {
        readTestData("src/com/mukhar/global_sample.txt");
        ArrayList<String> output = new ArrayList<>();
        assertEquals(expScore, ga.computeAlignment(v, w, output));
//        assertEquals(align1, output.get(0));
//        assertEquals(align2, output.get(1));
    }

    public void readTestData(String name) {
        In in = new In(name);
        v = in.readLine();
        w = in.readLine();
        expScore = Integer.parseInt(in.readLine());
        align1 = in.readLine();
        align2 = in.readLine();
        in.close();
    }

    public void readQuizData(String name) {
        In in = new In(name);
        v = in.readLine();
        w = in.readLine();
        in.close();
    }
}
