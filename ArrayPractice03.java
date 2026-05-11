public class ArrayPractice03 {
    public static void main(String[] args) {

        int[][] grades = {
            {80, 90, 70},
            {60, 100, 95}
        };
        
        int sum = 0;
        for(int score : grades[0]){
            sum += score;
        }
        
        System.out.println("totleÅF" + sum);
    }
}