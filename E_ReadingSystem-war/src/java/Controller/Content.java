/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import ejb.adminBeanLocal;
import ejb.authorBeanLocal;
import entity.Draft;
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
@Named(value = "content")
@ApplicationScoped
public class Content {
@EJB adminBeanLocal admin;
@EJB authorBeanLocal author;
    Integer ContentId;
    String ContentTitle,Image,Description;
    Integer Likes,TypeId,CategoryId,NoOfRead;
    ArrayList ContentList;
    private Map<String,Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();  
    private Content Content;

    public Content() {
    }

    public Integer getContentId() {
        return ContentId;
    }

    public void setContentId(Integer ContentId) {
        this.ContentId = ContentId;
    }

    public String getContentTitle() {
        return ContentTitle;
    }

    public void setContentTitle(String ContentTitle) {
        this.ContentTitle = ContentTitle;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Integer getLikes() {
        return Likes;
    }

    public void setLikes(Integer Likes) {
        this.Likes = Likes;
    }

    public Integer getTypeId() {
        return TypeId;
    }

    public void setTypeId(Integer TypeId) {
        this.TypeId = TypeId;
    }

    public Integer getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(Integer CategoryId) {
        this.CategoryId = CategoryId;
    }

    public Integer getNoOfRead() {
        return NoOfRead;
    }

    public void setNoOfRead(Integer NoOfRead) {
        this.NoOfRead = NoOfRead;
    }

    public Collection ContentList() {
        return admin.getAllContent();
    }
    
    public String displayContent(){
        return "contentById.xhtml";
    }
    
    public entity.Content contentById(Integer id){
        entity.Content c=admin.getContentById(id);
        return c;
    }
    
     public String save_draft_story(String contentTitle,String image,Integer categoryId,String desc){  
        try{ 
            String uname=(String)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
//            String uname=session.getAttribute("username");           
            author.addDraft(uname, contentTitle, image, categoryId, 2, desc);
        }
        catch(Exception e){  
            System.out.println(e);  
        }  
       return "user_homepage.xhtml?faces-redirect=true";  
    }  
    
    public String save_draft_poem(String contentTitle,String image,Integer categoryId,String desc){  
        try{ 
            String uname=(String)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
//            String uname=session.getAttribute("username");           
            author.addDraft(uname, contentTitle, image, categoryId, 3, desc);
        }
        catch(Exception e){  
            System.out.println(e);  
        }  
       return "user_homepage.xhtml?faces-redirect=true";  
    }  
    
     public String save_draft_article(String contentTitle,String image,Integer categoryId,String desc){  
        try{ 
            String uname=(String)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
//            String uname=session.getAttribute("username");           
            author.addDraft(uname, contentTitle, image, categoryId, 1, desc);
        }
        catch(Exception e){  
            System.out.println(e);  
        }  
       return "user_homepage.xhtml?faces-redirect=true";  
    }  
     
     public Collection<Draft> getDraft(){
         String uname=(String)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
         return author.getAllDraft(uname);
     }
    
     public String save_story(){  
        try{  
            admin.addContent(ContentTitle,Image,CategoryId,2,Description,0,0);
        }
        catch(Exception e){  
            System.out.println(e);  
        }  
       return "user_homepage.xhtml?faces-redirect=true";  
    }  
    
     public String save_poem(){  
        try{  
            admin.addContent(ContentTitle,Image,CategoryId,3,Description,0,0);
        }
        catch(Exception e){  
            System.out.println(e);  
        }  
       return "user_homepage.xhtml?faces-redirect=true";  
    }  
     
      public String save_article(){  
        try{  
            admin.addContent(ContentTitle,Image,CategoryId,1,Description,0,0);
        }
        catch(Exception e){  
            System.out.println(e);  
        }  
       return "user_homepage.xhtml?faces-redirect=true";  
    }  
    
////  Used to fetch record to update  
//    public String edit(int cid){  
//        entity.Content c=new entity.Content();
//        System.out.println(cid);  
//        try{  
//            entity.Content content = admin.getContentById(cid);
//            c.setContentId(content.getContentId());
//            c.setTitle(content.getTitle());
//            c.setDescription(content.getDescription());
//            c.setImage(content.getImage());
//            c.setCategoryId(content.getCategoryId());
//            c.setTypeId(content.getTypeId());
//            sessionMap.put("editContent", c);  
//        }
//        catch(Exception e){  
//            System.out.println(e);  
//        }         
//        return "/update_content.xhtml?faces-redirect=true";  
//    }  
//    
//    // Used to update user record  
//    public String update(entity.Content c){  
//        //int result = 0;  
//        try{  
//            admin.updateContent(c.getContentId(),c.getTitle(),c.getImage(),c.getCategoryId(),c.getTypeId(),c.getDescription());
//            sessionMap.remove(c,"editContent");
//        }catch(Exception e){  
//            System.out.println();  
//        }  
//        return "/manage_content.xhtml?faces-redirect=true";       
//    }  
//      
    public String edit(Integer id,String title,String image,Integer categoryId,Integer typeId,String des){
        this.ContentId=id;
        this.ContentTitle=title;
        this.Image=image;
        this.CategoryId=categoryId;
        this.TypeId=typeId;
        this.Description=des;
        return "update_content.xhtml?faces-redirect=true";
    }
    
    public String edit(){
        this.Content.edit(Content.ContentId,Content.ContentTitle,Content.Image,Content.CategoryId,Content.TypeId,Content.Description);
        this.Content=new Content();
        return "index.xhtml";
    }
    
    public String display(int id){
        this.ContentId=id;
         admin.updateReading(ContentId);
        return "display.xhtml?faces-redirect=true";
    }
    
    public entity.Content display(){
        entity.Content c=admin.getContentById(ContentId);
       
        return c;
    }
    
    public void delete(Integer id){  
        try{  
            admin.deleteContent(id);
        }catch(Exception e){  
            System.out.println(e);  
        }  
    }  
    
    public Collection<entity.Content> getContentByCategory(int id){
        return admin.getContentByCategory(id);
    }
    
    public void like(Integer id){
        admin.updateLike(id);
    }
    
    public void addToLibrary(Integer cid){
        String uname=(String)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
        admin.addToLibrary(uname,cid);
    }
    
    public Collection<entity.Content> getLibrary(){
          String uname=(String)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
          return admin.getLibrary(uname);
    }
    
    public String getContentById(Integer id){
        entity.Content c=admin.getContentById(id);
        String name=c.getTitle();
        return name;
    }
}
