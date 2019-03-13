import java.util.ArrayList;
import java.util.List;

//possui jogadores, deckCartas, regrasPartida, premio.
public class Partida {
private int jogadoresPermitidos = 6;
private int totalJogadoresNaPartida = 0;

List<Jogador> jogadoresNaPartida = new ArrayList<Jogador>();

	//adiciona jogadores na partida, se ainda tiver vaga, e se ele tiver mais de 20 em cash, que é o valor da aposta inicial
	public List<Jogador> EntrarNaPartida(Jogador jogador) {

		if (totalJogadoresNaPartida < jogadoresPermitidos && jogador.getCash() > 20) {
			jogadoresNaPartida.add(jogador);
			totalJogadoresNaPartida++;
		}
		return jogadoresNaPartida;
	}


	//faz a aposta minima e distribui as cartas aos jogadores
	public List<Jogador> IniciarPartida(List<Jogador> jogadoresNaPartida) {		
		
		//cria o baralho randomico
		DeckCartas deckCartas = new DeckCartas();
		deckCartas.GerarDeckCartas();
		
		//cada jogador da partida recebe 5 cartas, e paga 20 (minimo) para jogar
		for (int i = 0; i < jogadoresNaPartida.size(); i++) {
			//pega o jogador na lista na partida
			Jogador jog = new Jogador();
			jog = jogadoresNaPartida.get(i);
			
			//subtrair o valor da aposta para montar a premiaçao
			MontarPremiacao(jog);
			
			//dar 5 cartas para cada jogador
			for (int j = 0; j < 5; j++) {
				Carta carta = new Carta();
				carta = deckCartas.GerarDeckCartas().get(j);
				jog.CartasJogador(carta);
			}	
		}
		return jogadoresNaPartida;
	}

	//montar a premiaçao
	public int MontarPremiacao(Jogador jogador){
		int apostaTotal = 0;
		//pega o jogador na lista na partida e subtrair o valor da aposta minima, e credita o valor subtraido no premio
		jogador.setCash(-20);
		apostaTotal = apostaTotal + 20;	
		
		return apostaTotal;
	}
	
	//declara o vencedor da partida e credita o premio 
	//obs: em implementaçao
	public Jogador ApontarVencedor(List<Jogador> jogadoresNaPartida){
		int premio;
		//premio = MontarPremicao(jogador);
		Jogador vencedor = new Jogador();
		ComparaCartasJogadores comparaCartas = new ComparaCartasJogadores();
		vencedor = comparaCartas.AvaliaCartasJgadores(jogadoresNaPartida);
		//vencedor.setCash(+premio);
		return vencedor;
		
	}
}
