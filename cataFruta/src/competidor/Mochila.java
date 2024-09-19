package competidor;
import java.util.ArrayList;
import java.util.List;
import frutas.Frutas;
/**
 * Class da mochila utilizada pelo competidor onde tem uma lista de frutas
 * e um capacidade de carregamento
 */

public class Mochila {
	private List<Frutas> frutas;		// lista das frutas na mochila
	private int capacidadeMaxima;	// capacidade da mochila
	
	/**
	 * Construtor da mochila que cria uma lista vazia de frutas que é as que vão ser inseridos na mochila.
	 * @param capacidadeMaxima	capacidade maxiama que a mochila aceita.
	 */
	public Mochila(int capacidadeMaxima) {
		this.frutas = new ArrayList<>();
		this.capacidadeMaxima = capacidadeMaxima;
	}
	
	/**
	 * Metodo para inserir uma fruta na mochila
	 * @param fruta	a fruta que vai ser inserida.
	 * @return true se a fruta foi adicionada.
	 *
	 */
	public boolean addFruta(Frutas fruta) {
		if(frutas.size() < capacidadeMaxima) {
			frutas.add(fruta);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Metodo para remover uma fruta da mochila
	 * @param fruta a fruta que vai ser removida.
	 * @return	true se conseguiu remover.
	 * @return false se nao conseguiu remover.
	 */
	public boolean removeFruta(Frutas fruta) {
		if(frutas.contains(fruta)) {
			frutas.remove(fruta);
			return true;
		} else {
			return false;
		}
	}
	/**
	 * Mostra as frutas que estao na lista da mochila.
	 * @return lista de frutas.
	 */
	public List<Frutas> getFrutas() {
		return this.frutas;
	}
	
	/**
	 * Verifica se a mochila esta cheia
	 * @return true se estiver atingindo a capacidade maxima.
	 *
	 */
	public int getSize() {
		return frutas.size();
	}
	/**
	 * Metodo para remover uma fruta de um index da mochila
	 * @param i index que vai ser removido
	 * @return true se removeu, false se nao removeu
	 * 
	 */
	public boolean removeIndexFrut(int i) {
		if (this.isCheia()) {
			this.frutas.remove(i);
			return true;
		}
		return false;
	}
	
	/*
	 * Metodo que fala se a mochila ta cheia ou n
	 * @return true se estiver cheia false se estiver vazia
	 * 
	 */
	public boolean isCheia() {
		return this.frutas.size() >= this.capacidadeMaxima;
	}
	
}