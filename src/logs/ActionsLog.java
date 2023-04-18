package logs;

public class ActionsLog {
	
	static String log;
	
	public ActionsLog() {
		log = "";
	}
	
	public static void registerAction(String action) {
		log += action + "\n";
	} 
	
	@Override
	public String toString() {
		return log;
	}
}
