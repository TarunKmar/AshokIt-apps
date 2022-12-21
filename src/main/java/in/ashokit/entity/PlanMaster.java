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
@Table(name = "PLAN_MASTER")
@Data
public class PlanMaster {
	@Id
	@Column(name = "PLAN_ID")
	@GeneratedValue
	private Integer PlanId;
	
	@Column(name = "PLAN_NAME")
	private String PlanName;
	
	@Column(name = "PLAN_START_DATE")
	private LocalDate planStartDate;
	
	@Column(name = "PLAN_END_DATE")
	private LocalDate planEndDate;
	
	@Column(name = "PLAN_CATEGORY_ID")
	private Integer planCategoryId;
	
	@Column(name = "ACTIVE_SW")
	private String ActiveSwitch;
	
	
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
