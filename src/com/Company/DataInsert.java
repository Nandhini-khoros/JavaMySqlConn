package com.Company;
import java.io.*;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
public class DataInsert {


        String url;

    {
        url = "jdbc:mysql://localhost:3306/sample_db";
    }

    String username = "Nandhini";
    String pass = "Nandhini@4";

    public void insert() {
        try {
            Connection conn = DriverManager.getConnection(url, username, pass);
            String s = "INSERT INTO employee VALUES(?,?,?,?,?,?,?,?);";
            PreparedStatement my = conn.prepareStatement(s);
            Scanner scan = new Scanner(System.in);
            System.out.println("enter User id,firstname,lastname,Date,Address,Pincode,phoneno,emailid");
            int id = scan.nextInt();
            scan.nextLine();
            String firstname = scan.nextLine();
            String lastname = scan.nextLine();

            BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
            String str=b.readLine();
            Date d= Date.valueOf(str);
            String Address = scan.nextLine();

            int pincode = scan.nextInt();
            int phoneno = scan.nextInt();

            scan.nextLine();
            String email = scan.nextLine();

            my.setInt(1, id);
            my.setString(2, firstname);
            my.setString(3, lastname);
            my.setDate(4, d);
            my.setString(5,Address);
            my.setInt(6, pincode);
            my.setLong(7, phoneno);
            my.setString(8, email);
            my.executeUpdate();
            System.out.println("Details inserted");
        }
        catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }

}
