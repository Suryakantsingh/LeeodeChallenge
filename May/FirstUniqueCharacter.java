package leetCodeChallenge.may;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class FirstUniqueCharacter {

    public int firstUniqChar(String s) {

        if(s.length() == 0){
            return -1;
        }
        Queue<Character> queue = new LinkedList<>();
        HashMap map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (!queue.contains(ch) ) {

                if(!map.containsKey(ch)) {
                    map.put(ch, i);
                    queue.add(ch);
                }

            } else {
                queue.remove(ch);
            }
        }
        char c = '\0';
        if (!queue.isEmpty()) {
             c = queue.poll();
        }else{
            return -1;
        }
        if(map.containsKey(c)){
            return (int)map.get(c);
        }else{
            return -1;
        }
    }

    public static void main(String[] args) {
        FirstUniqueCharacter first = new FirstUniqueCharacter();
        System.out.println(first.firstUniqChar("cc"));
    }
}
