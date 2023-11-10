public class Student implements Observer{
    private String name;

    @Override
    public void update(String Message) {
        System.out.println(name + " got notification from administration, update: " + Message);
    }



    public Student(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void study() {
        System.out.println("Student name: " + name);
    }



    private StudyStrategy studyStrategy;
    public void setStudyStrategy(StudyStrategy studyStrategy) {
        this.studyStrategy = studyStrategy;
    }
    public void StartStudy() {
        studyStrategy.study();
    }
}
