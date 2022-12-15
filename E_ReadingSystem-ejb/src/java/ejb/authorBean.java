/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Author;
import entity.Comments;
import entity.Content;
import entity.Draft;
import entity.Follow;
import entity.Library;
import entity.Likes;
import entity.User;
import java.util.Collection;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Akshay
 */
@DeclareRoles({"Admin","User"})
@PermitAll
@Stateless
public class authorBean implements authorBeanLocal {
    @PersistenceContext(unitName="E_ReadingSystemPU")
    EntityManager em;
    
    @Override
    public Collection<Draft> getAllDraft(String username){
        return em.createNamedQuery("Draft.findByUsername").setParameter("username",username).getResultList();
    }

    @Override
    public void addDraft(String username,String contentTitle,String image,Integer categoryId,Integer typeId,String desc){
        Draft draft=new Draft();
        draft.setUsername(username);
        draft.setContentTitle(contentTitle);
        draft.setImage(image);
        draft.setCategoryId(categoryId);
        draft.setTypeId(typeId);
        draft.setDescription(desc);
        em.persist(draft);
    }
    
    @Override
    public void deleteDraft(Integer draftId){
        Draft draft=(Draft)em.find(Draft.class,draftId);
        em.remove(draft);
    }
    
    @Override
    public Collection<User> getUsersByName(String username){
        return em.createNamedQuery("User.findByUsername").setParameter("username",username).getResultList();
    }
    
    @Override
    public Collection<Comments> getAllComment(){
        return em.createNamedQuery("Comments.findAll").getResultList();
    }
    
   @Override
  public void addUser(String Username,String Password,String image,String Phone,String Email){
      User user=new User(Username,Password,image,Phone,Email,0,0);
      em.persist(user); 
  }
  
  @Override
    public void updateUser(String Username,String Password,String image,String Phone,String Email){
        User user=(User)em.find(User.class,Username);
        user.setPassword(Password);
        user.setImage(image);
        user.setEmail(Email);
        user.setPhone(Phone);
        em.persist(user);
        //em.getTransaction().commit();
   }
    
    @Override
    public void deleteUser(String Username){
        User user=(User)em.find(User.class,Username);
        em.remove(user);
    }
 
    
    @Override
    public Collection<Content> getAllContent(){
        return em.createNamedQuery("Content.findAll").getResultList();
    }
    
    @Override
    public Collection<Content> getContentByTitle(String title){
        return em.createNamedQuery("Content.findByTitle").setParameter("title",title).getResultList();
    }
    
    @Override
    public Collection<Content> getContentByCategory(Integer category){
        return em.createNamedQuery("Content.findByCategoryId").setParameter("categoryId",category).getResultList();
    }
    
    @Override
    public Collection<Content> getContentByType(Integer type){
        return em.createNamedQuery("Content.findByTypeId").setParameter("typeId",type).getResultList();
    }
    
     
  
    @Override
    public void Like(String username,Integer contentId){
        
        Likes like=new Likes();
        like.setUsername(username);
        like.setContentId(contentId);
        em.persist(like);
        
        Content content=(Content)em.find(Content.class,contentId);
        int l=content.getLikes();
        content.setLikes(l+1);
        em.persist(content);
    
    }
    
    @Override
    public void Comment(String username,Integer contentId,String desc){
        Comments comment=new Comments();
        comment.setUsername(username);
        comment.setContentId(contentId);
        comment.setDescription(desc);
        em.persist(comment);
    }
    
    @Override
    public boolean varifyFollow(Integer aid,String uname){
        try{
        Follow f=(Follow)em.createNamedQuery("Follow.findByUserAuthor").setParameter("username",uname).setParameter("authorId",aid).getSingleResult();
        if(f.getFollowId()==null){
            return false;
        }
        else{
            return true;
        }
        }catch(Exception e){
            return false;
        }
    }
    
    @Override
    public void Follow(String username,Integer authorId){
        Follow follow=new Follow();
        follow.setAuthorId(authorId);
        follow.setUsername(username);
        em.persist(follow);
        
        Author author=(Author)em.find(Author.class,authorId);
        int f=author.getFollower();
        author.setFollower(f+1);
        em.merge(author);
        
        User user=(User)em.find(User.class,username);
        int r=user.getFollowing();
        user.setFollowing(r+1);
        em.merge(user);
        
        if(varifyFollow(authorId,username)==false){
            Follow follow1=new Follow();
            follow1.setAuthorId(authorId);
            follow1.setUsername(username);
            em.persist(follow1);

            Author author1=(Author)em.find(Author.class,authorId);
            int f1=author1.getFollower();
            author1.setFollower(f1-1);
            em.merge(author1);

            User user1=(User)em.find(User.class,username);
            int r1=user1.getFollowing();
            user.setFollowing(r1-1);
            em.merge(user1);
        }
    }
    
    @Override
    public Collection<Library> getAllLibraryContent(String username){
        return em.createNamedQuery("Library.findByUsername").setParameter("username",username).getResultList();
    }
    
    @Override
    public void addToLibrary(String username,Integer contentId){
        Library library=new Library();
        library.setUsername(username);
        library.setLibraryContentId(contentId);
        em.persist(library);
    }
    
    @Override
    public void deleteFromLibrary(Integer libraryId,String username,Integer contentId){
        Library library=(Library)em.find(Library.class,libraryId);
        em.remove(library);
    }
    
    @Override
    public Collection<Comments> getAllCommentById(Integer id){
        return em.createNamedQuery("Comments.findByContentId").setParameter("contentId",id).getResultList();
    }
}
