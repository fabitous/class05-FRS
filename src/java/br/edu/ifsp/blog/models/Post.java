package br.edu.ifsp.blog.models;


public class Post {
    private String description;
    private String emailUser;
    private int ID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Post() {
    }
    
    public Post(String description, String emailUser, int ID) {
        this.description = description;
        this.emailUser = emailUser;
        this.ID = ID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }
    
}
