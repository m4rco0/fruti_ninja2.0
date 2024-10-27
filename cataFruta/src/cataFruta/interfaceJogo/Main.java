package cataFruta.interfaceJogo;

import javax.swing.SwingUtilities;

public class Main {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JogoFrame jogoFrame = new JogoFrame();
			jogoFrame.setVisible(true);
		});
	}
}
