package com.mukhar;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.princeton.cs.introcs.In;

public class SequencerTest {

    private String v;

    private String w;

    private String expected;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testFindLCS01() {
        readTestData("src/com/mukhar/lcs_sample.txt");
        assertEquals("AACCTTGG", v);
        assertEquals("ACACTGTGA", w);
        assertEquals("AACTGG", expected);
        Pointer[][] backtrack = new Pointer[v.length()][w.length()];
        Sequencer s = new Sequencer();
        // s.findLCS(v, w, backtrack);
        // s.outputLCS(backtrack, v, v.length() - 1, w.length() - 1);
        System.out.println(s.lcs(v, w));
    }

    @Test
    public void testFindLCS02() {
        readQuizData("src/com/mukhar/dataset_74_5.txt");
        Sequencer s = new Sequencer();
        System.out.println(s.lcs(v, w));
    }

    public void readTestData(String name) {
        In in = new In(name);
        in.readLine(); // ignore "Input"
        v = in.readLine();
        w = in.readLine();
        in.readLine(); // ignore "Output"
        expected = in.readLine();
        in.close();
    }

    public void readQuizData(String name) {
        In in = new In(name);
        v = in.readLine();
        w = in.readLine();
        in.close();
    }

}
