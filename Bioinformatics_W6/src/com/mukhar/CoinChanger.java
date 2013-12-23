package com.mukhar;

import java.util.ArrayList;

public class CoinChanger {
  public int minCoins(int money, ArrayList<Integer> coins)
  {
    int[] minCoins = new int[money + 1];
    minCoins[0] = 0;
    for (int m = 1; m < minCoins.length; m++) {
      minCoins[m] = Integer.MAX_VALUE;
      for (int i = 0; i < coins.size(); i++) {
        if (m >= coins.get(i)) {
          if (minCoins[m - coins.get(i)] + 1 < minCoins[m])
            minCoins[m] = minCoins[m - coins.get(i)] + 1;
        }
      }
    }
    return minCoins[money];
  }
}