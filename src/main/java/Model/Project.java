
package Model;

import java.util.Date;


public class Project {
    private int id;
    private String Name;
    private String Description;
    private Date CreatedAt;
    private Date UpdateAt;

    public Project(int id, String Name, String Description, Date CreatedAt, Date UpdateAt) {
        this.id = id;
        this.Name = Name;
        this.Description = Description;
        this.CreatedAt = CreatedAt;
        this.UpdateAt = UpdateAt;
    }
    
    public Project (){
        this.CreatedAt = new Date();
        this.UpdateAt = new Date();
        
    }

    @Override
    public String toString() {
        return this.Name;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Date getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(Date CreatedAt) {
        this.CreatedAt = CreatedAt;
    }

    public Date getUpdateAt() {
        return UpdateAt;
    }

    public void setUpdateAt(Date UpdateAt) {
        this.UpdateAt = UpdateAt;
    }

   

}