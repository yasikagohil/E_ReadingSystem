/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Akshay
 */
@Entity
@Table(name = "draft")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Draft.findAll", query = "SELECT d FROM Draft d"),
    @NamedQuery(name = "Draft.findByDraftId", query = "SELECT d FROM Draft d WHERE d.draftId = :draftId"),
    @NamedQuery(name = "Draft.findByUsername", query = "SELECT d FROM Draft d WHERE d.username = :username"),
    @NamedQuery(name = "Draft.findByContentTitle", query = "SELECT d FROM Draft d WHERE d.contentTitle = :contentTitle"),
    @NamedQuery(name = "Draft.findByCategoryId", query = "SELECT d FROM Draft d WHERE d.categoryId = :categoryId"),
    @NamedQuery(name = "Draft.findByTypeId", query = "SELECT d FROM Draft d WHERE d.typeId = :typeId"),
    @NamedQuery(name = "Draft.findByDescription", query = "SELECT d FROM Draft d WHERE d.description = :description")})
public class Draft implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "draftId")
    private Integer draftId;
    @Column(name = "username")
    private String username;
    @Column(name = "contentTitle")
    private String contentTitle;
    @Lob
    @Column(name = "image")
    private String image;
    @Column(name = "categoryId")
    private Integer categoryId;
    @Column(name = "typeId")
    private Integer typeId;
    @Column(name = "description")
    private String description;

    public Draft() {
    }

    public Draft(Integer draftId) {
        this.draftId = draftId;
    }

    public Integer getDraftId() {
        return draftId;
    }

    public void setDraftId(Integer draftId) {
        this.draftId = draftId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContentTitle() {
        return contentTitle;
    }

    public void setContentTitle(String contentTitle) {
        this.contentTitle = contentTitle;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (draftId != null ? draftId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Draft)) {
            return false;
        }
        Draft other = (Draft) object;
        if ((this.draftId == null && other.draftId != null) || (this.draftId != null && !this.draftId.equals(other.draftId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Draft[ draftId=" + draftId + " ]";
    }
    
}
