package com.jkimtoy;

import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

public class TwitterTest {
	//�������� ����
	static String accessToken="";
	static String accessSecret="";
		
	static Twitter twitter;	
	RequestToken requestToken = null;
	AccessToken finalAccessToken = null;
	
	 public static void main(String[] args){
	
	//twitter ��ü �ʱ�ȭ + consumer ���� set
	twitter = TwitterFactory.getSingleton();
	twitter.setOAuthConsumer(TwitterTest.getInstance().getAPIKey(), 
			TwitterTest.getInstance().getAPISecretKey());
	
	 }

}
