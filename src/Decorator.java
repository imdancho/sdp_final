interface StudentDecorator {
    void decorate();
    void enrollStudent(Student student);
}

class SportsDecorator implements StudentDecorator {
    private Student student;

    public SportsDecorator() {}

    @Override
    public void decorate() {
        student.study();
        System.out.println(student.getName() + " is a sportsman");
    }

    @Override
    public void enrollStudent(Student student) {
        this.student = student;
        System.out.println(student.getName() + " is enrolled in the Sport course");
    }
}
class MusicDecorator implements StudentDecorator {
    private Student student;

    public MusicDecorator() {}

    @Override
    public void decorate() {
        student.study();
        System.out.println(student.getName() + " is a musician");
    }

    @Override
    public void enrollStudent(Student student) {
        this.student = student;
        System.out.println(student.getName() + " is enrolled in the Music course");
    }
}
