/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Akshay
 */
@Entity
@Table(name = "content")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Content.findAll", query = "SELECT c FROM Content c"),
    @NamedQuery(name = "Content.findByContentId", query = "SELECT c FROM Content c WHERE c.contentId = :contentId"),
    @NamedQuery(name = "Content.findByTitle", query = "SELECT c FROM Content c WHERE c.title = :title"),
    @NamedQuery(name = "Content.findByCategoryId", query = "SELECT c FROM Content c WHERE c.categoryId = :categoryId"),
    @NamedQuery(name = "Content.findByTypeId", query = "SELECT c FROM Content c WHERE c.typeId = :typeId"),
    @NamedQuery(name = "Content.findByLikes", query = "SELECT c FROM Content c WHERE c.likes = :likes"),
    @NamedQuery(name = "Content.findByDescription", query = "SELECT c FROM Content c WHERE c.description = :description"),
    @NamedQuery(name = "Content.findByNoOfTimeRead", query = "SELECT c FROM Content c WHERE c.noOfTimeRead = :noOfTimeRead")})
public class Content implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "contentId")
    private Integer contentId;
    @Basic(optional = false)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @Lob
    @Column(name = "image")
    private String image;
    @Column(name = "categoryId")
    private Integer categoryId;
    @Column(name = "typeId")
    private Integer typeId;
    @Column(name = "likes")
    private Integer likes;
    @Column(name = "description")
    private String description;
    @Column(name = "no_of_time_read")
    private Integer noOfTimeRead;
     @ManyToMany(mappedBy="bookCollection")
    private Collection<Author> authorCollection;

    @JsonbTransient
    public Collection<Author> getAuthorCollection(){
        return authorCollection;
    }
    
    public void setAuthorCollection(Collection<Author> authors){
        this.authorCollection=authorCollection;
    }
    

    public Content() {
    }

    public Content(Integer contentId) {
        this.contentId = contentId;
    }

    public Content(Integer contentId, String title, String image) {
        this.contentId = contentId;
        this.title = title;
        this.image = image;
    }

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNoOfTimeRead() {
        return noOfTimeRead;
    }

    public void setNoOfTimeRead(Integer noOfTimeRead) {
        this.noOfTimeRead = noOfTimeRead;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (contentId != null ? contentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Content)) {
            return false;
        }
        Content other = (Content) object;
        if ((this.contentId == null && other.contentId != null) || (this.contentId != null && !this.contentId.equals(other.contentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Content[ contentId=" + contentId + " ]";
    }
    
}
