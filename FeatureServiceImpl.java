package com.hanif.testAPI;

import lombok.extern.slf4j.Slf4j;
import spring.beans.factory.annotation.Autowired;
import web.bind.bind.annotation.*;
import javax.validation.Valid;

@Slf4j
@Service
public class FeatureServiceImpl implements FeatureService {
	@Autowired Feature feature;
	@Autowired FeatureRepository featureRepository;
	@Autowired FeatureDto featureDto;
	@Autowired UpdateFeatureResponse updateFeatureResponse;
	
	public FeatureDto getCustFeature(String email, String featureName){
	
		//1. check if user session valid
		//2. Check if feature still active or already disable, else return feature inactive/disable
		
		//3. Find user record of feature in DB
		
		feature = featureRepository.findFeatureByEmailandFeatureName(email, featureName);
		
		if(feature!=null){
			featureDto.setCanAccess(true);
			return featureDto;
		}
		else{
			featureDto.setCanAccess(false);
			return featureDto;
		}
	}
	
	@Transactional
	public UpdateFeatureResponse updateCustFeature(UpdateFeatureRequest request){
	
		//1. check if user session valid
		//2. Check if feature still active or already disable, else return feature inactive/disable
		
		//3. Check if request is empty
		if(request != null && !request.getEmail().isEmpty() !request.getFeatureName().isEmpty()){
			feature = featureRepository.findFeatureByEmailandFeatureName(request.getEmail, request.getFeatureName);
			
			if(feature!=null){
				feature.setEnable(request.getEnable());
				featureRespository.saveAndFlush(feature);
				updateFeatureResponse.setHttpStatus("HTTPStatus OK(200)");
				return updateFeatureResponse;
			}
			else{
				updateFeatureResponse.setHttpStatus("HTTPStatus Not Modified(304)");
				return updateFeatureResponse;
			
			}
		}
		else{
			updateFeatureResponse.setHttpStatus("HTTPStatus Not Modified(304)");
				return updateFeatureResponse;
		}
		
	}
}