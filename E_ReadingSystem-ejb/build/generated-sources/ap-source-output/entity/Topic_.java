package entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2022-09-18T15:20:10")
@StaticMetamodel(Topic.class)
public class Topic_ { 

    public static volatile SingularAttribute<Topic, Integer> topicId;
    public static volatile SingularAttribute<Topic, Integer> contentId;
    public static volatile SingularAttribute<Topic, String> topicName;
    public static volatile SingularAttribute<Topic, String> description;
    public static volatile SingularAttribute<Topic, Integer> chepterId;

}