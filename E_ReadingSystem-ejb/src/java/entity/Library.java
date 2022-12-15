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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Akshay
 */
@Entity
@Table(name = "library")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Library.findAll", query = "SELECT l FROM Library l"),
    @NamedQuery(name = "Library.findByLibraryContentId", query = "SELECT l FROM Library l WHERE l.libraryContentId = :libraryContentId"),
    @NamedQuery(name = "Library.findByUsername", query = "SELECT l FROM Library l WHERE l.username = :username"),
    @NamedQuery(name = "Library.findByContentId", query = "SELECT l FROM Library l WHERE l.contentId = :contentId")})
public class Library implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "library_content_id")
    private Integer libraryContentId;
    @Column(name = "username")
    private String username;
    @Column(name = "contentId")
    private Integer contentId;

    public Library() {
    }

    public Library(Integer libraryContentId) {
        this.libraryContentId = libraryContentId;
    }

    public Integer getLibraryContentId() {
        return libraryContentId;
    }

    public void setLibraryContentId(Integer libraryContentId) {
        this.libraryContentId = libraryContentId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (libraryContentId != null ? libraryContentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Library)) {
            return false;
        }
        Library other = (Library) object;
        if ((this.libraryContentId == null && other.libraryContentId != null) || (this.libraryContentId != null && !this.libraryContentId.equals(other.libraryContentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Library[ libraryContentId=" + libraryContentId + " ]";
    }
    
}
