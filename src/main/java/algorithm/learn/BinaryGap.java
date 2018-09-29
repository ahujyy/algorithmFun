package algorithm.learn;

public class BinaryGap {

    public static void main(String[] args){

        int max=0;
        int a = 1244;

        int mag = Integer.SIZE - Integer.numberOfLeadingZeros(a);


    }

    public int solution(int N) {
        // write your code in Java SE 8
        if(N <=0 )return 0;

        int mag = Integer.SIZE - Integer.numberOfLeadingZeros(N);
        int max =0;
        boolean couldCount = false;
        int count = 0;
        for(int i=0;i<mag;i++){
            int lastBit = N & 0X01;
            if(lastBit == 1 && !couldCount){
                couldCount = true;
            }else if(lastBit==1 && couldCount){
                count = 0;
            }else if(couldCount && (lastBit==0)){
                count++;
                if(count > max)max= count;
            }
            N >>>=1;
        }
        return max;
    }
}
