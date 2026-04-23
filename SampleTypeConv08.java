class SampleTypeConv08{
    public static void main(String[] args){
        char c = 'A';

        byte b1 = 1;
        int i1 = b1 * c;

        float f1 = 2.1f;
        float f2 = f1 + c;

        System.out.println(i1);
        System.out.println(f2);

    }
}