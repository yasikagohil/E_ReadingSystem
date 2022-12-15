package entity;

import entity.Content;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-09-18T15:20:10")
@StaticMetamodel(Author.class)
public class Author_ { 

    public static volatile SingularAttribute<Author, String> image;
    public static volatile SingularAttribute<Author, Integer> follower;
    public static volatile SingularAttribute<Author, String> authorName;
    public static volatile SingularAttribute<Author, Integer> following;
    public static volatile SingularAttribute<Author, Integer> authorId;
    public static volatile CollectionAttribute<Author, Content> bookCollection;

}