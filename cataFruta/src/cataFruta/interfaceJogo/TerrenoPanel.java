package cataFruta.interfaceJogo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

import competidor.Competidor;
import estruturas.Arvore;
import estruturas.Pedra;
import frutas.Frutas;;

public class TerrenoPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private int rows;
	private int cols;
	private terreno.Terreno terreno;

	// Constructor to set up the size of the board (NxM)
	public TerrenoPanel(terreno.Terreno terreno) {
		this.terreno = terreno;
		int dim = terreno.getDimensao();
		this.rows = dim;
		this.cols = dim;
		this.setBackground(Color.GREEN);
		setPreferredSize(new Dimension(800, 800)); // Set preferred size for the panel
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// Image background = new
		// ImageIcon("/home/marco/git/fruti_ninja2.0/cataFruta/sprites/grama.png").getImage();
		// g.drawImage(background, 0, 0, getWidth(), getHeight(), this);

		int tileWidth = getWidth() / cols; // Calculate the width of each tile
		int tileHeight = getHeight() / rows; // Calculate the height of each tile

		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				Image image = null;

				// Check if the tile has a map element
				if (this.terreno.hasMapa(row, col)) {
					Object element = this.terreno.getMapa()[row][col];
					if (element instanceof Competidor) {
						Competidor c = (Competidor) element;
						image = c.getImg();
						g.drawString(c.getNome(), col * tileWidth, row * tileHeight);
					} else if (element instanceof Pedra) {
						Pedra p = (Pedra) element;
						image = p.getImg();
					} else if (element instanceof Frutas) {
						Frutas f = (Frutas) element;
						image = f.getImg();
					} else if (element instanceof Arvore) {
						Arvore a = (Arvore) element;
						image = a.getImg();
					}

					if (image != null) {
						g.drawImage(image, col * tileWidth, row * tileHeight, tileWidth, tileHeight, this);
					} else {
						// g.drawImage(background, col*tileWidth, row * tileHeight,tileWidth,
						// tileHeight, this);
					}
				} else {
					// This tile represents GRAMA
					g.setColor(getBackground());
					 // Tile color
					g.fillRect(col * tileWidth, row * tileHeight, tileWidth, tileHeight); // Draw the tile
				}
				// Draw the border around the tile
				g.setColor(Color.BLACK); // Set border color to black
				g.drawRect(col * tileWidth, row * tileHeight, tileWidth, tileHeight); // Draw the border
			}
		}
	}
}
