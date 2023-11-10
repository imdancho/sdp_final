import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SchoolManager schoolManager = SchoolManager.getInstance();
        List<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        CourseFactory mathCourseFactory = new MathCourseFactory();
        CourseFactory sdpCourseFactory = new SdpCourseFactory();
        Main_Course mathCourse = mathCourseFactory.createCourse("Algebra");
        Main_Course sdpCourse = sdpCourseFactory.createCourse("Patterns");

        DesignCourse designCourse = new DesignCourse();
        ScienceCourse scienceCourse = new ScienceCourse();
        Elective_Course DesignCourseAdapter = new DesignCourseAdapter(designCourse);
        Elective_Course ScienceCourseAdapter = new ScienceCourseAdapter(scienceCourse);

        StudentDecorator sportsStudent = new SportsDecorator();
        StudentDecorator musicsStudent = new MusicDecorator();

        while (running) {
            System.out.println("Choose an option:");
            System.out.println("0. Enter a complaint for school administration");
            System.out.println("1. Add a new student");
            System.out.println("2. Choose student's education format");
            System.out.println("3. Enroll a student in a course");
            System.out.println("4. Add/Remove a student for notification from the administration");
            System.out.println("5. Make a notification on behalf of the administration");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 0 -> {
                    System.out.print("Enter the complaint's text: ");
                    String complaint_text = scanner.next();
                    schoolManager.setComplaints(complaint_text);
                    System.out.println("List of complaints: \n" + schoolManager.getComplaints());
                }
                case 1 -> {
                    System.out.print("Enter the student's name: ");
                    String studentName = scanner.next();
                    Student newStudent = new Student(studentName);
                    students.add(newStudent);
                    System.out.println("Student " + studentName + " added.");
                }
                case 2 -> {
                    if (students.isEmpty()) {
                        System.out.println("No students. Add a student first.");
                        break;
                    }
                    System.out.println("Select a student:");
                    for (int i = 0; i < students.size(); i++) {
                        System.out.println((i + 1) + ". " + students.get(i).getName());
                    }
                    int studentIndex = scanner.nextInt();
                    Student selectedStudent = students.get(studentIndex - 1);

                    System.out.println("1 - Offline\n2 - Online");
                    int format_choice = scanner.nextInt();
                    if (format_choice == 1) selectedStudent.setStudyStrategy(new OfflineStudy());
                    else if (format_choice == 2) selectedStudent.setStudyStrategy(new OnlineStudy());
                    else {
                        System.out.println("Error");
                        break;
                    }
                    selectedStudent.StartStudy();
                }

                case 3 -> {
                    if (students.isEmpty()) {
                        System.out.println("No students to enroll. Add a student first.");
                        break;
                    }
                    System.out.println("Select a student to enroll:");
                    for (int i = 0; i < students.size(); i++) {
                        System.out.println((i + 1) + ". " + students.get(i).getName());
                    }
                    int studentIndex = scanner.nextInt();
                    Student selectedStudent = students.get(studentIndex - 1);
                    System.out.println("Main courses: \n1 - \"Math\"\n2 - \"SDP\"");
                    System.out.println("Elective courses: \n3 - \"Design\"\n4 - \"Science\"\n5 - \"Music\"\n6 - \"Sport\"");
                    System.out.println("Choose one");
                    int courseChoice = scanner.nextInt();

                    switch (courseChoice) {
                        case 1 -> {
                            mathCourse.enrollStudent(selectedStudent);
                            mathCourse.start();
                        }
                        case 2 -> {
                            sdpCourse.enrollStudent(selectedStudent);
                            sdpCourse.start();
                        }
                        case 3 -> {
                            DesignCourseAdapter.enrollStudent(selectedStudent);
                            DesignCourseAdapter.teach();
                        }
                        case 4 -> {
                            ScienceCourseAdapter.enrollStudent(selectedStudent);
                            ScienceCourseAdapter.teach();
                        }
                        case 5 -> {
                            musicsStudent.enrollStudent(selectedStudent);
                            musicsStudent.decorate();
                        }
                        case 6 -> {
                            sportsStudent.enrollStudent(selectedStudent);
                            sportsStudent.decorate();
                        }
                        default -> System.out.println("Error. Try again.");
                    }
                }

                case 4 -> {
                    if (students.isEmpty()) {
                        System.out.println("No students. Add a student first.");
                        break;
                    }
                    System.out.println("Select a student to add/remove:");
                    for (int i = 0; i < students.size(); i++) {
                        System.out.println((i + 1) + ". " + students.get(i).getName());
                    }
                    int studentIndex = scanner.nextInt();
                    Student selectedStudent = students.get(studentIndex - 1);

                    System.out.println("1 - Add\n2 - Remove");
                    int Choice = scanner.nextInt();

                    switch (Choice) {
                        case 1 -> schoolManager.addObserver(selectedStudent);
                        case 2 -> schoolManager.removeObserver(selectedStudent);
                        default -> System.out.println("Error. Try again.");
                    }
                }
                case 5 -> {
                    System.out.println("Enter a message for students");
                    String message = scanner.next();
                    schoolManager.notifyObserver(message);
                }
                case 6 -> running = false;
                default -> System.out.println("Invalid choice. Try again.");
            }
        }

        scanner.close();
    }
}


//public class Main {
//    public static void main(String[] args) {
//
//        SchoolManager schoolManager = SchoolManager.getInstance();
//
//        Student Shoma = new Student("Shoma");
//        Student Anelya = new Student("Anelya");
//
//        CourseFactory mathCourseFactory = new MathCourseFactory();
//        CourseFactory sdpCourseFactory = new SdpCourseFactory();
//
//        Main_Course mathCourse = mathCourseFactory.createCourse("Algebra");
//        Main_Course sdpCourse = sdpCourseFactory.createCourse("Patterns");
//
//        mathCourse.enrollStudent("Shoma");
//        sdpCourse.enrollStudent("Anelya");
//
//        mathCourse.start();
//        sdpCourse.start();
//
//        System.out.println("-----------------------------------");
//
//        DesignCourse designCourse = new DesignCourse();
//        ScienceCourse scienceCourse = new ScienceCourse();
//
//        Elective_Course DesignCourseAdapter = new DesignCourseAdapter(designCourse);
//        Elective_Course scienceCourseAdapter = new ScienceCourseAdapter(scienceCourse);
//
//        DesignCourseAdapter.teach();
//        scienceCourseAdapter.teach();
//
//        System.out.println("-----------------------------------");
//
//        StudentDecorator sportsStudent = new SportsDecorator(Shoma);
//        StudentDecorator musicsStudent = new MusicDecorator(Shoma) ;
//        SDPDecorator SDPStudent = new SDPDecorator(Shoma) ;
//
//        System.out.println("Shoma's normal day:");
//        Shoma.study();
//
//        System.out.println("\nShoma's day with sports:");
//        sportsStudent.decorate();
//
//        System.out.println("\nShoma's day with music:");
//        musicsStudent.decorate();
//
//        System.out.println("\nShoma's day with SDP:");
//        SDPStudent.decorate();
//
//        System.out.println("-----------------------------------");
//
//        SchoolSubject sdp = new SchoolSubject("sdp");
//
//        sdp.addObserver(Shoma);
//        sdp.addObserver(Anelya);
//
//        sdp.notifyObserver("First message");
//
//        sdp.removeObserver(Anelya);
//
//        sdp.notifyObserver("Second message");
//
//        System.out.println("-----------------------------------");
//
//        Student student = new Student("qaz");
//        student.setStudyStrategy(new OfflineStudy());
//        student.StartStudy();
//    }
//}