import java.util.*;

public class ActivitySelection {
    private int startTime;
    private int endTime;

    public ActivitySelection(int startTime, int endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }
    public static void main(String[] args){
        List<ActivitySelection> activities = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++){
            int startTime = in.nextInt();
            int endTime = in.nextInt();
            ActivitySelection activity = new ActivitySelection(startTime, endTime);
            activities.add(activity);
        }
        order(activities);
        System.out.println(numberOfActivities(activities));
    }

    public static int numberOfActivities(List<ActivitySelection> activities){
        int count = 1;
        int lastEndTime = activities.get(0).endTime;
        for (int i = 1; i < activities.size(); i++){
            if (activities.get(i).startTime > lastEndTime){
                lastEndTime = activities.get(i).endTime;
                count++;
            }
        }
        return count;
    }

    private static void order(List<ActivitySelection> activities) {

        Collections.sort(activities, new Comparator() {

            public int compare(Object o1, Object o2) {

                Integer endTime1  = ((ActivitySelection) o1).endTime;
                Integer endTime2 = ((ActivitySelection) o2).endTime;
                int sComp = endTime1.compareTo(endTime2);

                if (sComp != 0) {
                    return sComp;
                }

                Integer startTime1 = ((ActivitySelection) o1).startTime;
                Integer startTime2 = ((ActivitySelection) o2).startTime;
                return startTime1.compareTo(startTime2);
            }});
    }
}
