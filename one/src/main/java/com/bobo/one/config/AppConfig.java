package com.bobo.one.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

	@Value("${spring.application.name}")
	private String appName;
	@Value("${service.feign.url}")
	private String feignUrl;
	@Value("${server.port}")
	private String serverPort;
	@Value("${server.default:default.111}")
	private String defaultName;
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	public String getFeignUrl() {
		return feignUrl;
	}
	public void setFeignUrl(String feignUrl) {
		this.feignUrl = feignUrl;
	}
	public String getServerPort() {
		return serverPort;
	}
	public void setServerPort(String serverPort) {
		this.serverPort = serverPort;
	}
	public String getDefaultName() {
		return defaultName;
	}
	public void setDefaultName(String defaultName) {
		this.defaultName = defaultName;
	}
}
