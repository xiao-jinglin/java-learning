class SampleArray05 {
    public static void main(String[] args){
        int[][] array = {{11, 12, 13}, {21, 22, 23, 24}, {31, 32}};

        System.out.println("array.length = " + array.length);
        System.out.println("array[0].length = " + array[0].length);
        System.out.println("array[1].length = " + array[1].length);
        System.out.println("array[2].length = " + array[2].length);

        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length;j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
            
        }

        for (int[] row : array) {
            for (int num : row) System.out.print(num + " ");
            System.out.println();
        }

    }
}