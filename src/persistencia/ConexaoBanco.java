/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lucas
 */
public class ConexaoBanco {
    static Connection conn;
    private static final String url = "jdbc:mysql://127.0.0.1:3306/BarberShopV2";
    private static final String user = "root";
    private static final String password = "12345";
    
    public static Connection getConection(){
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            return conn;

            
        }catch(SQLException | ClassNotFoundException e){
            System.out.println("Falha ao conectar ao banco de dados: "+ e.getMessage());
            return null;
        }
    }
    
}
