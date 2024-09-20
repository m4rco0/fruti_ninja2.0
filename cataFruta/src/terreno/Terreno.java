package terreno;

import java.util.Random;

import cataFruta.*;
import competidor.Competidor;
import estruturas.Arvore;
import estruturas.Grama;
import frutas.Frutas;
/**
 * Classe que constroi um terreno para inserir elementos e remover do mapa
 */
public  class   Terreno {
	private int dimensao;
	private Elemento[][] mapa;
	/**
	 * Construitor do Terreno
	 * @param dimensao - dimensão do mapa que vai ser gerado
	 */
	public Terreno(int dimensao) {
		this.dimensao = dimensao;
		this.setMapa(new Elemento[dimensao][dimensao]);
	}
	
	public void colocarGrama() {
		for (int i = 0; i < this.getDimensao(); i++) {
			for(int j = 0 ; j < this.getDimensao(); j++) {
				if(this.mapa[i][j] == null) {
					Grama grama = new Grama(i, j);
					this.inserirElem(i, j, grama);
				}
			}
		}
	}
	public void colocarArvores(Arvore arvore, int qtsArv, Terreno terreno) {
		Random rand = new Random();
		for(int i = 0; i < qtsArv; i++) {
			int posx = rand.nextInt(terreno.getDimensao()-1);
			int posy = rand.nextInt(terreno.getDimensao()-1);
			while(terreno.mapa[posx][posy] != null) {
				posx = rand.nextInt(terreno.getDimensao()-1);
				posy = rand.nextInt(terreno.getDimensao()-1);
			}
			terreno.inserirElem(posx, posy, arvore);
		}
	}
	/**
	 * Pega a dimensao do mapa
	 * @return dimensao - int
	 */
	public int getDimensao() {
		return this.dimensao;
	}
	/**
	 * Seta a dimensao de o mapa, caso queira mudar
	 * @param dimensao - int
	 */
	public void setDimensao(int dimensao) {
		this.dimensao = dimensao;
	}
	/**
	 * Retorna o mapa com os elementos inseridos nele
	 * @return mapa - Matriz de elementos
	 */
	public Elemento[][] getMapa() {
		return this.mapa;
	}
	
	
	public void exibirMapa() {
		for(int i = 0; i < this.getDimensao(); i++) {
			for(int j = 0; j < this.getDimensao(); j++) {
				if(this.mapa[i][j] != null) {
					if(this.mapa[i][j] instanceof Grama)
					{
						System.out.printf("%s", this.mapa[i][j].getTipo());
					} if (this.mapa[i][j] instanceof Competidor)
					{
						Competidor c = (Competidor) this.getMapa()[i][j];
						System.out.printf("%s", c.getNome());
					}
				}else {
					System.out.printf("NULL");
				}
				if(j < this.getDimensao())
					System.out.printf(" |");
			}
			System.out.println();
		}
	}
	/**
	 * 
	 * @param mapa
	 */
	public void setMapa(Elemento[][] mapa) {
		this.mapa = mapa;
	}
	/**
	 * Retorna o tipo elemento inserido naquela posição da matriz
	 * @param x	- posição x
	 * @param y - posição y
	 * @return tipo - String do tipo que esta no local
	 */
	public String elemTipo(int x, int y) {
		return this.mapa[x][y].getTipo();
	}
	/**
	 * Inseri um elemento no mapa
	 * @param x - posição x do elemento
	 * @param y - posição y do elemento
	 * @param elem O elemento que vai ser inserido
	 */
	public void inserirElem(int x, int y, Elemento elem) {
	    if(this.mapa[x][y] == null)
        	    this.mapa[x][y] = elem;
            else
                System.out.println("Espaço ja esta ocupado");
     }
	public Elemento getElemento(int x, int y) {
		if((x >= 0 && x < this.getDimensao()) && (y >= 0 && y < this.getDimensao()))
			return this.getMapa()[x][y];
		return null;

	}
	public Competidor getCompetidor(int x, int y) {
		return (Competidor) this.mapa[x][y];
	}
	/**
	 * Remove um elemento do mapa
	 * @param x - posição x do elemento
	 * @param y - posição y do elemento
	 */
     public void removerElem(int x, int y) {
    	 this.mapa[x][y] = null;
     }
     
     public Frutas pegarFruta(int x, int y) {
    	if(this.getMapa()[x][y] instanceof Frutas) {
    		Frutas fruta = (Frutas) this.getElemento(x, y);
    		this.removerElem(x, x);
    		return fruta;
    	}
    	return null;
     }
     
     /**
      * Exibe o elemento no mapa
      * @param x - posição x do elemento
      * @param y - posição y do elemento
      * @return Elemento 
      */
     public Elemento exibeElem(int x, int y) {
         return this.mapa[x][y];
     }
}