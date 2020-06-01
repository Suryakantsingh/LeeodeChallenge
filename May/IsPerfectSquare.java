package leetCodeChallenge.may;

public class IsPerfectSquare {
    public boolean isPerfectSquareSecond(int num) {

        for (int i = 1; i * i <= num; i++) {
            if((num % i == 0) && (num / i == i) ){
                return true;
            }
        }
        return false;
    }

    public boolean isPerfectSquare(int num) {
        long l = 1,  r = num;
        while (r >= l){
            long mid = (l+r)/2;
            if(mid * mid == num){
                return true;
            }
            if(mid * mid < num) {
                l = mid+1;
            }else{
                r = mid -1;

            }
        }
        return false;
    }

    public static void main(String args[]) {
        IsPerfectSquare square = new IsPerfectSquare();
        System.out.println(square.isPerfectSquare(2147483647));

    }
}
