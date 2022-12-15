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
@Table(name = "content_type")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ContentType.findAll", query = "SELECT c FROM ContentType c"),
    @NamedQuery(name = "ContentType.findByTypeId", query = "SELECT c FROM ContentType c WHERE c.typeId = :typeId"),
    @NamedQuery(name = "ContentType.findByTypeName", query = "SELECT c FROM ContentType c WHERE c.typeName = :typeName")})
public class ContentType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "typeId")
    private Integer typeId;
    @Basic(optional = false)
    @Column(name = "typeName")
    private String typeName;

    public ContentType() {
    }

    public ContentType(Integer typeId) {
        this.typeId = typeId;
    }

    public ContentType(Integer typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (typeId != null ? typeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContentType)) {
            return false;
        }
        ContentType other = (ContentType) object;
        if ((this.typeId == null && other.typeId != null) || (this.typeId != null && !this.typeId.equals(other.typeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ContentType[ typeId=" + typeId + " ]";
    }
    
}
