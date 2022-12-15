/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Content;
import entity.Library;
import entity.User;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Akshay
 */
@Local
public interface readerBeanLocal {
     public Collection<User> getUsersByName(String username);
    public void addUser(String Username, String Password, String image, String Phone, String Email);
    public void updateUser(String Username, String Password, String image, String Phone, String Email);
    public void deleteUser(String Username);
    
    public Collection<Content> getAllContent();
    public Collection<Content> getContentByTitle(String title);
    public Collection<Content> getContentByCategory(Integer category);
    public Collection<Content> getContentByType(Integer type);
    
    public void Like(String username,Integer contentId);
    public void Comment(String username,Integer contentId,String desc);
    public void Follow(String username,Integer authorId);
    
    public Collection<Library> getAllLibraryContent(String username);
    public void addToLibrary(String username,Integer contentId);
    public void deleteFromLibrary(Integer libraryId,String username,Integer contentId);
}
