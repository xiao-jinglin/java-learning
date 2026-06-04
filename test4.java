class test4{
    int bar(int x){
        return 2 + x;
    }

    static int foo(){
        int x = 1;
        x = bar(x);
        return x;
        
        }

    public static void main(String[] args){
        System.out.print(foo());
    }
}