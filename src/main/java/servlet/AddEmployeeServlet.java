package servlet;

import bean.employee.EmployeeTable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;


public class AddEmployeeServlet extends HttpServlet {
    @Override
    protected  void  doGet (HttpServletRequest request, HttpServletResponse response){

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeTable employeeTable = new EmployeeTable();
        String surname;
        String name;
        String lastName;
        String sex;
        String birthDate;
        String address;
        String post;

        surname = req.getParameter("surname");
        name = req.getParameter("name");
        lastName = req.getParameter("lastName");
        sex = req.getParameter("sex");
        birthDate = req.getParameter("birthDate");
        address = req.getParameter("address");
        post = req.getParameter("post");

        employeeTable.insertIntoDB(surname, name, lastName, sex, LocalDate.parse(birthDate), address, post);

        if (req.getParameter("record") != null) req.getRequestDispatcher("/MyServlet").forward(req, resp);
    }
}
