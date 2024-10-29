package cataFruta.interfaceJogo;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import competidor.*;
import frutas.*;
import estruturas.Pedra;
import estruturas.*;;

/**
 * Classe que vai pintar o terreno
 */
public class TerrenoPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private int rows;
    private int cols;
    private terreno.Terreno terreno;
    private Image imagem;
    Font novaFonte;

   /**
    * Construtor do terreno NxN
    * @param link
    */
    public TerrenoPanel(terreno.Terreno terreno) {
        this.terreno = terreno;
        int dim = terreno.getDimensao();
        this.rows = dim;
        this.cols = dim;
        setOpaque(false);
        setPreferredSize(new Dimension(800, 800)); // Set preferred size for the panel
        this.novaFonte = new Font("Arial", Font.PLAIN, 25);
    }
    

    /**
     * Pintura do projeto
     */
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image background = null;
		try {
			background = ImageIO.read(getClass().getResource("/sprites/fundo.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        g.drawImage(background, 0, 0, getWidth(), getHeight(), this);

        int tileWidth = getWidth() / cols;  
        int tileHeight = getHeight() / rows;  

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Image image = null;

                // Check if the tile has a map element
                if (this.terreno.hasMapa(row, col)) {
                    Object element = this.terreno.getMapa()[row][col];
                    if (element instanceof Competidor) {
                        Competidor c = (Competidor) element;
                        image = c.getImg();
                        
                        g.setFont(this.novaFonte);
                        g.drawString(c.getNome(), col * tileWidth, row * tileHeight);
                    } else if (element instanceof Pedra) {
                        Pedra p = (Pedra) element;
                        image = p.getImg();
                    } else if (element instanceof Frutas) {
                        Frutas f =  (Frutas) element;
                        image = f.getImg();
                    } else if (element instanceof Arvore) {
                        Arvore a = (Arvore) element;
                        image = a.getImg();
                    }

                    if (image != null) {
                    g.drawImage(image, col * tileWidth, row * tileHeight, tileWidth, tileHeight, this);
                    } else {
                    //g.drawImage(background, col*tileWidth, row * tileHeight,tileWidth, tileHeight, this);
                    }
                } else {
                    // This tile represents GRAMA
                    g.setColor(new Color(255, 255, 255, 0));  // Tile color
                    g.fillRect(col * tileWidth, row * tileHeight, tileWidth, tileHeight); // Draw the tile
                }
                // Draw the border around the tile
                g.setColor(Color.WHITE);
  
                g.drawRect(col * tileWidth, row * tileHeight, tileWidth, tileHeight);  // Draw the border
            }
        }
    }
    
}