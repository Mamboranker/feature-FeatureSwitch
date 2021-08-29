package com.hanif.testAPI;

import lombok.extern.slf4j.Slf4j;
import spring.beans.factory.annotation.Autowired;
import web.bind.bind.annotation.*;
import javax.validation.Valid;

public interface FatureService {
	public FeatureDto getCustFeature (String email, String featureName);
	public UpdateFeatureResponse updateCustFeature(UpdateFeatureRequest request);
}