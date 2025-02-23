package com.example.servlets;

import java.io.IOException;
import java.util.ArrayList;

import com.example.Application.Application;
import com.example.model.Course;
import com.example.model.Student;
import com.example.services.StudentService;
import com.example.services.CourseService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/student")
public class StudentServlet extends HttpServlet {
    private StudentService studentService;

    @Override
    public void init() throws ServletException {
        studentService = (StudentService) Application.getContext().getBean(StudentService.class);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentId = req.getParameter("studentId");
        String studentName = req.getParameter("studentName");
        String studentProgram = req.getParameter("studentProgram");

        String[] courseIds = req.getParameter("courseIds").split(",");

        Student student = new Student(studentId, studentName, studentProgram, new ArrayList<>());

        CourseService cs = new CourseService(studentService.getCourseRepository());

        for (String courseId : courseIds) {
            Course course = cs.getCourse(Integer.parseInt(courseId));

            student.getCourses().add(course);
        }

        studentService.addStudent(student);

        resp.sendRedirect("./");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        studentService.getStudents().forEach(student -> {
            try {
                resp.getWriter().println(student);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    
}
