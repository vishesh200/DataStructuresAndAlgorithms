package Arrays;

public class TrappedRainwater {
    public static int trappedRainWater(int[] height) {
        int l = height.length;
        if(l <= 2) {
            return 0;
        }
        int trappedWater = 0;
        int[] leftMax = new int[l];
        leftMax[0] = height[0];
        for(int i=1; i<l; i++) {
            leftMax[i] = Math.max(height[i],leftMax[i-1]);
        }
        int[] rightMax = new int[l];
        rightMax[l-1] = height[l-1];
        for(int j=l-2; j>=0; j--) {
            rightMax[l-2] = Math.max(height[j],rightMax[j+1]);
        }
        for(int k=0; k<l; k++) {
            int waterLevel = Math.min(leftMax[k],rightMax[k]);
            trappedWater += waterLevel - height[k];
        }
        return trappedWater;
    }
    public static void main(String[] args) {
        int[] height = {4,2,0,6,3,2,5};
        System.out.println(trappedRainWater(height));
    }
}
