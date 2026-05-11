class test {
    public static void main(String[] args){
        int hp = 100;
        while(hp > 0){
            System.out.println("hp:" + hp);
            hp -= 20;
        }
        System.out.println("Game Over");

        for (int i = 10; i > 0; i -= 2) {
            System.out.println(i);
        }
        
        int sum = 0;
        for (int i = 1; i <= 10; i++){
            if(i % 2 != 0 && i % 3 != 0){
                sum += i;
            }
        }

        for(int i = 1;i <= 9; i++){
            for(int j = 1;j <= i; j++){
                System.out.printf("%d*%d=%d ",j,i,j*i);
            }
            System.out.println();
        }

    }
}