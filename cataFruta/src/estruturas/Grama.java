package estruturas;

import cataFruta.ElemEstaticos;
import frutas.Frutas;
import competidor.Competidor;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que cria uma grama como elemento Estatico.
 */
public class Grama extends ElemEstaticos {
	private List<Object> elementos; // Lista para armazenar diferentes elementos

	/**
	 * Construtor da grama.
	 *
	 * @param x - cordenada x da grama
	 * @param y - cordeanada y da grama
	 */
	public Grama(int x, int y) {
		super(x, y);
		this.elementos = new ArrayList<>();
	}

	public void adicionarElemento(Object elemento) {
		this.elementos.add(elemento);
	}

	public boolean contemElemento(Class<?> clazz) {
		for (Object elemento : elementos) {
			if (clazz.isInstance(elemento)) {
				return true;
			}
		}
		return false;
	}

	public <T> T obterElemento(Class<T> clazz) {
		for (Object elemento : elementos) {
			if (clazz.isInstance(elemento)) {
				return clazz.cast(elemento);
			}
		}
		return null;
	}

	public void removerElemento(Class<?> clazz) {
		elementos.removeIf(clazz::isInstance);
	}

	public List<Object> getElementos() {
		return elementos;
	}

	@Override
	public String getTipo() {
		return "Grama";
	}
}
