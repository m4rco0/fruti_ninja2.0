package interfaceJogo;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;
import cataFruta.MeuJogo;
import terreno.Terreno;

public class JogoFrame extends JFrame {
//    private MeuJogo jogo;
    private terreno.Terreno terreno = new Terreno(5);

    public JogoFrame() {
        setTitle("Cata Fruta");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

//        jogo = new MeuJogo(5, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 10);

        initUI();
    }

    private void inicilizarTerreno(int qtsPedras, int qtsArvMaracuja, int maracuja, int arvoreLaranja, int laranja, int arvoreAbacate, int abacate, int arvCoco, int coco, int arvAcerola, int acerola, int arvAmora, int Amora, int arvGoiaba) {
        terreno.colocarPedras(qtsPedras);
        terreno.adicionarArvores(qtsArvMaracuja, arvoreLaranja, arvoreAbacate, arvCoco, arvAcerola, arvAmora, arvGoiaba);
        terreno.gerarFrutas(maracuja, laranja, abacate, coco, Amora, acerola);
        terreno.colocarGrama();
    }

    private void initUI() {
        this.inicilizarTerreno(5, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        mainPanel.add(new JScrollPane(textArea), BorderLayout.CENTER);

        interfaceJogo.TerrenoPanel board = new interfaceJogo.TerrenoPanel(terreno);
        mainPanel.add(board, BorderLayout.CENTER);

        // Inicia jogo
        JButton startButton = new JButton("Iniciar Jogo");
        startButton.addActionListener(e -> {
//      jogo.iniciarJogo();
            textArea.setText("Jogo iniciado!");
        });
        mainPanel.add(startButton, BorderLayout.SOUTH);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));

        JPanel controlsPanel = new JPanel();
        controlsPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

// Configurações comuns para todos os botões
        gbc.insets = new Insets(0, 0, 0, 0);
        gbc.fill = GridBagConstraints.NONE;

// Botão "W" (linha 0, coluna 1)
        gbc.gridx = 1;  // Coluna 1 (centralizado)
        gbc.gridy = 0;  // Linha 0
        controlsPanel.add(new JButton("W"), gbc);

// Botão "A" (linha 1, coluna 0)
        gbc.gridx = 0;  // Coluna 0
        gbc.gridy = 1;  // Linha 1
        controlsPanel.add(new JButton("A"), gbc);

// Botão "S" (linha 1, coluna 1)
        gbc.gridx = 1;  // Coluna 1
        gbc.gridy = 1;  // Linha 1
        controlsPanel.add(new JButton("S"), gbc);

// Botão "D" (linha 1, coluna 2)
        gbc.gridx = 2;  // Coluna 2
        gbc.gridy = 1;  // Linha 1
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
