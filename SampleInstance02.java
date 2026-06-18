class Person2{
    String name;
    int age;

    Person2(String _name,int _age){
        name = _name;
        age = _age;
        System.out.println(name + "," + age);
    }
}

class SampleInstance02{
    public static void main(String[] args){
        new Person1("Tanaka", 23);
    }
}