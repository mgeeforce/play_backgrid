package models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.avaje.ebean.Page;

import play.data.validation.Constraints.Required;
//import play.db.ebean.Model.Finder;

@Entity
public class Item extends EntityObject {
	
	private static final long serialVersionUID = 1L;
	@Required
	public String name;
	public String description;
	public Date date;
	public int quantity;

	@Column(precision = 9, scale = 2)
	public BigDecimal amount;
	
	@OneToMany
	public List<Detail> details;
	
    public static Finder<Long,Item> find = new Finder<Long,Item>(Long.class, Item.class); 
    
    /**
     * Return a page of expense items
     *
     * @param page Page to display
     * @param pageSize Number of reports per page
     * @param sortBy Transaction property used for sorting
     * @param order Sort order (either or asc or desc)
     * @param filter Filter applied on the title column
     * @param status Status attribute of entity
     */
    public static Page<Item> page(int page, int pageSize, String sortBy, String order, String filter) {
    	return 
            find.where()
                .ilike("name", "%" + filter + "%")
                .orderBy(sortBy + " " + order)
                .findPagingList(pageSize)
                .setFetchAhead(false)
                .getPage(page);
    }


}
