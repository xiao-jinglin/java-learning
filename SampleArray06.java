class SampleArray05 {
    public static void main(String[] args){
        int[][][] array = new int[3][3][3];
        for(int[][] x: array){
            for(int[] y: x){
                for(int z: y){
                    System.out.print(z + " ");
                }
            }
        }
        

    }
}