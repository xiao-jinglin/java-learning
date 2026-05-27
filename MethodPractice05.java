class MethodPractice05 {
    public static void main(String[] args) {
        int[] array = {2, 3, 5, 8, 12};
        double std = std(array);
        System.out.println(std);
    }


    public static double std(double[] arr) {
        double sum = 0;
        for(double x: arr) sum += x;
        double ave = sum / arr.length;
        double std = 0;
        for(double x: arr) std += (x-ave)*(x-ave);
        double result = Math.sqrt(std/arr.length);
        
        return result;
    }
    public static double std(int[] arr) {
        double sum = 0;
        for(double x: arr) sum += x;
        double ave = sum / arr.length;
        double std = 0;
        for(double x: arr) std += (x-ave)*(x-ave);
        
        return Math.sqrt(std/arr.length);
    }
}