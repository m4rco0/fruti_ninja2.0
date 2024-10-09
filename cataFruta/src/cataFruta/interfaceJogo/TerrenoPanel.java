package cataFruta.interfaceJogo;

import javax.swing.*;
import java.awt.*;

public class TerrenoPanel extends JPanel {
    private int rows;
    private int cols;
    private terreno.Terreno terreno;

    // Constructor to set up the size of the board (NxM)
    public TerrenoPanel(terreno.Terreno terreno) {
        int dim = terreno.getDimensao();
        this.rows = dim;
        this.cols = dim;
        this.terreno = terreno;
        setPreferredSize(new Dimension(800, 800)); // Set preferred size for the panel
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int tileWidth = getWidth() / cols;  // Calculate the width of each tile
        int tileHeight = getHeight() / rows;  // Calculate the height of each tile

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                String label = "";

                // Check if the tile has a map element
                if (this.terreno.hasMapa(row, col)) {
                    if (this.terreno.getMapa()[row][col] instanceof competidor.Competidor) {
                        competidor.Competidor c = (competidor.Competidor) this.terreno.getMapa()[row][col];
                        label = c.getNome();

                        // Set tile color to white and text color to black
                        g.setColor(Color.WHITE);  // Tile color
                        g.fillRect(col * tileWidth, row * tileHeight, tileWidth, tileHeight); // Draw the tile
                        g.setColor(Color.BLACK);  // Text color
                    } else if (this.terreno.getMapa()[row][col] instanceof cataFruta.Elemento) {
                        label = this.terreno.getMapa()[row][col].getTipo();

                        // Set tile color to white and text color to black
                        g.setColor(Color.WHITE);  // Tile color
                        g.fillRect(col * tileWidth, row * tileHeight, tileWidth, tileHeight); // Draw the tile
                        g.setColor(Color.BLACK);  // Text color
                    }
                } else {
                    // This tile represents GRAMA
                    label = "GRAMA";
                    g.setColor(Color.GREEN);  // Tile color
                    g.fillRect(col * tileWidth, row * tileHeight, tileWidth, tileHeight); // Draw the tile
                    g.setColor(Color.BLACK);  // Text color
                }

                // Draw the label in the center of the tile
                FontMetrics fm = g.getFontMetrics();
                int textWidth = fm.stringWidth(label);
                int textHeight = fm.getAscent();
                int x = col * tileWidth + (tileWidth - textWidth) / 2;  // Center the text horizontally
                int y = row * tileHeight + (tileHeight + textHeight) / 2;  // Center the text vertically
                g.drawString(label, x, y);  // Draw the text on the tile

                // Draw the border around the tile
                g.setColor(Color.BLACK);  // Set border color to black
                g.drawRect(col * tileWidth, row * tileHeight, tileWidth, tileHeight);  // Draw the border
            }
        }
    }
}
