package com.jkimtoy;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class twitterController {
	
	@Autowired
	TwitterService service;
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@ResponseBody
	@RequestMapping(value = "/twit", method = {RequestMethod.POST})
	public int twit(@RequestParam HashMap<String,Object> allParameters, int seq){
		service.twit(allParameters, seq);
		
		return 1;
	
	}
}
