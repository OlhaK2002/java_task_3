import java.util.Arrays;

public class Student {
    int id;
    static int nextId = 1;
    String name, surname, group;
    Subject[] subjects;

    public Student() {}

    public Student(String name, String surname, String group, Subject[] subjects) {
        this.id = nextId++;
        this.name = name;
        this.surname = surname;
        this.group = group;
        this.subjects = subjects;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Subject[] getSubjects() {
        return subjects;
    }

    public String getSubjectsString() {
        return subjects.toString();
    }

    public void setSubjects(Subject[] subjects) {
        this.subjects = subjects;
    }

    public float getAverageMark() {
        float sum = 0;
        Subject[] subj = getSubjects();
        for (int i = 0; i < subj.length; i++) {
            sum += subj[i].getMark();
        }
        return sum / subj.length;
    }

    public String getStipend() {
        float av_mark = getAverageMark();
        if (av_mark > 4.0 && av_mark < 4.9) {
            return "звичайна";
        } else if (av_mark >= 5.0) {
            return "підвищена";
        }
         return "відсутня";
    }

    public String toString() {

        return getName() + " " + getSurname() + "\n Предмети: " + Arrays.toString(getSubjects()) + "\n Середній бал - " + getAverageMark() + "\n Стипендія - " + getStipend();
    }


}
