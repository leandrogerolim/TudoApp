package CertoApp;

import Controller.ProjectController;
import Controller.TaskController;
import Model.Project;
import Model.Task;
import Util.ConnectionFactory;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.SQLException;
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ProjectController ProjectController = new ProjectController();
//        
//        Project project = new Project();
//        project.setName("Projeto teste");
//        project.setDescription("description");
//        ProjectController.save(project);
        
//        Project.setId(3);
//        Project.setName("Novo nome do projeto");
//        Project.setDescription("New description");
//        ProjectController.update(Project);
//
//        ProjectController.removeById(2);
//
//////        
//        List<Project> projects = ProjectController.getAll();
//        System.out.println("Total de projetos = " + projects.size());        
//////        
        TaskController taskController = new TaskController();
//        
//        Task task = new Task(15, 12, "tarefa", "descripiton", "test", false, new Date(), new Date(), new Date());        
//        taskController.save(task);         
//        
//        task.setId(2);
//        task.setName("Novo nome tarefa");
//        task.setDescription("Nova descrição");
//        taskController.update(task);        
//
//        taskController.removeById(3);
//        
          List<Task> tasks = taskController.getAll(12);
          System.out.println("Total de tarefas = " + tasks.size());
//          
    }
    
}
