package leetCodeChallenge.may;



public class Trie {

    static final int alph = 26;
  static Trie[] child = new Trie[alph];
    boolean isEndofWord;

    static Trie root;

    public Trie() {

        isEndofWord = false;
        for(int i = 0; i < alph;i++){
            child[i] = null;
        }

    }

    public void insert(String word){

        int length = word.length();
        int index;
        Trie temp = root;
        for( int i=0 ; i<length ; i++){
            index = word.charAt(i) - 'a';

            if(child[index] == null){
                child[index] = new Trie();
            }
             temp = child[index];
        }
        temp.isEndofWord = true;
    }
    public boolean search( String key ) {
        int length = key.length();
        int index;
        Trie temp = root;

        for( int i = 0; i < length ; i++){

            index = key.charAt(i)-'a';
            if(child[index] == null)
                return false;

            temp = child[index];

        }
       return (temp!= null && temp.isEndofWord);
    }
    public static void main(String[] args){
        Trie tri = new Trie();
        tri.insert("surya");
        System.out.println(tri.search("surya"));
    }
}
