package com.Company;
import java.sql.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws SQLException {
        Scanner s=new Scanner(System.in);
        int a=s.nextInt();
        System.out.println("enter operation");
        switch (a){
            case 1:
                DataInsert i=new DataInsert();
                i.insert();
                break;
            case 2:
                DataDelete d=new DataDelete();
                d.delete();
                break;
            case 3:
                DataUpdate u=new DataUpdate();
                u.update();
                break;
            case 4:
                DataFetch k=new DataFetch();
                k.select();
                break;
            default:
                break;

        }
    }
}
