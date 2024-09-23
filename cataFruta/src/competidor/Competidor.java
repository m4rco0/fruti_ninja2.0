package competidor;
import cataFruta.*;
import estruturas.*;
import frutas.Frutas;
import terreno.Terreno;
import java.lang.Math;
import java.util.Random;
/**
 * Classe que representa um Competidor no jogo. um elemento dinâmico que pode se mover e interagir
 * com outros elementos do jogo. Cada competidor possui um nome, forca, capacidade maximo de uma mochila, altura e largura.
 *  quantos movimentos, mochila que ele carrega.
 * @author Marco Antonio da Silva Santos
 */
public class Competidor extends ElemDinamico {
	private String nome;
	
	private int forca;
	private int capacidadeMochila;
	private int pontos;
	private int roundParado;
	private int qts_mov;
	private Mochila mochila;
	
	/**
	 * Construtor que inicia o competidor com atributos.
	 * @param nome  - O nome do competidor.
	 * @param x - A posição inicial x do jogador.
	 * @param y - A posição inicial y do jogador.
	 * @param capacidadeMochila -  A capacidade da mochila , que defino o tanto de frutas que o jogador pode carregar.
	 * @param qts_mov -  A quantidade de movimento do jogador.
	 *
	 */
	public Competidor(String nome, int x, int y, int capacidadeMochila,int qts_mov) {
		super(x,y);
		this.nome = nome;
		this.capacidadeMochila = capacidadeMochila;
		this.setForca(1);
		this.pontos = 0;
		this.qts_mov = qts_mov;
		this.roundParado = 0;
		this.mochila = new Mochila(capacidadeMochila);
	}
	/**
	 * Obtém o nome do competidor.
	 * 
	 * @return nome
	 */
	public String getNome() {
		return this.nome;
	}
	
	/**
	 * Metodo que recebe o terreno e move o jogador para direita
	 * verificando as classes do terreno ao lado para mover-se
	 * se for uma grama move-se para direita
	 * se for uma pedra perde 3 pontos
	 * se for uma arvore fica embaixo
	 * se for um jogador empurra
	 * 
	 * @param terreno
	 */
	public void moverDireita(Terreno terreno) {
	    int novaY = this.y + 1;
	    
	    if(this.roundParado > 0) {
	    	System.out.println(this.nome + " está parado embaixo de uma árvore por mais " + this.roundParado + " rounds.");
	        return;
	    }
	    
	    // Verifica se a posição novaY está dentro dos limites do terreno
	    if (novaY < terreno.getDimensao()) {
	        if (terreno.getElemento(this.x, novaY) instanceof Grama) {
	            terreno.removerElem(this.x, novaY);
	            terreno.inserirElem(this.x, novaY, this);
	            terreno.removerElem(this.x, this.y);
	            terreno.inserirElem(this.x, this.y, new Grama(this.x, this.y));
	            this.setPos(this.x, novaY);
	        } else if (terreno.getElemento(this.x, novaY) instanceof Competidor) {
	            Competidor empurrado = (Competidor) terreno.getElemento(this.x, novaY); 
	            this.empurrao(empurrado, this.x, novaY, terreno);
	        } else if (terreno.getElemento(this.x, novaY) instanceof Pedra) {
	            int puloY = this.y + 2;

	            // Verifica se a posição puloY está dentro dos limites do terreno
	            if (puloY < terreno.getDimensao() && this.qts_mov >= 3 && terreno.getElemento(this.x, puloY) instanceof Grama) {
	                this.qts_mov -= 3;
	                terreno.removerElem(this.x, this.y);
	                terreno.removerElem(this.x, puloY);
	                terreno.inserirElem(this.x, this.y, new Grama(this.x, this.y));
	                terreno.inserirElem(this.x, puloY, this);
	                this.setPos(this.x, puloY);
	            }
	        } else if (terreno.getElemento(this.x, novaY) instanceof Arvore) {
	        	Arvore arv = (Arvore) terreno.getElemento(this.x, novaY);
	        	this.pegarFrutaArv(arv);
	        } else if (terreno.getElemento(this.x, this.y+1) instanceof Frutas) {
	        	Frutas fruta = terreno.pegarFruta(this.x, novaY);
	        	if(fruta.getTipo() == "Laranja")
	        		this.pontos++;
	        	this.mochila.addFruta(fruta);
	        	terreno.removerElem(this.x, this.y+1);
	        	terreno.removerElem(this.x, this.y);
	        	terreno.inserirElem(this.x, this.y+1, this);
	        	terreno.colocarGrama();
	        	this.setPos(this.x, this.y+1);
	        }
	    }
	    this.qts_mov -=1;
	}

	
	/**
	 * Metodo que recebe o terreno e move o jogador para esquerda
	 * verificando as classes do terreno ao lado para mover-se
	 * se for uma grama move-se para esquerda
	 * se for uma pedra perde 3 pontos
	 * se for uma arvore fica embaixo
	 * se for um jogador empurra
	 * 
	 * @param terreno
	 */
	public void moverEsquerda(Terreno terreno) {
	    int novaY = this.y - 1;

	    // Verifica se a posição novaY está dentro dos limites do terreno
	    if (novaY >= 0) {
	        if (terreno.getElemento(this.x, novaY) instanceof Grama) {
	            terreno.removerElem(this.x, novaY);
	            terreno.inserirElem(this.x, novaY, this);
	            terreno.removerElem(this.x, this.y);
	            terreno.inserirElem(this.x, this.y, new Grama(this.x, this.y));
	            this.setPos(this.x, novaY);
	        } else if (terreno.getElemento(this.x, novaY) instanceof Competidor) {
	            Competidor empurrado = (Competidor) terreno.getElemento(this.x, novaY); 
	            this.empurrao(empurrado, this.x, novaY, terreno);
	        } else if (terreno.getElemento(this.x, novaY) instanceof Pedra) {
	            int puloY = this.y - 2;

	            // Verifica se a posição puloY está dentro dos limites do terreno
	            if (puloY >= 0 && this.qts_mov >= 3 && terreno.getElemento(this.x, puloY) instanceof Grama) {
	                this.qts_mov -= 3;
	                terreno.removerElem(this.x, this.y);
	                terreno.removerElem(this.x, puloY);
	                terreno.inserirElem(this.x, this.y, new Grama(this.x, this.y));
	                terreno.inserirElem(this.x, puloY, this);
	                this.setPos(this.x, puloY);
	            }
	        }else if (terreno.getElemento(this.x, novaY) instanceof Frutas) {
            	Frutas fruta = terreno.pegarFruta(this.x, novaY);
            	if(fruta.getTipo() == "Laranja")
            		this.pontos++;
	        	this.mochila.addFruta(fruta);
	        	terreno.removerElem(this.x, this.y);
	        	terreno.removerElem(this.x, novaY);
	        	terreno.inserirElem(this.x, novaY, this);
	        	this.setPos(this.x, novaY);
	        	terreno.colocarGrama();
	        	
	        }
	    }
	    this.qts_mov--;
	}

	
	/**
	 * Metodo que recebe o terreno e move o jogador para cima
	 * verificando as classes do terreno ao lado para mover-se
	 * se for uma grama move-se para cima
	 * se for uma pedra perde 3 pontos
	 * se for uma arvore fica embaixo
	 * se for um jogador empurra
	 * 
	 * @param terreno
	 */
	public void moverCima(Terreno terreno) {
	    int novaX = this.x - 1;

	    // Verifica se a posição novaX está dentro dos limites do terreno
	    if (novaX >= 0) {
	        if (terreno.getElemento(novaX, this.y) instanceof Grama) {
	            terreno.removerElem(novaX, this.y);
	            terreno.inserirElem(novaX, this.y, this);
	            terreno.removerElem(this.x, this.y);
	            terreno.inserirElem(this.x, this.y, new Grama(this.x, this.y));
	            this.setPos(novaX, this.y);
	        } else if (terreno.getElemento(novaX, this.y) instanceof Competidor) {
	            Competidor empurrado = (Competidor) terreno.getElemento(novaX, this.y); 
	            this.empurrao(empurrado, novaX, this.y, terreno);
	        } else if (terreno.getElemento(novaX, this.y) instanceof Pedra) {
	            int puloX = this.x - 2;

	            // Verifica se a posição puloX está dentro dos limites do terreno
	            if (puloX >= 0 && this.qts_mov >= 3 && terreno.getElemento(puloX, this.y) instanceof Grama) {
	                this.qts_mov -= 3;
	                terreno.removerElem(this.x, this.y);
	                terreno.removerElem(puloX, this.y);
	                terreno.inserirElem(this.x, this.y, new Grama(this.x, this.y));
	                terreno.inserirElem(puloX, this.y, this);
	                this.setPos(puloX, this.y);
	            }
	        }else if (terreno.getElemento(novaX, this.y) instanceof Frutas) {
	        	Frutas fruta = terreno.pegarFruta(novaX, this.y);
	        	if(fruta.getTipo() == "Laranja")
	        		this.pontos++;
	        	this.mochila.addFruta(fruta);
	        	terreno.removerElem(novaX, this.y);
	        	terreno.removerElem(this.x, this.y);
	        	terreno.inserirElem(novaX, this.y, this);
	        	terreno.colocarGrama();
	        	this.setPos(novaX, this.y);
	        }
	    }
	    this.qts_mov--;
	}

	
	/**
	 * Metodo que recebe o terreno e move o jogador para baixo
	 * verificando as classes do terreno ao lado para mover-se
	 * se for uma grama move-se para baixo
	 * se for uma pedra perde 3 pontos
	 * se for uma arvore fica embaixo
	 * se for um jogador empurra
	 * 
	 * @param terreno
	 */
	public void moverBaixo(Terreno terreno) {
	    int novaX = this.x + 1;

	    // Verifica se a posição novaX está dentro dos limites do terreno
	    if (novaX < terreno.getDimensao()) {
	        if (terreno.getElemento(novaX, this.y) instanceof Grama) {
	            terreno.removerElem(novaX, this.y);
	            terreno.inserirElem(novaX, this.y, this);
	            terreno.removerElem(this.x, this.y);
	            terreno.inserirElem(this.x, this.y, new Grama(this.x, this.y));
	            this.setPos(novaX, this.y);
	        } else if (terreno.getElemento(novaX, this.y) instanceof Competidor) {
	            Competidor empurrado = (Competidor) terreno.getElemento(novaX, this.y); 
	            this.empurrao(empurrado, novaX, this.y, terreno);
	        } else if (terreno.getElemento(novaX, this.y) instanceof Pedra) {
	            int puloX = this.x + 2;

	            // Verifica se a posição puloX está dentro dos limites do terreno
	            if (puloX < terreno.getDimensao() && this.qts_mov >= 3 && terreno.getElemento(puloX, this.y) instanceof Grama) {
	                this.qts_mov -= 3;
	                terreno.removerElem(this.x, this.y);
	                terreno.removerElem(puloX, this.y);
	                terreno.inserirElem(this.x, this.y, new Grama(this.x, this.y));
	                terreno.inserirElem(puloX, this.y, this);
	                this.setPos(puloX, this.y);
	            }
	        }else if (terreno.getElemento(novaX, this.y) instanceof Frutas) {
	        	Frutas fruta = terreno.pegarFruta(novaX, this.y);
	        	this.mochila.addFruta(fruta);
	        	if(fruta.getTipo() == "Laranja")
	        		this.pontos++;
	        	terreno.removerElem(novaX, this.y);
	        	terreno.removerElem(this.x, this.y);
	        	terreno.inserirElem(novaX, this.y, this);
	        	terreno.colocarGrama();
	        	this.setPos(novaX, this.y);
	        }
	    }
	    this.qts_mov--;
	}

	
	public void exibirFrutas() {
		this.mochila.mostrar();
	}
	/**
	 * Obtém a quantidade de forca do Competidor.
	 * @return a forca do jogador.
	 */
	public int getForca() {
		return this.forca;
	}
	
	/**
	 * Obtém a quantidade de items que podem serem armazenados na mochila.
	 * 
	 * @return A capacidade da mochila.
	 */
	public int getCapacidadeMochila() {
		return this.capacidadeMochila;
	}
	/**
	 * Obtém os pontos do jogador.
	 * @return pontos
	 */
	public int getPontos() {
		return this.pontos;
	}
	/**
	 * Define a força do jogador.
	 * @param forca A forca do competidor.
	 */
	public void setForca(int forca) {
		this.forca = forca;
	}
	/**
	 * metodo para adicionar os pontos de vitoria
	 * @param pontos Os pontos que vão ser adicionados
	 */
	public void addPontos(int pontos) {
		this.pontos += pontos;
	}
	
	/**
	 * Metodo que mostra quantos movimentos o competidor possui.
	 * @return	qts_mov os movimentos restante do competidor.
	 */
	public int getMov() {
		return this.qts_mov;
	}
	
	/**
	 * Metodo para ver se comeu uma fruta bichada.
	 * @return	true se comeu a fruta bichada.
	 * @return false se nao comeu fruta bichada.
	 */
	
	/**
	 * Metodo especial para consumir a fruta.
	 * @param fruta a fruta que vai ser inserido na mochila.
	 * 
	 */
	public void consumirFruta(Frutas fruta) {
		if(fruta.getTipo() == "Maracujá") {
			this.addPontos(pontos);
		} else if (fruta.getTipo() == "Coco") {
			this.qts_mov = this.getMov() * 2;
		} else if (fruta.getTipo() == "Abacate") {
			this.setForca(this.getForca() * 2);
		} else if (fruta.getTipo() == "Laranja") {
			this.roundParado = 0;
		}
		
		if(fruta.isBichada())
			this.roundParado++;
		this.mochila.removeFruta(fruta);
		System.out.println("[-]"+fruta.getTipo()+ "removido");
	}
	
	/**
	 * Competidor pega a fruta do chao e remove do terreno.
	 * @param fruta a fruta pega pelo jogador
	 */
	public void pegarFrutaArv(Arvore arvore) {
		this.mochila.addFruta(arvore.pegaFruta());
		this.setForca(this.getForca() + 1);
		this.roundParado = 2;
		System.out.println("[+]"+ arvore.getTipo() + "fruto pego");
	}
	/**
	 * Metodor para pegar uma fruta do chão e colocar na mochila
	 * @param fruta
	 */
	public void pegarFrutaChao(Frutas fruta) {
		this.mochila.addFruta(fruta);
	}
	
	public int getForcaDef() {
		return this.mochila.getSize();
	}
	
	
	/**
	 * Metodo que empurra um competidor em certa posição
	 * @param competidor
	 * @param x
	 * @param y
	 */
	public void empurrao(Competidor competidor, int x, int y, Terreno terreno) {
		System.out.println("Empurrar " + competidor.nome + " tem " + competidor.mochila.getSize() + " frutas");
	}
	
	public void exibirMochila() {
		System.out.println("Conteudo da mochila:");
		mochila.mostrar();
	}
	
	/**
	 * Getter de rounds parados
	 * @return roundsParado
	 */
	public int getRoundsParado() {
		return this.roundParado;
	}
	
	/**
	 * Setter de rounds parados
	 * @param roundsParados
	 */
	public void setRoundsParado(int roundsParados) {
		this.roundParado = roundsParados;
	}
	/**
	 * Diminuir apenas 1 dos rounds parados, se for maior que 0
	 */
	public void decrementarRoundsParado() {
        if (this.roundParado > 0) {
            this.roundParado--;
        }
    }
	/**
	 * Seta o movimento de um jogador
	 * @param nextInt - quantos movimentos
	 */
	public void setMov(int nextInt) {
		// TODO Auto-generated method stub
		this.qts_mov = nextInt;
	}
	
	
	@Override
	public String getTipo() {
		return "Competidor";
	}

}