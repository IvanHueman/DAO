/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mrysi.beans;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Alyta
 */
public class ConexionMySQL {
   public static Connection getConnection() throws java.sql.SQLException {
            Connection connect; 

               try  {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String URL= "jdbc:mysql://localhost:3306/universidad?useSSL=false";
            String usuario="root";
            String contraseña ="0230";
            connect = DriverManager.getConnection(URL,usuario,contraseña);
            connect.createStatement();
            System.out.print("La conexion se hizo correcta");
            


        connect.close();
        return connect;
        }catch(java.sql.SQLException ex) {
                System.out.println(ex); 
        return null;
        } catch (ClassNotFoundException ex) {
           System.out.println(ex);
        }
       return null;
}
}
   