package interfaceJogo;

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
                if (this.terreno.hasMapa(row, col)) {
                    if (this.terreno.getMapa()[row][col] instanceof competidor.Competidor) {
                        competidor.Competidor c = (competidor.Competidor) this.terreno.getMapa()[row][col];
                        System.out.println(c.getNome());
                        label = c.getNome();
                    } else if(this.terreno.getMapa()[row][col] instanceof cataFruta.Elemento) {
                        label = this.terreno.getMapa()[row][col].getTipo();
                        System.out.println(label);
                    }

                    // Draw the label in the center of the tile
//                    g.fil/**/lRect(col * tileWidth, row * tileHeight, tileWidth, tileHeight); // Draw each rectangle

                }
                FontMetrics fm = g.getFontMetrics();
                int textWidth = fm.stringWidth(label);
                int textHeight = fm.getAscent();
                int x = col * tileWidth + (tileWidth - textWidth) / 2;  // Center the text horizontally
                int y = row * tileHeight + (tileHeight + textHeight) / 2;  // Center the text vertically
                g.drawString(label, x, y);  // Draw the text on the tile
//                g.setColor(Color.WHITE);  // Alternate between white...
            }
        }
    }
}
