/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package mrysi.servlets;

import mrysi.beans.DAO;
import mrysi.beans.DAOimp;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import mrysi.beans.Persona;

/**
 *
 
@author alytaz*/


/**
 *
 
@author maxim*/
public class ServletEscuelas extends HttpServlet {
    private final DAO<Persona> dao = new DAOimp();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("BD.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        var nombre = request.getParameter("nombre");

       try {
           Persona pers = new Persona();

           pers.setNombre(nombre);

           if (nombre.isEmpty() || nombre.isBlank()) {
               return;
           }

            dao.insert(pers);
        } catch (java.sql.SQLException ex) {
            System.out.println(ex);
        }

       response.sendRedirect("BD.jsp");
    }

}





  

 

