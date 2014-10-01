/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Jhonbarranco
 */
public class prueba {

    /**
     * @param args the command line arguments
     */
    public String getIva() throws SQLException {

        float precio = 100000;
        float dec = 10000;
        int cant = 1;

        Connection conn = (Connection) BD.GetConnection();
        Statement stmt = null;

        try {

            String query = "SELECT Graficos,Codins FROM Alm_ImgInsumos";

            try {
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                while (rs.next()) {

                }
                rs.close();
            } catch (SQLException e) {

            }

        } catch (Exception e) {
            if (stmt != null) {
                stmt.close();
            }
        }

        return "";
    }

    public static void main(String[] args) {
        // TODO code application logic here

    }

}
