class MethodEx0119 {
    public static void main(String[] args){
        //問題1
        System.out.println("----------問題1----------");
        greet();

        //問題2
        System.out.println("----------問題2----------");
        printMessage("World");

        //問題3
        System.out.println("----------問題3----------");
        System.out.println(two(2.71828));

        //問題4
        System.out.println("----------問題4----------");
        System.out.println(ave(2,3));
        
        //問題5
        System.out.println("----------問題5----------");
        int x5 = 47;
        boolean isPrime = true;
        for(int i = 2; i * i <= x5; i++){
            if(x5 % i == 0){
                isPrime = false;
                break;
            }
        }
        if(isPrime){
            System.out.println(x5 + "は素数です");
        }else{
            System.out.println(x5 + "は素数ではありません");
        }
        
        //問題6
        System.out.println("----------問題6----------");
        int x6 = 6;
        for(int i = 1; i <= x6; i++){
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        //問題7
        System.out.println("----------問題7----------");
        int x7 = 5;
        for(int i = 1,space = x7-1; i <= x7; i++,space--){
            for(int k = 1; k <= space; k++){
                System.out.print(" ");
            }
            for(int j = 1; j <= 2*i-1; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        //問題8
        System.out.println("----------問題8----------");
        for(int i = 1; i <= 9; i++){
            for(int j = 1; j <= 9; j++){
                System.out.printf(i*j + "\t");
            }
            System.out.println();
        }
    }

    //問題1のメソッド定義
    static void greet(){
        System.out.println("Hello");
    }

    //問題2のメソッド定義
    public static void printMessage(String str){
        System.out.println(str); 
    }

    //問題4のメソッド定義
    public static double two(double d){
        double x = d * 100 + 0.5;
        int x1 = (int)x;
        return x1/100.0;
    }
    
    //問題4のメソッド定義
    public static double ave(int x, int y){
        double ave = (x + y) / 2.0;
        return two(ave);
    }

}