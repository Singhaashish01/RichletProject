package com.iispl.exercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DBConnection {
	

	    private static final String URL = "jdbc:mysql://localhost:3306/Exercisedb";
	    private static final String USER = "root";
	    private static final String PASS = "root123";

	    public List<Student> getAllStudents() {
	        List<Student> list = new ArrayList<>();

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection(URL, USER, PASS);

	            String sql = "SELECT * FROM student";
	            PreparedStatement ps = con.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	                Student s = new Student(
	                    rs.getInt("id"),
	                    rs.getString("student_name"),
	                    rs.getInt("marks")
	                );
	                list.add(s);
	            }

	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return list;
	    }
	    
	    public boolean deleteStudent(int id) {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection(URL, USER, PASS);

                String sql = "DELETE FROM student WHERE id = ?";
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setInt(1, id);

                int rows = pstmt.executeUpdate();
                con.close();

                return rows > 0;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
	}
