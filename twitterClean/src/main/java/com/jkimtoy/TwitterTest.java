package com.jkimtoy;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

public class TwitterTest {
	//�������� ����
	static String accessToken="";
	static String accessSecret="";
		
	static Twitter twitter;
	static RequestToken requestToken=null;
	static AccessToken finalAccessToken=null;

	 public static void main(String[] args){
	//twitter ��ü �ʱ�ȭ + consumer ���� set
	twitter = TwitterFactory.getSingleton();
	
	//getInstance�ص� ������, ������ ������ ��ū�� ����Ͽ� �־ ��. getInstance�ҰŸ� �޼ҵ带 �����ؾ��Ѵ�. 
	//twitter.setOAuthConsumer(TwitterInfo.getInstance().getAPIKey(), TwitterInfo.getInstance().getAPISecretKey());

	
	
	try {
		requestToken = twitter.getOAuthRequestToken();
	}catch(TwitterException e) {
		e.printStackTrace();
	}
	System. out.println(requestToken.getAuthorizationURL());
	        
	
	twitter.setOAuthAccessToken(finalAccessToken);
	try {
    	//������ ȹ��
		User user = twitter.verifyCredentials();
		System.out.println(user.getScreenName());
		
        //������ Ʈ�� ���
		String msg = "this is test tweet from application";
		Status status = twitter.updateStatus(msg);		
	}catch(Exception e) {
		e.printStackTrace();
}

	 }
}
