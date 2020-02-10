import java.util.Scanner;

public class LightUpBulbs {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        long x = in.nextLong();
        long y = in.nextLong();
        int[] bulbs = new int[n];
        in.nextLine();
        String bulbString = in.nextLine();
        String[] bulbsArray = bulbString.split("");
        for (int i = 0; i < n; i++){
            bulbs[i] = Integer.parseInt(bulbsArray[i]);
        }
        //Find the number of groups of zeros
        int zerosGroups = 0;
        if (bulbs[0] == 0){
            zerosGroups = 1;
        }

        for (int i = 1; i < n-1; i++){
             if (bulbs[i] == 1 && bulbs[i+1] == 0){
                 zerosGroups += 1;
             }
        }
        //Total cost
        long totalcost = (zerosGroups-1)* Math.min(x, y) + y;
        System.out.println(totalcost);
    }
}
