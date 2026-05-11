class ForPractice{
    public static void main(String[] args){
        for(int x = 0; x <= 20; x++){
            for(int y = 0; y <= 33; y++){
                int z = 0;
                z = 100 - x - y;

                if(z >= 0 && z % 3 == 0 && x*5 + y*3 + z/3 == 100){
                    System.out.println(x + " " + y + " " + z);
                    
                } 
            }
        }
    }
}