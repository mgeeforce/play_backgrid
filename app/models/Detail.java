package models;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Detail extends EntityObject {
	
	private static final long serialVersionUID = 1L;

	public Date detailDate;
	public int inventory;

	@Column(precision = 9, scale = 2)
	public BigDecimal price;
	
	@ManyToOne
	public Item item;

}
