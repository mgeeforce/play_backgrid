package models;

import javax.persistence.*;

import java.sql.Timestamp;

import play.db.ebean.Model;
import play.data.validation.*;

import com.avaje.ebean.annotation.CreatedTimestamp;
import com.avaje.ebean.annotation.UpdatedTimestamp;
import com.fasterxml.jackson.annotation.*;


/**
 * Product entity managed by Ebean
 */
@SuppressWarnings("serial")
@MappedSuperclass
public class EntityObject extends Model {
	
    @Id
    public Long id;

    @Version
    @CreatedTimestamp
    @JsonIgnore
    public Timestamp created;
    
    @UpdatedTimestamp
    @JsonIgnore
    public Timestamp updated;
    

    
}