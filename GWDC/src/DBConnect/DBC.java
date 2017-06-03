
package DBConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Nanika
 */
public class DBC {
    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement pst;
    private static ResultSet rs;
    

    public static void createUT(){
        try
        {   
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/Peeroll;IGNORECASE=TRUE", "edmon", "" );
            stmt = connection.createStatement();
         //  stmt.executeUpdate( "DROP TABLE IF EXISTS USERTABLE" );
            stmt.executeUpdate( "CREATE TABLE USERTABLE ( user varchar(50),pass varchar(50),name varchar(50),pos varchar(50))" );

            stmt.executeUpdate( "INSERT INTO USERTABLE ( user,pass,name,pos ) VALUES ( 'admin','admin','admin','admin')" );

            stmt.close();
            connection.close();
        }
        catch( Exception e )
        {
            System.out.println( e.getMessage() );
        }
    }    
    
     public static void createEMPDATA(){
        try
        {   
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/Peeroll;IGNORECASE=TRUE", "edmon", "" );
            stmt = connection.createStatement();
         //   stmt.executeUpdate( "DROP TABLE IF EXISTS EMPDATA" );
            stmt.executeUpdate( "CREATE TABLE EMPDATA (EMPID varchar(50) PRIMARY KEY,"
                + "SURNAME varchar(50),"
                    + "FIRSTNAME varchar(50),"
                    + "MIDDLENAME varchar(50),"
                    + "GENDER varchar(50),"
                    + "BIRTHDATE DATE,"
                    + "AGE varchar(50),"
                    + "ADDRESS varchar(50),"
                    + "CIVILSTATUS varchar(50),"
                    + "CONTACTNUM varchar(50),"
                    + "CONTACTINEMER varchar(50),"
                    + "DESIGNATION varchar(50),"
                    + "DEPARTMENT varchar(50),"
                    + "PROBATION varchar(50),"
                    + "EMPLOYEETYPE varchar(50),"
                    + "EMPLOYMENTSTATUS varchar(50),"
                    + "SHIFT varchar(50),"
                    + "DATEOFEMP DATE,"
                    + "SALTYPE varchar(50),"
                    + "WD varchar(50),"
                    + "BP varchar(50),"
                    + "DSR varchar(50),"
                    + "HSR varchar(50),"
                    + "MSR varchar(50),"
                    + "FOOD varchar(50),"
                    + "TRANSPO varchar(50),"
                    + "PAGIBIG varchar(50),"
                    + "SSS varchar(50),"
                    + "PHILHEALTH varchar(50),"
                    + "LEAVEC varchar(50),"
                    + "DEPENDENTS varchar(50),"
                    + "IMAGE blob)" );
            
            
            stmt.close();
            connection.close();
        }
        catch( Exception e )
        {
            System.out.println( e.getMessage() );
        }
    }    
     
     public static void createEMPDATA3(){
        try
        {   
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/Peeroll;IGNORECASE=TRUE", "edmon", "" );
            stmt = connection.createStatement();
          // stmt.executeUpdate( "DROP TABLE IF EXISTS EMPDATA3" );
            stmt.executeUpdate( "CREATE TABLE EMPDATA3 (STARTDATE DATE,"
                    + "ENDDATE DATE,"
                    + "PAYMENTDATE DATE,"
                    + "EMPLOYEEID varchar(50),"
                    + "SURNAME varchar(50),"
                    + "FIRSTNAME varchar(50),"
                    + "DESIGNATION varchar(50),"
                    + "DEPARTMENT varchar(50),"
                    + "BASICSALARY varchar(50),"
                    + "FOOD varchar(50),"
                    + "TRANSPO varchar(50),"
                    + "PAGIBIG varchar(50),"
                    + "SSS varchar(50),"
                    + "PHILHEALTH varchar(50),"
                    + "LOAN varchar(50),"
                    + "TI varchar(50),"
                    + "TP varchar(50),"
                    + "ABSENCES varchar(50),"
                    + "UNDERTIME varchar(50),"
                    + "LATES varchar(50),"
                    + "GROSSPAY varchar(50),"
                    + "NETPAY varchar(50),"
                    + "BONUS varchar(50),"
                    + "MONTH13 varchar(50),"
                    + "OVERTIME varchar(50),"
                    + "NIGHTDIFF varchar(50),"
                    + "HOLIDAYPAY varchar(50),"
                    + "CA varchar(50),"
                    + "PAIDSTAT varchar(10))" );

            
            stmt.close();
            connection.close();
        }
        catch( Exception e )
        {
            System.out.println( e.getMessage() );
        }
    }    
     
}
