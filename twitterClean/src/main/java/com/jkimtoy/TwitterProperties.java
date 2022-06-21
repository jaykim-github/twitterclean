package com.jkimtoy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TwitterProperties {
	@Value("${apiKey}")
	private String apiKey;
	
	@Value("${apiKeySecret}")
	private String apiKeySecret;
	
	public String getApiKey() {
		return apiKey;
	}
	
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	
	public String getApiKeySecret() {
		return apiKeySecret;
	}
	
	public void setApiKeySecret(String apiKeySecret) {
		this.apiKeySecret = apiKeySecret;
	}
	
	
}
