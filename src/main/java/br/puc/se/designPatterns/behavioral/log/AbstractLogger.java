package br.puc.se.designPatterns.behavioral.log;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractLogger implements Logger {
	
private LogLevel level = LogLevel.INFO;
	
	private Set<LogListener> listeners = new HashSet<>();
	
	@Override
	public void addListener(LogListener listener) {
		this.listeners.add(listener);
	}
	
	@Override
	public void log(LogLevel messageLevel, String message) {
		if (messageLevel.getPriority() <= level.getPriority()) {
			String formatedMessage = this.formatMessage(messageLevel, message);
			this.doLog(formatedMessage);
		}
	}
	
	public abstract String formatMessage(LogLevel messageLevel, String message);
	
	@Override
	public void setLogLevel(LogLevel logLevel) {
		this.level= logLevel;
	}
	
	public void doLog(String formatedMessage) {
		// mocking the http post over internet and notify the listeners
		for (LogListener listener : listeners) {
			listener.onLog(formatedMessage);
		}
	}

}
