package api.learn;

public class ShitOperator {

    public static void main(String[] args){
        int negative6 = -6;
        int n6shiftN = negative6 >> 4;
        System.out.println(n6shiftN);
        System.out.println(Integer.toBinaryString(negative6));
        System.out.println(Integer.toBinaryString(n6shiftN));

        int n6ShiftNoSignal = negative6 >>> 1;
        System.out.println(n6ShiftNoSignal);



        int intMax = Integer.MAX_VALUE;
        System.out.println("\n" +Integer.toBinaryString(intMax));

        int foo = Integer.parseInt("01111111000000000000000000000000", 2);
        System.out.println( foo);
        System.out.println(Integer.toBinaryString(foo));
        int fooShitN = foo >>4;
        System.out.println(Integer.toBinaryString(fooShitN));


        System.out.println(0xff >>> 7);
        System.out.println((((byte) 0xff) >>> 7));
        System.out.println((byte) (((byte) 0xff) >>> 7));
    }
}
