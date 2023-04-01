package Stacks;

import java.util.Stack;

/*
We have been given a Histogram in the form of a height array and each bar i.e. each
array element has a width of 1 unit. We need to find the maximum area of a rectangle
which can be constructed by using the bars of the histogram.
 */
public class MaxAreaInAHistogram {
    public static void calcMaxArea(int[] heights) {
        Stack<Integer> s = new Stack<>();
        int maxArea = 0;
        int[] nextSmallerLeft = new int[heights.length];
        int[] nextSmallerRight = new int[heights.length];

        // Calculating the Next Smaller Element on the RHS
        for(int i=heights.length-1; i>=0; i--) {
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nextSmallerRight[i] = heights.length;
            } else {
                nextSmallerRight[i] = s.peek();
            }
            s.push(i);
        }

        // Calculating the Next Smaller Element on the LHS
        s = new Stack<>();
        for(int i=0; i<heights.length; i++) {
            while(!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nextSmallerLeft[i] = -1;
            } else {
                nextSmallerLeft[i] = s.peek();
            }
            s.push(i);
        }

        // Calculating the maximum possible area
        for(int i=0; i<heights.length; i++) {
            int height = heights[i];
            /* Here we subtract one from the difference of the indices as we do not want to include
            the nextSmallerRight bar while calculating our Area so we subtract its width from our width
            of the concerned rectangle */
            int width = nextSmallerRight[i] - nextSmallerLeft[i] - 1;
            int currArea = height * width;
            maxArea = Math.max(currArea,maxArea);
        }

        System.out.println("Maximum area of the given histogram is: "+maxArea);
    }

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        calcMaxArea(heights);
    }
}
