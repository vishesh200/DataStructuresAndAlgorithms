package GreedyAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class CoinChangeProblem {
    public static void main(String[] args) {
        Integer[] coins = {1,2,5,10,20,50,100,500,1000,2000};
        Arrays.sort(coins, Comparator.reverseOrder());

        int numberOfCoins = 0;
        int amount = 590;
        ArrayList<Integer> answer = new ArrayList<>();

        for(int i=0; i<coins.length; i++) {
            if(coins[i] < amount) {
                while(coins[i] <= amount) {
                    numberOfCoins++;
                    answer.add(coins[i]);
                    amount -= coins[i];
                }
            }
        }

        System.out.println("Minimum number of coins required are : "+numberOfCoins);
        System.out.println("Required denominations : "+answer);
    }
}
