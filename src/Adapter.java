interface Elective_Course {
    void teach();
    void enrollStudent(Student student);

}

class DesignCourse {
    public void teachDesign() {
        System.out.println("This is Design course!!!!!!!!!!");
    }
}

class ScienceCourse {
    public void teachScience() {
        System.out.println("This is Science course!!!!!!!!!!");
    }
}

class DesignCourseAdapter implements Elective_Course {
    private final DesignCourse designCourse;
    public Student student;

    public DesignCourseAdapter(DesignCourse designCourse) {
        this.designCourse = designCourse;
    }

    @Override
    public void teach() {
        designCourse.teachDesign();
    }

    @Override
    public void enrollStudent(Student student) {
        this.student = student;
        System.out.println(student.getName() + " is enrolled in the Design course");
    }
}

class ScienceCourseAdapter implements Elective_Course {
    private final ScienceCourse scienceCourse;
    public Student student;


    public ScienceCourseAdapter(ScienceCourse scienceCourse) {
        this.scienceCourse = scienceCourse;
    }

    @Override
    public void teach() {
        scienceCourse.teachScience();
    }

    @Override
    public void enrollStudent(Student student) {
        this.student = student;
        System.out.println(student.getName() + " is enrolled in the Science course");
    }
}