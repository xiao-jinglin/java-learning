class SampleCall01{
    static void meth(int[] a){
        a[0] = 1000;
    }

    public static void main(String[] args){
        int[] array = {10, 20, 30};
        meth(array);

        for(int x: array){
            System.out.println(x);
        }
    }
}