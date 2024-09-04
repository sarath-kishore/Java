package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class jobSequencing {
    public static void main(String[] args) {
        int[] id = {1, 2, 3, 4}; // job id
        int[] deadlines = {4, 1, 1, 1}; // job deadline
        int[] profits = {20, 10, 40, 30}; // job profit
        int n = 6; // total meetings
        System.out.println("Max profits: " + greedy(id, deadlines, profits));
    }

    static class job{
        int id;
        int deadline;
        int profit;

        job(){

        }
        job(int id, int deadline, int profit){
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }

    }

    static int greedy(int[] id, int[] deadlines, int[] profits){
        int maxProfits = 0;
        int maxDeadline = -1;

        ArrayList<job> list = new ArrayList<>();
        for(int i=0; i<id.length; i++){
            list.add(new job(id[i], deadlines[i], profits[i]));
            maxDeadline = Math.max(maxDeadline, deadlines[i]);
        }

        int[] possible_slots = new int[maxDeadline+1];
        // maxDeadline + 1, because 1-based indexing. 0 cannot be used for a deadline.

        Collections.sort(list, (a,b)-> {
//            sort in the descending order of the profits. max profits first.
            return -(int) (a.profit - b.profit);
        });

        ArrayList<Integer> sequence = new ArrayList<>();

        for(int i=0; i<list.size(); i++){
            int current_job = list.get(i).deadline;

            for(int j=current_job; j>0; j--){ // j is not equal to 0, because deadlines can never be at 0 time. common sense.
                if(possible_slots[j]==0){
                    possible_slots[j] = list.get(i).id;
                    maxProfits += list.get(i).profit;
                    sequence.add(list.get(i).id);
                    System.out.println(Arrays.toString(possible_slots));
                    break;
                }
            }
        }

        System.out.println(sequence);

        return maxProfits;
    }

}
