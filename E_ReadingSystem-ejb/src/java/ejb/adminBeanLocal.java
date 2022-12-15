/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Author;
import entity.Chepter;
import entity.Content;
import entity.ContentCategory;
import entity.ContentType;
import entity.Role;
import entity.Topic;
import entity.User;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Akshay
 */
@Local
public interface adminBeanLocal {
    public Collection<User> getAllUsers();
    public User getUserByName(String username);
    public void addUser(String Username,String Password,String Phone,String Email);
    public void updateUser(String Username,String Password,String image,String Phone,String Email);
    public void deleteUser(String Username);
    
    public Collection<ContentCategory> getAllContentCategory();
    public void addCategory(String categoryName);
    public void updateCategory(Integer categoryId,String categoryName);
    public void deleteCategory(Integer categoryId);
    public ContentCategory getCategoryById(Integer id);
    
    public Collection<ContentType> getAllContentType();
    public void addType(String typeName);
    public void updateType(Integer typeId,String typeName);
    public void deleteType(Integer typeId);
    public ContentType getTypeById(Integer id);
    
    public Collection<Topic> getAllTopic();
    public void addTopic(Integer contentId,Integer chepterId,String topicName,String desc);
    public void updateTopic(Integer topicId,Integer contentId,Integer chepterId,String topicName,String desc);
    public void deleteTopic(Integer topicId);
    public Topic getTopicById(Integer id);
    
    public Collection<Chepter> getAllChepter();
    public void addChepter(Integer contentId,String chepterName,String desc);
    public void updateChepter(Integer chepterId,Integer contentId,String chepterName,String desc);
    public void deleteChepter(Integer chepterId);
    public Chepter getChepterById(Integer id);
    
    public Collection<Content> getAllContent();
    public void addContent(String title,String image,Integer CategoryId,Integer typeId,String desc,Integer noOfTimeRead,Integer likes);
    public void updateContent(Integer contentId,String title,String image,Integer CategoryId,Integer typeId,String desc);
    public void deleteContent(Integer contentId);
    public Content getContentById(Integer id);
    public Collection<Content> getContentByCategory(Integer id);
    public void updateLike(Integer id);
    public void updateReading(Integer id);
    
    public Collection<Author> getAllAuthor();
    public void addAuthor(String authorName);
    public void updateAuthor(Integer authorId,String authorName);
    public void deleteAuthor(Integer authorId);
    public Author getAuthorById(Integer id);

    public void addRoleOfUser(String username,Collection<String> roleIds);
    public void addBookOfAuthor(Integer authorId,Collection<Integer> contentIds);
    public Integer getAuthorByName(String name);
    public Collection<Content> getContentOfAuthorId(Integer id);
    public Collection<Content> getContentOfAuthor(String authorName);
    public Collection<Role> getRolesOfUser(String username);
    public Collection<User> getUsersByRole(String roleName);
    public void addToLibrary(String uname,Integer cid);
    public Collection<Content> getLibrary(String uname);
}
