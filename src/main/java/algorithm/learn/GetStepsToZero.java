package algorithm.learn;

public class GetStepsToZero {

    public static void main(String[] args){
        GetStepsToZero stepsToZero = new GetStepsToZero();
        stepsToZero.solution("011100");
    }


    public int solution(String s) {
        // write your code in Java SE 8 --- transform String to bytes preparing for moving operator.
        int n =-1, len = s.length(), size = 0;
        if(len % 8 == 0) size = len/8;
        else size = len/8 + 1;

        //create byte array
        byte[] bits = new byte[size];
        for(int i=0 ;i < size; i++){
            bits[i] = 0;
        }
        //init byte array using values from String parameter .
        char[] arrs = s.toCharArray();
        int idxCnt = 0;
        for(int i = arrs.length ; i>0 ; i--){
            byte c = (byte)(arrs[i-1] - '0');
            int position  = idxCnt % 8;
            if(c != 0){// == 1
                c = (byte)  (1 << position );
                int idx = idxCnt / 8 ;
                byte bt = bits[idx];
                byte result = (byte) (bt | c);
                bits[idx] = result;
            }
            idxCnt++ ;
        }
        //odd represents 1 at end of byte, even represents 0.
        int steps = 0;

//-----------------------------------------------------------solution -----------------
        // only need count number of 1 and 0 .
        String ss = "0000011100";
        char[] chars = ss.toCharArray();
        boolean startCount = false; int oneCnt =0, zeroCnt = 0;
        for(char c : chars){
            byte bv = (byte)( c - '0');
            if(bv == 0 && !startCount)continue; // abandon front zeros.
            else if(bv == 1 && !startCount) startCount = true;

            //start count.
            int dummy =  bv == 1 ? oneCnt++ : zeroCnt++;

        }

        //  1 is ODD need two steps:  step1 minus 1(bit 1 becomes 0), step2 >> 1.
        //  0 is even need one step : >>1.
        //  The last 1 only need become 0.
        n = (oneCnt * 2 + zeroCnt ) -1;

        System.out.println("steps: " + n);
        return n;
    }
}
