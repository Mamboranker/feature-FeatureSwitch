package com.hanif.testAPI;

import lombok.extern.slf4j.Slf4j;
import spring.beans.factory.annotation.Autowired;
import web.bind.bind.annotation.*;
import javax.validation.Valid;

@Data
@ToString
@AllArgsConstructor
@Entity
@Table(name = "TBL_USER_FEATURE", 
       uniqueConstraint = {@UniqueConstraint(columnNames) = {"id"}, name = "id_unique")})
	   
public class Feature implements Serializable{
	
		@Column(name = "id")
		private UUID id;
		
		@Column(name = "feature_code")
		private String featureCode;
		
		@Column(name = "cust_email")
		private String custEmail;
}