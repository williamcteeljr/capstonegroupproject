package com.capstone.project;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class SpringMVCController {
	

	
	@RequestMapping(value = "/firstPage")
	public String firstPage(ModelMap model) {
		

		model.addAttribute("message", "Spring MVC AngularJS RESTFul Service");
		
		return "index";		
	}
	
	@RequestMapping(value = "/angularServiceCall")
	public String angularServiceCall(ModelMap model) {
		
		model.addAttribute("message", "Spring MVC AngularJS");		
		return "AngularJSService";		
	}

	@RequestMapping(value = "/getSampleJSONData/{name}")
	public @ResponseBody String getSampleJSONData(@PathVariable String name) {		

		JSONObject jo = new JSONObject();
		jo.put("values", new JSONArray(new Long[][]{{1025409600000L,23L},{1028088000000L,19L},{1030766400000L,21L},{1033358400000L,22L}}));		
		jo.put("key", "North America");
		
		JSONArray ja = new JSONArray();
		
		for (int i = 0; i < 10; i++) {
			ja.put(jo);
		}
		
		return ja.toString();	
	}


}
