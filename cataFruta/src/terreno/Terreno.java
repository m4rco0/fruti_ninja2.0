package terreno;
import estruturas.*;
import frutas.*;
import java.util.Random;

import cataFruta.*;
import competidor.Competidor;
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

	/**
     * Verifica se uma posição está disponível no mapa
     * @param x posição x no mapa
     * @param y posição y no mapa
     * @return true se a posição está disponível, false caso contrário
     */
	public boolean posicaoDisponivel(int x, int y) {
		if(this.mapa[x][y] == null)
			return true;
		return false;
	}
	
	
	// funções de inicializar terreno
	public void colocarGrama() {
		for (int i = 0; i < this.getDimensao(); i++) {
			for(int j = 0 ; j < this.getDimensao(); j++) {
				if(this.posicaoDisponivel(i, j)) {
					Grama grama = new Grama(i, j);
					this.inserirElem(i, j, grama);
				}
			}
		}
	}
	 
	/**
     * Adiciona uma árvore em uma posição específica do mapa
     * @param arvore A árvore a ser adicionada
     * @param x posição x no mapa
     * @param y posição y no mapa
     * @return true se a árvore foi adicionada com sucesso, false caso contrário
     */
	public boolean colocarArvores(Arvore arvore, int x, int y) {
		if(this.posicaoDisponivel(x, y)) {
			mapa[x][y] = arvore;
			return true;
		}
		return false;
	}
	/**
	 * Coloca um número especificado de pedras em posições aleatórias no terreno.
	 * As pedras são posicionadas em locais aleatórios no mapa, garantido que a posição
	 * escolhida esteja vazia antes de inserir uma pedra.
	 *
	 * @param qtsPedras O número de pedras a serem colocadas no terreno.
	 */
	public void colocarPedras(int qtsPedras) {
		Random dado = new Random();
		for(int i = 0; i < qtsPedras; i++) {
			//gero posições aleatorias
			int posx = dado.nextInt(this.getDimensao());
			int posy = dado.nextInt(this.getDimensao());

			while(this.mapa[posx][posy] != null) {
				posx = dado.nextInt(this.getDimensao());
				posy = dado.nextInt(this.getDimensao());
			}
			// insiro no terreno apos encontrar
			this.inserirElem(posx, posy, new Pedra(posx, posy));
		}
	}
	
	 /**
     * Adiciona uma árvore em uma posição específica do mapa
     * @param arvore A árvore a ser adicionada
     * @param x posição x no mapa
     * @param y posição y no mapax
     * @return true se a árvore foi adicionada com sucesso, false caso contrário
     */
    public boolean adicionaArvore(Arvore arvore, int x, int y) {
        if (posicaoDisponivel(x, y)) {
            this.mapa[x][y] = arvore;
            System.out.println("Adicionou a arvore");
            return true;
        }
        return false;
    }
    
    public boolean setarArvores(Arvore arvore) {
    	Random rand = new Random();
    	int tentativas =0;
    	while(tentativas < this.getDimensao()) {
    		int x = rand.nextInt(this.getDimensao());
    		int y = rand.nextInt(this.getDimensao());
    		if(this.adicionaArvore(arvore, x, y))
    			return true;
    		
    	}
    	return false;
    }
    
    public void criarArvores(String tipo, int qtsArvores) {
    	if(tipo == "laranja") {
    		for(int i = 0; i < qtsArvores; i++) {
    			ArvoreLaranja arv = new ArvoreLaranja(0, 0, "laranja", new Laranja(0, 0, false));
    			this.setarArvores(arv);	
    		}
    	} else if (tipo == "maracuja") {
    		for(int i = 0; i < qtsArvores; i++) {
    			ArvoreMaracuja arv = new ArvoreMaracuja(0, 0, "maracuja", new Maracuja(0, 0, false));
    			this.setarArvores(arv);
    		}
    	} else if (tipo == "abacate") {
    		for(int i = 0; i < qtsArvores; i++) {
    			ArvoreAbacate arv = new ArvoreAbacate(0, 0, "abacate", new Abacate(0, 0, false));
    			this.setarArvores(arv);
    		}
    	} else if (tipo == "coco") {
    		for(int i = 0; i < qtsArvores; i++) {
    			ArvoreCoco arv = new ArvoreCoco(0, 0, "coco", new Coco(0, 0, false));
    			this.setarArvores(arv);
    			
    		}
    	}else if (tipo == "acerola") {
    			for(int i = 0; i < qtsArvores; i++) {
        			ArvoreAcerola arv = new ArvoreAcerola(0, 0, "acerola", new Acerola(0, 0, false));
        			this.setarArvores(arv);
        			
        		}
    		} else if (tipo == "amora") {
    			for(int i = 0; i < qtsArvores; i++) {
        			ArvoreAmora arv = new ArvoreAmora(0, 0, "amora", new Amora(0, 0, false));
        			this.setarArvores(arv);
        		}
    		} else if (tipo == "goiaba") {
    			for(int i = 0; i < qtsArvores; i++) {
    				ArvoreGoiaba arv = new ArvoreGoiaba(0,0, "goiaba", new Goiaba(0,0, false));
    				this.setarArvores(arv);
    			}
    		}
    	}
    
    public void adicionarArvores(int arvMaracuja, int arvLaranja, int arvAbacate, int arvCoco, int arvAcerola, int arvAmora, int arvGoiaba) {
    	this.criarArvores("maracuja", arvMaracuja);
    	this.criarArvores("laranja", arvLaranja);
    	this.criarArvores("abacate", arvAbacate);
    	this.criarArvores("coco", arvCoco);
    	this.criarArvores("acerola", arvAcerola);
    	this.criarArvores("amora", arvAmora);
    	this.criarArvores("goiaba", arvGoiaba);
    	
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
					if (this.mapa[i][j] instanceof Competidor)
					{
						Competidor c = (Competidor) this.getMapa()[i][j];
						System.out.printf("%s", c.getNome());
					} else if(this.mapa[i][j] instanceof Elemento) {
						System.out.printf("%s", this.mapa[i][j].getTipo());
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