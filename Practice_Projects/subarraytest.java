import java.util.ArrayList;

public class subarraytest {
    
    static void create_subarray(int nums[])
    {
        ArrayList<ArrayList<Integer>> subarr = new ArrayList<>();
        int ctr=0;

        for(int i=1;i<=nums.length;i++)
        {
            for(int j=0;j<=nums.length-i;j++)
            {   
                subarr.add(ctr,new ArrayList<Integer>());

                for(int z=0;z<i;z++)
                {
                    subarr.get(ctr).add(nums[j+z]);
                }
                ctr++;
            }
        }
        subarr.forEach(System.out::println);
        //subarr.stream().forEach(System.out::println);
    }

    public static int maxSubArray(int[] nums) {
        
        ArrayList<ArrayList<Integer>> subarr = new ArrayList<>();
        int ctr=0;
        int sum=0;
        int max=Integer.MIN_VALUE;

        for(int i=1;i<=nums.length;i++)
        {
            for(int j=0;j<=nums.length-i;j++)
            {   
                subarr.add(ctr,new ArrayList<Integer>());

                for(int z=0;z<i;z++)
                {
                    subarr.get(ctr).add(nums[j+z]);
                    sum+=nums[j+z];
                }
                ctr++;
                if(sum>max) max=sum;
                sum=0;
            }
        }
        
        return max;
    }

    public static void main(String args[])
    {
        int nums[] = {1,2,3};
        create_subarray(nums);
    }
}
