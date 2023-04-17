/*
 *Info from: https://www.youtube.com/watch?v=cXtm9aMmyhU
 */

package AppUI;

/* Esto es para que se muestre por pantalla la consola. No lo estoy usando ya. Va en el main, dentro del constructor
PrintStream printStream = new PrintStream(new CustomOutpuStream(textArea));
System.setOut(printStream);
System.setErr(printStream);
*/

import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JTextArea;

public class CustomOutpuStream extends OutputStream{
	
	// Attributes
	private JTextArea textArea;
	
	// Constructor
	public CustomOutpuStream(JTextArea textArea) {
		this.textArea = textArea;		
	}
	
	// Methods
	@Override
	public void write(int b) throws IOException {
		// redirects data to the text area
		textArea.append(String.valueOf((char)b));
		// scrolls the text area to the end of data
		textArea.setCaretPosition(textArea.getDocument().getLength());
		// keeps the textArea up to date
		textArea.update(textArea.getGraphics());
		
	}
		

}
