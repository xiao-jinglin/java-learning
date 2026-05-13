class test1 {
    public static void main(String[] args){
        int i = 1;
        int perm = 1;

        int count = 0;

        do{
            count++;
            System.out.print("‘æ " + count + " ŽŸ\t" + i + "\t" + perm);
            perm *= i;
            i++;

            boolean b = (i<=5);
            System.out.println( "\t" + perm + "\t" + i + "\t" + b );
        }while(i<=5);
           
        System.out.println(perm);
    }
}