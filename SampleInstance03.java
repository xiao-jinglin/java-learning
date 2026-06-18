class Person3{
    String name;
    int age;

    Person3(int[] x){
        System.out.println(name + "," + age);
    }
}

class SampleInstance03{
    public static void main(String[] args){
        int[] x = new int[3];
        new Person3(x);
    }
}