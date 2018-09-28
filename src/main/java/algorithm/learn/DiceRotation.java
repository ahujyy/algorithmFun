package algorithm.learn;

import java.util.HashMap;
import java.util.Map;

public class DiceRotation {

    public static void  main(String args[]){
        System.out.println("hahaha ");

        int[] xx = {1,1,6};
        int[] ab= {1,2,3,4};
        int[] rep= {1,1,1,1,1,2,2,3,5,6};

        System.out.println(xxm(rep));
    }

    public static void  pocV(int v, Map<Integer,Integer> noCount){

        if (noCount.get(v) == null)noCount.put(v, 1);
        else noCount.put(v, noCount.get(v) +1);

    }

    public static  int xxm(int[] A){
        Map<Integer,Integer> noCount = new HashMap<>();

        for(int v: A){
            pocV(v,noCount);
        }

        int count_1 = noCount.get(1) == null ? 0:  noCount.get(1);
        int count_6 = noCount.get(6) == null ? 0:  noCount.get(6);
        int count_2 = noCount.get(2) == null ? 0:  noCount.get(2);
        int count_5 = noCount.get(5) == null ? 0:  noCount.get(5);
        int count_3 = noCount.get(3) == null ? 0:  noCount.get(3);
        int count_4 = noCount.get(4) == null ? 0:  noCount.get(4);


        int min16 = Math.min(count_1,count_6) * 2 + count_2 + count_5 + count_3 + count_4;
        int min25 = Math.min(count_2,count_5) * 2 + count_1 + count_6 + count_3 + count_4;
        int min34 = Math.min(count_3,count_4) * 2 + count_1 + count_6 + count_2 + count_5;


        return Math.min(min16, Math.min(min25, min34));



    }
}
