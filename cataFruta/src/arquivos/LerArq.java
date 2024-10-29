package arquivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.JFileChooser;

/**
 * Classe responsável por ler a configuração de um arquivo de texto. O arquivo
 * deve conter informações sobre a dimensão, pedras, frutas, porcentagem de
 * frutas bichadas e capacidade da mochila.
 */
public class LerArq {
	private int dimensao;
	private int pedras;
	private Map<String, int[]> frutas;
	private int bichadas;
	private int mochila;

	/**
	 * Construtor da classe LerArq. Abre um JFileChooser para o usuário selecionar
	 * um arquivo e lê a configuração do arquivo selecionado.
	 */
	public LerArq() {
		frutas = new HashMap<>();
	}

	/**
	 * Lê a configuração do arquivo fornecido.
	 *
	 */
	public void lerConfig() {
		JFileChooser escolha = new JFileChooser();
		int responseFile = escolha.showOpenDialog(null);
		if (responseFile == JFileChooser.APPROVE_OPTION) {
			File arq = escolha.getSelectedFile();
			System.out.println("Caminho do arquivo aberto = " + arq.getAbsolutePath());
			try (Scanner sc = new Scanner(arq)) {
				while (sc.hasNextLine()) {
					String linha = sc.nextLine().trim();
					if (linha.isEmpty()) {
						continue;
					}
					String[] partes = linha.split(" ");

					if (partes.length < 2) {
						continue;
					}

					try {
						switch (partes[0].toLowerCase()) {
						case "dimensao":
							this.dimensao = Integer.parseInt(partes[1]);
							break;
						case "pedras":
							this.pedras = Integer.parseInt(partes[1]);
							break;
						case "bichadas":
							this.bichadas = Integer.parseInt(partes[1]);
							break;
						case "mochila":
							this.mochila = Integer.parseInt(partes[1]);
							break;
						default:
							if (partes.length == 3) {
								System.out.println(partes[0]);
								String fruta = partes[0].toLowerCase();
								System.out.println(partes[1]);
								int arv = Integer.parseInt(partes[1]);
								System.out.println(partes[2]);
								int fruto = Integer.parseInt(partes[2]);
								this.frutas.put(fruta, new int[] { arv, fruto });
							}
							break;
						}
					} catch (NumberFormatException e) {
						System.out.println("Erro ao ler número em linha: " + linha);
					}
				}
				exibirConfiguracao();
			} catch (FileNotFoundException e) {
				System.out.println("Arquivo não encontrado: " + e.getMessage());
			}
		} else {
			System.out.println("Nenhum arquivo selecionado");
		}
	}

	/**
	 * Exibe a configuração lida do arquivo.
	 */
	public void exibirConfiguracao() {
		System.out.println("Configurações lidas do arquivo:");
		System.out.println("Dimensão: " + this.dimensao);
		System.out.println("Pedras: " + this.pedras);
		System.out.println("Frutas:");
		for (Map.Entry<String, int[]> entry : frutas.entrySet()) {
			System.out.println(" - " + entry.getKey() + ": Árvores = " + entry.getValue()[0] + ", Frutas = "
					+ entry.getValue()[1]);
		}
		System.out.println("Frutas bichadas: " + bichadas + "%");
		System.out.println("Capacidade da mochila: " + mochila);
	}

	/**
	 * Metodo apra salvar a configuração do mapa em um arquivo
	 *
	 */
	public void salvarConfig() {
		JFileChooser escolha = new JFileChooser();
		escolha.setDialogTitle("Salvar Configuração"); // Título da janela
		escolha.setFileSelectionMode(JFileChooser.FILES_ONLY); // Configura para selecionar arquivos

		// Exibe o diálogo de salvar
		int responseFile = escolha.showSaveDialog(null);
		if (responseFile == JFileChooser.APPROVE_OPTION) {
			File arquivoSalvar = escolha.getSelectedFile(); // Obtém o arquivo selecionado

			// Verifica se o arquivo possui a extensão .txt, se não, adiciona
			if (!arquivoSalvar.getName().endsWith(".txt")) {
				arquivoSalvar = new File(arquivoSalvar.getAbsolutePath() + ".txt");
			}

			try (FileWriter writer = new FileWriter(arquivoSalvar)) {
				writer.write("dimensao " + this.dimensao + "\n");
				writer.write("pedras " + this.pedras + "\n");
				for (Map.Entry<String, int[]> entry : frutas.entrySet()) {
					writer.write(entry.getKey() + " " + entry.getValue()[0] + " " + entry.getValue()[1] + "\n");
				}
				writer.write("bichada " + this.bichadas + "\n");
				writer.write("mochila " + this.mochila + "\n");
				System.out.println("Configurações salvas em: " + arquivoSalvar.getAbsolutePath());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Nenhum arquivo selecionado");
		}
	}

	/**
	 * Obtém a dimensão da floresta.
	 *
	 * @return A dimensão da floresta.
	 */
	public int getDimensao() {
		return this.dimensao;
	}

	/**
	 * Define a dimensão da floresta.
	 *
	 * @param dimensao A nova dimensão da floresta.
	 */
	public void setDimensao(int dimensao) {
		this.dimensao = dimensao;
	}

	/**
	 * Obtém a quantidade de pedras na floresta.
	 *
	 * @return A quantidade de pedras.
	 */
	public int getPedras() {
		return this.pedras;
	}

	/**
	 * Define a quantidade de pedras na floresta.
	 *
	 * @param pedras A nova quantidade de pedras.
	 */
	public void setPedras(int pedras) {
		this.pedras = pedras;
	}

	/**
	 * Obtém a porcentagem de frutas bichadas.
	 *
	 * @return A porcentagem de frutas bichadas.
	 */
	public int getBichadas() {
		return this.bichadas;
	}

	/**
	 * Define a porcentagem de frutas bichadas.
	 *
	 * @param bichadas A nova porcentagem de frutas bichadas.
	 */
	public void setBichadas(int bichadas) {
		this.bichadas = bichadas;
	}

	/**
	 * Obtém a capacidade da mochila.
	 *
	 * @return A capacidade da mochila.
	 */
	public int getMochila() {
		return this.mochila;
	}

	/**
	 * Define a capacidade da mochila.
	 *
	 * @param mochila A nova capacidade da mochila.
	 */
	public void setMochila(int mochila) {
		this.mochila = mochila;
	}

	/**
	 * Obtém o mapa de frutas.
	 *
	 * @return O mapa de frutas.
	 */
	public Map<String, int[]> getFrutas() {
		return this.frutas;
	}

	/**
	 * Define o mapa de frutas.
	 *
	 * @param frutas O novo mapa de frutas.
	 */
	public void setFrutas(Map<String, int[]> frutas) {
		this.frutas = frutas;
	}

	/**
	 * Adiciona uma nova fruta ao mapa de frutas.
	 *
	 * @param nome             O nome da fruta.
	 * @param arvores          A quantidade de árvores da fruta.
	 * @param quantidadeFrutas A quantidade de frutas.
	 */
	public void addFruta(String nome, int arvores, int quantidadeFrutas) {
		frutas.put(nome, new int[] { arvores, quantidadeFrutas });
	}

	/**
	 * Obtém a quantidade de árvores de uma fruta específica.
	 *
	 * @param fruta O nome da fruta.
	 * @return A quantidade de árvores da fruta, ou 0 se a fruta não existir.
	 */
	public int getQuantidadeArvores(String fruta) {
		int[] valores = this.frutas.get(fruta);
		return valores != null ? valores[0] : 0;
	}

	/**
	 * Obtém a quantidade de frutas de uma fruta específica.
	 *
	 * @param fruta O nome da fruta.
	 * @return A quantidade de frutas, ou 0 se a fruta não existir.
	 */
	public int getQuantidadeFrutas(String fruta) {
		int[] valores = this.frutas.get(fruta);
		return valores != null ? valores[1] : 0;
	}

}
