package cataFruta.interfaceJogo;

/**
 * Main do projeto
 */
import javax.swing.SwingUtilities;

/**
 * {@link Class Main} classe princiapl
 */
public class Main {

	/**
	 * Construtor do main
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JogoFrame jogoFrame = new JogoFrame();
			jogoFrame.setVisible(true);
		});
	}
}
