interface Main_Course {
    void enrollStudent(Student student);
    void start();
    String getCourseName();

}

interface CourseFactory {
    Main_Course createCourse(String courseName);
}

class MathCourse implements Main_Course {
    private String courseName;
    public Student student;

    public MathCourse(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public void enrollStudent(Student student) {
        this.student = student;
        System.out.println(student.getName() + " is enrolled in the Math course: " + courseName);
    }

    @Override
    public void start() {
        System.out.println("Math course has started.");
    }

    @Override
    public String getCourseName() {
        return courseName;
    }
}
class SdpCourse implements Main_Course {
    private String courseName;
    public Student student;

    public SdpCourse(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public void enrollStudent(Student student) {
        this.student = student;
        System.out.println(student.getName() + " is enrolled in the SDP course: " + courseName);
    }

    @Override
    public void start() {
        System.out.println("SDP course has started.");
    }

    @Override
    public String getCourseName() {
        return courseName;
    }
}

class SdpCourseFactory implements CourseFactory {
    @Override
    public Main_Course createCourse(String courseName) {
        return new SdpCourse(courseName);
    }
}
class MathCourseFactory implements CourseFactory {
    @Override
    public Main_Course createCourse(String courseName) {
        return new MathCourse(courseName);
    }
}
