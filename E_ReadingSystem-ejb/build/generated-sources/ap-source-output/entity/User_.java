package entity;

import entity.Role;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-09-18T15:20:10")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> image;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, Integer> follower;
    public static volatile CollectionAttribute<User, Role> roleCollection;
    public static volatile SingularAttribute<User, String> phone;
    public static volatile SingularAttribute<User, Integer> following;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> username;

}