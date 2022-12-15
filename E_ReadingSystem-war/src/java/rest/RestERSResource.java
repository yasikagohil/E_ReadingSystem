/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import ejb.adminBeanLocal;
import entity.Author;
import entity.Chepter;
import entity.Content;
import entity.ContentCategory;
import entity.ContentType;
import entity.Role;
import entity.Topic;
import entity.User;
import java.util.Collection;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Akshay
 */

@DeclareRoles({"Admin","User"})
@PermitAll
@Path("restERS")
public class RestERSResource {

    @Context
    private UriInfo context;
    @EJB adminBeanLocal admin;
   
    public RestERSResource() {
    }
      
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<User> getAllUsers(){
      return admin.getUsersByRole("User");                         
    }

    @Path("adduser/{Username/{Password}/{Phone}/{Email}")
    @POST
    public void addUser(@PathParam("Username")String Username,@PathParam("Password")String Password,@PathParam("Phone")String Phone,@PathParam("Email")String Email){
        admin.addUser(Username, Password, Phone, Email);
    }

    @Path("updateUser/{Username}/{Password}/{Image}/{Phone}/{Email}")
    @POST
      public void updateUser(@PathParam("Username")String Username,@PathParam("Password")String Password,@PathParam("Image")String Image,@PathParam("Phone")String Phone,@PathParam("Email")String Email){
        admin.updateUser(Username, Password, Image, Phone, Email);
   }
    
    @Path("deleteUser/{Username}")
    @DELETE
    public void deleteUser(@PathParam("Username")String Username){
       admin.deleteUser(Username);
    }
   
    @GET
    @Path("getUserByName/{username}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User getUserByName(@PathParam("username") String username){
        return admin.getUserByName(username);
    }
 
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAlContentCategory")
    public Collection<ContentCategory> getAllContentCategory(){
       return  admin.getAllContentCategory();
    }
    
    @POST
    @Path("addCategory/{categoryName}")
    public void addCategory(@PathParam("categoryName") String categoryName){
        admin.addCategory(categoryName);
    }
    
    @POST
    @Path("updateCategory/{categoryId}/{categoryName}")
    public void updateCategory(Integer categoryId,String categoryName){
        admin.updateCategory(categoryId, categoryName);
    }
    
    @DELETE
    @Path("deleteCategory/categoryId")
    public void deleteCategory(@PathParam("categoryId") Integer categoryId){
        admin.deleteCategory(categoryId);
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getCategoryById/{categoryId}")
    public ContentCategory getCategoryById(@PathParam("categoryId") Integer id){
        return admin.getCategoryById(id);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAllContentType")
    public Collection<ContentType> getAllContentType(){
        return admin.getAllContentType();
    }
    
    @POST
    @Path("addType/{typeName}")
    public void addType(@PathParam("typeName") String typeName){
        admin.addType(typeName);
    }
    
    @POST
    @Path("updateType/{typeId}/{typeName}")
    public void updateType(@PathParam("typeId")Integer typeId,@PathParam("typeName")String typeName){
        admin.updateType(typeId, typeName);
    }
    
    @DELETE
    @Path("deleteType/{typeId}")
    public void deleteType(@PathParam("typeId")Integer typeId){
        admin.deleteType(typeId);
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getTypeById/{typeId}")
    public ContentType getTypeById(@PathParam("typeId") Integer id){
        return admin.getTypeById(id);
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAllTopic")
    public Collection<Topic> getAllTopic(){
        return admin.getAllTopic();
    }
    
    @POST
    @Path("addTopic/{contentId}/{chepterId}/{topicName}/{desc}")
    public void addTopic(@PathParam("contentId")Integer contentId,@PathParam("chepterId")Integer chepterId,@PathParam("topicName")String topicName,@PathParam("desc")String desc){
        admin.addTopic(contentId, chepterId, topicName, desc);
    }
    
    @POST
    @Path("updateTopic/{topicId}/{contentId}/{chepterId}/{topicName}/{desc}")
    public void updateTopic(@PathParam("topicId")Integer topicId,@PathParam("contentId")Integer contentId,@PathParam("chepterId")Integer chepterId,@PathParam("topicName")String topicName,@PathParam("desc")String desc){
        admin.updateTopic(topicId, contentId, chepterId, topicName, desc);
    }
    
    @DELETE
    @Path("deleteTopic/{topicId}")
    public void deleteTopic(@PathParam("topicId")Integer topicId){
        admin.deleteTopic(topicId);
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getTopicById/{topicId}")
    public Topic getTopicById(@PathParam("topicId")Integer id){
        return admin.getTopicById(id);
    }
    
    @GET
    @Path("getAllChepter")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Chepter> getAllChepter(){
        return admin.getAllChepter();
    }
    
    @POST
    @Path("addChepter/{contentId}/{chepterName}/{desc}")
    public void addChepter(@PathParam("contentId")Integer contentId,@PathParam("chepterName")String chepterName,@PathParam("desc")String desc){
        admin.addChepter(contentId, chepterName, desc);
    }
    
    @POST
    @Path("updateChepter/{chepterId}/{contentId}/{chepterName}/{desc}")
    public void updateChepter(@PathParam("chepterId")Integer chepterId,@PathParam("contentId")Integer contentId,@PathParam("chepterName")String chepterName,@PathParam("desc")String desc){
        admin.updateChepter(chepterId, contentId, chepterName, desc);
    }
    
    @DELETE
    @Path("deletChepter/{chepterId}")
    public void deleteChepter(@PathParam("chepterId")Integer chepterId){
        admin.deleteChepter(chepterId);
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getChepterById/{chepterId}")
    public Chepter getChepterById(@PathParam("chepterId")Integer id){
        return admin.getChepterById(id);
    }
    
    @GET
    @Path("getAllcontent")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Content> getAllContent(){
        return admin.getAllContent();
    }
    
    @POST
    @Path("addContent/{title}/{image}/{categoryId}/{typeId}/{desc}/{noOfread}/{likes}")
    public void addContent(@PathParam("title")String title,@PathParam("image")String image,@PathParam("categoryId")Integer CategoryId,@PathParam("typeId")Integer typeId,@PathParam("desc")String desc,@PathParam("noOfread")Integer noOfTimeRead,@PathParam("likes")Integer likes){
        admin.addContent(title, image, CategoryId, typeId, desc, noOfTimeRead, likes);
    }
    
    @POST
    @Path("updateContent/{contentId}/{title}/{image}/{categoryId}/{typeId}/{desc}")
    public void updateContent(@PathParam("contentId")Integer contentId,@PathParam("title")String title,@PathParam("image")String image,@PathParam("categoryId")Integer CategoryId,@PathParam("typeId")Integer typeId,@PathParam("desc")String desc){
        admin.updateContent(contentId, title, image, CategoryId, typeId, desc);
    }
    
    @DELETE
    @Path("deleteContent/{contentId}")
    public void deleteContent(@PathParam("contentId")Integer contentId){
        admin.deleteContent(contentId);
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getContentById/{id}")
    public Content getContentById(@PathParam("id")Integer id){
        return admin.getContentById(id);
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getContentByCategory/{id}")
    public Collection<Content> getContentByCategory(@PathParam("id")Integer id){
        return admin.getContentByCategory(id);
    }
    
    @POST
    @Path("updateLike/{id}")
    public void updateLike(@PathParam("id")Integer id){
        admin.updateLike(id);
    }
    
    @POST
    @Path("updateReading/{id}")
    public void updateReading(@PathParam("id")Integer id){
        admin.updateReading(id);
    }
    
    @GET
    @Path("getAllAuthor")
    public Collection<Author> getAllAuthor(){
        return admin.getAllAuthor();
    }
    
    @POST
    @Path("addAuthor/{authorname}")
    public void addAuthor(@PathParam("authorName")String authorName){
        admin.addAuthor(authorName);
    }
    
    @POST
    @Path("updateAuthor/{authorId}/{authorName}")
    public void updateAuthor(@PathParam("")Integer authorId,@PathParam("")String authorName){
        admin.updateAuthor(authorId, authorName);
    }
    
    @DELETE
    @Path("deleteAuthor/{authorId}")
    public void deleteAuthor(@PathParam("authorID")Integer authorId){
        admin.deleteAuthor(authorId);
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAuthorById/{id}")
    public Author getAuthorById(@PathParam("id")Integer id){
        return admin.getAuthorById(id);
    }

    @POST
    @Path("addRoleOfUser/{username}/{roleIds}")
    public void addRoleOfUser(@PathParam("username")String username,@PathParam("roleIds")Collection<String> roleIds){
        admin.addRoleOfUser(username, roleIds);
    }
    
    @POST
    @Path("addBookOfAuthor/{authorId}/{contentIds}")
    public void addBookOfAuthor(@PathParam("authorId")Integer authorId,@PathParam("contentIds")Collection<Integer> contentIds){
        admin.addBookOfAuthor(authorId, contentIds);
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getAuthorByName/{authorName}")
    public Integer getAuthorByName(@PathParam("authorName")String name){
        return admin.getAuthorByName(name);
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getContentOfAuthorId/{id}")
    public Collection<Content> getContentOfAuthorId(@PathParam("id")Integer id){
        return admin.getContentOfAuthorId(id);
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getContentOfAuthor/{authorName}")
    public Collection<Content> getContentOfAuthor(@PathParam("authorName")String authorName){
        return admin.getContentOfAuthor(authorName);
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getRolesOfUser/{username}")
    public Collection<Role> getRolesOfUser(@PathParam("username")String username){
        return admin.getRolesOfUser(username);
    }
    
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("getUsersByRole/{roleName}")
    public Collection<User> getUsersByRole(@PathParam("roleName")String roleName){
        return admin.getUsersByRole(roleName);
    }

    /**
     * Retrieves representation of an instance of rest.RestERSResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of RestERSResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
