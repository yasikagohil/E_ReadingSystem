/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ejb.adminBeanLocal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Akshay
 */
@DeclareRoles({"Admin","User"})
@PermitAll
@Named(value = "category")
@ApplicationScoped
public class Category {
  @EJB adminBeanLocal admin;
    Integer categoryId;
    String categoryName;
    ArrayList categoryList;
    private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();  

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void seCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    
    public Collection categoryList(){
        return admin.getAllContentCategory();
    }
    
    public String save(){  
        try{  
            admin.addCategory(categoryName);
        }
        catch(Exception e){  
            System.out.println(e);  
        }  
       return "manage_category.xhtml?faces-redirect=true";  
    }  
    
    //  Used to fetch record to update  
    public String edit(int tid){  
        entity.ContentCategory t=new entity.ContentCategory();
        
        try{  
            entity.ContentCategory category = admin.getCategoryById(tid);
            t.setCategoryId(category.getCategoryId());
            t.setCategoryName(category.getCategoryName());
            sessionMap.put("editcategory", t);  
        }
        catch(Exception e){  
            System.out.println(e);  
        }         
        return "/update_categorye.xhtml?faces-redirect=true";  
    }  
    
      // Used to update user record  
    public String update(entity.ContentCategory t){  
        //int result = 0;  
        try{  
            admin.updateCategory(t.getCategoryId(),t.getCategoryName());
        }catch(Exception e){  
            System.out.println();  
        }  
        return "/manage_category.xhtml?faces-redirect=true";        
    }  
    
    public void delete(Integer id){  
        try{  
            admin.deleteCategory(id);
        }catch(Exception e){  
            System.out.println(e);  
        }  
    }  
  
    public Category() {
    }
    
}
