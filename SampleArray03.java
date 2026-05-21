import java.util.Arrays;

class SampleArray03 {
    public static void main(String[] args){
        int[] ai = {34,58,7,89,100};
        for(int i = 0; i < ai.length; i++)
            System.out.println("ai[" + i + "] = " + ai[i]);

        System.out.println(Arrays.toString(ai));

    }
}