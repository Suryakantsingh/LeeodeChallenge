package leetCodeChallenge.may;

public class RemoveKdigit {
    public String removeKdigits(String num, int k) {
        if (num.length() == 0) {
            return num;
        }
        if(num.length() == k){
            return "0";
        }

        StringBuilder str = new StringBuilder(num);
        String value = ""+str.charAt(0);
        Integer intValue = new Integer(value);
        String st = ""+num.charAt(num.length()-1);
        Integer lastValue = new Integer(st);

        if (k == 1) {
            if( num.length() == 1 ){
                return "0";
            }else{
                if(num.charAt(1) == '0'){
                    str.deleteCharAt(0);
                }else{
                    if(lastValue > intValue){
                        str.deleteCharAt(num.length()-1);
                    }else{
                        str.deleteCharAt(0);
                    }

                }
            }
        } else {
            int l = 1;
            for (int i = 1; i < str.length(); i++) {
                String s = ""+str.charAt(l);
                Integer temp = new Integer(s);
                if (k >= 0 && temp > intValue) {
                    str.deleteCharAt(l);
                    k--;
                    l = 1;
                }else {
                    l++;
                }
            }
            if( str.length() == k ){
                int j = 0;
                while ( j < k ){
                    str.deleteCharAt(j);
                    j++;
                }
            }
        }
        while(str.charAt(0)=='0'&& str.length()>1){
            str.deleteCharAt(0);
        }
      return str.toString();
    }

    public static void main(String[] args) {
        RemoveKdigit remmove = new RemoveKdigit();
        String num = "10";
        System.out.println(remmove.removeKdigits(num, 1));

    }
}
