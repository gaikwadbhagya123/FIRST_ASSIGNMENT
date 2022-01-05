 import java.sql.*;
import java.util.*;

public class Insertquery{
	private static final String insert_student="insert into student"
                                           +"(student_no,student_name,student_dob,student_doj) values "
					   +"(?,?,?,?);";

	private static final String update_student="update student set student_name=? where student_no=?;";
	

	private static final String delete_student="delete from student where student_no=?;";

	private static final String all_student="select * from student;";

	private static final String one_student="select * from student where student_no=?;";


public static void main(String[] args ) throws SQLException {

	  
        Insertquery createTableExample = new Insertquery();
        createTableExample.insertRecord();
        createTableExample.updateRecord();
        createTableExample.deleteRecord();
        createTableExample.allRecord();
        createTableExample.oneRecord();
   } //main
	


//1.INSERT STUDENT DATA INTO STUDENT TABLE

public void insertRecord() throws SQLException{
		System.out.println(insert_student);

       //this for get current date
		//java.util.Date javaDate = new java.util.Date();
                // java.sql.Date mySQLDate = new java.sql.Date(javaDate.getTime());

      //for accepting date of birt from user
		Scanner sc=new Scanner(System.in);
		System.out.println("enter birthdate");
                String dob=sc.next();
		java.sql.Date sqdob = java.sql.Date.valueOf(dob);

      //for accepting joining date from user
                System.out.println("enter date of join");
		String doj=sc.next();
                java.sql.Date sqdoj = java.sql.Date.valueOf(doj);

                final String url = "jdbc:mysql://localhost:3306/studentdetails";
                final String user = "root";
                final String password = "mysql123";

	   try( Connection con = DriverManager.getConnection(url,user,password);
                  

           PreparedStatement preparedStatement=con.prepareStatement(insert_student)){
	
		preparedStatement.setInt(1,10);
		preparedStatement.setString(2,"bhagyashree");
		preparedStatement.setDate(3,sqdob);
		preparedStatement.setDate(4,sqdoj);

		System.out.println(preparedStatement);
		System.out.println("inserted successfully");
			
		int result = preparedStatement.executeUpdate();
		System.out.println(result);
				

           }catch (SQLException ex) {
                ex.printStackTrace();
		}
 
  }        


//2.UPDATE STUDENT DATA INTO STUDENT TABLE

public void updateRecord() throws SQLException{
	        System.out.println(update_student);

                 
		final String url = "jdbc:mysql://localhost:3306/studentdetails";
                final String user = "root";
                final String password = "mysql123";
                        
        //step-1 establishing onnection

	     try( Connection con = DriverManager.getConnection(url,user,password);
	//create statment using connection object
                PreparedStatement preparedStatement1=con.prepareStatement(update_student)){
				
	//set parameters
		preparedStatement1.setString(1,"nitsya");
		preparedStatement1.setInt(2,7);
		System.out.println(preparedStatement1);
	        System.out.println("updated sucessfully");
                          
        //execute query 
                preparedStatement1.executeUpdate();
			
             }catch (SQLException ex) {
                  ex.printStackTrace();
               }	
 }


//3.DELETE STUDENT DATA FROM STUDENT TABLE

public void deleteRecord() throws SQLException{
		System.out.println(delete_student);
	        final String url = "jdbc:mysql://localhost:3306/studentdetails";
                final String user = "root";
                final String password = "mysql123";
                        
        //step-1 establishing onnection

	    try( Connection con = DriverManager.getConnection(url,user,password);
	//create statment using connection object
                      PreparedStatement preparedStatement2=con.prepareStatement(delete_student)){
				
	//set parameters
		preparedStatement2.setInt(1,6);
		System.out.println(preparedStatement2);
                          
		System.out.println("deleted sucessfully");
                          
        //execute query 
                preparedStatement2.executeUpdate();

		}catch (SQLException ex) {
  			ex.printStackTrace();
 			}	
   }


//3.GET LIST OF ALL STUDENTS
public void allRecord() throws SQLException{
		System.out.println(all_student);
	        final String url = "jdbc:mysql://localhost:3306/studentdetails";
                final String user = "root";
                final String password = "mysql123";
                        
        //step-1 establishing onnection

	    try( Connection con = DriverManager.getConnection(url,user,password);
	//create statment using connection object
                PreparedStatement preparedStatement3=con.prepareStatement(all_student)){
	//execute query 
		ResultSet rs = preparedStatement3.executeQuery();
				 
      	    while (rs.next()) {
  
                int student_no = rs.getInt("student_no");
                String student_name = rs.getString("student_name");
                String student_dob = rs.getString("student_dob");
		String student_doj = rs.getString("student_dob");
                System.out.println(student_no + "\t\t" + student_name
                                   + "\t\t" + student_dob + "\t\t" + student_doj);
            }
                       
                        
	}catch (SQLException ex) {
  		  ex.printStackTrace();
		}	
  }


//5.GET ONE STUDENT INFORMATION DEPENDING ON THE STUDENT ID FILTER

public void oneRecord() throws SQLException{
	       System.out.println(one_student);
	       final String url = "jdbc:mysql://localhost:3306/studentdetails";
               final String user = "root";
               final String password = "mysql123";
                        
        //step-1 establishing onnection

	    try( Connection con = DriverManager.getConnection(url,user,password);
	//create statment using connection object
                PreparedStatement preparedStatement4=con.prepareStatement(one_student)){
				
	//set parameters
		preparedStatement4.setInt(1,1);
		System.out.println(preparedStatement4);
                          
		System.out.println("display one record sucessfully");
                          
        //execute query 
                       

		ResultSet rs = preparedStatement4.executeQuery();
				 
      	     while (rs.next()) {
  
                int student_no = rs.getInt("student_no");
                String student_name = rs.getString("student_name");
                String student_dob = rs.getString("student_dob");
		String student_doj = rs.getString("student_dob");
                System.out.println(student_no + "\t\t" + student_name
                                   + "\t\t" + student_dob + "\t\t" + student_doj);
            }
	}catch (SQLException ex) {
    		ex.printStackTrace();
		}	
	}
}