package com.example.servlets;

import java.io.IOException;

import com.example.model.Course;
import com.example.repositories.CourseRepository;
import com.example.services.CourseService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/course")
public class CourseServlet extends HttpServlet {
    CourseService courseService;

    @Override
    public void init() throws ServletException {
        courseService = new CourseService(new CourseRepository());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String courseId = req.getParameter("courseId");
        String courseName = req.getParameter("courseName");
        String professorName = req.getParameter("professorName");
        String schedule = req.getParameter("schedule");

        Course course = courseService.createCourse(Integer.parseInt(courseId), courseName, professorName, schedule);

        courseService.addCourse(course);

        resp.sendRedirect("./");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        courseService.getCourses().forEach(course -> {
            try {
                resp.getWriter().println(course);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}
