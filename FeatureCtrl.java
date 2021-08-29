package com.hanif.testAPI;

import lombok.extern.slf4j.Slf4j;
import spring.beans.factory.annotation.Autowired;
import web.bind.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping(produces = APPLICATION_JSON_VALUE)
@Slf4jpublic class FeatureController{

	@Autowired FeatureService featureService;

	@GetMapping(value = "/feature/get-cust-feature")
	@RequestHeaders
	public FeatureDto getFeature(@Valid
								 @RequestParam(value = "email") String email,
								 @RequestParam(value = "featureName") String featureName){
			return this.featureService.getCustFeature(email,featureName);
	}
	
	@PostMapping(value = "/feature/update-cust-feature")
	@RequestHeaders
	public UpdateFeatureResponse updateCustFeature(@Valid
												   @RequestBody UpdateFeatureRequest request){
			return this.featureService.updateCustFeatures(request);
	}
}