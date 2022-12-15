/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:RestERSResource [restERS]<br>
 * USAGE:
 * <pre>
 *        restClient client = new restClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Akshay
 */
public class restClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/E_ReadingSystem-war/webresources";

    public restClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("restERS");
    }

    public void deleteTopic(String topicId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteTopic/{0}", new Object[]{topicId})).request().delete();
    }

    public void addUser(String Username,String Password, String Phone, String Email) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("adduser/{0}/{1}/{2}/{3}", new Object[]{Username,Password,Phone,Email})).request().post(null);
    }

    public void updateCategory(String categoryId, String categoryName) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateCategory/{0}/{1}", new Object[]{categoryId, categoryName})).request().post(null);
    }

    public <T> T getAuthorById(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getAuthorById/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllChepter(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllChepter");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void deleteContent(String contentId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteContent/{0}", new Object[]{contentId})).request().delete();
    }

    public <T> T getAllContentCategory(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAlContentCategory");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addCategory(String categoryName) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addCategory/{0}", new Object[]{categoryName})).request().post(null);
    }

    public <T> T getAuthorByName(Class<T> responseType, String authorName) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getAuthorByName/{0}", new Object[]{authorName}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateTopic(String topicId, String contentId, String chepterId, String topicName, String desc) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateTopic/{0}/{1}/{2}/{3}/{4}", new Object[]{topicId, contentId, chepterId, topicName, desc})).request().post(null);
    }

    public void updateChepter(String chepterId, String contentId, String chepterName, String desc) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateChepter/{0}/{1}/{2}/{3}", new Object[]{chepterId, contentId, chepterName, desc})).request().post(null);
    }

    public <T> T getRolesOfUser(Class<T> responseType, String username) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getRolesOfUser/{0}", new Object[]{username}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateLike(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateLike/{0}", new Object[]{id})).request().post(null);
    }

    public <T> T getAllAuthor(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllAuthor");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void deleteAuthor(String authorId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteAuthor/{0}", new Object[]{authorId})).request().delete();
    }

    public String getJson() throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
    }

    public <T> T getTypeById(Class<T> responseType, String typeId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getTypeById/{0}", new Object[]{typeId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getTopicById(Class<T> responseType, String topicId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getTopicById/{0}", new Object[]{topicId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllUsers(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addRoleOfUser(String username, String roleIds) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addRoleOfUser/{0}/{1}", new Object[]{username, roleIds})).request().post(null);
    }

    public <T> T getContentOfAuthor(Class<T> responseType, String authorName) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getContentOfAuthor/{0}", new Object[]{authorName}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getUsersByRole(Class<T> responseType, String roleName) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getUsersByRole/{0}", new Object[]{roleName}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getContentOfAuthorId(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getContentOfAuthorId/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void deleteType(String typeId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteType/{0}", new Object[]{typeId})).request().delete();
    }

    public <T> T getAllTopic(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllTopic");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addAuthor(String authorname) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addAuthor/{0}", new Object[]{authorname})).request().post(null);
    }

    public void updateUser(String Username, String Password, String Image, String Phone, String Email) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateUser/{0}/{1}/{2}/{3}/{4}", new Object[]{Username, Password, Image, Phone, Email})).request().post(null);
    }

    public <T> T getContentById(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getContentById/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addBookOfAuthor(String authorId, String contentIds) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addBookOfAuthor/{0}/{1}", new Object[]{authorId, contentIds})).request().post(null);
    }

    public <T> T getAllContent(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllcontent");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addContent(String title, String image, String categoryId, String typeId, String desc, String noOfread, String likes) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addContent/{0}/{1}/{2}/{3}/{4}/{5}/{6}", new Object[]{title, image, categoryId, typeId, desc, noOfread, likes})).request().post(null);
    }

    public void deleteCategory() throws ClientErrorException {
        webTarget.path("deleteCategory/categoryId").request().delete();
    }

    public <T> T getContentByCategory(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getContentByCategory/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addType(String typeName) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addType/{0}", new Object[]{typeName})).request().post(null);
    }

    public void putJson(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void addChepter(String contentId, String chepterName, String desc) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addChepter/{0}/{1}/{2}", new Object[]{contentId, chepterName, desc})).request().post(null);
    }

    public <T> T getCategoryById(Class<T> responseType, String categoryId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getCategoryById/{0}", new Object[]{categoryId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void deleteChepter(String chepterId) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deletChepter/{0}", new Object[]{chepterId})).request().delete();
    }

    public void addTopic(String contentId, String chepterId, String topicName, String desc) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addTopic/{0}/{1}/{2}/{3}", new Object[]{contentId, chepterId, topicName, desc})).request().post(null);
    }

    public void deleteUser(String Username) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteUser/{0}", new Object[]{Username})).request().delete();
    }

    public void updateReading(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateReading/{0}", new Object[]{id})).request().post(null);
    }

    public void updateAuthor(String authorId, String authorName) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateAuthor/{0}/{1}", new Object[]{authorId, authorName})).request().post(null);
    }

    public <T> T getUserByName(Class<T> responseType, String username) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getUserByName/{0}", new Object[]{username}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllContentType(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getAllContentType");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateContent(String contentId, String title, String image, String categoryId, String typeId, String desc) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateContent/{0}/{1}/{2}/{3}/{4}/{5}", new Object[]{contentId, title, image, categoryId, typeId, desc})).request().post(null);
    }

    public <T> T getChepterById(Class<T> responseType, String chepterId) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getChepterById/{0}", new Object[]{chepterId}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateType(String typeId, String typeName) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateType/{0}/{1}", new Object[]{typeId, typeName})).request().post(null);
    }

    public void close() {
        client.close();
    }
    
}
