package leetCodeChallenge.may;

public class NumberCompliment {

    public int findComplement(int num) {

        String str = Integer.toBinaryString(num);
        String result = "";

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == '1') {
                result = result+'0';
            } else {
                result = result+'1';
            }
        }

      return Integer.parseInt(result,2);
    }

    public static void main(String[] args) {
        NumberCompliment comp = new NumberCompliment();
        System.out.println(comp.findComplement(5));
    }
}
