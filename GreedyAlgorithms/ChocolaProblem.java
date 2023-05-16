package GreedyAlgorithms;

/* We have been a two-dimensional chocolate bar consisting of n rows
and m columns. We have n-1 horizontal cuts and m-1 vertical cuts of varying
costs. We want to cut the whole bar into pieces of dimension 1x1. Find the
minimal cost required for cutting the bar. */

/* All of the cuts need to be applied as we need to cut the chocolate into pieces
of dimension 1x1.
So total cuts = (n - 1) + (m - 1)
Also Total cost = (Cost of a horizontal cut * Number of vertical pieces it cut) + (Cost of a vertical cut * Number of horizontal pieces it cut)
 */

import java.util.Arrays;
import java.util.Collections;

public class ChocolaProblem {
    public static void main(String[] args) {
        int n=4, m=6;
        Integer[] costVer = {2,1,3,1,4};
        Integer[] costHor = {4,1,2};

        /* Whenever we cut a chocolate bar, it breaks up into more pieces.
        So it'll be more beneficial if we apply cuts of higher costs first and
        those with less cost later as the number of chocolate pieces is going to
        increase as the cuts are going to get applied */

        // Therefore sorting the cost arrays in reverse order
        Arrays.sort(costHor, Collections.reverseOrder());
        Arrays.sort(costVer, Collections.reverseOrder());

        int v = 0, h = 0; // v and h denote the current cut to be applied (Pointers for traversing both the cost arrays)
        int vp = 1, hp = 1; // vp and hp are the number of horizontal and vertical pieces at present which are 1 initially
        int totalCost = 0;

        while(h < costHor.length && v < costVer.length) {
            // Case 1 : Applying horizontal cut as it's more expensive
            if(costHor[h] >= costVer[v]) {
                totalCost += (costHor[h] * vp); // A horizontal cut goes through vertical pieces
                hp++; // Each horizontal cut divides the chocolate into 2 horizontal pieces
                h++;
            }
            // Case 2 : Applying the vertical cut
            else {
                totalCost += (costVer[v] * hp); // A vertical cut goes through horizontal pieces
                vp++; // Each vertical cut divides the chocolate into 2 vertical pieces
                v++;
            }
        }

        // For the leftover cuts
        while(h < costHor.length) {
            totalCost += (costHor[h] * vp);
            hp++;
            h++;
        }

        while(v < costVer.length) {
            totalCost += (costVer[v] * hp);
            vp++;
            v++;
        }

        System.out.println("Minimum possible cost to cut the chocolate is : "+totalCost);
    }
}
