
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Linhas;
import util.ConnectionFactory;

/**
 *
 * @author Paula Belmiro
 */
public class LinhasController {
    
    public void save(Linhas linhas){
       String sql = "INSERT INTO linhas (id,"
               + "codigo,"
               + "nome) VALUES (?, ?, ?)";
       
       Connection connection = null;
       PreparedStatement statement = null;
       
       try{
           connection = ConnectionFactory.getConnection();
           statement = connection.prepareStatement(sql);
           statement.setInt(1, linhas.getId());
           statement.setString(2, linhas.getCodigo());
           statement.setString(3, linhas.getNome());
           statement.execute();
       } catch(Exception ex){
           throw new RuntimeException("Erro ao salvar a linha "
           + ex.getMessage(), ex);
       } finally{
           ConnectionFactory.closeConnection(connection, statement);       
       }
    }
    
    public void update(Linhas linhas){
        String sql = "UPDATE linhas SET "
               + "codigo = ?,"
               + "nome = ?, "
               + "WHERE id = ?";
    
       Connection connection = null;
       PreparedStatement statement = null;
       
       try{
           //Estabelecendo a conexão com o banco de dados
           connection = ConnectionFactory.getConnection();
           
           //Preparando a query
           statement = connection.prepareStatement(sql);
           
           //Setando os valores do statement
           statement.setString(1, linhas.getCodigo());
           statement.setString(2, linhas.getNome());
           statement.setInt(3, linhas.getId());
           
           //Executando a query
           statement.execute();
       } catch(Exception ex){
           throw new RuntimeException("Erro ao atualizar a linha "
           + ex.getMessage(), ex);
       } finally{
           ConnectionFactory.closeConnection(connection, statement);       
       }
    }
     
     public void removeById(int linhasId) throws SQLException{
       String sql = "DELETE FROM linhas WHERE id = ?";
       
       Connection connection = null;
       PreparedStatement statement = null;
       
       try{
            //Estabelecendo a conexão com o banco de dados
           connection = ConnectionFactory.getConnection();
           
           //Preparando a query
           statement = connection.prepareStatement(sql);
           
           //Setando os valores
           statement.setInt(1, linhasId);
           
           //Executando a query
           statement.execute();
       } catch (Exception ex){
           throw new RuntimeException("Erro ao deletar a linha " + ex.getMessage(), ex);
       } finally{
           ConnectionFactory.closeConnection(connection, statement);
       }
    } 

     public List<Linhas> getAll(){
       
        String sql = "SELECT * FROM linhas";
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        List<Linhas> linhas = new ArrayList<Linhas>();
        
        try{
           //Estabelecendo a conexão com o banco de dados
           connection = ConnectionFactory.getConnection();
           
           //Preparando a query
           statement = connection.prepareStatement(sql);
           
           //Setando ao valores que corresponde ao filtro de busca
           //statement.setInt();
           
           //Valor retornado pela execução da query
           resultSet = statement.executeQuery();
           
           //Enquanto houverem valores a serem percorridos no meu resultSet
           while(resultSet.next()){
               
               Linhas linha = new Linhas();
               linha.setId(resultSet.getInt("id"));
               linha.setCodigo(resultSet.getString("codigo"));
               linha.setNome(resultSet.getString("nome"));
               linhas.add(linha);
           }
        } catch(Exception ex){
           throw new RuntimeException("Erro ao gerar a lista de linhas "
           + ex.getMessage(), ex);
        } finally{
           ConnectionFactory.closeConnection(connection, statement, resultSet);       
       }
        //Lista de tarefas que foi criada e carregada do banco de dados 
        return linhas;
    } 

}