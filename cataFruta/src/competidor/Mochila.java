package competidor;

import java.util.ArrayList;
import java.util.List;
import frutas.Frutas;
import frutas.Laranja;

/**
 * Class da mochila utilizada pelo competidor onde tem uma lista de frutas e um
 * capacidade de carregamento
 */

public class Mochila {
	private List<Frutas> frutas; // lista das frutas na mochila
	private int capacidadeMaxima; // capacidade da mochila

	/**
	 * Construtor da mochila que cria uma lista vazia de frutas que é as que vão ser
	 * inseridos na mochila.
	 * 
	 * @param capacidadeMaxima capacidade maxiama que a mochila aceita.
	 */
	public Mochila(int capacidadeMaxima) {
		this.frutas = new ArrayList<>();
		this.capacidadeMaxima = capacidadeMaxima;
	}

	/**
	 * Metodo para inserir uma fruta na mochila
	 * 
	 * @param fruta a fruta que vai ser inserida.
	 * @return true se a fruta foi adicionada.
	 *
	 */
	public boolean addFruta(Frutas fruta) {
		if (frutas.size() < capacidadeMaxima) {
			frutas.add(fruta);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Metodo para remover uma fruta da mochila
	 * 
	 * @param fruta a fruta que vai ser removida.
	 * @return true se conseguiu remover.
	 * @return false se nao conseguiu remover.
	 */
	public boolean removeFruta(Frutas fruta) {
		if (frutas.contains(fruta)) {
			frutas.remove(fruta);
			return true;
		} else {
			return false;
		}
	}
	

	/**
	 * Mostra as frutas que estao na lista da mochila.
	 * 
	 * @return lista de frutas.
	 */
	public List<Frutas> getFrutas() {
		return this.frutas;
	}

	/**
	 * Retorna o tamanho da mochila
	 * 
	 * @return int size - quantas frutas estão na mochila
	 */
	public int getSize() {
		return frutas.size();
	}

	/**
	 * Metodo para remover uma fruta de um index da mochila
	 * 
	 * @param i index que vai ser removido
	 * @return true se removeu, false se nao removeu
	 * 
	 */
	public Frutas removeIndexFrut(int i) {
		if (this.getSize() > i) {
			return this.frutas.get(i);
		}
		return null;
	}

	/**
	 * Metodo para mostrar as frutas da mochila
	 */
	public void mostrar() {
		if (frutas.isEmpty()) {
			System.out.println("A mochila está vazia.");
		} else {
			for (Frutas fruta : frutas) {
				System.out.printf("%s ", fruta.getTipo());
			}
			System.out.println();
		}
	}

	
	public int getPontos() {
		int pontos = 0;
		for(int i = 0; i < this.frutas.size(); i++) {
			if(frutas.get(i) instanceof Laranja)
				pontos++;
		}
		
		return pontos;
	}
	public int qtsFrutas(Frutas fruta) {
		int qts = 0;
		for(int i = 0; i < frutas.size(); i++) {
			if(frutas.get(i).equals(fruta))
				qts++;
		}
		return qts;
	}
	/*
	 * Metodo que fala se a mochila ta cheia ou n
	 * 
	 * @return true se estiver cheia false se estiver vazia
	 * 
	 */
	public boolean isCheia() {
		return this.frutas.size() >= this.capacidadeMaxima;
	}

}