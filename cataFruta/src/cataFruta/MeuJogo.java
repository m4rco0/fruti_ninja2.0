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
	private Competidor competidor1;
	private Competidor competidor2;
	public MeuJogo(int dimensao, int qtsPedras, int arvoreMaracuja, int maracuja, int arvoreLaranja, int laranja, int arvoreAbacate, int abacate, int arvCoco, int coco, int arvAcerola, int acerola, int arvAmora, int Amora, int arvGoiaba, int goiaba, double bichada,int capacidadeMochila) {
		terreno = new Terreno(dimensao);
		inicializarCompetidores();
		inicilizarTerreno(qtsPedras,arvoreMaracuja, maracuja, arvoreLaranja,laranja, arvoreAbacate, abacate, arvCoco, coco, arvAcerola, acerola, arvAmora, Amora, arvGoiaba, goiaba, bichada);
	}
	private void inicilizarTerreno(int qtsPedras, int qtsArvMaracuja, int maracuja, int arvoreLaranja, int laranja, int arvoreAbacate, int abacate, int arvCoco, int coco, int arvAcerola, int acerola, int arvAmora, int Amora, int arvGoiaba, int goiaba, double bichada) {
		terreno.colocarGrama();
	}
	private void inicializarCompetidores() {
		Random num = new Random();
		competidor1 = new Competidor("Competidor1",num.nextInt(terreno.getDimensao()) , num.nextInt(terreno.getDimensao()), 10, 1, 1, 2);
		competidor2 = new Competidor("COmppetidor2", num.nextInt(terreno.getDimensao()), num.nextInt(terreno.getDimensao()), 10, 1, 1, 2);
		terreno.inserirElem(competidor1.getX(), competidor1.getY(), competidor1);
		terreno.inserirElem(competidor2.getX(), competidor2.getY(), competidor2);
	}
	public void iniciarJogo() {
		Scanner scanner = new Scanner(System.in);
		boolean jogoRodando =true;
		Random random = new Random();
		int round = 1;
		
		while(jogoRodando) {
			if(competidor1.getMov() <= 0) {
				competidor1.setMov(random.nextInt(6) + random.nextInt(6));
			} else if (competidor2.getMov() <= 0) {
				competidor2.setMov(random.nextInt(6) + random.nextInt(6));
			}
			System.out.println("Round "+round);
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
			round++;
		}
		scanner.close();
		
	}
	public static void main(String[] args) {
		MeuJogo jogo = new MeuJogo(5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		jogo.iniciarJogo();
	}
	
	private boolean checarVitoria(Competidor competidor) {
        return competidor.getPontos() >= 3;
    }
	
	private void executarRound(Competidor competidor, Scanner scanner) {
		System.out.println("Vez de " + competidor.getNome());
		System.out.println("Movimentos restantes " +competidor.getMov());
		boolean passou = false;
		
		while(competidor.getMov() > 0 || passou != false) {
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
			case 'E':
				passou = true;
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

