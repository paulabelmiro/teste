
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Itinerario;
import util.ConnectionFactory;

/**
 *
 * @author Paula Belmiro
 */
public class ItinerarioController {
    
    public void save(Itinerario itinerario){
        String sql = "INSERT INTO itinerario (lat, "
               + "lng) VALUES (?, ?)";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try{
            //Cria conexão com o banco
           connection = ConnectionFactory.getConnection();
           //Cria um PreparedStatement, classe usada para executar a query
           statement = connection.prepareStatement(sql);
           
           statement.setString(1, itinerario.getLat());
           statement.setString(2, itinerario.getLng());
                      
           //Executa a sql para inserção dos dados
           statement.execute();
       } catch(Exception ex){
           throw new RuntimeException("Erro ao salvar o itinerario "
           + ex.getMessage(), ex);
       } finally{
           ConnectionFactory.closeConnection(connection, statement);       
       }
    }
 
    public void update(Itinerario itinerario){
        String sql = "UPDATE itinerario SET "
               + "lat = ?,"
               + "lng = ?,"
               + "WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try{
           //Estabelecendo a conexão com o banco de dados
           connection = ConnectionFactory.getConnection();
           
           //Preparando a query
           statement = connection.prepareStatement(sql);
           
           //Setando os valores do statement
           statement.setString(1, itinerario.getLat());
           statement.setString(2, itinerario.getLng());
           statement.setInt(3, itinerario.getId());
           
           //Executando a query
           statement.execute();
       } catch(Exception ex){
           throw new RuntimeException("Erro ao atualizar o itinerario "
           + ex.getMessage(), ex);
       } finally{
           ConnectionFactory.closeConnection(connection, statement);       
       }
        
    }

    public void removeById(int idLinha){
        String sql = "DELETE FROM itinerario WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try{
            //Estabelecendo a conexão com o banco de dados
           connection = ConnectionFactory.getConnection();
           
           //Preparando a query
           statement = connection.prepareStatement(sql);
           
           //Setando os valores
           statement.setInt(1, idLinha);
           
           //Executando a query
           statement.execute();
       } catch (Exception ex){
           throw new RuntimeException("Erro ao deletar o itinerario " + ex.getMessage(), ex);
       } finally{
           ConnectionFactory.closeConnection(connection, statement);
       }
    }

    public List<Itinerario> getAll(){
        String sql = "SELECT * FROM itinerario";
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        List<Itinerario> itinerarios = new ArrayList<Itinerario>();
            
    try{
           //Estabelecendo a conexão com o banco de dados
           connection = ConnectionFactory.getConnection();
           
           //Preparando a query
           statement = connection.prepareStatement(sql);
                   
           //Valor retornado pela execução da query
           resultSet = statement.executeQuery();
           
           //Enquanto houverem valores a serem percorridos no meu resultSet
           while(resultSet.next()){
               
               Itinerario itinerario = new Itinerario();
               
               itinerario.setId(resultSet.getInt("id"));
               itinerario.setLat(resultSet.getString("lat"));
               itinerario.setLng(resultSet.getString("lng"));
               itinerarios.add(itinerario);
           }
        } catch(Exception ex){
           throw new RuntimeException("Erro ao gerar a lista de itinerario "
           + ex.getMessage(), ex);
        } finally{
           ConnectionFactory.closeConnection(connection, statement, resultSet);       
       }
        //Lista de tarefas que foi criada e carregada do banco de dados 
        return itinerarios;
    }
}
