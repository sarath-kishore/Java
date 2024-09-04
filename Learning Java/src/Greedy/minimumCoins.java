package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class minimumCoins {
    public static void main(String[] args) {
        int[] denominations = {1, 2, 5, 10, 20, 50, 100, 500, 1000};
        int val = 39;
        List<Integer> list = new ArrayList<>();
        int count = 0;
        int j = denominations.length-1;
        while(val>0 && j>=0){
            while(denominations[j]>val && j>=0){
                j--;
            }
            while(denominations[j]<=val && val>0){
                list.add(denominations[j]);
                val -= denominations[j];
                count++;
            }
        }

        System.out.println(list);
        System.out.println(count);

    }
}
