class LoopEx0119 {
    public static void main(String[] args){
        //–â‘è1
        System.out.println("----------–â‘è1----------");
        int x1 = 5;
        for(int i = 0; i < 10; i++){
            System.out.print(x1++ + " ");
        }
        System.out.println();

        //–â‘è2
        System.out.println("----------–â‘è2----------");
        int x2 = 5;
        int sum1 = 0;
        for(int i = 0; i < 10; i++){
            sum1 += x2++;
        }
        System.out.println(sum1);

        //–â‘è3
        System.out.println("----------–â‘è3----------");
        int x3 = 2000;
        int sum2 = 0;
        int count1 = 1;
        for(; true;){
            sum2 += count1++;
            if(sum2 > x3){
                break;
            }
        }
        System.out.printf("%d‚ğ‰‚ß‚Ä’´‚¦‚½‚Æ‚«‚Ì”‚Í%d‚ÅA%d‚Ü‚Å‘«‚µZ‚ğ‚·‚é‚Æ’´‚¦‚Ü‚·B\n", x3, sum2, count1-1);

        //–â‘è4
        System.out.println("----------–â‘è4----------");
        int x4 = 0;
        for(int i = 1; i <= 100; i++){
            if(i % 3 == 0 || i % 5 == 0){
                x4++;
            }
        }
        System.out.println(x4);
        
        //–â‘è5
        System.out.println("----------–â‘è5----------");
        int x5 = 47;
        boolean isPrime = true;
        for(int i = 2; i * i <= x5; i++){
            if(x5 % i == 0){
                isPrime = false;
                break;
            }
        }
        if(isPrime){
            System.out.println(x5 + "‚Í‘f”‚Å‚·");
        }else{
            System.out.println(x5 + "‚Í‘f”‚Å‚Í‚ ‚è‚Ü‚¹‚ñ");
        }
        
        //–â‘è6
        System.out.println("----------–â‘è6----------");
        int x6 = 6;
        for(int i = 1; i <= x6; i++){
            for(int j = 1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println();
        }

        //–â‘è7
        System.out.println("----------–â‘è7----------");
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

        //–â‘è8
        System.out.println("----------–â‘è8----------");
        for(int i = 1; i <= 9; i++){
            for(int j = 1; j <= 9; j++){
                System.out.printf(i*j + "\t");
            }
            System.out.println();
        }

    }
}