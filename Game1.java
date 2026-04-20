import java.util.Scanner;
import java.util.Random;   

class Game1 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        int targetNumber = random.nextInt(100) + 1;
        int guess = 0;
        int attempts = 0;
        boolean hasGuessedCorrectly = false;

        System.out.println("--- 数字当てゲームへようこそ！ ---");
        System.out.println("1から100までの数字を頭の中で決めました。");

        while (!hasGuessedCorrectly){
            System.out.println("予想した数字を入力ください。");

            if (input.hasNextInt()){
                guess  = input.nextInt();
                attempts ++;

                if (guess < targetNumber){
                    System.out.println("もっと「大きい」ですよ。");
                }else if (guess> targetNumber){
                    System.out.println("もっと「小さい」ですよ。");
                }else{
                    hasGuessedCorrectly = true;
                }
            }else{
                System.out.println("エラー：有効な数字を入力してください！");
                input.next();
            }
        }
        System.out.println("\nおめでとうございます！");
        System.out.println("あなたは " + attempts + " 回目で正解の「" + targetNumber + "」を当てました。");

        input.close();
    }
}