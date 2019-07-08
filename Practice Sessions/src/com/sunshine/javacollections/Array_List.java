package com.sunshine.javacollections;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

public class Array_List implements ArrLst_Interface {
	private ArrayList<Integer> numbers;
	private Properties prop;
	private FileReader fr;
	private FileWriter fw;
	private Connection con;
	private Scanner sn;
	public Array_List() {
		numbers=new ArrayList<Integer>();
	}
	
	public Array_List(String filename) {
		numbers=new ArrayList<Integer>();
		try {
				System.setProperty("userdir", "//home//nagesh//Projects//Java//Practice Sessions");
				fr=new FileReader(System.getProperty("userdir")+"//src//"+filename+".properties");
				//System.out.println(fr);
			
		} catch (FileNotFoundException e) {
			System.out.println("The file Specified is not available,Want to create?");
			System.out.println("Enter 1 to create 0 to exit");
			int ch=sn.nextInt();
			if(ch==1) {
				try {
					fw=new FileWriter((new File(filename)));
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}else if(ch==0) {
				System.exit(0);
			}
		}
		prop=new Properties();
		
	}
	
	public Array_List(String host,String dbname,String portno,String filename) {
		numbers=new ArrayList<Integer>();
		prop=new Properties();
		try {
			System.setProperty("userdir", "//home//nagesh//Projects//Java//Practice Sessions");
			fr=new FileReader(System.getProperty("userdir")+"//src//"+filename+".properties");
			prop.load(fr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://"+host+":"+portno+"/"+dbname,prop.getProperty("uname"),prop.getProperty("pass"));
			if(con.isValid(20)) {
				System.out.println("Connection is established");
			}else {
				System.out.println("Connection is not established");
			}
		} catch (ClassNotFoundException cnfe) {
			System.out.println("Class Not Found");
		}catch(SQLException sqle) {
			System.out.println("Database is not connected..");
		}
	}
	
	public void storeDataInArrayList(int data) {
		numbers.add(data);
		if(numbers.size()>0) {
			System.out.println("Data is Stored");
		}else {
			System.out.println("Data is Not Stored");
		}
	}
	
	public void storeDataInArrayListFromAnother(ArrayList<Integer> num) {
		numbers=num;
		if(numbers.size()>0) {
			System.out.println("Data is Stored from another list");
			numbers.set(0, 235106);
		}else {
			System.out.println("Data is Not Stored");
		}
	}
	
	public void storeDataFromPropertiesFile(String property) {		
		
		try {
			prop.load(fr);
			numbers.add(Integer.parseInt(prop.getProperty(property)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(numbers.size()>0) {
			System.out.println("Data is Stored from Properties File");
			numbers.set(0, 235107);
		}else {
			System.out.println("Data is Not Stored");
		}
	}
	
	public void storeDataFromDatabase(String tabname) {
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("SELECT * FROM "+tabname);
			while(rs.next()) {
				numbers.add(Integer.parseInt(rs.getString("task_id")));
			}
			System.out.println("Data Is Stored a Database");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(NullPointerException npe) {
			System.out.println("No Data..");
		}
	}
	
	public void testData() {
		System.setProperty("userdir", "//home//nagesh//Projects//Java//Practice Sessions");
		System.out.println(System.getProperty("userdir"));
	}
	public ArrayList<Integer> getDataFromArrayList(){
		return numbers;
	}
}