package cataFruta.interfaceJogo;
import arquivos.LerArq;
import cataFruta.interfaceJogo.TerrenoPanel;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;
import cataFruta.MeuJogo;
import terreno.Terreno;
import arquivos.*;
/**
 * Classe JogoFrame que cria a interface gráfica do jogo.
 * Responsável por exibir o terreno e permitir que os jogadores façam seus movimentos através de botões.
 */
public class JogoFrame extends JFrame {
    //private MeuJogo jogo;
    /**
     * O terreno do jogo.
     * Utilizado para representar o estado e os elementos do jogo, como frutas, árvores e pedras.
     */
    private terreno.Terreno terreno = new Terreno(5);
    /**
     * Construtor da classe JogoFrame.
     * Inicializa a interface gráfica do jogo, configurando o tamanho da janela, título, e preparando o terreno.
     */
    public JogoFrame() {
        setTitle("Cata Fruta");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        //MeuJogo jogo = new MeuJogo(5, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 10);
        initUI();
    }
    /**
     * Metodo responsável por inicializar o terreno com elementos do jogo.
     * As pedras, árvores e frutas são distribuídas pelo terreno de acordo com as quantidades fornecidas.
     *
     * @param qtsPedras A quantidade de pedras no terreno.
     * @param qtsArvMaracuja A quantidade de árvores de maracujá.
     * @param maracuja A quantidade de frutos de maracujá.
     * @param arvoreLaranja A quantidade de árvores de laranja.
     * @param laranja A quantidade de frutos de laranja.
     * @param arvoreAbacate A quantidade de árvores de abacate.
     * @param abacate A quantidade de frutos de abacate.
     * @param arvCoco A quantidade de coqueiros.
     * @param coco A quantidade de cocos.
     * @param arvAcerola A quantidade de árvores de acerola.
     * @param acerola A quantidade de frutos de acerola.
     * @param arvAmora A quantidade de amoreiras.
     * @param amora A quantidade de frutos de amora.
     * @param arvGoiaba A quantidade de goiabeiras.
     * @param goiaba A quantidade de frutos de goiaba.
     */

    private void inicilizarTerreno(int qtsPedras, int qtsArvMaracuja, int maracuja, int arvoreLaranja, int laranja, int arvoreAbacate, int abacate, int arvCoco, int coco, int arvAcerola, int acerola, int arvAmora, int Amora, int arvGoiaba, int goiaba) {
        terreno.colocarPedras(qtsPedras);
        terreno.adicionarArvores(qtsArvMaracuja, arvoreLaranja, arvoreAbacate, arvCoco, arvAcerola, arvAmora, arvGoiaba);
        terreno.gerarFrutas(maracuja, laranja, abacate, coco, Amora, acerola, goiaba);
    }
    /**
     * Metodo responsável por inicializar a interface gráfica do jogo.
     * Configura os componentes visuais como o painel do terreno e os botões de controle.
     */
    private void initUI() {
    	LerArq arq = new LerArq();
        this.inicilizarTerreno(arq.getPedras(),arq.getQuantidadeArvores("maracuja"), arq.getQuantidadeFrutas("maracuja"),arq.getQuantidadeArvores("laranja"),arq.getQuantidadeFrutas("laranja"), arq.getQuantidadeArvores("abacate"), arq.getQuantidadeFrutas("abacate"), arq.getQuantidadeArvores("coco"), arq.getQuantidadeFrutas("coco"), arq.getQuantidadeArvores("acerola"), arq.getQuantidadeFrutas("acerola"), arq.getQuantidadeArvores("amora"), arq.getQuantidadeFrutas("amora"), arq.getQuantidadeArvores("goiaba"), arq.getQuantidadeFrutas("goiaba"));

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        getContentPane().setBackground(Color.GREEN);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        mainPanel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        TerrenoPanel board = new TerrenoPanel(terreno);
        mainPanel.add(board, BorderLayout.CENTER);

        // Inicia jogo
        JButton startButton = new JButton("Iniciar Jogo");
        startButton.addActionListener(e -> {
            //jogo.iniciarJogo();
            textArea.setText("Jogo iniciado!");
        });
        mainPanel.add(startButton, BorderLayout.SOUTH);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));

        JPanel controlsPanel = new JPanel();
        controlsPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.fill = GridBagConstraints.NONE;

        gbc.gridx = 1;
        gbc.gridy = 0;
        controlsPanel.add(new JButton("W"), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        controlsPanel.add(new JButton("A"), gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        controlsPanel.add(new JButton("S"), gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        controlsPanel.add(new JButton("D"), gbc);

        //Adiciona os botões no abaixo no painel
        JPanel parentPanel = new JPanel();
        parentPanel.setLayout(new BorderLayout());
        parentPanel.add(Box.createVerticalGlue(), BorderLayout.CENTER);
        parentPanel.add(controlsPanel, BorderLayout.SOUTH);
        // Adiciona o painel ao painel principal
        mainPanel.add(parentPanel, BorderLayout.EAST);
        add(mainPanel);

        add(mainPanel);
    }
    /**
     * Metodo main que inicia a interface gráfica do jogo.
     * Cria e exibe a janela principal do jogo usando o SwingUtilities.
     *
     * @param args Argumentos da linha de comando (não utilizados).
     */

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JogoFrame frame = new JogoFrame();
            frame.setVisible(true);
        });
    }
}
