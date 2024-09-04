package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class fracKnapsack {
    static class items{
        int val;
        int weight;
        double fracW;
        items(){

        }
        items(int val, int weight){
            this.val = val;
            this.weight = weight;
            this.fracW = (double) val / (double) weight;
        }
    }

    public static void main(String[] args) {
        int n = 3;
        int capacity = 50;
        int[] values = {60, 100, 120};
        int[] weight = {10, 20, 30};

        List<items> list = new ArrayList<>();

        for(int i=0; i<values.length; i++){
            list.add(new items(values[i], weight[i]));
        }

        Collections.sort(list, (a,b) -> {
            return -(int)(a.fracW - b.fracW);
        });


        double total_val = 0;
        int total_weight = 0;
        int j = 0;
        while(capacity>0 && j<list.size()){
            if(total_weight + list.get(j).weight <= capacity){
                total_val += list.get(j).val;
                capacity -= list.get(j).weight;
            }else{
                int remaining_capacity = capacity;
                total_val += list.get(j).fracW * remaining_capacity;
            }
            j++;
        }

        System.out.println("Total value: " + total_val);
    }
}
