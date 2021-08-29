package com.hanif.testAPI;

import lombok.extern.slf4j.Slf4j;
import spring.beans.factory.annotation.Autowired;
import web.bind.bind.annotation.*;
import javax.validation.Valid;

public interface FeatureRepository extends JpaRepository{

	Feature findFeatureByEmailandFeatureName(@Param("email") String email, @Param("feature_name") String featureName);
}