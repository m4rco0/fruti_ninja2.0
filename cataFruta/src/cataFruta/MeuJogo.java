package cataFruta;
import competidor.*;
import estruturas.*;
import terreno.*;
import java.util.Random;
import java.util.Scanner;
/**
 * Classe main para fazer os rounds do jogo e utilizar as classes de todos os elementos que vão estar no jogo.
 * @author marcola.
 * @param args
 */
public class MeuJogo {
	private Terreno terreno;
	private int round;
	private Competidor competidor1;
	private Competidor competidor2;
	
	/**
	 * Construtor que cria o jogo recebendo a dimensão e a quantidade de objetos para o mapa
	 * @param dimensao - tamanho da matriz quadrada
	 * @param qtsPedras - quantidade de pedras no mapa
	 * @param arvoreMaracuja
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
	 * @param bichada
	 * @param capacidadeMochila
	 */
	public MeuJogo(int dimensao, int qtsPedras, int arvoreMaracuja, int maracuja, int arvoreLaranja, int laranja, int arvoreAbacate, int abacate, int arvCoco, int coco, int arvAcerola, int acerola, int arvAmora, int Amora, int arvGoiaba, int goiaba, double bichada,int capacidadeMochila) {
		terreno = new Terreno(dimensao);
		inicializarCompetidores(capacidadeMochila);
		inicilizarTerreno(qtsPedras,arvoreMaracuja, maracuja, arvoreLaranja,laranja, arvoreAbacate, abacate, arvCoco, coco, arvAcerola, acerola, arvAmora, Amora, arvGoiaba, goiaba, bichada);
	}
	/**
	 * Função que inicializar os objetos no terreno como arvores frutas e pedras
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
	 * @param bichada
	 */
	private void inicilizarTerreno(int qtsPedras, int qtsArvMaracuja, int maracuja, int arvoreLaranja, int laranja, int arvoreAbacate, int abacate, int arvCoco, int coco, int arvAcerola, int acerola, int arvAmora, int Amora, int arvGoiaba, int goiaba, double bichada) {
		terreno.colocarPedras(qtsPedras);
		terreno.adicionarArvores(qtsArvMaracuja, arvoreLaranja, arvoreAbacate, arvCoco, arvAcerola, arvAmora, arvGoiaba);
		terreno.gerarFrutas(maracuja, laranja, abacate, coco, Amora, acerola);
		terreno.colocarGrama();
	}
	
	/**
	 * Metodo que cria os jogadores e colocam em posições aleatorias do mapa
	 */
	private void inicializarCompetidores(int capacidadeMochila) {
		Random num = new Random();
		competidor1 = new Competidor("Competidor1",num.nextInt(terreno.getDimensao()) , num.nextInt(terreno.getDimensao()), capacidadeMochila, num.nextInt(terreno.getDimensao()));
		competidor2 = new Competidor("COmppetidor2", num.nextInt(terreno.getDimensao()), num.nextInt(terreno.getDimensao()), capacidadeMochila, num.nextInt(terreno.getDimensao()));
		terreno.inserirElem(competidor1.getX(), competidor1.getY(), competidor1);
		terreno.inserirElem(competidor2.getX(), competidor2.getY(), competidor2);
	}
	
	/**
	 * Metodo  onde fica o loop do game que recebe as entradas do jogador até algum jogador consigua coletar as frutas necessarias para ganhar.
	 * 
	 */
	public void iniciarJogo() {
		Scanner scanner = new Scanner(System.in);
		boolean jogoRodando =true;
		Random random = new Random();
		this.round = 1;
		
		while(jogoRodando) {
			if(competidor1.getMov() <= 0) {
				competidor1.setMov(random.nextInt(6) + random.nextInt(6));
			} 
			if (competidor2.getMov() <= 0) {
				competidor2.setMov(random.nextInt(6) + random.nextInt(6));
			}
			System.out.println("Round "+this.round);
			exibirTerreno();
			executarRound(competidor1, scanner);
			if(checarVitoria(competidor1)) {
				System.out.println(competidor1.getNome() + "venceu");
				jogoRodando = false;
				break;
			}
			executarRound(competidor2, scanner);
			if(checarVitoria(competidor2)) {
				System.out.println(competidor2.getNome() + "venceu");
				jogoRodando = false;
				break;
			}
			this.round++;
			competidor1.decrementarRoundsParado();
			competidor2.decrementarRoundsParado();
		}
		scanner.close();
	}
	
	public static void main(String[] args) {
		MeuJogo jogo = new MeuJogo(5, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 10);
		jogo.iniciarJogo();
	}
	/**
	 * Metodo que olha se o competidor ganhou ou não apos a sua jogadar acabar
	 * @param competidor - competidor que pode ser oganhador
	 * @return true se ganhou.
	 */
	private boolean checarVitoria(Competidor competidor) {
        return competidor.getPontos() >= 3;
    }
	
	/**
	 *  Metodo que executa round de cada jogador
	 * @param competidor - competidor que vai se mover
	 * @param scanner - teclas de caminhar
	 */
	private void executarRound(Competidor competidor, Scanner scanner) {
		System.out.println("Vez de " + competidor.getNome());
		System.out.println("Movimentos restantes " +competidor.getMov());
		boolean passou = false;
		
		
		while(competidor.getMov() > 0 || passou != false) {
			if(competidor.getRoundsParado() > 0) {
				System.out.println(competidor.getNome() + " está parado por " + competidor.getRoundsParado() + " round(s).");
				return;
			}
			System.out.println("Escolha uma direção para mover (WASD): ");
			char movimento = scanner.next().toUpperCase().charAt(0);
			switch(movimento) {
			case 'W':
				competidor.moverCima(terreno);
				break;
			case 'D':
				competidor.moverDireita(terreno);
				break;
			case 'A':
				competidor.moverEsquerda(terreno);
				break;
			case 'S':
				competidor.moverBaixo(terreno);
				break;
			case 'I':
				competidor.exibirMochila();
				break;
			default:
				System.out.println("Movimento invalido");
			}
			exibirTerreno();
		}
	}
	private void exibirTerreno() {
        terreno.exibirMapa();
    }
}

