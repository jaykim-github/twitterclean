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
	
//	@Autowired
	TwitterService service;
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@ResponseBody
	@RequestMapping(value = "/twit", method = {RequestMethod.POST})
	public int twit(@RequestParam HashMap<String,Object> allParameters){
		//폼 데이터들을 담아 서비스로 넘기기, 서비스는 데이터들을 100번 트윗할 수 있도록  for문 생성
		service.twit(allParameters);
		
		return 1;
	
	}
}
