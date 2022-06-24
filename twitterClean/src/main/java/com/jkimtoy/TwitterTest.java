package com.jkimtoy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
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

@SpringBootApplication
public class TwitterTest {
	// 전역변수 선언
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

	public static void twit(String[] args) {

		try (ConfigurableApplicationContext ctx = SpringApplication.run(TwitterTest.class, args)) {
			TwitterTest m = ctx.getBean(TwitterTest.class);		

			// twitter 객체 초기화 + consumer 인증 set
			twitter = TwitterFactory.getSingleton();

			twitter.setOAuthConsumer(m.apikey(),m.apisecretKey());

			try {
				requestToken = twitter.getOAuthRequestToken();
			} catch (TwitterException e) {
				e.printStackTrace();
			}
			System.out.println(requestToken.getAuthorizationURL());

			finalAccessToken = new AccessToken(m.accesstoken(),m.secrettoken);

			twitter.setOAuthAccessToken(finalAccessToken);
			try {
				// 계정명 획득
				User user = twitter.verifyCredentials();
				System.out.println(user.getScreenName());

				// 계정에 트윗 등록
				String msg = "properties 파일 테스트";
				Status status = twitter.updateStatus(msg);
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
}
