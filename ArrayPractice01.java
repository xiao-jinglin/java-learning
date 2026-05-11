class ArrayPractic01 {
    public static void main(String[] args) {
        int[] data = {12, 45, 98, 3, 56, 77};
        
        int max = data[0];
        
        for(int i = 1; i < data.length ; i++){
            if(data[i] > max){
                max = data[i];
            }
        }

        System.out.println("ˆê”Ô‘å‚«‚¢‚Ì‚ÍF" + max);
    }
}