
package service;

import DAO.StudentDAO;
import controller.Student;
import model.Student1;
import java.util.List;

public class StudentService {
    private StudentDAO dao = new StudentDAO();

    public boolean saveStudent(Student1 s) {
        return dao.addStudent(s);
    }

    public List<Student1> fetchAllStudents() {
        return dao.getAllStudents();
    }

    public boolean updateStudent(Student1 s) {
        return dao.updateStudent(s);
    }

    public boolean deleteStudent(int rollNo) {
        return dao.deleteStudent(rollNo);
    }
}

