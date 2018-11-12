package servlet;

import bean.employee.Employee;
import bean.employee.EmployeeTable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmployeeTable employeeTable = new EmployeeTable();
        List<Employee> dataList = null;
        try {
            dataList = employeeTable.buildData();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("list", dataList);
        //проверка листа
        String size = String.valueOf(dataList.size());
        request.setAttribute("size", size);

        request.getRequestDispatcher("tableOfEmployees.jsp").forward(request, response);
    }
}
