class MethodPractice04 {
    public static void main(String[] args) {
        int number = 15;
        int result = fibonacci(number);
        System.out.println(result);
    }


    public static int fibonacci(int n) {
        if(n == 1 || n == 2){
            return 1;
        }

        return fibonacci(n-1) + fibonacci(n-2);
    }
}