import java.util.Scanner;

class SampleFlow {
    public static void main(String[] args){
        int price = 1000;

        Scanner sc = new Scanner(System.in);
        System.out.println("age‚ğ“ü—Í‚µ‚Ä‚­‚¾‚³‚¢F");
        
        int age = sc.nextInt(); 

        if (age <= 20){
            price = 500;
        }

        System.out.println("—¿‹à‚ÍF" + price);
        
        sc.close(); 
    }
}