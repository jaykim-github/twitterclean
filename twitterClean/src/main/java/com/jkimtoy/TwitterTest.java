package com.jkimtoy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

@Controller
@PropertySource("src/main/resources/twitter.properties")
public class TwitterTest {
	//전역변수 선언
	static String accessToken="";
	static String accessSecret="";
		
	static Twitter twitter;
	static RequestToken requestToken=null;
	static AccessToken finalAccessToken=null;
	
	@Autowired
	TwitterProperties prop;
	
	private static String apiKey;
	
	@Value("${apiKey}")
	private void setApiKey(String key) {
		apiKey = key;
	}

	 public static void main(String[] args){
		 
	//twitter 객체 초기화 + consumer 인증 set
	twitter = TwitterFactory.getSingleton();
	
	//getInstance해도 되지만, 기존에 얻어놓은 토큰을 사용하여 넣어도 됨. getInstance할거면 메소드를 생성해야한다. 
	//twitter.setOAuthConsumer(TwitterInfo.getInstance().getAPIKey(), TwitterInfo.getInstance().getAPISecretKey());
	twitter.setOAuthConsumer("", "");
	
	try {
		requestToken = twitter.getOAuthRequestToken();
	}catch(TwitterException e) {
		e.printStackTrace();
	}
	System. out.println(requestToken.getAuthorizationURL());
	
	finalAccessToken=new AccessToken("1407688173241569283-QZDLSI knGiGQEogLR1O5x6SXfNBFkl", "w5gW4F0QDAXlAwnUVJRCilmk89N4NOn33yO0ge8UFHv3O");
	
	twitter.setOAuthAccessToken(finalAccessToken);
	try {
    	//계정명 획득
		User user = twitter.verifyCredentials();
		System.out.println(user.getScreenName());
		
        //계정에 트윗 등록
		String msg = "테스트";
		Status status = twitter.updateStatus(msg);		
	}catch(Exception e) {
		e.printStackTrace();
	}
	

	 }
}
