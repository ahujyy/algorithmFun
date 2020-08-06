package algorithm.kmp;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

//10:43
public class KMP {

    public static void main(String [] args){
        //String sourceString = "XGABCDEFHIJKAGSXRFFABCDEIJKLMOPQRABCDJKLMOPQDDxxxABCDEIJKLMOPQRABCDJKLMOPQDD";
        //String matchTargetString = "ABCDEIJKLMOPQRABCDJKLMOPQDD";

        String sourceString = "ABCDABCDAB";
        String matchTargetString = "ABCDAB";

        List<Integer> matchTable = getMatchHopsTable(matchTargetString);

        //当部分匹配 ，回退i， j置 0
        for(int i=0,j=0;  i<=sourceString.length() - matchTargetString.length(); ){

            int startFrom = i;
            while (j < matchTargetString.length()  && i < sourceString.length()
                    && sourceString.charAt(i) == matchTargetString.charAt(j)){
                i++; j++;
            }

            if(j == matchTargetString.length()) {
                //match
                System.out.println("start index: " + startFrom + ", string: " + sourceString.substring(startFrom, i));
            }


            if(j ==0 ){
                i ++;
            }else {
                i = i - matchTable.get(j-1);
            }
            j=0;

        }

        // 部分匹配后不会退i， 置j  比如匹配部分为ABCDEFABC(匹配串设为ABCDEFABCZZZZZ)，设查找串为XXXXX ABCDEFABCYXXXX,
        // i 指向Y， j重置3 （table.get(j-1)）

        int matchIdx = 0;
        for(int i=0;  i< sourceString.length() ;  i++){


            if(sourceString.charAt(i) == matchTargetString.charAt(matchIdx)){
                matchIdx++;


                if(matchIdx == matchTargetString.length() ){
                    //match,  i 指向最后 match的 下标， matchIdx 已经 ++.
                    System.out.println("found one match, i:" +i +", matchIdx: " + matchIdx
                            + ", start index: " + (i+1 - matchIdx)
                            +  ", string:" +  sourceString.substring(i + 1 - matchIdx, i +1));


                    //matchIdx = 0;
                    matchIdx = matchTable.get(matchIdx -1 );
                }

            }else{
                //发现不匹配两种情况：
                // 1， 两者都是第一个不匹配， i 移到下一个，i 不需要重新匹配。
                // 2，前面有部分匹配，匹配部分的串 如果它的头部 和 尾部 有重合串，头部重合部分的下一个index就是需要和i重新开始测试是否匹配。
                //    这时候i 会重新匹配一次。

              int dm =    (matchIdx ==0)  ?  (matchIdx = 0) :  (matchIdx = matchTable.get(matchIdx-1));

              if(matchIdx ==0 &&  i > ( sourceString.length() - matchTargetString.length() ) ){
                  System.out.println("i+" + i);
                  break;
              }
            }
        }

    }


    private static  List<Integer> getMatchHopsTable(String matchCharSequence){

        if(matchCharSequence == null || matchCharSequence.length() == 0)return null;
        List<Integer> table = new ArrayList<>(matchCharSequence.length());

        //"ABCDEIJKLMOPQRABCDJKLMOPQDD"
        //source =DDDABCXXABCXXABEE    matchStr = "ABCXXABCXXAB"----ABCXXAB

        IntStream.range(0, matchCharSequence.length()).forEach(idx->{

            //init
            table.add(idx, 0);

            String matchedCharSequence = matchCharSequence.substring(0, idx + 1);

            // update
            if(matchedCharSequence.length() == 2
                    && matchedCharSequence.charAt(0) == matchedCharSequence.charAt(1))
                table.set(idx, 1);

            else if(matchedCharSequence.length() > 2){

                Map<String, String> checkDuplicatedMap = new HashMap<>();
                for(int start =1; start < idx; start ++){
                    String part1 = matchedCharSequence.substring(0, start+1);
                    String part2 = matchedCharSequence.substring(start, idx+1);
                    if(checkDuplicatedMap.containsKey(part1)
                            && table.get(idx) < part1.length()){

                        table.set(idx, part1.length());
                    }else  checkDuplicatedMap.put(part1 , "");

                    if(checkDuplicatedMap.containsKey(part2)
                            && table.get(idx) < part2.length()){

                        table.set(idx, part2.length());
                    }else  checkDuplicatedMap.put(part2 , "");

                }
            }

           System.out.println("table size: " + table.size() + ", matched String: "
                    + matchedCharSequence + ", hops: " + table.get(idx));
        });

        return table;
    }
}
