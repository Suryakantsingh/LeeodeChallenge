package leetCodeChallenge.may;

public class Straight_Line {

    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates.length == 1){
            return true;
        }
        double m = coordinates[1][1]-coordinates[0][1];
        double n = coordinates[1][0]-coordinates[0][0];
        double gradient = m/n;
        boolean result = false;
        for(int i = 1; i<coordinates.length-1;i++){
           double x = coordinates[i+1][0] - coordinates[i][0];
           double y = coordinates[i+1][1] - coordinates[i][1];
           if((y/x) == gradient){
               result = true;
           }else{
               return false;
           }
        }
       return result;
    }

    public static void main(String[] args) {
        Straight_Line st = new Straight_Line();
        int[][] arr = {{-7,-3},{-7,-1},{-2,-2},{0,-8},{2,-2},{5,-6},{5,-5},{1,7}};
        System.out.println(st.checkStraightLine(arr));
    }
}
