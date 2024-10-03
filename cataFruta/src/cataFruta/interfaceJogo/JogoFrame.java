package interfaceJogo;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;
import cataFruta.MeuJogo;
import terreno.Terreno;

public class JogoFrame extends JFrame {
    private MeuJogo jogo;
    private terreno.Terreno terreno = new Terreno(5);

    public JogoFrame() {
        setTitle("Cata Fruta");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        jogo = new MeuJogo(5, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 10);

        initUI();
    }

    private void inicilizarTerreno(int qtsPedras, int qtsArvMaracuja, int maracuja, int arvoreLaranja, int laranja, int arvoreAbacate, int abacate, int arvCoco, int coco, int arvAcerola, int acerola, int arvAmora, int Amora, int arvGoiaba) {
        terreno.colocarPedras(qtsPedras);
        terreno.adicionarArvores(qtsArvMaracuja, arvoreLaranja, arvoreAbacate, arvCoco, arvAcerola, arvAmora, arvGoiaba);
        terreno.gerarFrutas(maracuja, laranja, abacate, coco, Amora, acerola);
    }

    private void initUI() {
        this.inicilizarTerreno(5, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        getContentPane().setBackground(Color.GREEN);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        mainPanel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        interfaceJogo.TerrenoPanel board = new interfaceJogo.TerrenoPanel(terreno);
        mainPanel.add(board, BorderLayout.CENTER);

        // Inicia jogo
        JButton startButton = new JButton("Iniciar Jogo");
        startButton.addActionListener(e -> {
            jogo.iniciarJogo();
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JogoFrame frame = new JogoFrame();
            frame.setVisible(true);
        });
    }
}
