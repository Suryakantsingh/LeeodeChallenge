package leetCodeChallenge.may;

import java.util.HashMap;
import java.util.Map;

public class JewelsandStones {

    public int numJewelsInStones(String J, String S) {

        Map<Character, Integer> stone = new HashMap<>();

        for (int i = 0; i < S.length(); i++) {
             char c = S.charAt(i);
            if(stone.containsKey(c)){
                 int n = stone.get(c);
                 stone.put(c,n+1);
             }else{
                 stone.put(c,1);
             }
        }

        int result = 0;

        for(int j=0 ; j<J.length(); j++){
            char ch = J.charAt(j);
            if(stone.containsKey(ch)){
                int n = stone.get(ch);
                result = result+n;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        JewelsandStones jewels = new JewelsandStones();
        System.out.println(jewels.numJewelsInStones("z", "ZZ"));
    }
}
