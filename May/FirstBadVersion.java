package leetCodeChallenge.may;

public class FirstBadVersion {

    public int firstBadVersion(int n) {
        if(isBadVersion(1))
            return 1;


        int l = 1;
        int r = n;

        while (r >= l) {
            int mid = ((r - l) / 2)+l;
            if(isBadVersion(mid) == true){
                r = mid;
            }else{
                l = mid;
            }
            if((r-l) == 1 && isBadVersion(l) == false && isBadVersion(r) == true){
                return r;
            }

        }
     return 0;
    }

    public boolean isBadVersion(int version) {
        if (version >= 1702766719 )
            return true;

        return false;
    }

    public static void main(String[] args){
        FirstBadVersion first = new FirstBadVersion();
        System.out.println(first.firstBadVersion(2126753390));
    }
}
