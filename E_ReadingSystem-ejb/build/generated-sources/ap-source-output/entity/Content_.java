package entity;

import entity.Author;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-09-18T15:20:10")
@StaticMetamodel(Content.class)
public class Content_ { 

    public static volatile SingularAttribute<Content, String> image;
    public static volatile CollectionAttribute<Content, Author> authorCollection;
    public static volatile SingularAttribute<Content, Integer> contentId;
    public static volatile SingularAttribute<Content, String> description;
    public static volatile SingularAttribute<Content, Integer> typeId;
    public static volatile SingularAttribute<Content, String> title;
    public static volatile SingularAttribute<Content, Integer> categoryId;
    public static volatile SingularAttribute<Content, Integer> likes;
    public static volatile SingularAttribute<Content, Integer> noOfTimeRead;

}