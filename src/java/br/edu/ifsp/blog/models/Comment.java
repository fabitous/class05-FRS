package br.edu.ifsp.blog.models;


public class Comment {
    private String description;
    private int idPost;

    public Comment() {
    }

    public Comment(String description, int idPost) {
        this.description = description;
        this.idPost = idPost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdPost() {
        return idPost;
    }

    public void setIdPost(int idPost) {
        this.idPost = idPost;
    }
    
}
