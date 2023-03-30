package Stacks;

import java.util.Stack;

/*
We have been given an array of Stock prices, and we need to calculate the
span of each stock. Span of a stock is the maximum number of consecutive days
for which the stock had lower or equal price when compared to today's price.
 */
public class StockSpanProblem {
    public static void calculateStockSpan(int[] stocks, int[] span) {
        Stack<Integer> s = new Stack<>();
        // Span of stock on 0th index is 1 as it itself has a price less than equal to it
        span[0] = 1;
        s.push(0);

        for(int i=1; i<stocks.length; i++) {
            int currPrice = stocks[i];
            while(!s.isEmpty() && currPrice > stocks[s.peek()]) {
                s.pop();
            }
            if(s.isEmpty()) {
                span[i] = i + 1;
            } else {
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }
            s.push(i);
        }
    }
    public static void main(String[] args) {
        int[] stocks = {100,80,60,70,60,85,100};
        int[] span = new int[stocks.length];
        calculateStockSpan(stocks,span);
        for(int i=0; i<span.length; i++) {
            System.out.println(span[i]+" ");
        }
        System.out.println();
    }
}
