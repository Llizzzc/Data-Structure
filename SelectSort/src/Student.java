public class Student implements Comparable<Student> {
    private String name;
    private int number;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student another) {
//        if (this.score < another.score)
//            return -1;
//        else if (this.score > another.score)
//            return 1;
//        return 0;
        return this.score - another.score;
    }

    @Override
    public boolean equals(Object student) {
        if (this == student) return true; //    是否比较的是同一个对象
        if (student == null) return false;  // 传入对象是否为空
        if (this.getClass() != student.getClass()) return false;    // 是否属于同一个类
        Student another = (Student) student;
        return this.number == another.number && this.name.equals(another.name);
    }

    @Override
    public String toString() {
        return String.format("Student(name: %s, score: %d)", name, score);
    }
}
