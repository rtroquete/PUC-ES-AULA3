package br.puc.se.designPatterns.behavioral.strategy;

import java.util.Date;

import br.puc.se.designPatterns.behavioral.log.AbstractLogger;
import br.puc.se.designPatterns.behavioral.log.LogLevel;

public class ConsoleLogger extends AbstractLogger {

	public String formatMessage(LogLevel messageLevel, String message) {
		return String.format("[Logger: %s] %s:%s: %s", "ConsoleLogger", new Date(), messageLevel, message);
	}
	
	@Override
	public String getOutput() {
		return "";
	}

}
