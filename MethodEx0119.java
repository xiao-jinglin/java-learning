class MethodEx0119 {
    public static void main(String[] args){
        //問題1
        System.out.println("----------問題1----------");
        greet();

        //問題2
        System.out.println("----------問題2----------");
        printMessage("World");

        //問題3
        System.out.println("----------問題3----------");
        System.out.println(two(2.71828));

        //問題4
        System.out.println("----------問題4----------");
        System.out.println(ave(2,3));
        
        //問題5
        System.out.println("----------問題5----------");
        System.out.println(ave3(2,3,4));
        
        //問題6
        System.out.println("----------問題6----------");
        System.out.println(ave4(2,3,4,5));

        //問題7
        System.out.println("----------問題7----------");
        int[] arr = {2, 3, 4, 5, 6};
        System.out.println(avex(arr));

        //問題8
        System.out.println("----------問題8----------");
        System.out.println(isEven(47));

        //問題9
        System.out.println("----------問題9----------");
        System.out.println(factorial(5));

        //問題10
        System.out.println("----------問題10----------");
        int[] arr1 = {2, 3, 4, 5, 6};
        System.out.println(getRange(arr1));

        //問題11
        System.out.println("----------問題11----------");
        int[] arr2 = {2, 7, 1, 8, 2};
        int[] arr3 = copy(arr2);
        arr3[0] = 3;
        System.out.println("コピーした配列の最初の要素: " + arr2[0]);

        //問題12
        System.out.println("----------問題12----------");
        int[] arr4 = {2, 7, 1, 8, 2};
        int[] arr5 = remove(arr4, 2);
        
        System.out.print("元の配列: ");
        printArray(arr4);
        System.out.println("削除する値: " + 2);

        System.out.print("結果の配列: ");
        printArray(arr5);


        //問題13
        System.out.println("----------問題13----------");
        int[][] arr6 = {{1, 2}, {3, 4, 5}, {6, 7, 8}};
        int[] arr7 = rowMax(arr6);
        System.out.println("元の配列: [");
        for(int[] row: arr6) printArray(row);
        System.out.println("]");

        System.out.print("結果の配列: ");
        printArray(arr7);



    }
        
        

    //問題1のメソッド定義
    static void greet(){
        System.out.println("Hello");
    }

    //問題2のメソッド定義
    public static void printMessage(String str){
        System.out.println(str); 
    }

    //問題3のメソッド定義
    public static double two(double d){
        double x = d * 100 + 0.5;
        int x1 = (int)x;
        return x1/100.0;
    }

    //問題4のメソッド定義
    public static double ave(int x, int y){
        double ave = (x + y) / 2.0;
        return two(ave);
    }

    //問題5のメソッド定義
    public static double ave3(int x, int y, int z){
        double ave = (x + y + z) / 3.0;
        return two(ave);
    }

    //問題6のメソッド定義
    public static double ave4(int x, int y, int z, int a){
        double ave = (x + y + z +a) / 4.0;
        return two(ave);
    }

    //問題7のメソッド定義
    public static double avex(int... arr){
        if (arr == null || arr.length == 0) return 0.0;
        double sum = 0;
        for(int x: arr) sum += x;
        double ave = sum / arr.length;
        return two(ave);
    }

    //問題8のメソッド定義
    public static boolean isEven(int x){
        return (x % 2 == 0) ? true : false;
    }

    //問題9のメソッド定義
    public static long factorial(int x){
        return (x <= 1) ? 1 : (long) x * factorial(x - 1);
    }

    //問題10のメソッド定義
    static int getRange(int[] arr){
        if (arr == null || arr.length == 0) return -1;

        int max = arr[0];
        int mix = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > max) max = arr[i];
            if(arr[i] < mix) mix = arr[i];
        }
        return max - mix;
    }

    //問題11のメソッド定義
    static int[] copy(int[] arr){
        if (arr == null) return null;
        int[] res = new int[arr.length];
        int i = 0;
        for(int x: arr) res[i++] = x;
        return res;
    }

    //問題12のメソッド定義
    static int[] remove(int[] arr, int n){
        if (arr == null) return null;
        int count = 0;
        for(int x: arr) if(x == n) count++;
        int[] res = new int[arr.length - count];
        int i = 0;
        for(int x: arr) if(x != n) res[i++] = x;
        return res;
    }
    static void printArray(int[] arr) {
        if (arr == null) {
            System.out.println("null");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + (i == arr.length - 1 ? "" : ", "));
        }
        System.out.println("]");
    }

    //問題13のメソッド定義
    static int[] rowMax(int[][] arr){
        if (arr == null) return null;
        int[] res = new int[arr.length];
        int i = 0;
        for(int[] row: arr){
            int max = row[0];
            for(int num: row) if(num > max) max = num;
            res[i++] = max;
        }
        return res;
    }


}