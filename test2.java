import java.util.Scanner;

class test2 {
    public static void main(String[] args){
        int n = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("数字を入力してください：");
        if (sc.hasNextInt()) { 
            n = sc.nextInt(); 
            if(isPrime(n)){
                System.out.println(n + "は素数です。");
            }else{
                System.out.println(n + "は素数ではありません。");
            }
        } else {
            System.out.println("エラー：整数を入力してください。");
        }
        

        sc.close();
        
    }
    public static boolean isPrime(int n){
        if(n <= 1) return false;
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0) return false;
        }
        return true;
    }
}