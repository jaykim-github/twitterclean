package com.jkimtoy;

import java.util.HashMap;

public class TwitterService {
	public int twitting(HashMap<String,Object> req_data) {
		//폼에서 받은 데이터들을 가지고 String을 만들어야하는데...
		
		String arr[] = new String[100];
		
		for(int i=0; i<arr.length; i++) {
			String str = "";
			for(int j = 0; j<req_data.size(); j++) {
				//hashmap 키값 기준으로 스트링에 값 추가해서 더하기, 대상자 + 키워드 값 더해서 String하나하나 배열에 저장하기
			}
		}
		
		
		return 1;
	}
}
