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
import entity.Library;
import entity.Likes;
import entity.Role;
import entity.Topic;
import entity.User;
import java.util.Collection;
import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Akshay
 */
@DeclareRoles({"Admin","User"})
@PermitAll
@Stateless
public class adminBean implements adminBeanLocal {
@PersistenceContext(unitName="E_ReadingSystemPU")
  EntityManager em;

public adminBean(){
    
}

    public adminBean(EntityManager em) {
        this.em = em;
    }

  @Override
  public Collection<User> getAllUsers(){
      return em.createNamedQuery("User.findAll").getResultList();
  }

  @Override
  public User getUserByName(String username){
      User user=(User)em.find(User.class,username);
      return user;
  }
  
 @Override
  public void addUser(String Username,String Password,String Phone,String Email){
      User user=new User(Username,Password,"E:/yg/profilePhoto",Phone,Email,0,0);
      em.persist(user); 
  }
  
  @Override
    public void updateUser(String Username,String Password,String image,String Phone,String Email){
        User user=(User)em.find(User.class,Username);
        user.setPassword(Password);
        user.setImage(image);
        user.setEmail(Email);
        user.setPhone(Phone);
        em.merge(user);
   }
    
    @Override
    public void deleteUser(String Username){
        User user=(User)em.find(User.class,Username);
        em.remove(user);
    }
 
    @Override
    public Collection<ContentCategory> getAllContentCategory(){
        return em.createNamedQuery("ContentCategory.findAll").getResultList();
    }
    
    @Override
    public void addCategory(String categoryName){
        ContentCategory category=new ContentCategory();
        category.setCategoryName(categoryName);
        em.persist(category);
    }
    
    @Override
    public void updateCategory(Integer categoryId,String categoryName){
        ContentCategory category=(ContentCategory)em.find(ContentCategory.class,categoryId);
        category.setCategoryName(categoryName);
        em.merge(category); 
    }
    
    @Override
    public void deleteCategory(Integer categoryId){
        ContentCategory category=(ContentCategory)em.find(ContentCategory.class,categoryId);
        em.remove(category);
    }
    
    @Override
    public ContentCategory getCategoryById(Integer id){
        return em.find(ContentCategory.class,id);
    }
    
    @Override
    public Collection<ContentType> getAllContentType(){
        return em.createNamedQuery("ContentType.findAll").getResultList();
    }
    
    @Override
    public void addType(String typeName){
        ContentType type=new ContentType();
        type.setTypeName(typeName);
        em.persist(type);
    }
    
    @Override
    public void updateType(Integer typeId,String typeName){
        ContentType type=(ContentType)em.find(ContentType.class,typeId);
        type.setTypeName(typeName);
        em.merge(type);
    }
    
    @Override
    public void deleteType(Integer typeId){
        ContentType type=(ContentType)em.find(ContentType.class,typeId);
        em.remove(type);
    }
    
    @Override
     public ContentType getTypeById(Integer id){
         return em.find(ContentType.class,id);
     }
  
     @Override
    public Collection<Topic> getAllTopic(){
        return em.createNamedQuery("Topic.findAll").getResultList();
    }
    
     @Override
    public void addTopic(Integer contentId,Integer chepterId,String topicName,String desc){
        Topic topic=new Topic();
        topic.setContentId(contentId);
        topic.setChepterId(chepterId);
        topic.setTopicName(topicName);
        topic.setDescription(desc);
        em.persist(topic);
    }
     @Override
    public void updateTopic(Integer topicId,Integer contentId,Integer chepterId,String topicName,String desc){
        Topic topic=(Topic)em.find(Topic.class,topicId);
        topic.setContentId(contentId);
        topic.setChepterId(chepterId);
        topic.setTopicName(topicName);
        topic.setDescription(desc);
        em.merge(topic);
    }
    
     @Override
    public void deleteTopic(Integer topicId){
        Topic topic=(Topic)em.find(Topic.class,topicId);
        em.remove(topic);
    }
    
    @Override
    public Topic getTopicById(Integer id){
        return em.find(Topic.class,id);
    }
    
    @Override
    public Collection<Chepter> getAllChepter(){
        return em.createNamedQuery("Chepter.findAll").getResultList();
    }
    
    @Override
    public void addChepter(Integer contentId,String chepterName,String desc){
        Chepter chepter=new Chepter();
        chepter.setContentId(contentId);
        chepter.setChepterName(chepterName);
        chepter.setDescription(desc);
        em.persist(chepter);
    }
    
    @Override
    public void updateChepter(Integer chepterId,Integer contentId,String chepterName,String desc){
        Chepter chepter=(Chepter)em.find(Chepter.class,chepterId);
        chepter.setContentId(contentId);
        chepter.setChepterName(chepterName);
        chepter.setDescription(desc);
        em.merge(chepter);
    }
    
    @Override
    public void deleteChepter(Integer chepterId){
        Chepter chepter=(Chepter)em.find(Chepter.class,chepterId);
        em.remove(chepter);
    }
    
    @Override
    public Chepter getChepterById(Integer id){
        return em.find(Chepter.class,id);
    }
    
    @Override
    public Collection<Content> getAllContent(){
        return em.createNamedQuery("Content.findAll").getResultList();
    }
    
    @Override
    public Content getContentById(Integer id){
        Content content=(Content)em.find(Content.class,id);
        return content;
    }
    
    @Override
    public Collection<Content> getContentByCategory(Integer id){
        return em.createNamedQuery("Content.findByCategoryId").setParameter("categoryId",id).getResultList();    
    }
    
    @Override
    public void addContent(String title,String image,Integer CategoryId,Integer typeId,String desc,Integer noOfTimeRead,Integer likes){
        Content content=new Content();
        content.setTitle(title);
        content.setCategoryId(CategoryId);
        content.setImage(image);
        content.setTypeId(typeId);
        content.setDescription(desc);
        content.setNoOfTimeRead(0);
        content.setLikes(likes);
        em.persist(content);
    }
    
     @Override
    public void updateContent(Integer contentId,String title,String image,Integer CategoryId,Integer typeId,String desc){
        Content content=(Content)em.find(Content.class,contentId);
        content.setTitle(title);
        content.setImage(image);
        content.setCategoryId(CategoryId);
        content.setTypeId(typeId);
        content.setDescription(desc);
        em.merge(content);
    }
    
    @Override
    public void updateLike(Integer id)
    {
        String name=(String)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
        Likes like=new Likes();
        like.setUsername(name);
        like.setContentId(id);
        em.persist(like);
        
        Content content=(Content)em.find(Content.class,id);
        int l=content.getLikes();
        content.setLikes(l+1);
        em.merge(content);
        if(varifyLike(id,name)==false){
            Likes like1=new Likes();
            like1.setUsername(name);
            like1.setContentId(id);
            em.persist(like1);

            Content content1=(Content)em.find(Content.class,id);
            int l1=content1.getLikes();
            content.setLikes(l1-1);
            em.merge(content1);
        }
    }
    
//    @Override
    public boolean varifyLike(Integer cid,String uname){
        try{
        Likes f=(Likes)em.createNamedQuery("Likes.findByUserContent").setParameter("username",uname).setParameter("contentId",cid).getSingleResult();
        if(f.getLikeId()==null){
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
    public void updateReading(Integer id){
        Content content=(Content)em.find(Content.class,id);
        int r=content.getNoOfTimeRead();
        content.setNoOfTimeRead(r+1);
        em.merge(content);
    }
    
     @Override
    public void deleteContent(Integer contentId){
        Content content=(Content)em.find(Content.class,contentId);
        em.remove(content);
    }
    
    @Override
    public Collection<Author> getAllAuthor(){
        return em.createNamedQuery("Author.findAll").getResultList();
    }
    
    @Override
    public void addAuthor(String authorName){
        Author author=new Author();
        author.setAuthorName(authorName);
        author.setFollower(0);
        author.setFollowing(0);
        em.persist(author);
    }
    
    @Override
    public void updateAuthor(Integer authorId,String authorName){
        Author author=(Author)em.find(Author.class,authorId);
        author.setAuthorName(authorName);
        em.merge(author);
    }
    
    @Override
    public void deleteAuthor(Integer authorId){
        Author author=(Author)em.find(Author.class,authorId);
        em.remove(author);
    }
    
    @Override
     public Author getAuthorById(Integer id)
     {
         return em.find(Author.class,id);
     }
    
    @Override
    public void addRoleOfUser(String username,Collection<String> roleIds){
        User user=(User)em.find(User.class,username);
        Collection<Role> roles=user.getRoleCollection();
        
        for(String rname:roleIds){
            Role role=(Role)em.find(Role.class,rname);
            
            if(!roles.contains(role)){
                Collection<User> users=role.getUserCollection();
                users.add(user);
                roles.add(role);
                user.setRoleCollection(roles);
                role.setUserCollection(users);
                em.merge(user);
            }
        }
    }
    
    @Override
    public void addBookOfAuthor(Integer authorId,Collection<Integer> contentIds){
        Author author=(Author)em.find(Author.class,authorId);
        Collection<Content> contents=author.getBookCollection();
        
        for(Integer cid:contentIds){
            Content content=em.find(Content.class,cid);
            
            if(!contents.contains(content)){
                Collection<Author> authors=content.getAuthorCollection();
                authors.add(author);
                contents.add(content);
                author.setBookCollection(contents);
                content.setAuthorCollection(authors);
                em.merge(author);
            }
        }
    }
    
    @Override
    public Integer getAuthorByName(String name){
        Integer id;
        Author a=(Author)em.createNamedQuery("Author.findByAuthorName").setParameter("authorName",name).getSingleResult();
//        Author a=em.find(Author.class,name);
        id=a.getAuthorId();
        return id;
    }
    
    @Override
    public Collection<Content> getContentOfAuthorId(Integer id){
        Author a=em.find(Author.class,id);
        return a.getBookCollection();
    }
    
    
    @Override
    public Collection<Content> getContentOfAuthor(String aname){
        Author a=(Author)em.createNamedQuery("Author.findByAuthorName").setParameter("authorName",aname).getSingleResult();
        return a.getBookCollection();
    }
    
    @Override
    public Collection<Role> getRolesOfUser(String username){
        User u=em.find(User.class,username);
        return u.getRoleCollection();
    }
    
    @Override
    public Collection<User> getUsersByRole(String roleName){
        Role r=em.find(Role.class,roleName);
        return r.getUserCollection();
    }
    
    @Override
    public void addToLibrary(String uname,Integer cid){
        Library library=new Library();
        library.setUsername(uname);
        library.setContentId(cid);
        em.persist(library);
    }
    
    @Override
    public Collection<Content> getLibrary(String uname){
        return em.createNamedQuery("Library.findByUsername").setParameter("username",uname).getResultList();
    }
}
