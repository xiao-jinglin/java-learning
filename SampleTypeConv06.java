class SampleTypeConv06{
    public static void main(String[] args){
        byte x = 1;

        boolean b = (boolean)x;//boolean型はほかのどの基本データ型とも型の交換性が無いため、コンパイルエラーとなります。

        System.out.println(b);

    }
}