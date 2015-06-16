
import java.sql.*;
import java.util.ArrayList;


public class JDBC {

ArrayList<String> WhatList, WhenList, WhereList, HowMuchList, ImagePath;

		   // JDBC driver name and database URL
		   final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		   final String DB_URL = "jdbc:mysql://localhost/";
		   final String DB_URL2 = "jdbc:mysql://localhost/STUDENTS";
		   
		   //  Database credentials
		   final String USER = "root";
		   final String PASS = "";

		   
		   
		   public void createDB() {
			   Connection conn = null;
			   Statement stmt = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);

		      //STEP 4: Execute a query
		      System.out.println("Creating database...");
		      stmt = conn.createStatement();
		      
		      String sql = "CREATE DATABASE IF NOT EXISTS STUDENTS";
		      stmt.executeUpdate(sql);
		      System.out.println("Database created successfully...");
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            stmt.close();
		      }catch(SQLException se2){
		      }// nothing we can do
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   System.out.println("Goodbye!");
		}//end main

		   
		   
		   public void createTable() {
			   Connection conn = null;
			   Statement stmt = null;
			      try{
			         //STEP 2: Register JDBC driver
			         Class.forName("com.mysql.jdbc.Driver");


			         //STEP 3: Open a connection
			         System.out.println("Connecting to a selected database...");
			         conn = DriverManager.getConnection(DB_URL2, USER, PASS);
			         System.out.println("Connected database successfully...");
			         
			         //STEP 4: Execute a query
			         System.out.println("Creating table in given database...");
			         stmt = conn.createStatement();
			         
			         String sql = "CREATE TABLE IF NOT EXISTS REGISTRATION" +
			                      "(id INTEGER not NULL, " +
			                      " var1 VARCHAR(255), " + 
			                      " var2 VARCHAR(255), " + 
			                      " var3 VARCHAR(255), " +
			                      " var4 VARCHAR(255), " +
			                      " var5 VARCHAR(255), " +
			                      " PRIMARY KEY ( id ))"; 

			         stmt.executeUpdate(sql);
			         System.out.println("Created table in given database...");
			      }catch(SQLException se){
			         //Handle errors for JDBC
			         se.printStackTrace();
			      }catch(Exception e){
			         //Handle errors for Class.forName
			         e.printStackTrace();
			      }finally{
			         //finally block used to close resources
			         try{
			            if(stmt!=null)
			               conn.close();
			         }catch(SQLException se){
			         }// do nothing
			         try{
			            if(conn!=null)
			               conn.close();
			         }catch(SQLException se){
			            se.printStackTrace();
			         }//end finally try
			      }//end try
			      System.out.println("Goodbye!");
			   }//end main
		   
		  
		   
		   public void insertRecord(){
			   Connection conn = null;
			   Statement stmt = null;
			   try{
			      //STEP 2: Register JDBC driver
			      Class.forName("com.mysql.jdbc.Driver");
			      
			      
			      //STEP 3: Open a connection
			      System.out.println("Connecting to a selected database...");
			      conn = DriverManager.getConnection(DB_URL2, USER, PASS);
			      System.out.println("Connected database successfully...");
			      
			      //STEP 4: Execute a query
			      System.out.println("Inserting records into the table...");
			      stmt = conn.createStatement();
			      
			   
			      MyApplication howManyRecords = new MyApplication();
			      
			      int j;
			      j = howManyRecords.listSize();
			      
			      for(int a=1; a<=j; a++){
			    	  	WhatList.add(MyApplication.WhatListRecord(a));
			    		WhenList.add(MyApplication.WhenListRecord(a));
			    		WhereList.add(MyApplication.WhereListRecord(a));
			    		HowMuchList.add(MyApplication.HowMuchListRecord(a));
			    		ImagePath.add(MyApplication.ImagePathListRecord(a));
			    		
			    		String sql = "INSERT INTO Registration " +
				                   "VALUES (WhatList.get(a), WhenList.get(a), WhereList.get(a), HowMuchList.get(a), ImagePath.get(a))";
				                   stmt.executeUpdate(sql);
			      }
			      
/*			      for(int i=0; i<j; i++){
			      String sql = "INSERT INTO Registration " +
			                   "VALUES ('aa', 'bb', 'cc', 'dd', 'ee', 'ff')";
			      stmt.executeUpdate(sql);
			      }*/

			      
			      
			      System.out.println("Inserted records into the table...");

			   }catch(SQLException se){
			      //Handle errors for JDBC
			      se.printStackTrace();
			   }catch(Exception e){
			      //Handle errors for Class.forName
			      e.printStackTrace();
			   }finally{
			      //finally block used to close resources
			      try{
			         if(stmt!=null)
			            conn.close();
			      }catch(SQLException se){
			      }// do nothing
			      try{
			         if(conn!=null)
			            conn.close();
			      }catch(SQLException se){
			         se.printStackTrace();
			      }//end finally try
			   }//end try
			   System.out.println("Goodbye!");
			}//end main
		   
		   
		   
	/*	   
		   public void selectRecord(){
			   Connection conn = null;
			   Statement stmt = null;
		   try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      System.out.println("Connected database successfully...");
		      
		      //STEP 4: Execute a query
		      System.out.println("Creating statement...");
		      stmt = conn.createStatement();

		      String sql = "SELECT id, first, last, age FROM Registration";
		      ResultSet rs = stmt.executeQuery(sql);
		      //STEP 5: Extract data from result set
		      while(rs.next()){
		         //Retrieve by column name
		         int id  = rs.getInt("id");
		         int age = rs.getInt("age");
		         String first = rs.getString("first");
		         String last = rs.getString("last");

		         //Display values
		         System.out.print("ID: " + id);
		         System.out.print(", Age: " + age);
		         System.out.print(", First: " + first);
		         System.out.println(", Last: " + last);
		      }
		      rs.close();
		   }catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   System.out.println("Goodbye!");
		}//end main */
}
