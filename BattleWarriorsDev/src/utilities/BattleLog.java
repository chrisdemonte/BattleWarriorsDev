package utilities;

import java.util.ArrayList;


public class BattleLog {
	
	ArrayList<String> log;
	int logLength;
	
	public BattleLog() {
		super();
		this.log = new ArrayList<String>();
		this.logLength = 0;
	}

	public ArrayList<String> getLog() {
		return log;
	}

	public void setLog(ArrayList<String> log) {
		this.log = log;
	}

	public int getLogLength() {
		return logLength;
	}

	public void setLogLength(int logLength) {
		this.logLength = logLength;
	}
	public void addToLog (String str) {
		log.add(str);
	}
	
	

}
