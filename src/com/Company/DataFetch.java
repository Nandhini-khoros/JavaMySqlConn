package com.Company;
import java.sql.*;
public class DataFetch {
    String url="jdbc:mysql://localhost:3306/sample_db";
    String username="Nandhini";
    String password="Nandhini@4";
    public void select(){
        try  {
            Connection con = DriverManager.getConnection(url, username, password);
            Statement st = con.createStatement();
            String s="select * from sample_db.employee";
            ResultSet rs = st.executeQuery(s);
            while(rs.next()){
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)+
                        " "+rs.getDate(4)+" "+rs.getString(5)+" "+rs.getInt(6)+
                         " "+rs.getLong(7)+" "+rs.getString(8));
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
