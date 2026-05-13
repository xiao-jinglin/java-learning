class MethodPractice03 {
    public static void main(String[] args) {
        int number = 15;
        int result = factorial(number);
        System.out.println(number + "‚ÌŠKæ‚Í " + result + " ‚Å‚·B");
    }


    public static int factorial(int n) {
        if(n <= 1){
            return 1;
        }

        return n * factorial(n-1);
    }
}