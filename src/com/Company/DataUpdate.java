package com.Company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;
public class DataUpdate {
    String url = "jdbc:mysql://localhost:3306/sample_db";
    String username = "Nandhini";
    String pass = "Nandhini@4";

    public void update() {
        try {
            Connection conn = DriverManager.getConnection(url, username, pass);
            System.out.println("enter user id");
            Scanner sc = new Scanner(System.in);
            int id = sc.nextInt();
            String s = "select * from employee where id=" + id;
            PreparedStatement my = conn.prepareStatement(s);
            ResultSet r = my.executeQuery();
            //my.setInt(1,id);
            //ResultSet r=my.executeQuery();
            if (r.next()) {
                System.out.println("USER EXISTS");
                System.out.println("enter field to be modified:\n" + "1.First name\n" + "2.Last name\n" + "3.Date of birth\n"+"4.Address\n"+"5.Pincode\n"+"6.Contact number\n"+"7.Email id");
                int choice = sc.nextInt();
                String str = null;
                //int p;
                switch (choice) {
                    case 1:
                        System.out.println("enter first name:");
                        sc.nextLine();
                        String fn = sc.nextLine();
                        str = "update employee set firstname=?where id=?";
                        PreparedStatement st = conn.prepareStatement(str);
                        st.setString(1, fn);
                        st.setInt(2, id);
                        st.executeUpdate();
                        break;
                    case 2:
                        System.out.println("enter last name:");
                        sc.nextLine();
                        String ln = sc.nextLine();
                        str = "update employee set lastname=? where id=?";
                        PreparedStatement st1 = conn.prepareStatement(str);
                        st1.setString(1, ln);
                        st1.setInt(2, id);
                        st1.executeUpdate();
                        break;
                    case 3:
                        BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
                        System.out.println("enter Date:");
                        String date=b.readLine();
                        Date d= Date.valueOf(date);
                        str = "update employee set Date=?where id=?";
                        PreparedStatement st2 = conn.prepareStatement(str);
                        //st.setString(a);
                        st2.setDate(1, d);
                        st2.setInt(2, id);
                        st2.executeUpdate();
                        break;
                    case 4:
                        System.out.println("enter address:");
                        sc.nextLine();
                        String add = sc.nextLine();
                        str = "update employee set Address=?where id=?";
                        PreparedStatement st3 = conn.prepareStatement(str);
                        st3.setString(1, add);
                        st3.setInt(2, id);
                        st3.executeUpdate();
                        break;
                    case 5:
                        System.out.println("enter pincode:");
                        int p=sc.nextInt();
                        str = "update employee set pincode=?where id=?";
                        PreparedStatement st4 = conn.prepareStatement(str);
                        st4.setInt(1, p);
                        st4.setInt(2, id);
                        st4.executeUpdate();
                        break;

                    case 6:
                        System.out.println("enter phoneno");
                        long l = sc.nextLong();
                        str = "update employee set phoneno=?where id=?";
                        PreparedStatement st6 = conn.prepareStatement(str);
                        st6.setLong(1, l);
                        st6.setInt(2, id);
                        st6.executeUpdate();
                        break;
                    case 7:
                        System.out.println("enter email id");
                        sc.nextLine();
                        String eid = sc.nextLine();
                        str = "update employee set emailid=?where id=?";
                        PreparedStatement st7 = conn.prepareStatement(str);
                        st7.setString(1, eid);
                        st7.setInt(2, id);
                        st7.executeUpdate();
                        break;


                }
                System.out.println("Details updated ");
            } else {
                System.out.println("INVALID USER");
            }

        }catch (SQLException | IOException throwables) {
            throwables.printStackTrace();
        }
    }
}
