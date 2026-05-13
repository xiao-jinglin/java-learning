import java.util.Arrays;

class MethodPractice02 {
    public static void main(String[] args) {
        int[] scores = {85, 92, 78, 99, 60};
        
        int max = findMax(scores);
        
        System.out.println("配列の中身：" + Arrays.toString(scores));
        System.out.println("最大値は：" + max);
    }


    public static int findMax(int[] arr) {
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
}