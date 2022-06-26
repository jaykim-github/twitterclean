package com.jkimtoy;

import java.util.HashMap;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

public class TwitterService {
	// �������� ����
		static String accessToken = "";
		static String accessSecret = "";

		static Twitter twitter;
		static RequestToken requestToken = null;
		static AccessToken finalAccessToken = null;

		@Value("${apiKey}")
		private String apiKey;
		@Value("${apiKeySecret}")
		private String apisecretKey;
		
		@Value("${accesstoken}")
		private String accesstoken;
		@Value("${secrettoken}")
		private String secrettoken;

		public String apikey() {
			return this.apiKey;
		}

		public String apisecretKey() {
			return this.apisecretKey;
		}
		
		public String accesstoken() {
			return this.accesstoken;
		}
		public String secrettoken() {
			return this.secrettoken;
		}

	
	public String[] twitting(HashMap<String,Object> req_data) {
		//������ ���� �����͵��� ������ String�� �������ϴµ�...
		
		String arr[] = new String[100];
		Set<String> keySet = req_data.keySet();
		
		for(int i=0; i<arr.length; i++) {
			String str = "";
			
			for (String key : keySet) {	
				str += req_data.get("person") + " ";
				if(!key.equals("person")) {
					//System.out.println(key + " : " + req_data.get(key));
					str += req_data.get(key) + "\\r\\n";
				}
			}
			
			arr[i] = str;
			str = "";

		}
		
		return arr;
	}
	
	
	public void twit(HashMap<String,Object> req_data) {
		TwitterService service = new TwitterService();
		
		String arr[] = service.twitting(req_data);

		try (ConfigurableApplicationContext ctx = SpringApplication.run(TwitterService.class, arr)) {
			TwitterService m = ctx.getBean(TwitterService.class);		

			// twitter ��ü �ʱ�ȭ + consumer ���� set
			twitter = TwitterFactory.getSingleton();

			twitter.setOAuthConsumer(m.apikey(),m.apisecretKey());

			try {
				requestToken = twitter.getOAuthRequestToken();
			} catch (TwitterException e) {
				e.printStackTrace();
			}
			System.out.println(requestToken.getAuthorizationURL());

			finalAccessToken = new AccessToken(m.accesstoken(),m.secrettoken());

			twitter.setOAuthAccessToken(finalAccessToken);
			try {
				// ������ ȹ��
				User user = twitter.verifyCredentials();
				System.out.println(user.getScreenName());

				// ������ Ʈ�� ���
				//String msg = "properties ���� �׽�Ʈ";
				
				for(int i = 0; i<arr.length; i++) {
					Status status = twitter.updateStatus(arr[i]);
				}
		
				
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
	}
}
