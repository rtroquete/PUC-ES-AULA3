package br.puc.se.designPatterns.behavioral.log.templatemethod;

import java.util.Date;

import br.puc.se.designPatterns.behavioral.log.AbstractLogger;
import br.puc.se.designPatterns.behavioral.log.LogLevel;

public class FileLogger extends AbstractLogger {

	private String fileName = "./output.log";
	
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getFileName() {
		return fileName;
	}
	
	public String formatMessage(LogLevel messageLevel, String message) {
		return String.format("[Logger: %s on %s]:%s:%s: %s", "FileLogger", this.fileName, new Date(), messageLevel, message);
	}
	
	@Override
	public String getOutput() {
		return this.fileName;
	}

}


