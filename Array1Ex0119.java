class Array1Ex0119 {
    public static void main(String[] args){
        //問題1
        System.out.println("----------問題1----------");
        int[] array1 = {1,2,3,4,5,6,7,8,9,10};

        for(int i = 0; i < array1.length; i++){
            System.out.print(array1[i] + " ");
        }
        System.out.println();

        //問題2
        System.out.println("----------問題2----------");
        int[] array2 = {1,2,3,4,5,6,7,8,9,10};

        for(int i = array2.length - 1; i >= 0; i--){
            System.out.print(array2[i] + " ");
        }
        System.out.println();

        //問題3
        System.out.println("----------問題3----------");
        int[] array3 = {31,41,59,26,53,58,97,93,23,84};
        int sum = 0;

        for(int i = 0; i < array3.length; i++){
            sum += array3[i];
        }
        double eva = (double)sum /  array3.length;
        System.out.println("平均値:" + eva);

        //問題4
        System.out.println("----------問題4----------");
        int[] array4 = {31,41,59,26,53,58,97,93,23,84};
        int count = 0;

        for(int i = 0; i < array3.length; i++){
            if(array3[i] % 2 == 0 && array3[i] >= 10){
                count++;
            }
        }
        System.out.println("10以上の偶数は、" + count+ "個です" );

        
        //問題5
        System.out.println("----------問題5----------");
        int[] array5 = {31,41,59,26,53,58,97,93,23,84};
        int max = array5[0];
        int mix = array5[0];

        for(int i = 1; i < array5.length; i++){
            if(max < array5[i])
                max = array5[i];
            if(mix > array5[i])
                mix = array5[i];
        }

        System.out.println("最大値は" + max + "、最小値は" + mix + "です");
        
        //問題6
        System.out.println("----------問題6----------");
        int[] array6 = {31,41,59,26,53,58,97,93,23,84};
        int[] array6_rev = new int[10];
        for(int i = array6.length - 1,j = 0; i >= 0; i--,j++){
            array6_rev[j] = array6[i];
        }
        for(int i = 0; i < array6_rev.length; i++){
            System.out.print(array6_rev[i] + " ");
        }
        System.out.println();

        //問題7
        System.out.println("----------問題7----------");
        int[] array7 = {3, 5, 2, 2, 7, 4, 1, 6, 4, 3};
        int count1 = 1,sum1 = 0;
        boolean allZeros = true;

        for(int i = 0; i < array7.length; i++){
            if(array7[i] != 0){
                allZeros = false;
                break;
            }
        }
        if(array7.length == 0 || allZeros){
            count1 =0;
        }

        for(int i = 0; i < array7.length; i++){
            if(sum1 + array7[i] > 10){
                count1++;
                sum1 = 0;
            }
            sum1 += array7[i];
        }
        System.out.println("必要な台車は" + count1 + "台です");

    }
}