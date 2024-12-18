package cataFruta.interfaceJogo;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import arquivos.LerArq;
import competidor.Competidor;
import terreno.Terreno;

/**
 * Classe JogoFrame que cria a interface gráfica do jogo. Responsável por exibir
 * o terreno e permitir que os jogadores façam seus movimentos através de
 * botões.
 *
 */
public class JogoFrame extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	/**
	 * O terreno do jogo. Utilizado para representar o estado e os elementos do
	 * jogo, como frutas, árvores e pedras.
	 */
	private terreno.Terreno terreno;
	private Competidor competidor1;
	private Competidor competidor2;
	private Competidor competidorAtual;
	private int round;
	private LerArq arq = new LerArq();
	private JLabel roundLabel;
	private JLabel jogadorLabel;
	private JPanel controles;
	private JTable table;
	private DefaultTableModel tableModel;
	private JLabel movsLabel;
	private JTextArea actionLog;

	/**
	 * Construtor para criar um painel com titulo de "Cata Fruta" tamanho 800x600
	 */
	public JogoFrame() {
		this.round = 0;
		setTitle("Cata Fruta");
		setSize(1000, 600);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		initUI();

	}
	
	/**
	 * Metodo para inicializar o terreno
	 * @param qtsPedras
	 * @param qtsArvMaracuja
	 * @param maracuja
	 * @param arvoreLaranja
	 * @param laranja
	 * @param arvoreAbacate
	 * @param abacate
	 * @param arvCoco
	 * @param coco
	 * @param arvAcerola
	 * @param acerola
	 * @param arvAmora
	 * @param Amora
	 * @param arvGoiaba
	 * @param goiaba
	 */
	private void inicilizarTerreno(int qtsPedras, int qtsArvMaracuja, int maracuja, int arvoreLaranja, int laranja,
			int arvoreAbacate, int abacate, int arvCoco, int coco, int arvAcerola, int acerola, int arvAmora, int Amora,
			int arvGoiaba, int goiaba) {
		terreno.colocarPedras(qtsPedras);
		terreno.adicionarArvores(qtsArvMaracuja, arvoreLaranja, arvoreAbacate, arvCoco, arvAcerola, arvAmora,
				arvGoiaba);
		terreno.gerarFrutas(maracuja, laranja, abacate, coco, Amora, acerola, goiaba);
	}

	/**
	 * Metodo responsável por inicializar a interface gráfica do jogo. Configura os
	 * componentes visuais como o painel do terreno e os botões de controle.
	 */
	private void initUI() {
		// Exibir menu de seleção para Novo Jogo ou Carregar Jogo
		String[] options = { "Novo Jogo", "Carregar Jogo" };
		int choice = JOptionPane.showOptionDialog(null, "Selecione uma opção", "Menu", JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
		Random num = new Random();
		// Verificar a escolha do usuário
		if (choice == 0) {
			System.out.println("Novo Jogo selecionado");
			int dimensao = 0;
			// validação do tamanho do terreno
			while (dimensao < 3) {
				String input = JOptionPane.showInputDialog("Digite a dimensão do terreno: ");
				try {
					dimensao = Integer.parseInt(input);
					if (dimensao < 3) {
						JOptionPane.showMessageDialog(null, "A dimensão deve ser maior ou igual a 3. Tente novamente.");
					}
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.");
				}
			}
			this.terreno = new Terreno(dimensao);
			int qtsPedras = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de Pedras:"));
			int qtsArvMaracuja = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de Árvores de Maracujá:"));
			int maracuja = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de Frutas de Maracujá:"));
			int arvoreLaranja = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de Árvores de Laranja:"));
			int laranja = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de Frutas de Laranja:"));
			int arvoreAbacate = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de Árvores de Abacate:"));
			int abacate = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de Frutas de Abacate:"));
			int arvCoco = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de Coqueiros:"));
			int coco = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de Cocos:"));
			int arvAcerola = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de Árvores de Acerola:"));
			int acerola = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de Frutas de Acerola:"));
			int arvAmora = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de Amoreiras:"));
			int amora = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de Frutas de Amora:"));
			int arvGoiaba = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de Goiabeiras:"));
			int goiaba = Integer.parseInt(JOptionPane.showInputDialog("Quantidade de Frutas de Goiaba:"));
			int tamMochila = Integer.parseInt(JOptionPane.showInputDialog("Qual o tamanho da mochila: "));
			// Criar o mapa de frutas
			Map<String, int[]> frutas = new HashMap<>();
			frutas.put("maracuja", new int[] { qtsArvMaracuja, maracuja });
			frutas.put("laranja", new int[] { arvoreLaranja, laranja });
			frutas.put("abacate", new int[] { arvoreAbacate, abacate });
			frutas.put("coco", new int[] { arvCoco, coco });
			frutas.put("acerola", new int[] { arvAcerola, acerola });
			frutas.put("amora", new int[] { arvAmora, amora });
			frutas.put("goiaba", new int[] { arvGoiaba, goiaba });
			arq.setDimensao(dimensao);
			arq.setMochila(tamMochila);
			arq.setPedras(qtsPedras);
			arq.setFrutas(frutas);
			this.inicilizarTerreno(qtsPedras, qtsArvMaracuja, maracuja, arvoreLaranja, laranja, arvoreAbacate, abacate,
					arvCoco, coco, arvAcerola, acerola, arvAmora, amora, arvGoiaba, goiaba);

			String nomeCompetidor1 = JOptionPane.showInputDialog("Digite o nome do Competidor 1:");
			String nomeCompetidor2 = JOptionPane.showInputDialog("Digite o nome do Competidor 2:");

			competidor1 = new Competidor(nomeCompetidor1, num.nextInt(terreno.getDimensao()),
					num.nextInt(terreno.getDimensao()), 10, num.nextInt(terreno.getDimensao()));
			competidor2 = new Competidor(nomeCompetidor2, num.nextInt(terreno.getDimensao()),
					num.nextInt(terreno.getDimensao()), 10, num.nextInt(terreno.getDimensao()));
			terreno.inserirCompetidor(competidor1.getX(), competidor1.getY(), competidor1);
			terreno.inserirCompetidor(competidor2.getX(), competidor2.getY(), competidor2);

			System.out.printf("Competidor 1: %d, %d\n", competidor1.getX(), competidor1.getY());
			System.out.printf("Competidor 2: %d, %d\n", competidor2.getX(), competidor2.getY());

		} else if (choice == 1) {
			System.out.println("Carregar Jogo selecionado");
			// Carregando o arquivo
			arq.lerConfig();

			this.terreno = new Terreno(arq.getDimensao());
			int pedras = arq.getPedras();
			int arvore_maracuja = arq.getQuantidadeArvores("maracuja");
			int frutas_maracuja = arq.getQuantidadeFrutas("maracuja");
			int arvore_laranja = arq.getQuantidadeArvores("laranja");
			int fruta_laranja = arq.getQuantidadeFrutas("laranja");
			int arvore_abacate = arq.getQuantidadeArvores("abacate");
			int fruta_abacate = arq.getQuantidadeFrutas("abacate");
			int arvore_coco = arq.getQuantidadeArvores("coco");
			int fruta_coco = arq.getQuantidadeFrutas("coco");
			int arvore_acerola = arq.getQuantidadeArvores("acerola");
			int fruta_acerola = arq.getQuantidadeFrutas("acerola");
			int arvore_amora = arq.getQuantidadeArvores("amora");
			int fruta_amora = arq.getQuantidadeFrutas("amora");
			int arvore_goiaba = arq.getQuantidadeArvores("goiaba");
			int fruta_goiaba = arq.getQuantidadeFrutas("goiaba");

			this.inicilizarTerreno(pedras, arvore_maracuja, frutas_maracuja, arvore_laranja, fruta_laranja,
					arvore_abacate, fruta_abacate, arvore_coco, fruta_coco, arvore_acerola, fruta_acerola, arvore_amora,
					fruta_amora, arvore_goiaba, fruta_goiaba);

			String nomeCompetidor1 = JOptionPane.showInputDialog("Digite o nome do Competidor 1:");
			String nomeCompetidor2 = JOptionPane.showInputDialog("Digite o nome do Competidor 2:");

			competidor1 = new Competidor(nomeCompetidor1, num.nextInt(terreno.getDimensao()),
					num.nextInt(terreno.getDimensao()), arq.getMochila(), num.nextInt(terreno.getDimensao()));
			competidor2 = new Competidor(nomeCompetidor2, num.nextInt(terreno.getDimensao()),
					num.nextInt(terreno.getDimensao()), arq.getMochila(), num.nextInt(terreno.getDimensao()));

			terreno.inserirCompetidor(competidor1.getX(), competidor1.getY(), competidor1);
			terreno.inserirCompetidor(competidor2.getX(), competidor2.getY(), competidor2);

			System.out.printf("Competidor 1: %d, %d\n", competidor1.getX(), competidor1.getY());
			System.out.printf("Competidor 2: %d, %d\n", competidor2.getX(), competidor2.getY());

		}

		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());

		TerrenoPanel board = new TerrenoPanel(terreno);
		mainPanel.add(board, BorderLayout.CENTER);

		JPanel controlsPanel = new JPanel();
		this.controles = controlsPanel;
		controlsPanel.setLayout(new BoxLayout(controlsPanel, BoxLayout.Y_AXIS));
		
		actionLog = new JTextArea(10, 20);
        actionLog.setEditable(false);
        JScrollPane logScrollPane = new JScrollPane(actionLog);
        logScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        controlsPanel.add(logScrollPane, BorderLayout.SOUTH);
        mainPanel.add(controlsPanel, BorderLayout.EAST);
		
		// tabela para exibir as frutas coletadas por cada competidor
		table = new JTable(tableModel);
		tableModel = new DefaultTableModel(new Object[]{"Frutas", competidor1.getNome(), competidor2.getNome()}, 0);
		table = new JTable(tableModel);
		table.setPreferredScrollableViewportSize(new Dimension(200, 128));
		table.setFillsViewportHeight(true);
				
		
		
		//controle de movimentação
		JPanel movementPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.fill = GridBagConstraints.HORIZONTAL;
		
		JButton buttonMovCima = new JButton("▲");
		buttonMovCima.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				moveJogador("w");
			}
		});
		
		controlsPanel.add(buttonMovCima);
		JButton leftButton = new JButton("◀");
		leftButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				moveJogador("a");
			}
		});
		
		
		
		
		controlsPanel.add(leftButton);
		JButton downButton = new JButton("▼");
		controlsPanel.add(downButton);
		downButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				moveJogador("s");
			}
		});
		
		JButton rightButton = new JButton("▶");
		controlsPanel.add(rightButton);
		rightButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				moveJogador("d");
			}
		});
		
		controlsPanel.add(movementPanel);
		mainPanel.add(controlsPanel, BorderLayout.EAST);
		getContentPane().add(mainPanel);
		setVisible(true);
		atualizarTabelaFrutas();
		// Adicionar painel de controle ao lado direito
		
		GridBagConstraints gbc1 = new GridBagConstraints();
		JLabel roundLabel = new JLabel("Round " + round);
		this.roundLabel = roundLabel;
		JLabel jogadorLabel = new JLabel(
				"Jogador: " + (round % 2 == 0 ? competidor2.getNome() : competidor1.getNome()));
		this.jogadorLabel = jogadorLabel;
		JLabel movsLabel = new JLabel("movs: 0");
		this.movsLabel = movsLabel;
		
		
		

		// Criação do painel pai
		JPanel parentPanel = new JPanel();
		parentPanel.setLayout(new BoxLayout(parentPanel, BoxLayout.Y_AXIS)); // Usando BoxLayout para empilhar
																				// verticalmente
		
		JButton salvarJogoButton = new JButton("Salvar Jogo");
		salvarJogoButton.setPreferredSize(new Dimension(120, 30));
		salvarJogoButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				salvarConfig();
				JOptionPane.showMessageDialog(null, "Jogo salvo");
			}
		});
		parentPanel.add(salvarJogoButton);
		
		JLabel tamanhoMochilaLabel = new JLabel("Tamanho da Mochila: " +  arq.getMochila());
		
		// Adicionando o botão "Iniciar Jogo" ao painel pai
		JButton iniciarJogoButton = new JButton("Iniciar Jogo");
		iniciarJogoButton.setPreferredSize(new Dimension(120, 30));
		iniciarJogoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Lógica para iniciar o jogo
				controlsPanel.setVisible(true);
				iniciarJogo();
				iniciarJogoButton.setVisible(false);
				parentPanel.add(tamanhoMochilaLabel);
				JScrollPane scrollPane = new JScrollPane(table);
				controlsPanel.add(scrollPane);
				controlsPanel.add(buttonMovCima);
				controlsPanel.add(leftButton);
				controlsPanel.add(downButton);
				controlsPanel.add(rightButton);
			}
		});
		
		controlsPanel.setVisible(false);
		parentPanel.add(roundLabel, gbc1);
		parentPanel.add(jogadorLabel, gbc1);
		
		parentPanel.add(movsLabel, gbc1);
		parentPanel.add(iniciarJogoButton); // Adiciona o botão "Iniciar Jogo"

		// Adicionando um espaço entre os botões, se necessário
		parentPanel.add(Box.createVerticalStrut(5)); // Cria um espaço de 10 pixels
		// Adicionando o botão "Salvar Jogo" ao painel pai
		//parentPanel.add(salvarJogoButton); // Adiciona o botão "Salvar Jogo"
		// Adicionando o painel de controle na parte inferior
		parentPanel.add(controlsPanel); // Adiciona o painel de controle
		
		mainPanel.add(parentPanel, BorderLayout.EAST);
		add(mainPanel, BorderLayout.CENTER);
		// Adicionando o painel pai ao painel principa
		// getContentPane().add(mainPanel);
	}

	/**
	 * Metodo responsavel por mudar o round do painel
	 *
	 * @param qRound qual round
	 */
	public void setRoundLabel(int qRound) {
		this.roundLabel.setText("Round " + qRound);
	}

	/**
	 * Metodo que chama a classe {@link LerArq} para salvar config do mapa
	 */
	private void salvarConfig() {
		arq.salvarConfig();
		arq.exibirConfiguracao();
	}

	/**
	 * Metodo para inicar o jogo, após clickar no botão iniciarJogo
	 */
	private void iniciarJogo() {
		competidorAtual = competidor1;
		round = 1;
		updateRoundInfo();

		repaint();
	}

	/**
	 * Move o jogador para o botão que clickou informando o lado, que pede para
	 * {@link Competidor} se mover.
	 *
	 * @param direcao onde o jogador vai se mover
	 */
	private void moveJogador(String direcao) {
		
		
		if (competidorAtual.getPontos() >= 2) {
			JOptionPane.showMessageDialog(null, "Jogodor " + competidorAtual.getNome() + " ganhou!");
			controles.setVisible(false);
			return;
		}

		if (direcao == "d") {
			actionLog.append(competidorAtual.getNome() + " moveu-se para direita\n");
			competidorAtual.moverDireita(terreno, actionLog);
			repaint();
			checkTurn();
		} else if (direcao == "w") {
			actionLog.append(competidorAtual.getNome() + " moveu-se para cima\n");
			competidorAtual.moverCima(terreno, actionLog);
			repaint();
			checkTurn();
		} else if (direcao == "a") {
			actionLog.append(competidorAtual.getNome() + " moveu-se para esquerda\n");
			competidorAtual.moverEsquerda(terreno, actionLog);
			repaint();
			checkTurn();
		} else if (direcao == "s") {
			actionLog.append(competidorAtual.getNome() + " moveu-se para baixo\n");
			competidorAtual.moverBaixo(terreno, actionLog);
			repaint();
			checkTurn();
		}
		movsLabel.setText("movs: " + competidorAtual.getMov());
		atualizarTabelaFrutas();
	}

	/**
	 * Metodo para ver o jogador que vai participar do turno e passara vez para ele
	 */
	private void checkTurn() {

		if (competidorAtual.getRoundsParado() > 0) {
			if (competidorAtual == competidor1) {
				competidorAtual = competidor2;
			} else {
				competidorAtual = competidor1;
			}
			return;
		}
		if (competidorAtual.getMov() < 0) {

			if (competidorAtual == competidor2) {
				competidor2.girarDados();
				competidorAtual = competidor1;

			} else {
				competidor1.girarDados();
				competidorAtual = competidor2;
				round++;
			}

			updateRoundInfo();
		}
	}
	private void atualizarTabelaFrutas() {
		
		// Exemplo de frutas coletadas - você pode substituir com valores reais dos competidores
		String[] frutas = {"Maracujá", "Laranja", "Abacate", "Coco", "Acerola", "Amora", "Goiaba","qts frutas"};
		int[] frutasCompetidor1 = {competidor1.qtsFrutas("maracuja"), competidor1.qtsFrutas("laranja"), competidor1.qtsFrutas("abacate"), competidor1.qtsFrutas("coco"), competidor1.qtsFrutas("acerola"), competidor1.qtsFrutas("amora"), competidor1.qtsFrutas("goiaba"), competidor1.getqtsMochila()};  // Exemplo
		int[] frutasCompetidor2 = {competidor2.qtsFrutas("maracuja"), competidor2.qtsFrutas("laranja"), competidor2.qtsFrutas("abacate"), competidor2.qtsFrutas("coco"), competidor2.qtsFrutas("acerola"), competidor2.qtsFrutas("amora"), competidor2.qtsFrutas("goiaba"), competidor2.getqtsMochila()};  // Exemplo

		tableModel.setRowCount(0);  // Limpa linhas anteriores

		for (int i = 0; i < frutas.length; i++) {
			tableModel.addRow(new Object[]{frutas[i], frutasCompetidor1[i], frutasCompetidor2[i]});
		}
	}
	
	/**
	 * Atuliza os label de informações do jogador
	 */
	private void updateRoundInfo() {
		roundLabel.setText("Round: " + round);
		jogadorLabel.setText("Jogador Atual: " + competidorAtual.getNome());

		competidor1.decrementarRoundsParado();
		competidor2.decrementarRoundsParado();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
		
	}


}