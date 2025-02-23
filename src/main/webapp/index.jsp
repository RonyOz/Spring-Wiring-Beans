<%@ page import="org.springframework.context.ApplicationContext" %>
<%@ page import="org.springframework.context.support.ClassPathXmlApplicationContext" %>
<%@ page import="com.example.services.CourseService" %>
<%@ page import="com.example.services.StudentService" %>
<%@ page import="com.example.model.Course" %> 
<%@ page import="com.example.model.Student" %> 
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>

<html>
  <head>
      <title>Version XML</title>
  </head>
  <body>

    <!-- Courses List -->
    <section>
      <h2>Courses List</h2>
      <ul>
        <%
          ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
          CourseService cs = (CourseService) ctx.getBean("courseService");

          for (Course course : cs.getCourses()) {
            out.println("<li>" + course.toString() + "</li>");
          }
        %>
      </ul>
    </section>

    <!-- Form -->
    <form action="course" method="post">
      <fieldset>
        <legend>Register Course</legend>

        <label for="courseId">Course ID:</label>
        <input type="number" id="courseId" name="courseId" required>

        <label for="courseName">Course Name:</label>
        <input type="text" id="courseName" name="courseName">

        <label for="professorName">Professor Name:</label>
        <input type="text" id="professorName" name="professorName">

        <label for="schedule">Schedule:</label>
        <input type="text" id="schedule" name="schedule">

        <button type="submit">Register Course</button>
      </fieldset>
    </form>

    
    <!-- Students List -->
    <section>
      <h2>Students List</h2>
      <ul >
        <%
          StudentService ss = (StudentService) ctx.getBean("studentService");

          for (Student student : ss.getStudents()) {
            out.println("<li>" + student.toString() + "</li>");
          }
        %>
      </ul>
    </section>

    <!-- Form -->
    <form action="student" method="post">
      <fieldset>
        <legend>Add Student</legend>

        <label for="studentId">Student ID:</label>
        <input type="text" id="studentId" name="studentId" required>

        <label for="studentName">Student Name:</label>
        <input type="text" id="studentName" name="studentName" >

        <label for="studentProgram">Student Program:</label>
        <input type="text" id="studentProgram" name="studentProgram" >

        <label for="courseIds">Course IDs:</label>
        <input type="number" id="courseIds" name="courseIds" required>

        <button type="submit">Register Student</button>
      </fieldset>
    </form>

  </body>
</html>