package in.ashokit.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.binding.PlansBinding;
import in.ashokit.entity.PlanCategory;
import in.ashokit.entity.PlanMaster;
import in.ashokit.repository.PlanCategoryRepository;
import in.ashokit.repository.PlanMasterRepository;

@Service
public class ViewPlnaServiceImpl implements ViewPlanService{
	@Autowired
	private PlanCategoryRepository categoryRepo;
	@Autowired
	private PlanMasterRepository planRepo;


	@Override
	public Map<Integer, String> getPlanCategory() {
		// TODO Auto-generated method stub
		List<PlanCategory> categoryList = categoryRepo.findAll();
		Map<Integer , String> map=new HashMap();
		categoryList.forEach(catageroy ->{
			map.put(catageroy.getCategoryId(), catageroy.getCategoryName());
		});
		return map;
	}
	
	
	
	//To Save Plan Details

	@Override
	public boolean save(PlansBinding plan) {
		// TODO Auto-generated method stub
		
		PlanMaster entity=new PlanMaster();
		BeanUtils.copyProperties(plan, entity);		
		PlanMaster save = planRepo.save(entity);
			/*
		if(save.getPlanId() != null) {
			return true;
		}else {
		return false;
		}
		*/
		return save.getPlanId() != null;
	}

	
	@Override
	public List<PlanMaster> getAllPlanDetails() {
		// TODO Auto-generated method stub
		List<PlanMaster> getAllPlans = planRepo.findAll();
		return getAllPlans;
	}
	

	@Override
	public PlanMaster getPlanById(Integer id) {
		// TODO Auto-generated method stub
                       Optional<PlanMaster> findById = planRepo.findById(id);
                       if(findById.isPresent()) {
                    	   return findById.get();
                           }
						return null;
						}

	@Override
	public boolean UpdatePlanById(PlanMaster plan) {
		// TODO Auto-generated method stub
		PlanMaster save = planRepo.save(plan);
		
		if(save.getPlanId() !=null) {
			
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteById(Integer id) {
		// TODO Auto-generated method stub
		
		boolean status=false;
		try {
		planRepo.deleteById(id);
	status=true;
	return status;
		
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean planStatusChange(Integer id, String staus) {
		// TODO Auto-generated method stub
			Optional<PlanMaster> findById = planRepo.findById(id);
			if(findById.isPresent()) {
				PlanMaster planMaster = findById.get();
			planMaster.setActiveSwitch(staus);
			planRepo.save(planMaster);
			return true;
			}
		return false;
	}
	

}
