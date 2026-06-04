class SampleOverload01{
    static int add(int x,int y){
        int sum = x + y;
        return sum;
    }

    static int add(int x,int y,int z){
        int sum = x + y + z;
        return sum;
    }

    public static void main(String[] args){
        int x = 12, y = 3, z = 4;
        System.out.println("x + y =" + add(x, y));
        System.out.println("x + y + z =" + add(x, y, z));
    }
}