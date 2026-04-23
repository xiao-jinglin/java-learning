class SampleTypeConv05{
    public static void main(String[] args){
        byte b1 = 65;

        char c = (char)b1;
        byte b2 = (byte)c;

        System.out.println(c + ":" + b2);

    }
}