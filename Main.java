import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    static String[] nameSubjects = new String[] {
            "Literature", "History", "Mathematics", "Biology", "Chemistry", "Physics", "Music", "Art", "Informatic"
    };

    public static String uniqueSubjectName(HashSet name_keys) {
        Boolean find_value = false;
        int name_key = 0;
        while(!find_value) {
            name_key = (int) (Math.random() * (nameSubjects.length - 1));
            if (!name_keys.contains(name_key)) {
                find_value = true;
            }
        }
        name_keys.add(name_key);
        return nameSubjects[name_key];
    }
    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("./InputStudent.txt"));
        try {
            String str;
            ArrayList data = new ArrayList<ArrayList>();
            while ((str = reader.readLine()) != null) {
                ArrayList<String> strList = new ArrayList<String>(Arrays.asList(str.split(", ")));
                data.add(strList);
            }
            Student[] students = new Student[data.size()];
            for (int i = 0; i < data.size(); i++) {
                ArrayList student_info = (ArrayList) data.get(i);
                Subject[] subs = new Subject[5];
                HashSet<Integer> sub_name_keys = new HashSet<Integer>();
                for (int j = 0; j < subs.length; j++) {
                    Subject s = new Subject();
                    s.setNameSubject(uniqueSubjectName(sub_name_keys));
                    s.setMark((float) (2 + Math.random() * (5 - 2)));
                    s.setPassed(s.getMark() > 2);
                    subs[j] = s;
                }
                students[i] = new Student((String) student_info.get(0), (String) student_info.get(1), (String) student_info.get(2), subs);
                System.out.println(students[i]);
            }
            System.out.println("Найкращий предмет - " + Utils.getTheBestSubject(students) + "\n");
            Student best_student = Utils.getTheBestStudent(students);
            System.out.println("Найкращий учень - " + best_student.getName() + " " + best_student.getSurname());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (reader != null)
                reader.close();
        }
    }
}
