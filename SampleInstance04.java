class Person4{
    String name;
    int age;

    Person4(String _name,int _age){
        name = _name;
        age = _age;
        System.out.println(name + "," + age);
    }
}

class SampleInstance04{
    public static void main(String[] args){
        new Person4("Tanaka", 23);
        new Person4("fukuda", 43);
    }
}