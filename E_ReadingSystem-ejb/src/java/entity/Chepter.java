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
@Table(name = "chepter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chepter.findAll", query = "SELECT c FROM Chepter c"),
    @NamedQuery(name = "Chepter.findByChepterId", query = "SELECT c FROM Chepter c WHERE c.chepterId = :chepterId"),
    @NamedQuery(name = "Chepter.findByContentId", query = "SELECT c FROM Chepter c WHERE c.contentId = :contentId"),
    @NamedQuery(name = "Chepter.findByChepterName", query = "SELECT c FROM Chepter c WHERE c.chepterName = :chepterName"),
    @NamedQuery(name = "Chepter.findByDescription", query = "SELECT c FROM Chepter c WHERE c.description = :description")})
public class Chepter implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "chepterId")
    private Integer chepterId;
    @Column(name = "contentId")
    private Integer contentId;
    @Column(name = "chepterName")
    private String chepterName;
    @Column(name = "description")
    private String description;

    public Chepter() {
    }

    public Chepter(Integer chepterId) {
        this.chepterId = chepterId;
    }

    public Integer getChepterId() {
        return chepterId;
    }

    public void setChepterId(Integer chepterId) {
        this.chepterId = chepterId;
    }

    public Integer getContentId() {
        return contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    public String getChepterName() {
        return chepterName;
    }

    public void setChepterName(String chepterName) {
        this.chepterName = chepterName;
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
        hash += (chepterId != null ? chepterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chepter)) {
            return false;
        }
        Chepter other = (Chepter) object;
        if ((this.chepterId == null && other.chepterId != null) || (this.chepterId != null && !this.chepterId.equals(other.chepterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Chepter[ chepterId=" + chepterId + " ]";
    }
    
}
