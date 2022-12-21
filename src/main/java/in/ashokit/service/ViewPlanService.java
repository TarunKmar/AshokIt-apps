package in.ashokit.service;

import java.util.List;
import java.util.Map;

import in.ashokit.binding.PlansBinding;
import in.ashokit.entity.PlanMaster;

public interface ViewPlanService {
	public Map<Integer, String> getPlanCategory();
	
	public boolean save(PlansBinding plan);
	
	public  List<PlanMaster> getAllPlanDetails();
	
	public PlanMaster getPlanById(Integer id);
	
	public boolean UpdatePlanById(PlanMaster plan);
	
	public boolean deleteById(Integer id);
	
	public boolean planStatusChange(Integer id,String staus);
	
	
	

}
