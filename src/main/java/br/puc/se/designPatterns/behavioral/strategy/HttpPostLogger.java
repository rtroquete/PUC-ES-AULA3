package br.puc.se.designPatterns.behavioral.strategy;

import java.util.Date;

import br.puc.se.designPatterns.behavioral.log.AbstractLogger;
import br.puc.se.designPatterns.behavioral.log.LogLevel;

public class HttpPostLogger extends AbstractLogger {

	private String uri = "http://localhost:8080";
	
	public void setUri(String uri) {
		this.uri = uri;
	}
	
	public String getUri() {
		return uri;
	}
	
	public String formatMessage(LogLevel messageLevel, String message) {
		return String.format("[Logger: %s on %s]:%s:%s: %s", "HttpPostLogger", this.uri, new Date(), messageLevel, message);
	}

	@Override
	public String getOutput() {
		return this.uri;
	}
}

