/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ejb.adminBeanLocal;
import ejb.authorBeanLocal;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;

/**
 *
 * @author Akshay
 */
@DeclareRoles({"Admin","User"})
@PermitAll
@Named(value = "author")
@Dependent
public class Author {

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public ArrayList getAuthorList() {
        return authorList;
    }

    public void setAuthorList(ArrayList authorList) {
        this.authorList = authorList;
    }

    @EJB adminBeanLocal admin;
    @EJB authorBeanLocal user;
    Integer authorId;
    String authorName;
    ArrayList authorList;
    /**
     * Creates a new instance of Author
     */
    public Author() {
    }
    
    public Collection authorList(){
        return admin.getAllAuthor();
    }
    
     public String save(){  
        try{  
            admin.addAuthor(authorName);
        }
        catch(Exception e){  
            System.out.println(e);  
        }  
       return "manage_author.xhtml?faces-redirect=true";  
    }  
    
     public void delete(Integer id){  
        try{  
            admin.deleteAuthor(id);
        }catch(Exception e){  
            System.out.println(e);  
        }  
    }  
  
     public void follow(Integer id){
         String name=(String)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
         user.Follow(name,id);
     }
}
