package com.Company;
import java.sql.*;
import java.util.Scanner;
public class DataDelete {
    String url = "jdbc:mysql://localhost:3306/sample_db";
    String username = "Nandhini";
    String pass = "Nandhini@4";

    public void delete() {
        try {
            Connection conn = DriverManager.getConnection(url, username, pass);
            System.out.println("enter user id ");
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            String s = "select * from employee where id=" + id;
            PreparedStatement my = conn.prepareStatement(s);
            ResultSet r = my.executeQuery();
            if (r.next()) {
                String str = "delete from employee where id="+id;
                PreparedStatement st = conn.prepareStatement(str);
                st.executeUpdate();
                System.out.println("deleted successfully");
            } else {
                System.out.println("Invalid user");
            }
        }

        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
