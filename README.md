# Group: 
SE-2218

# Group Members:
Mukhradinuly Daniyar  
Kadirbekova Anel  
Agdal Zhannur  

# Description of the project.
The topic of the project is a school management system. It allows you to create students, manage their schedule, receive complaints from them and send alerts.  

# Student Class:
Student implements the Observer interface, indicating that instances of this class can receive notifications.  
It has a name attribute and a method update(String Message) to print notifications.  
The class has a StudyStrategy field for different study strategies and methods for setting the strategy (setStudyStrategy) and starting the study (StartStudy).  
Student also uses the decorator pattern with SportsDecorator and MusicDecorator to add sports and music attributes.  

# Notify Class:
Notify is a base class that implements the Observer pattern. It has methods for adding, removing, and notifying observers.  

# StudyStrategy Interface:
StudyStrategy is an interface defining a method study(). This interface is implemented by OfflineStudy and OnlineStudy.  

# StudentDecorator Interface:
StudentDecorator is an interface for decorating a student with additional attributes and enrolling a student.  

# SportsDecorator and MusicDecorator:
Implement the StudentDecorator interface to add sports and music attributes to a student.  

# Observer Interface and Notify Class:
Observer is an interface defining the update(String Message) method for receiving notifications.  
Notify is a class implementing the Observer pattern, used for notifying observers.  

# Main_Course and CourseFactory Interfaces:
Main_Course is an interface for main courses with methods like enrollStudent, start, and getCourseName.  
CourseFactory is an interface for creating different types of courses.  

# MathCourse and SdpCourse Classes:
MathCourse and SdpCourse implement the Main_Course interface, representing different types of main courses.  
They have methods for enrolling students, starting the course, and getting the course name.  

# SdpCourseFactory and MathCourseFactory:
Implement the CourseFactory interface to create instances of SdpCourse and MathCourse respectively.  

# Elective_Course Interface:
Elective_Course is an interface for elective courses with methods for teaching and enrolling students.  

# DesignCourse and ScienceCourse Classes:
DesignCourse and ScienceCourse are external classes representing elective courses.

# DesignCourseAdapter and ScienceCourseAdapter:
Adapters that implement Elective_Course to adapt external courses into the system.
