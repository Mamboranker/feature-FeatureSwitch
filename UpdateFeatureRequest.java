package com.hanif.testAPI;

import lombok.extern.slf4j.Slf4j;
import spring.beans.factory.annotation.Autowired;
import web.bind.bind.annotation.*;
import javax.validation.Valid;

@Data
@NoArgsConstructor
public class UpdateFeatureRequest {
	
	private String featureName;
	private String email;
	private Boolean enable;
	
}