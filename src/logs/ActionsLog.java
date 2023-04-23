package logs;

/**
 * Log system to record different Strings about the actions realized by the
 * player or the npcs.<br>
 * The main attribute of the ActionsLog object is a string <b>(log)</b> when the
 * method registerAction(text) concatenate more text.<br>
 * Whit method toString() we read the log.
 * 
 * @author Fernando Tarrino del Pozo (FernandoEsra)
 *
 */

public class ActionsLog {
	
	static String log;
	
	/**
	 * Create a new empty action log.
	 */
	public ActionsLog() {
		log = "";
	}
	
	/**
	 * Concatenate a new action on the log.<br>
	 * There is <b>no need to add a page break</b>, the method adds it at the end
	 * automatically.
	 * 
	 * @param action New text with an action to be saved.
	 */
	public static void registerAction(String action) {
		log += action + "\n";
	} 
	
	@Override
	public String toString() {
		return log;
	}
}
