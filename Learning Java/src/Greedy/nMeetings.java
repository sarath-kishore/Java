package Greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class nMeetings {
    public static void main(String[] args) {
        int[] s = {1, 3, 0, 5, 8, 5}; // starting time
        int[] f = {2, 4, 6, 7, 9, 9}; // finishing time
        int n = 6; // total meetings
        System.out.println(greedy(s, f, n));
    }

    static class meeting{
        int start;
        int end;
        int pos;
        meeting(){

        }
        meeting(int start, int end, int pos){
            this.start = start;
            this.end = end;
            this.pos = pos;
        }
    }

    static class meetingComparator implements Comparator<meeting>{

        @Override
        public int compare(meeting o1, meeting o2) {
            // sort in the ascending order of the end times.
            if(o1.end < o2.end)
                return -1;
            if(o1.end > o2.end)
                return 1;
            if(o1.end==o2.end){
                // if 2 meetings end at the same time, sort in the ascending order of their positions.
                if(o1.pos < o2.pos)
                    return -1;
                else
                    return 1;
            }
            return -1;
        }
    }

    static int greedy(int[] s, int[] f, int n){
        ArrayList<meeting> list = new ArrayList<>();

        for(int i=0; i<s.length; i++){
            list.add(new meeting(s[i], f[i], i));
        }

        Collections.sort(list, new meetingComparator());

        int totalMeetings = 1;
        System.out.println(list.get(0).start + " -> " + list.get(0).end);

        for(int i = 1, j=0; i<s.length; i++){
            if(list.get(i).start > list.get(j).end){
                totalMeetings++;
                j++;
                System.out.println(list.get(i).start + " -> " + list.get(i).end);
            }
        }


        return totalMeetings;
    }
}
