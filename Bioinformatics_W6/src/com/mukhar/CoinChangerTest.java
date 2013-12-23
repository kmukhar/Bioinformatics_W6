package com.mukhar;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import edu.princeton.cs.introcs.In;

public class CoinChangerTest {

  private ArrayList<Integer> coins;
  private Integer money;
  private int expected;
  private CoinChanger cc;

  @Before
  public void setUp() throws Exception
  {
    cc = new CoinChanger();
  }

  @Test
  public void testMinCoins01()
  {
    readTestData("src/com/mukhar/dp_min_coins.txt");
    assertEquals(expected, cc.minCoins(money, coins));
  }

  @Test
  public void testMinCoins02()
  {
    readQuizData("src/com/mukhar/dataset_71_8.txt");
    System.out.println("" + cc.minCoins(money, coins));
  }

  public void readTestData(String name)
  {
    In in = new In(name);
    in.readLine(); // skip "Input"
    money = Integer.valueOf(in.readLine());
    String[] s = in.readLine().split(",");
    coins = new ArrayList<>();
    for (String s2 : s)
      coins.add(new Integer(s2));
    in.readLine(); // skip "Output"
    expected = Integer.valueOf(in.readLine());
  }

  public void readQuizData(String name)
  {
    In in = new In(name);
    money = Integer.valueOf(in.readLine());
    String[] s = in.readLine().split(",");
    coins = new ArrayList<>();
    for (String s2 : s)
      coins.add(new Integer(s2));
  }
}
