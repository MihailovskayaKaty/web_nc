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

public class TableServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("addEmployee") != null)
            request.getRequestDispatcher("addEmployee.jsp").forward(request, response);//переход на форму добававления

        EmployeeTable employeeTable = new EmployeeTable();
        String id;
        String sex;
        List<Employee> dataList = null;

        if (request.getParameter("deleteEmployee") != null) {
            id = request.getParameter("removeByID");
            employeeTable.deleteFromDB(Integer.parseInt((id)));
            //перезагружаем БД на страницу после удаления
            try {
                dataList = employeeTable.buildData();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            request.setAttribute("list", dataList);
            String size = String.valueOf(dataList.size());
            request.setAttribute("size", size);
            request.getRequestDispatcher("tableOfEmployees.jsp").forward(request, response);
        }
        //Фильтрация
        if (request.getParameter("filterByMonth") != null) {
            sex = request.getParameter("sexFilterValue");
            request.setAttribute("sex", sex);
            try {
                dataList = employeeTable.buildData();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            request.setAttribute("list", dataList);
            request.getRequestDispatcher("filterRes.jsp").forward(request, response);
        }
    }

}
