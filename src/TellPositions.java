import java.util.*;

public class TellPositions {
    public static <K, V extends Comparable<V>> Map<K, V>
    sortByValues(final Map<K, V> student_studentmarks_map, Map<String, Integer> student_studentid_map) {
        Comparator<K> valueComparator = new Comparator<K>() {
            public int compare(K k1, K k2) {
                int compare =
                        student_studentmarks_map.get(k1).compareTo(student_studentmarks_map.get(k2));
                if (compare == 0) {
                    if (student_studentid_map.get(k1) > student_studentid_map.get(k2)){
                        return 1;
                    }
                    return -1;
                }
                else if(compare == 1){
                    return -1;
                }
                else
                    return 1;
            }
        };

        Map<K, V> sortedByValues =
                new TreeMap<K, V>(valueComparator);
        sortedByValues.putAll(student_studentmarks_map);
        return sortedByValues;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        Map<String, Integer> student_studentid_map = new HashMap<>();
        TreeMap<String, Integer> student_studentmarks_map = new TreeMap<String, Integer>();

        for (int i = 0; i < n; i++){
            String line = in.nextLine();
            String[] studentDetails = line.split("\\s");
            student_studentid_map.put(studentDetails[0]+(i+10000), i+1);
            int studentMarks = Integer.parseInt(studentDetails[1]) + Integer.parseInt(studentDetails[2]) + Integer.parseInt(studentDetails[3]);
            student_studentmarks_map.put(studentDetails[0]+(i+10000), studentMarks);
        }

        Map<String, Integer> sortedMap = sortByValues(student_studentmarks_map, student_studentid_map);
        int i = 1;
        for (Map.Entry<String, Integer> entry : sortedMap.entrySet()){
            int length = entry.getKey().length();
            System.out.println(i + " " + entry.getKey().substring(0, length - 5));
            i++;
        }
    }
}
