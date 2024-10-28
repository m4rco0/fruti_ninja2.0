package competidor;
import cataFruta.*;
import estruturas.*;
import frutas.Frutas;
import frutas.Laranja;
import terreno.Terreno;

import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
/**
 * Classe que representa um Competidor no jogo. um elemento dinâmico que pode se mover e interagir
 * com outros elementos do jogo. Cada competidor possui um nome, forca, capacidade maximo de uma mochila, altura e largura.
 *  quantos movimentos, mochila que ele carrega.
 * @author Marco Antonio da Silva Santos
 */
public class Competidor extends ElemDinamico {
	private Image imagem;
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
		this.imagem = new ImageIcon("catafruta/sprites/player/playerr.png").getImage();
	}

	public Image getImg() {
		return this.imagem;
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
		
		
		if(terreno.posicaoDisponivel(novaX, this.getY())) {
			terreno.inserirCompetidor(novaX, this.getY(), this);
			terreno.removerElem(this.x, this.y);
			this.setPos(novaX, this.y);
		} else if (x >= 2 &&terreno.getElemento(novaX, y) instanceof Pedra) {
			if(terreno.getElemento(novaX-1, y) == null) {
				terreno.inserirCompetidor(novaX-1, y, this);
				terreno.removerElem(x, y);
			} else if ( terreno.getElemento(novaX-1, y) instanceof Frutas) {
				Frutas fruta = terreno.pegarFruta(novaX-1, y);
				this.pegarFrutaChao(fruta);
				terreno.removerElem(novaX-1, y);
				terreno.inserirCompetidor(novaX-1, y, this);
				terreno.removerElem(x, y);
			}
			this.setPos(novaX-1, y);
			this.qts_mov-= 2;
		} else if (terreno.getElemento(novaX, y) instanceof Frutas) {
			Frutas fruta = terreno.pegarFruta(novaX, y);
			this.pegarFrutaChao(fruta);
			terreno.removerElem(novaX, y);
			terreno.inserirCompetidor(novaX, y, this);
			terreno.removerElem(x, y);
			this.setPos(novaX, y);
		}
		this.qts_mov--;
		this.imagem = new ImageIcon("catafruta/sprites/player/Player_Back.png").getImage();

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
		if(terreno.posicaoDisponivel(novaX, this.y)) {
			terreno.removerElem(x, y);
			terreno.inserirCompetidor(novaX, y, this);
			this.setPos(novaX, y);
		}else if (x < terreno.getDimensao() -2 &&terreno.getElemento(novaX, y) instanceof Pedra) {
			if(terreno.getElemento(novaX +1, y)  == null) {
				terreno.inserirCompetidor(novaX+1, y, this);
				terreno.removerElem(x, y);
			} else if ( terreno.getElemento(novaX+1, y) instanceof Frutas) {
				Frutas fruta = terreno.pegarFruta(novaX+1, y);
				this.pegarFrutaChao(fruta);
				terreno.removerElem(x, y);
				terreno.inserirCompetidor(novaX+1, y, this);
			}
			this.setPos(novaX+1, y);
			this.qts_mov-=2;
			
		} else if (terreno.getElemento(novaX, y) instanceof Frutas) {
			Frutas fruta = terreno.pegarFruta(novaX, y);
			this.pegarFrutaChao(fruta);
			terreno.inserirCompetidor(novaX, y, this);
			terreno.removerElem(x, y);
			this.setPos(novaX, y);
		}
		System.out.println(this.qts_mov);
		this.qts_mov--;
		this.imagem = new ImageIcon("catafruta/sprites/player/playerr.png").getImage();
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

		// verificar se n tem nada e colocar o jogadr
		if(terreno.posicaoDisponivel(x, novaY)) {
			terreno.removerElem(x, y);
			terreno.inserirCompetidor(x, novaY, this);
			this.setPos(x, novaY);
		}else if (y >= 2 &&terreno.getElemento(x, novaY) instanceof Pedra) {
			if(terreno.getElemento(x, novaY-1)  == null) {
				terreno.inserirCompetidor(x, novaY-1, this);
				terreno.removerElem(x, y);
			}else if (terreno.getElemento(x, novaY -1) instanceof Frutas) {
				Frutas fruta = terreno.pegarFruta(x, novaY-1);
				this.pegarFrutaChao(fruta);
				terreno.inserirCompetidor(x, novaY-1, this);
				terreno.removerElem(x, y);
			}
			this.setPos(x, novaY-1);
			this.qts_mov-=2;
		} else if (terreno.getElemento(x, novaY) instanceof Frutas) {
			Frutas fruta = terreno.pegarFruta(x, novaY);
			this.pegarFrutaChao(fruta);
			terreno.inserirCompetidor(x, novaY, this);
			terreno.removerElem(x, y);
			this.setPos(x, novaY);
		}
		this.qts_mov--;
		this.imagem = new ImageIcon("catafruta/sprites/player/Player_Left.png").getImage();
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
	    int dy = this.y + 1;

	    if(terreno.posicaoDisponivel(x, dy)) {
	    	terreno.removerElem(x, y);
	    	terreno.inserirCompetidor(x, dy, this);
	    	this.setPos(x, dy);
	    } else if (y <= terreno.getDimensao() -2 && terreno.getElemento(x, dy) instanceof Pedra ) {
	    	if( terreno.getElemento(x, dy+1)  == null) {
	    		terreno.inserirCompetidor(x, dy+1, this);
				terreno.removerElem(x, y);
	    	} else if ( terreno.getElemento(x, dy +1) instanceof Frutas) {
	    		Frutas fruta = terreno.pegarFruta(x, dy);
	    		this.pegarFrutaChao(fruta);
	    		terreno.inserirCompetidor(x, dy+1, this);
	    		terreno.removerElem(x, y);
	    	}
			this.setPos(x, dy+1);
			this.qts_mov-=2;
		} else if (terreno.getElemento(x, dy) instanceof Frutas) {
			Frutas fruta = terreno.pegarFruta(x, dy);
			this.pegarFrutaChao(fruta);
			terreno.inserirCompetidor(x, dy, this);
			terreno.removerElem(x, y);
			this.setPos(x, dy);
		}
	    this.imagem = new ImageIcon("catafruta/sprites/player/Player_Right.png").getImage();
	    this.qts_mov -=1;
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
	
	public void girarDados() {
		Random dado = new Random();
		this.qts_mov += (dado.nextInt(6) + dado.nextInt(6));
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
		if(fruta instanceof Laranja)
			this.addPontos(1);
		this.mochila.addFruta(fruta);
	}
	
	/**
	 * Metodo para saber a força de um jogador
	 * @return
	 */
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
	
	/**
	 * Printa o conteudo da mmochila
	 */
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
	
	
	/**
	 * Tipo da classe
	 */
	@Override
	public String getTipo() {
		return "Competidor";
	}

}