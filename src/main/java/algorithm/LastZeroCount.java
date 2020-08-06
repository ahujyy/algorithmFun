package algorithm;

public class LastZeroCount {



    public static void main(String args[]){

    System.out.println(getZero(125));


    }

    public static int getZero(int num){
        int count = 0;

        while(num>=5){
            int n = num;
            while(n%5==0){
                count++;
                n/=5;
            }
            num--;
        }
        return count;
    }


    int f(int n){
        int sum = 0;
        while(n != 0){
            sum += n / 5;
            n = n / 5;
        }
        return sum;
    }



    //25  50 75 100  125

}
