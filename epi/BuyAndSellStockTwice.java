package epi;
import epi.test_framework.EpiTest;
import epi.test_framework.GenericTest;

import java.util.Collections;
import java.util.List;
public class BuyAndSellStockTwice {
  //T O(N^2) S O(1)
  @EpiTest(testDataFile = "buy_and_sell_stock_twice.tsv")
  public static double buyAndSellStockTwice(List<Double> prices) {
    if(prices.size() < 4) {
      return BuyAndSellStock.computeMaxProfit(prices);
    }

    int st = 0, ed = prices.size();
    double rt = 0;

    for(int i = 1; i < ed - 1; i++) {
      rt = Math.max(rt, BuyAndSellStock.computeMaxProfit(prices.subList(st, i + 1)) + BuyAndSellStock.computeMaxProfit(prices.subList(i, ed)));
    }

    return rt;
  }

  public static void main(String[] args) {
    System.exit(
        GenericTest
            .runFromAnnotations(args, "BuyAndSellStockTwice.java",
                                new Object() {}.getClass().getEnclosingClass())
            .ordinal());
  }
}
