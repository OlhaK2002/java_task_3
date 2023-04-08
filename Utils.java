import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Utils {
    public static String getTheBestSubject(Student[] students) {
        HashMap<String, Float> subject_mark = new HashMap<String, Float>();
        HashMap<String, Integer> subject_count = new HashMap<String, Integer>();
        for (Student stud:students) {
            Subject[] subjects =  stud.getSubjects();
            for (Subject sub:subjects) {
                String name_sub = sub.getNameSubject();
                if (subject_mark.containsKey(name_sub)) {
                    subject_mark.put(name_sub, subject_mark.get(name_sub) +  sub.getMark());
                    subject_count.put(name_sub, subject_count.get(name_sub) +  1);
                } else {
                    subject_mark.put(name_sub, sub.getMark());
                    subject_count.put(name_sub, 1);
                }
            }
        }
        float best_mark_value = 0.0F;
        String best_mark = "";
        Set<Map.Entry<String, Float>> set = subject_mark.entrySet();
        for (Map.Entry<String, Float> subj_val: set) {
            String key_value = subj_val.getKey();;
            float std_count_value = subject_count.get(key_value);
            float sub_mark_value = subj_val.getValue();
            float av_mark_value = sub_mark_value / std_count_value;
            if (av_mark_value > best_mark_value) {
                best_mark_value = av_mark_value;
                best_mark = key_value;
            }
        }
        return best_mark;
    }

    public static Student getTheBestStudent(Student[] students) {
        float best_mark = 0;
        Student best_student = new Student();
        for (Student student: students) {
            if (student.getAverageMark() > best_mark) {
                best_mark = student.getAverageMark();
                best_student = student;
            }
        }
        return best_student;
    }

}
