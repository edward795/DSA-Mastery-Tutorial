package TwoPointerApproach;
public class TrappingWatter {
    public static void main(String[] args) {
        int[] arr=new int[]{2,1,3,4,6,5};
        System.out.println("Maximum water that can be stored:"+gettrappedWater(arr));
    }
    
    //Efficient Soln : O(n)
    static int gettrappedWater(int[] height){
        int n=height.length;
        int low=0,high=n-1,ans=0;
        while(low<=high){
            if(height[low]<height[high]){
                ans=Math.max(ans,(high-low-1)*height[low]);
                low+=1;
            }else if(height[high]<height[low]){
                ans=Math.max(ans,(low-high-1)*height[high]);
                high-=1;
            }else{
                ans=Math.max(ans,(high-low-1)*height[low]);
                low+=1;
                high-=1;
            }
        }
        return ans;
    }
}
