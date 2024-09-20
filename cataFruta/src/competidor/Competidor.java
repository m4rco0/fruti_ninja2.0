package competidor;
import cataFruta.*;
import estruturas.*;
import frutas.Frutas;
import terreno.Terreno;
import java.lang.Math;
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
	private int qts_mov;
	private boolean drog;
	private Mochila mochila;
	private int forcaDef;
	
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
		this.drog = false;
		this.mochila = new Mochila(capacidadeMochila);
		this.setForcaDef(1);
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
		if(terreno.getElemento(this.x, this.y+1) instanceof Grama) {
			terreno.removerElem(this.x, this.y+1);
			terreno.inserirElem(this.x, this.y+1, this);
			terreno.removerElem(this.x, this.y);
			terreno.inserirElem(this.x, this.y, new Grama(this.x, this.y));
			this.setPos(this.x, this.y +1);
		} else if (terreno.getElemento(this.x, this.y+1) instanceof Pedra) {
			
		}
		this.qts_mov--;
	}
	
	public void moverEsquerda(Terreno terreno) {
		if(terreno.getElemento(this.x, this.y-1) instanceof Grama) {
			terreno.removerElem(this.x, this.y-1);
			terreno.inserirElem(this.x, this.y -1, this);
			terreno.removerElem(this.x, this.y);
			terreno.inserirElem(this.x, this.y, new Grama(this.x, this.y));
			this.setPos(this.x, this.y -1);
		} else if (terreno.getElemento(this.x, this.y -1) instanceof Pedra) {
			
		}
		this.qts_mov--;
	}
	
	public void moverCima(Terreno terreno) {
		if(terreno.getElemento(this.x-1, this.y) instanceof Grama) {
			terreno.removerElem(this.x-1, this.y);
			terreno.inserirElem(this.x-1, this.y, this);
			terreno.removerElem(this.x, this.y);
			terreno.inserirElem(this.x, this.y, new Grama(this.x, this.y));
			this.setPos(this.x-1, this.y);
		} else if (terreno.getElemento(this.x-1, this.y) instanceof Pedra) {
			
		}
		this.qts_mov--;
	}
	
	public void moverBaixo(Terreno terreno) {
		if(terreno.getElemento(this.x+1, this.y) instanceof Grama) {
			terreno.removerElem(this.x+1, this.y);
			terreno.inserirElem(this.x+1, this.y, this);
			terreno.removerElem(this.x, this.y);
			terreno.inserirElem(this.x, this.y, new Grama(this.x, this.y));
			this.setPos(this.x+1, this.y);
		} else if (terreno.getElemento(this.x+1, this.y) instanceof Pedra) {
			
		}
		this.qts_mov--;
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
	public boolean getDrog() {
		return this.drog;
	}
	
	/**
	 * Metodo para limpar o efeito da fruta bichada.
	 * 
	 */
	public void limparEfeito() {
		this.drog = false;
	}
	/**
	 * Obtém o tipo do elemento, que é COmpetidor.
	 * 
	 * @return Uma strinco om o nome "Competidor".
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
			this.limparEfeito();
		}
		
		if(fruta.isBichada())
			this.drog = true;
		this.mochila.removeFruta(fruta);
		System.out.println("[-]"+fruta.getTipo()+ "removido");
	}
	
	/**
	 * Competidor pega a fruta do chao e remove do terreno.
	 * @param fruta a fruta pega pelo jogador
	 */
	public void pegarFruta(Arvore arvore) {
		this.mochila.addFruta(arvore.pegaFruta());
		this.setForca(this.getForca() + 1);
		this.setForcaDef(this.getForcaDef() + 1);
		System.out.println("[+]"+ arvore.getTipo() + "fruto pego");
	}
	public void pegarFrutaChao(Frutas fruta) {
		this.mochila.addFruta(fruta);
	}
	public int getForcaDef() {
		return forcaDef;
	}
	public void setForcaDef(int forcaDef) {
		this.forcaDef = forcaDef;
	}
	
	public void empurrao(Competidor competidor, int x, int y) {
		int f_a = this.getForca();
		int f_d = competidor.getForcaDef();
		int empurrao = (int) Math.round(Math.log(f_a +1) / Math.log(2) - Math.log(f_d +1)/ Math.log(2));
		int frutasDerrubadas = Math.max(0, empurrao);
		for (int i = 0; i < frutasDerrubadas; i++) {
			competidor.mochila.removeIndexFrut(i);
		}
	}
	
	@Override
	public String getTipo() {
		return "Competidor";
	}
	public void setMov(int nextInt) {
		// TODO Auto-generated method stub
		this.qts_mov = nextInt;
	}
}