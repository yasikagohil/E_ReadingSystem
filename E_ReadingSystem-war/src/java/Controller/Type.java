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
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Akshay
 */
@DeclareRoles({"Admin","Supervisor"})
@RolesAllowed("Admin")
@Named(value = "type")
@ApplicationScoped
public class Type {
    @EJB adminBeanLocal admin;
    Integer typeId;
    String typeName;
    ArrayList typeList;
    private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();  

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Type() {
    }
    
    public Collection TypeList(){
        return admin.getAllContentType();
    }
    
    public String save(){  
        try{  
            admin.addType(typeName);
        }
        catch(Exception e){  
            System.out.println(e);  
        }  
       return "manage_type.xhtml?faces-redirect=true";  
    }  
    
    //  Used to fetch record to update  
    public String edit(int tid){  
        entity.ContentType t=new entity.ContentType();
        
        try{  
            entity.ContentType type = admin.getTypeById(tid);
            t.setTypeId(type.getTypeId());
            t.setTypeName(type.getTypeName());
            sessionMap.put("editType", t);  
        }
        catch(Exception e){  
            System.out.println(e);  
        }         
        return "/update_type.xhtml?faces-redirect=true";  
    }  
    
      // Used to update user record  
    public String update(entity.ContentType t){  
        //int result = 0;  
        try{  
            admin.updateType(t.getTypeId(),t.getTypeName());
        }catch(Exception e){  
            System.out.println();  
        }  
        return "/manage_type.xhtml?faces-redirect=true";        
    }  
    
    public void delete(Integer id){  
        try{  
            admin.deleteType(id);
        }catch(Exception e){  
            System.out.println(e);  
        }  
    }  

}
