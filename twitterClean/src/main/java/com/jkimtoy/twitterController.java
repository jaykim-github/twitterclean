package com.jkimtoy;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class twitterController {
	
//	@Autowired
//	TwitService service;
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/twit")
	public int twit(@RequestParam HashMap<String,Object> allParameters){
		//�� �����͵��� ��� ���񽺷� �ѱ��, ���񽺴� �����͵��� 100�� Ʈ���� �� �ֵ���  for�� ����
		//int result = service.Register(allParameters);
		
		return 1;
	}
}
