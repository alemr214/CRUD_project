/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package itver.crud_project;

import conn.MySQLConnection;
import java.sql.SQLException;

import conn.MySQLConnection;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author crist
 */
public class CRUD_project {

    public static void main(String[] args) {
        String schemaN;
        MySQLConnection connSQL = new MySQLConnection();
        Scanner sc = new Scanner(System.in);
        try {
            connSQL.openConnection();
            connSQL.connectSchema();

            connSQL.showSchemas();
            connSQL.useSchema();
            connSQL.showTables();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connSQL.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        sc.close();
    }
}
