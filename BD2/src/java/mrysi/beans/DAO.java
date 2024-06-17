/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mrysi.beans;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author Alyta
 * @param <Persona>
 */
public interface DAO <Persona> {
    void insert(Persona entidad) throws SQLException;
    void update(Persona entidad) throws SQLException;
    void delete(int nombre) throws SQLException;
    Persona read(int nombre) throws SQLException;
    List<Persona> readAll() throws SQLException;
}
