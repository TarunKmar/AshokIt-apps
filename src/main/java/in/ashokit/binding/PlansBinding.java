package in.ashokit.binding;

import java.time.LocalDate;

import lombok.Data;

@Data
public class PlansBinding {
   
	private String PlanName;
	private Integer planCategoryId;
	private String ActiveSwitch;
	 private String CreatedBy;
	 private LocalDate planEndDate;
	 private String UpdatedBy;
	 private LocalDate planStartDate;
	
	
}
