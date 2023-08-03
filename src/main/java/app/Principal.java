package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Principal {
    public static void main(String[] args) throws SQLException {
    Connection connection = null;
    try{
        //cria classe de conexão com a dependencia
        Class.forName("com.mysql.cj.jdbc.Driver");

        //cria a string de conexão
        connection = DriverManager.getConnection("jdbc:mysql://localhost/superherodb","root","root");

        //cria a consulta
        ResultSet resultado = connection.createStatement().executeQuery("SELECT * FROM superheroes");

        //mostrar os dados
        while (resultado.next()){
            System.out.println("---------------------------------------------");
            System.out.println("HERÓI: " + resultado.getString("name"));
            System.out.println("NOME: " + resultado.getString("firstname"));
            System.out.println("SOBRENOME: " + resultado.getString("lastname"));
            System.out.println("LOCAL: " + resultado.getString("place"));
        }
    }catch (Exception e){

    }finally {
        if(connection != null)
            connection.close();;
    }
    }
}

