package in.ashokit.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name = "PLAN_CATEGORY")
public class PlanCategory {
	@Id
	@GeneratedValue
	@Column(name = "CATEGORY_ID")
	private Integer categoryId;
	@Column(name = "CATEGORY_NAME")
	private String categoryName;
	@Column(name = "ACTIVE_SW")
    private char ActiveSwitch;
	
	@Column(name = "CREATED_BY")
    private String CreatedBy;
	@Column(name = "UPDATED_BY")
     private String UpdatedBy;
	
	@Column(name = "CREATE_DATE",updatable = false)
	@CreationTimestamp
     private LocalDate CreatedDate;
	
	@Column(name = "UPDATE_DATE" ,insertable = false)
	@UpdateTimestamp
     private LocalDate UpdatedDate;
}
