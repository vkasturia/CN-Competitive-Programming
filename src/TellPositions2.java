import java.util.*;

public class TellPositions2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();

        List<Student> studentList = new ArrayList<Student>(n);

        for (int i = 0; i < n; i++){
            String line = in.nextLine();
            String[] studentDetails = line.split("\\s");
            int studentMarks = Integer.parseInt(studentDetails[1]) + Integer.parseInt(studentDetails[2]) + Integer.parseInt(studentDetails[3]);
            studentList.add(new Student(studentDetails[0], n-i, studentMarks));
        }

        //System.out.println("pre-sorting");
        //System.out.println(studentList);
        //System.out.println();

        Collections.sort(studentList, Comparator.comparing(Student::getMarks)
                .thenComparing(Student::getId).reversed());

        //System.out.println("post-sorting");
        int j = 1 ;
        for (Student s : studentList){
            System.out.println(j + " " + s.getName());
            j++;
        }
    }

    private static class Student {

        private String name;
        private int id;
        private int marks;

        public Student(String name, int id, int marks) {
            this.name = name;
            this.id = id;
            this.marks = marks;
        }

        public String getName() {
            return name;
        }


        public int getId() {
            return id;
        }

        public int getMarks() {
            return marks;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}