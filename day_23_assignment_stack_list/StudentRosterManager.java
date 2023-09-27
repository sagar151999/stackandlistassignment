package day_23_assignment_stack_list;

import java.util.ArrayList;
import java.util.Scanner;

class Course {
    private String courseId;
    private String courseName;
    private String semester;

    public Course(String courseId, String courseName, String semester) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.semester = semester;
    }

    @Override
    public String toString() {
        return "Course ID: " + courseId + ", Course Name: " + courseName + ", Semester: " + semester;
    }
}

class Student {
    private String studentId;
    private String name;
    private ArrayList<Course> enrolledCourses = new ArrayList<>();

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
    }

    public void enrollCourse(Course course) {
        enrolledCourses.add(course);
    }

    @Override
    public String toString() {
        StringBuilder coursesString = new StringBuilder();
        for (Course course : enrolledCourses) {
            coursesString.append("\n").append(course.toString());
        }
        return "Student ID: " + studentId + ", Name: " + name + "\nEnrolled Courses:" + coursesString.toString();
    }
}

public class StudentRosterManager {
    private ArrayList<Student> studentRoster = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        StudentRosterManager manager = new StudentRosterManager();
        manager.run();
    }

    public void run() {
        int choice;
        do {
            System.out.println("\nStudent Roster Management System");
            System.out.println("1. Add a new student");
            System.out.println("2. Enroll a student in a course");
            System.out.println("3. Display list of courses a student is enrolled in");
            System.out.println("4. Display list of students in the roster");
            System.out.println("5. Remove a student by ID");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addNewStudent();
                    break;
                case 2:
                    enrollStudentInCourse();
                    break;
                case 3:
                    displayCoursesForStudent();
                    break;
                case 4:
                    displayStudentRoster();
                    break;
                case 5:
                    removeStudentById();
                    break;
                case 6:
                    System.out.println("Exiting the program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 6);
    }

    private void addNewStudent() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        Student newStudent = new Student(studentId, name);
        studentRoster.add(newStudent);
        System.out.println("Student added successfully.");
    }

    private void enrollStudentInCourse() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        Student student = findStudentById(studentId);
        if (student == null) {
            System.out.println("Student not found.");
            return;
        }
        System.out.print("Enter course ID: ");
        String courseId = scanner.nextLine();
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();
        System.out.print("Enter semester: ");
        String semester = scanner.nextLine();
        Course course = new Course(courseId, courseName, semester);
        student.enrollCourse(course);
        System.out.println("Student enrolled in the course successfully.");
    }

    private void displayCoursesForStudent() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        Student student = findStudentById(studentId);
        if (student == null) {
            System.out.println("Student not found.");
        } else {
            System.out.println("Courses enrolled by student with ID " + studentId + ":");
            System.out.println(student);
        }
    }

    private void displayStudentRoster() {
        System.out.println("Student Roster:");
        for (Student student : studentRoster) {
            System.out.println(student);
        }
    }

    private void removeStudentById() {
        System.out.print("Enter student ID to remove: ");
        String studentId = scanner.nextLine();
        Student student = findStudentById(studentId);
        if (student == null) {
            System.out.println("Student not found.");
        } else {
            studentRoster.remove(student);
            System.out.println("Student removed successfully.");
        }
    }

    private Student findStudentById(String studentId) {
        for (Student student : studentRoster) {
            if (studentId.equals(student.toString())) {
                return student;
            }
        }
        return null;
    }
}
