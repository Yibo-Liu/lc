import java.util.*;

class Solution_0001 {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> ints = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length ; i++){
            if (ints.containsKey(nums[i])){
                result[0] = ints.get(nums[i]);
                result[1] = i;
                return  result;
            }
            ints.put(target-nums[i], i );
        }
        return result;

    }

    public int[] twoSum2(int[] nums) {

        Set<Integer> resultSet = new HashSet<Integer>();


        return null;

    }

    public int reverse(int x) {
        int x_length = (x + "").length();
        System.out.println(x_length);
        int now_int = 0;
        int sum = 0;
        boolean blow_zero = false;
        if(x < 0 ){
           blow_zero = true;
           x = 0-x;
        } else if (x==0) {
            return 0;
        }

        while(x > 0){
            now_int = x%10;
            sum += x*(Math.pow(10,--x_length));
            x = x/10;
        }

        if(blow_zero){
           sum = 0-sum;
        }




        return sum;
    }

    public static void main(String[] args) {
        String s = "leet";
        System.out.println(s.substring(0,4));

        System.out.println(s.charAt(0));


    }


}