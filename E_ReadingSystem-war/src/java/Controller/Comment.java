/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ejb.authorBeanLocal;
import entity.Comments;
import java.util.Collection;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Akshay
 */
@Named(value = "comment")
@ApplicationScoped
public class Comment {

    String des;
    @EJB authorBeanLocal author;
    Integer commentId;

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }
  
    public Comment() {
    }
    
    public Collection<Comments> getComments(Integer id){
       return author.getAllCommentById(id);
    }
    
     public void add(Integer cid,String des){  
        try{  
             String name=(String)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
            author.Comment(name,cid, des);
        }
        catch(Exception e){  
            System.out.println(e);  
        }  
     }
}
