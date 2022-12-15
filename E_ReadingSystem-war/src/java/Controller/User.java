/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ejb.adminBeanLocal;
import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;
import javax.ws.rs.core.GenericType;
import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;

/**
 *
 * @author Akshay
 */
@DeclareRoles({"Admin","Supervisor"})
@RolesAllowed("Admin")
@Named(value = "user")
@ApplicationScoped
public class User {
    @EJB adminBeanLocal admin;
    Collection<entity.User> users;
    GenericType<Collection<entity.User>> gusers;
    Boolean isLogin=false;
    User user;
    String message="";
    String Username;  
    String image;
    String email;  
    String password;  
    String Phone;  
    String des;
    ArrayList usersList ;  
    //private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();  
    private User User;
    
    public String getUsername() {  
        return Username;  
    }  
    public void setUsername(String name) {  
        this.Username = name;  
    }  
    public String getImage(){
        return image;
    }
    public void setImage(String image){
        this.image=image;
    }
    public String getEmail() {  
        return email;  
    }  
    public void setEmail(String email) {  
        this.email = email;  
    }  
    public String getPassword() {  
        return password;  
    }  
    public void setPassword(String password) {  
        this.password = password;  
    }  
    public String getPhone() {  
        return Phone;  
    }  
    public void setPhone(String Phone) {  
        this.Phone = Phone;  
    }  

   // Used to fetch all records  
    public Collection usersList(){  
      return admin.getAllUsers();
    }  
    
   
    
    // Used to save user record  
    public String save(){  
        try{  
            Pbkdf2PasswordHashImpl pb;
            pb = new Pbkdf2PasswordHashImpl();
            String ps=pb.generate(password.toCharArray());
            admin.addUser(Username, ps, Phone, email);
        }
        catch(Exception e){  
            System.out.println(e);  
        }  
       return "index.xhtml?faces-redirect=true";  
    }
    
//     private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();  
//    // Used to fetch record to update  
//    public String edit(String Username){  
//     entity.User user=new entity.User();
//        System.out.println(Username);  
//        try{  
//            entity.User u = admin.getUserByName(Username);
//            user.setUsername(u.getUsername());
//            user.setEmail(u.getEmail());
//            user.setPhone(u.getPhone());
//            sessionMap.put("editUser", user);  
//        }
//        catch(Exception e){  
//            System.out.println(e);  
//        }         
//       return "/edit_user.xhtml?faces-redirect=true";  
//    }  
    // Used to update user record  
    
     public String update(String Username, String password, String image, String Phone,String email){
        this.Username=Username;
        this.password=password;
        this.Phone=Phone;
        this.email=email;
        this.image=image;
        return "edit_user.xhtml?faces-redirect=true";
    }
    
    public String update(){  
        //int result = 0;  
        try{  
            admin.updateUser(User.Username, User.password, User.image, User.Phone, User.email);
        }catch(Exception e){  
            System.out.println();  
        }  
        return "/manage_user.xhtml?faces-redirect=true";        
    }  
    
    // Used to delete user record  
    public void delete(String Username){  
        try{  
            admin.deleteUser(Username);
        }catch(Exception e){  
            System.out.println(e);  
        }  
    }  
   
    public User() {
    }
    
    public entity.User getUserByName(){
        String name=(String)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
        entity.User u=admin.getUserByName(name);
        return u;
    }
    
    public Collection<entity.Content> getContentCollection(){
         String name=(String)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
         Integer id=admin.getAuthorByName(name);
         Collection<entity.Content> c=admin.getContentOfAuthorId(id);
         return c;
    }
    
    public Collection<entity.User> adminList(){
        return admin.getUsersByRole("admin");
    }
    
    public void addComment(){
        
    }
}
