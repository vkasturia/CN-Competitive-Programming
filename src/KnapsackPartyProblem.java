import java.util.*;

public class KnapsackPartyProblem {
    public static void main(String[] args) {
        KnapsackPartyProblem knapsackSolver = new KnapsackPartyProblem();
        Scanner in = new Scanner(System.in);
        int maxWeight = in.nextInt();
        int numberOfItems = in.nextInt();
        while (maxWeight != 0 && numberOfItems != 0) {
            int[] values = new int[numberOfItems + 1];
            int[] weights = new int[numberOfItems + 1];
            weights[0] = 0;
            values[0] = 0;
            for (int i = 1; i <= numberOfItems; i++) {
                weights[i] = in.nextInt();
                values[i] = in.nextInt();
            }
            knapsackSolver.solveKnapsack(numberOfItems, values, weights, maxWeight);
            maxWeight = in.nextInt();
            numberOfItems = in.nextInt();
        }
    }

    public void solveKnapsack(int numberOfItems, int[] values, int[] weights, int maxWeight){
        int[][] memoizationTable = new int[numberOfItems+1][maxWeight+1];
        boolean[][] chosenItems = new boolean[numberOfItems+1][maxWeight+1];

        fill2DArray(memoizationTable, -1);

        for(int i=0; i<memoizationTable[0].length ; i++){
            memoizationTable[0][i]=0;
        }


        for(int i=1; i<=numberOfItems; i++){
            for(int currentCapacity=0; currentCapacity<=maxWeight; currentCapacity++){	// <=
                if(weights[i] > currentCapacity){
                    memoizationTable[i][currentCapacity] = memoizationTable[i-1][currentCapacity];
                }
                else if( (values[i] + memoizationTable[i-1][currentCapacity-weights[i]]) > (memoizationTable[i-1][currentCapacity]) ){
                    memoizationTable[i][currentCapacity] = values[i] + memoizationTable[i-1][currentCapacity-weights[i]];
                    chosenItems[i][currentCapacity]=true;
                }
                else{
                    memoizationTable[i][currentCapacity] = memoizationTable[i-1][currentCapacity];
                }
            }
        }
        //System.out.println("\nKnapsack with weight capacity "+maxWeight+" has optimal value:  "+memoizationTable[numberOfItems][maxWeight]);
        //System.out.println(findOptimalKnapsackContents(maxWeight, memoizationTable, chosenItems));
        System.out.println(findOptimalKnapsackContents(maxWeight, memoizationTable, chosenItems, weights, numberOfItems) + " " + memoizationTable[numberOfItems][maxWeight]);
    }

    //Fill 2d Array with a value (passed by reference)
    public static void fill2DArray(int[][] matrix, int fillValue){
        for(int i=0; i<matrix.length ; i++){
            for(int j=0; j<matrix[i].length ; j++){
                matrix[i][j]= fillValue;
            }
        }
    }

    private String getItemAsString(int itemIndex, int[] values, int[] weights){
        return "Item "+itemIndex+" (Value="+values[itemIndex]+", Weight="+weights[itemIndex]+")";
    }

    private int findOptimalKnapsackContents(int knapsackWeightCapacity, int[][] memoizationTable, boolean[][] chosenItems, int[] weights, int numberOfItems){
        int weightOfItems = 0;
        //System.out.println("_____Knapsack Contains_____");

        int currentCapacity=knapsackWeightCapacity;	//start from bottom right corner of the matrix
        for(int i=numberOfItems; i>=1; i--){
            if(chosenItems[i][currentCapacity]){	//if it was included
                //System.out.println(getItemAsString(i));
                currentCapacity -= weights[i];	//subtract the item's weight for next iteration since we've included an item
                weightOfItems += weights[i];
            }
        }
        return weightOfItems;
    }
}