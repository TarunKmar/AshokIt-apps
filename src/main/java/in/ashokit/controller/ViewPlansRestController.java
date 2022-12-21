package in.ashokit.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.binding.PlansBinding;
import in.ashokit.constants.AppConstants;
import in.ashokit.entity.PlanMaster;
import in.ashokit.props.AppProperties;
import in.ashokit.service.ViewPlanService;
import net.bytebuddy.asm.Advice.This;

@RestController
public class ViewPlansRestController {
	
	private ViewPlanService service;
	

	private AppProperties app;
	private Map<String, String> message;
	
public  ViewPlansRestController(ViewPlanService service,AppProperties app) {
	
	this.service=service;
	this.message=app.getMessage();
	System.out.println(this.message);
	
	
}
	
	
	@GetMapping("/plancatageory")
	public ResponseEntity<Map<Integer, String>> getPlanCatageroes(){
		Map<Integer, String> planCategory = service.getPlanCategory();
		return new ResponseEntity<>(planCategory,HttpStatus.OK);
		}

	
	@PostMapping("/plan")
	public ResponseEntity<String> savePlan(@RequestBody PlansBinding plan ){
		
		String msg=AppConstants.EMPTY_STR;
		boolean save = service.save(plan);
		if(save ) {
			
			 msg = message.get(AppConstants.PLAN_SAVE_SUCC);
			
		}else {
			msg=message.get(AppConstants.PLAN_SAVE_FAIL);
			}
		return new ResponseEntity<>(msg,HttpStatus.CREATED);
		}
	
	
	@GetMapping("/Allplans")
	public ResponseEntity<List<PlanMaster>> getAllPlnas(){
	List<PlanMaster> allPlanDetails = service.getAllPlanDetails();
		return new ResponseEntity<>(allPlanDetails,HttpStatus.OK);
	}
	
	
	@GetMapping("/pans/{planId}")
	public ResponseEntity<PlanMaster> getPlanById(@PathVariable Integer planId){
		PlanMaster planById = service.getPlanById(planId);
		return new ResponseEntity<>(planById,HttpStatus.CREATED);
		}
	
	
	@PutMapping("/update")
	public ResponseEntity<String> updatePlans(@RequestBody PlanMaster plan){
		

		String msg=AppConstants.EMPTY_STR;
		boolean updatePlanById = service.UpdatePlanById(plan);
		if(updatePlanById) {
			msg= message.get(AppConstants.PLAN_UPDATE_SUCC);
			}else {
				msg= message.get(AppConstants.PLAN_UPDATE_FAIL);
				}
		return new ResponseEntity<>(msg,HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> DeletePlan(@PathVariable Integer id){
		
		String msg=AppConstants.EMPTY_STR;
		boolean updatePlanById = service.deleteById(id);
		if(updatePlanById) {
			msg=message.get(AppConstants.PLAN_DELETE_SUCC);
			}else {
				msg=message.get(AppConstants.PLAN_DELETE_FAIL);
				}
		return new ResponseEntity<>(msg,HttpStatus.CREATED);
	}
		
	
	@PutMapping("/statuschange/{id}/{status}")
	public ResponseEntity<String> planStatusChange(@PathVariable Integer id,@PathVariable String status){
		
		String msg=AppConstants.EMPTY_STR;
	boolean planStatusChange = service.planStatusChange(id, status);
		if(planStatusChange) {
			msg=message.get(AppConstants.PLAN_STATUS_SUCC);
			}else {
				msg=message.get(AppConstants.PLAN_STATUS_FAIL);
				}
		return new ResponseEntity<>(msg,HttpStatus.CREATED);
	}
	

	
	
}
