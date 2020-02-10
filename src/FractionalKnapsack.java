import java.util.*;

public class FractionalKnapsack {
    private int time;
    private int cost;
    private int speed;

    public FractionalKnapsack(int time, int cost, int speed){
        this.time = time;
        this.cost = cost;
        this.speed = speed;
    }

    public static void main(String[] args){
        List<FractionalKnapsack> workers = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int maxArea = in.nextInt();
        int n = in.nextInt();
        for (int i = 0; i < n; i++){
            int time = in.nextInt();
            int cost = in.nextInt();
            int speed = in.nextInt();
            FractionalKnapsack worker = new FractionalKnapsack(time, cost, speed);
            workers.add(worker);
        }
        order(workers);
        System.out.println(totalCost(maxArea, workers));
    }

    public static int totalCost(int maxArea, List<FractionalKnapsack> workers){
        FractionalKnapsack optimumWorker = workers.get(0);
        int totalCost = optimumWorker.cost;
        for (int i = 1; i < workers.size() && maxArea > 0; i++){
            FractionalKnapsack currentWorker = workers.get(i);
            maxArea = maxArea - (currentWorker.time - optimumWorker.time) * optimumWorker.speed;
            if (currentWorker.speed > optimumWorker.speed && maxArea > 0){
                totalCost += currentWorker.cost;
                optimumWorker = currentWorker;
            }
            optimumWorker.time = currentWorker.time;
        }
        return totalCost;
    }


    private static void order(List<FractionalKnapsack> workers) {

        Collections.sort(workers, new Comparator() {

            public int compare(Object o1, Object o2) {

                Integer time1  = ((FractionalKnapsack) o1).time;
                Integer time2 = ((FractionalKnapsack) o2).time;
                int tComp = time1.compareTo(time2);
                if (tComp != 0) {
                    return tComp;
                }
                Integer cost1 = ((FractionalKnapsack) o1).cost;
                Integer cost2 = ((FractionalKnapsack) o2).cost;
                int cComp = cost1.compareTo(cost2);
                if (cComp != 0) {
                    return cComp;
                }
                Integer speed1 = ((FractionalKnapsack) o1).speed;
                Integer speed2 = ((FractionalKnapsack) o2).speed;
                return speed1.compareTo(speed2);
            }});
    }
}
