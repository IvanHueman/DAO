/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mrysi.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author alyta
 */
public class DAOimp implements DAO<Persona>{
   
    private Connection conn;

    public DAOimp() {
        try {
            this.conn = ConexionMySQL.getConnection();
        } catch (SQLException e) {
        }
    }
    @Override
    public void insert(Persona entidad) throws SQLException {
        conn = ConexionMySQL.getConnection();
        String insertQuery = "INSERT INTO persona (nombre) VALUES (?)";
        PreparedStatement ps = conn.prepareStatement(insertQuery);
       
        ps.setString(1, entidad.getNombre());
        
        ps.executeUpdate();
        
        conn.close();
    }

    @Override
    public void update(Persona entidad) throws SQLException {
        String updateQuery = "UPDATE persona SET nombre = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(updateQuery);
        ps.setString(1, entidad.getNombre());
        ps.setInt(2, entidad.getId());
        ps.executeUpdate();
    }

    @Override
    public void delete(int id) throws SQLException {
              String deleteQuery = "DELETE FROM persona WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(deleteQuery);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public Persona read(int id) throws SQLException {
       String readQuery = "SELECT * FROM persona WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(readQuery);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Persona(rs.getInt("id"), rs.getString("nombre"));
        }
        return null;
    }

    @Override
    public List<Persona> readAll() throws SQLException {
        String readAllQuery = "SELECT * FROM persona";
        PreparedStatement ps = conn.prepareStatement(readAllQuery);
        ResultSet rs = ps.executeQuery();
        List<Persona> pers = new ArrayList<>();
        while (rs.next()) {
            pers.add(new Persona(rs.getInt("id"), rs.getString("nombre")));
        }
        return pers;
    }
}