public class Student {
    private String name;
    private int number;

    public Student(String name, int number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public boolean equals(Object student) {
        if (this == student) return true; //    是否比较的是同一个对象
        if (student == null) return false;  // 传入对象是否为空
        if (this.getClass() != student.getClass()) return false;    // 是否属于同一个类
        Student another = (Student) student;
        return this.number == another.number && this.name.equals(another.name);
    }
}
