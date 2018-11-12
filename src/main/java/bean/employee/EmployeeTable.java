package bean.employee;

import DBConnector.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;


public class EmployeeTable {
    //TABLE VIEW AND DATA
    Connection connection;


    public EmployeeTable() { // связь с бд
        DBConnector dbConnector = new DBConnector();
        dbConnector.init();
        connection = dbConnector.getConnection();
    }

    public ArrayList<Employee> buildData() throws SQLException {
        ArrayList<Employee> list = new ArrayList<Employee>();
        try {
            String sql = "SELECT * FROM workers";
            ResultSet rs = connection.createStatement().executeQuery(sql);

            while (rs.next()) {
                Employee employee = new Employee();
                employee.setIdworkers(rs.getInt("idworkers"));
                employee.setName(rs.getString("name"));
                employee.setSurname(rs.getString("surname"));
                employee.setLastName(rs.getString("lastname"));
                employee.setSex(rs.getString("sex"));
                employee.setBirthDate(rs.getDate("birthday").toLocalDate());
                employee.setAddress(rs.getString("address"));
                employee.setPost(rs.getString("post"));
                list.add(employee);
            }

        } catch (Exception e) {
            e.printStackTrace();
            close();
        }
        return list;
    }

    public void insertIntoDB(String surname, String name, String lastname, String sex, LocalDate birthday,
                             String address, String post) {
        String sql = "INSERT INTO workers(surname, name, lastname, sex, birthday, address, post)"
                + "VALUES(?,?,?,?,?,?,?)";
        try {

            PreparedStatement statement = connection.prepareStatement(sql);
            setFieldsForDBWorker(statement, surname, name, lastname, sex, birthday, address, post);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            close();
        }

    }

    public void deleteFromDB(int id) {
        String sql = "DELETE FROM workers WHERE idworkers = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            close();
        }
    }

    public void updateDBAfterEdit(String surname, String name, String lastname, String sex, LocalDate birthday,
                                  String address, String post,  int id) {
        String sql = "UPDATE workers SET surname = ?, name = ?, lastname = ?, sex = ?, birthday = ?, address = ?, post = ?,  WHERE idworkers = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            setFieldsForDBWorker(statement, surname, name, lastname, sex, birthday, address, post);
            statement.setInt(8, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            close();
        }
    }

    public void setFieldsForDBWorker(PreparedStatement statement, String surname, String name, String lastname, String sex, LocalDate birthday,
                                     String address, String post) {
        try {
            statement.setString(1, surname);
            statement.setString(2, name);
            statement.setString(3, lastname);
            statement.setString(4, sex);
            statement.setDate(5, java.sql.Date.valueOf(birthday));
            statement.setString(6, address);
            statement.setString(7, post);
        } catch (SQLException e) {
            e.printStackTrace();
            close();
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}
