package controller;

import service.StudentService;
import DAO.StudentDAO;
import  model.Student1;
import java.util.*;

public class Student {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();
        int choice;

        do {
            System.out.println("\n==== Student Management Menu ====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    Student1 s = new Student1();
                    System.out.print("Roll No: "); s.setRollNo(sc.nextInt());
                    sc.nextLine();
                    System.out.print("Name: "); s.setName(sc.nextLine());
                    System.out.print("Marks: "); s.setMarks(sc.nextDouble());
                    sc.nextLine();
                    System.out.print("Course: "); s.setCourse(sc.nextLine());
                    System.out.print("Address: "); s.setAddress(sc.nextLine());
                    System.out.print("Class: "); s.setClassName(sc.nextLine());
                    System.out.print("City: "); s.setCity(sc.nextLine());
                    System.out.print("College: "); s.setCollegeName(sc.nextLine());

                    System.out.println(service.saveStudent(s) ? "✅ Student added" : "❌ Failed to add student");
                    break;

                case 2:
                    List<Student1> list = service.fetchAllStudents();
                    System.out.println("Roll\tName\tMarks\tCourse\tClass\tCity\tCollege");
                    for (Student1 stu : list) {
                        System.out.println(stu.getRollNo() + "\t" + stu.getName() + "\t" + stu.getMarks() + "\t" + stu.getCourse() + "\t" + stu.getClassName() + "\t" + stu.getCity() + "\t" + stu.getCollegeName());
                    }
                    break;

                case 3:
                    System.out.print("Enter Roll No to update: ");
                    int rnoUpdate = sc.nextInt();
                    sc.nextLine();
                    Student1 u = new Student1();
                    u.setRollNo(rnoUpdate);
                    System.out.print("Name: "); u.setName(sc.nextLine());
                    System.out.print("Marks: "); u.setMarks(sc.nextDouble());
                    sc.nextLine();
                    System.out.print("Course: "); u.setCourse(sc.nextLine());
                    System.out.print("Address: "); u.setAddress(sc.nextLine());
                    System.out.print("Class: "); u.setClassName(sc.nextLine());
                    System.out.print("City: "); u.setCity(sc.nextLine());
                    System.out.print("College: "); u.setCollegeName(sc.nextLine());
                    System.out.println(service.updateStudent(u) ? "✅ Student updated" : "❌ Update failed");
                    break;

                case 4:
                    System.out.print("Enter Roll No to delete: ");
                    int rnoDelete = sc.nextInt();
                    System.out.println(service.deleteStudent(rnoDelete) ? "✅ Student deleted" : "❌ Delete failed");
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 5);
        sc.close();
    }
}
