
package Controller;

import Model.Project;
import Util.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ProjectController {
    public void save(Project Project) {
        String sql = "INSERT INTO projects "
                + "(Name,"
                + "Description,"
                + "CreatedAt,"
                + "UpdateAt) VALUES (?, ?, ?, ?)";
                
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, Project.getName());
            statement.setString(2, Project.getDescription());
            statement.setDate(3, new Date(Project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(Project.getUpdateAt().getTime()));
            
            statement.execute();
        } catch (SQLException error) {
            throw new RuntimeException("Erro ao salvar o projeto no banco de dados", error);           
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
    
    public void update(Project Project) {
        String sql = "UPDATE projects SET "
                + "Name = ?,"
                + "Description = ?,"
                + "CreatedAt = ?,"
                + "UpdateAt = ?"
                + "WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, Project.getName());
            statement.setString(2, Project.getDescription());
            statement.setDate(3, new Date(Project.getCreatedAt().getTime()));
            statement.setDate(4, new Date(Project.getUpdateAt().getTime()));
            statement.setInt(5, Project.getId());
            statement.execute();
        } catch (SQLException error) {
            throw new RuntimeException("Erro ao atualizar o projeto no banco de dados", error);           
        } finally { 
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
    
    public void removeById(int idProject) {
        String sql = "DELETE FROM projects WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            
            statement.setInt(1, idProject);
            statement.execute();
        } catch (SQLException error) {
            throw new RuntimeException("Erro ao deletar o projeto no banco de dados", error);           
        } finally { 
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
    
    public List<Project> getAll() {
        String sql = "SELECT * FROM projects";
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
               
        List<Project> projects = new ArrayList<Project>();
        
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);            
            resultSet = statement.executeQuery();
             while(resultSet.next()) {
                 
            Project project = new Project ();
                
                project.setId(resultSet.getInt("id"));
                project.setName(resultSet.getString("name"));
                project.setDescription(resultSet.getString("description"));
                project.setCreatedAt(resultSet.getDate("createdAt"));
                project.setUpdateAt(resultSet.getDate("updateAt"));
                                   
                projects.add(project);               
            }
        } catch (SQLException error) {
            throw new RuntimeException("Erro ao buscar os projetos no banco de dados", error);           
        } finally { 
            ConnectionFactory.closeConnection(connection, statement, resultSet);
        }
        
        return projects;
    }
}
