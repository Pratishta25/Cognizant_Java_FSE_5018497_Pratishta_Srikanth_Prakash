package com.example.mvcpattern;

public class MVCPatternTest {
    public static void main(String[] args) {
        // Create a student
        Student student = new Student("1", "John Doe", "A");

        // Create a view
        StudentView view = new StudentView();

        // Create a controller
        StudentController controller = new StudentController(student, view);

        // Display the initial student details
        controller.updateView();

        // Update student details
        controller.setStudentName("Jane Smith");
        controller.setStudentGrade("B");

        // Display the updated student details
        controller.updateView();
    }
}
