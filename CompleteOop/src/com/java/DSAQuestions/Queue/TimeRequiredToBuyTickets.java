package com.java.DSAQuestions.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class TimeRequiredToBuyTickets {
    public static int timeRequiredToBuy(int[] tickets, int k) {
        // Approach-1(Brute Force)
        // TC=O(n*k), SC=O(1)

        /*
        int time=0;
        int i=0, n =tickets.length;

        while(tickets[k]!=0) {
            if(tickets[i] > 0){
                tickets[i] = tickets[i] - 1;
                time++;
            }
            i = (i+1)%n;
        }

        return time;

         */


        // Approach-2 (Optimised)
        // TC=O(n), SC=O(1)
        /**
         * #(1) Any person curr_ticket having tickets more than the k pos person,
         *      will buy tickets minimum of tickets[k] and curr_ticket times only.
         * #(2) Person curr_ticket having tickets less than kth person ( curr_ticket < tickets[k] ),
         *      and standing before him(i<k), will be able to buy curr_ticket amount.
         * #(3) Person curr_ticket standing after kth person having more tickets than kth person,
         *      will be able to buy one less than the ticket kth person can buy(condition: tickets[k] - 1).
         */

        /*
        int time=0;
        for (int curr_ticket : tickets) {
            if (curr_ticket <= tickets[k]) {
                time += Math.min(curr_ticket, tickets[k]);
            } else {
                time += Math.min(curr_ticket, tickets[k]-1);
            }
        }

        return time;

         */

        // or
        /*
        int time_sec=0;
        int least_tickets = tickets[k];


        for (int i = 0; i < tickets.length; i++) {
            if (k < i && tickets[i] >= least_tickets){
                time_sec += (least_tickets - 1);
            } else if (tickets[i] < least_tickets ) {
                time_sec += tickets[i];
            }else {
                time_sec += least_tickets;
            }
        }
        return time_sec;

         */

        //Approach-3(Using Queue)
        // TC=O(n), SC=O(n)
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < tickets.length; i++) {
            q.add(i);
        }

        int time=0;

        while(tickets[k]!=0 && !q.isEmpty()) {
                tickets[q.peek()]--;
                if(tickets[q.peek()]!=0){
                    q.add(q.peek());
                }
                q.poll();
                time++;
        }

        return time;

    }

    public static void main(String[] args) {
        int[] tickets = {2,3,2};
        int k=2;

        System.out.println(timeRequiredToBuy(tickets,k)); // 6
    }
}
