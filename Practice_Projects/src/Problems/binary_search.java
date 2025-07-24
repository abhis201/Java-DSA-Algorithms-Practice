package Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class binary_search{
    
    static int bin_search(List<Integer> arr,int val,int high, int low)
    {
        int mid = (high+low)/2;

        while(low<=high)
        {
            if(arr.get(mid)==val) return mid;
            else if(arr.get(mid)<val) return bin_search(arr, val, high, mid+1);
            else if(arr.get(mid)>val) return bin_search(arr, val, mid-1, low);
        }
        return -1;
    }

    public static void main(String[] args)
    {
        List<Integer> nums = new ArrayList<>();

        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(12);
        nums.add(23);
        nums.add(31);
        nums.add(11);
        nums.add(52);
        nums.add(63);

        System.out.println(nums);

        Collections.sort(nums);

        System.out.println(nums);
        System.out.println(bin_search(nums, 11, nums.size()-1, 0));
        

    }
}
