package com.czj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        int maxProfit = maxProfit(prices);
        System.out.println("最大收益:" + maxProfit);
    }


    public static int maxProfit(int[] prices) {
        //价格走向，1升0保持-1降
        int direct = 0;
        //收益
        int profit = 0;
        //buy， sell时机
        int buyDay = -1;
        int sellDay = -1;

        for (int i = 0; i < prices.length - 1; i++) {
            //升序or降序
            direct = getDirect(prices[i], prices[i+1]);
            if (direct == 1) {
                if (buyDay < 0) {
                    buyDay = i;
                    System.out.println((buyDay+1) + "天买入，价格：" + prices[buyDay]);
                }
            } else if (direct == -1) {
                if (sellDay < 0 && buyDay > 0) {
                    sellDay = i;
                    int currentProfit = prices[sellDay] - prices[buyDay];
                    profit += currentProfit;
                    System.out.println((sellDay+1) + "天卖出，价格：" + prices[sellDay] + ", 这波收益：" + currentProfit);
                    //售出后，清空buyDay和sellDay
                    buyDay = -1;
                    sellDay = -1;
                }
            }
        }
        if (sellDay < 0) {
            sellDay = prices.length - 1;
            int currentProfit = prices[sellDay] - prices[buyDay];
            System.out.println("最后还没卖出，只能" + (sellDay+1) + "天卖出，价格：" + prices[sellDay] + ", 这波收益：" + currentProfit);
            profit += currentProfit;
        }
        return profit;
    }

    public static int getDirect(int before, int after) {
        if (before == after) {
            return 0;
        }
        return before < after ? 1 : -1;
    }
}
