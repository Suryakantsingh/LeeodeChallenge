/*
Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array

*/
public class Counting_Bits {

    public int[] countBits(int num) {
        int[] result = new int[num+1];

        for (int i = 0; i <= num; i++) {
            int count = 0;
            String str = Integer.toBinaryString(i);

            for (int j = 0; j < str.length(); j++) {

                if (str.charAt(j) == '1') {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }

    public static void main(String[] args) {
        Counting_Bits bit = new Counting_Bits();
        bit.countBits(5);
    }
}
