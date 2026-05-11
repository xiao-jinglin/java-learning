import java.util.Arrays;

class ArrayPractice02 {
    public static void main(String[] args) {
        int[] nums = {45, 12, 89, 33, 1};

        Arrays.sort(nums);
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        double ave =(double) sum / nums.length;

        System.out.println(nums[nums.length - 1]);
    }
}