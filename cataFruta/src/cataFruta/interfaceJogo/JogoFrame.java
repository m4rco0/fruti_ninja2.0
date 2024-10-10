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
import competidor.Competidor;
import terreno.Terreno;
import arquivos.*;
/**
 * Classe JogoFrame que cria a interface gráfica do jogo.
 * Responsável por exibir o terreno e permitir que os jogadores façam seus movimentos através de botões.
 */
public class JogoFrame extends JFrame {
    /**
     * O terreno do jogo.
     * Utilizado para representar o estado e os elementos do jogo, como frutas, árvores e pedras.
     */
    private terreno.Terreno terreno;
    private competidor.Competidor competidor1;
    private competidor.Competidor competidor2;

    /**
     * Construtor da classe JogoFrame.
     * Inicializa a interface gráfica do jogo, configurando o tamanho da janela, título, e preparando o terreno.
     */
    public JogoFrame() {
        setTitle("Cata Fruta");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
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
        // Exibir menu de seleção para Novo Jogo ou Carregar Jogo
        String[] options = {"Novo Jogo", "Carregar Jogo"};
        int choice = JOptionPane.showOptionDialog(
                null,
                "Selecione uma opção",
                "Menu",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                null,
                options,
                options[0]
        );

        Random num = new Random();
        // Verificar a escolha do usuário
        if (choice == 0) {
            System.out.println("Novo Jogo selecionado");
            int dimensao = 0;
            //validação do tamanho do terreno
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

            this.inicilizarTerreno(
                    qtsPedras,
                    qtsArvMaracuja, maracuja,
                    arvoreLaranja, laranja,
                    arvoreAbacate, abacate,
                    arvCoco, coco,
                    arvAcerola, acerola,
                    arvAmora, amora,
                    arvGoiaba, goiaba
            );

            String nomeCompetidor1 = JOptionPane.showInputDialog("Digite o nome do Competidor 1:");
            String nomeCompetidor2 = JOptionPane.showInputDialog("Digite o nome do Competidor 2:");

            competidor1 = new Competidor(nomeCompetidor1, num.nextInt(terreno.getDimensao()), num.nextInt(terreno.getDimensao()), 10, num.nextInt(terreno.getDimensao()));
            competidor2 = new Competidor(nomeCompetidor2, num.nextInt(terreno.getDimensao()), num.nextInt(terreno.getDimensao()), 10, num.nextInt(terreno.getDimensao()));
            terreno.inserirCompetidor(competidor1.getX(), competidor1.getY(), competidor1);
            terreno.inserirCompetidor(competidor2.getX(), competidor2.getY(), competidor2);

            System.out.printf("Competidor 1: %d, %d\n", competidor1.getX(), competidor1.getY());
            System.out.printf("Competidor 2: %d, %d\n", competidor2.getX(), competidor2.getY());

        } else if (choice == 1) {
            System.out.println("Carregar Jogo selecionado");
            //Carregando o arquivo
            LerArq arq = new LerArq();
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

            this.inicilizarTerreno(
                    pedras,
                    arvore_maracuja, frutas_maracuja,
                    arvore_laranja, fruta_laranja,
                    arvore_abacate, fruta_abacate,
                    arvore_coco, fruta_coco,
                    arvore_acerola, fruta_acerola,
                    arvore_amora, fruta_amora,
                    arvore_goiaba, fruta_goiaba
            );

            String nomeCompetidor1 = JOptionPane.showInputDialog("Digite o nome do Competidor 1:");
            String nomeCompetidor2 = JOptionPane.showInputDialog("Digite o nome do Competidor 2:");

            competidor1 = new Competidor(nomeCompetidor1, num.nextInt(terreno.getDimensao()), num.nextInt(terreno.getDimensao()), 10, num.nextInt(terreno.getDimensao()));
            competidor2 = new Competidor(nomeCompetidor2, num.nextInt(terreno.getDimensao()), num.nextInt(terreno.getDimensao()), 10, num.nextInt(terreno.getDimensao()));
            terreno.inserirCompetidor(competidor1.getX(), competidor1.getY(), competidor1);
            terreno.inserirCompetidor(competidor2.getX(), competidor2.getY(), competidor2);

            System.out.printf("Competidor 1: %d, %d\n", competidor1.getX(), competidor1.getY());
            System.out.printf("Competidor 2: %d, %d\n", competidor2.getX(), competidor2.getY());

        }

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        getContentPane().setBackground(Color.GREEN);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        mainPanel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        TerrenoPanel board = new TerrenoPanel(terreno);
        mainPanel.add(board, BorderLayout.CENTER);

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

        JPanel parentPanel = new JPanel();
        parentPanel.setLayout(new BorderLayout());
        parentPanel.add(Box.createVerticalGlue(), BorderLayout.CENTER);
        parentPanel.add(controlsPanel, BorderLayout.SOUTH);

        mainPanel.add(parentPanel, BorderLayout.EAST);
        add(mainPanel, BorderLayout.CENTER);
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
