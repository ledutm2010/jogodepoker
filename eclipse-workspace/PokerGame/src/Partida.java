import java.util.ArrayList;
import java.util.List;

//possui jogadores, deckCartas, regrasPartida, premio.
public class Partida {
private int jogadoresPermitidos = 6;
private int totalJogadoresNaPartida = 0;

List<Jogador> jogadoresNaPartida = new ArrayList<Jogador>();

	//adiciona jogadores na partida, respeitando o limite
	public void AdicionarJogadores(Jogador jogador) {

		if (totalJogadoresNaPartida < jogadoresPermitidos) {
			jogadoresNaPartida.add(jogador);
			totalJogadoresNaPartida++;
		}
	}


	//so recebe cartas quem ainda tem cash
	public void DistribuirCartas(Jogador jogador) {		
		
		//cria o baralho randomico
		DeckCartas deckcartas = new DeckCartas();
		deckcartas.GerarDeckCartas();
		
		//distribuir as cartas
		for (int i = 0; i < totalJogadoresNaPartida; i++) {
			//pega o jogador na lista na partida
			Jogador jog = new Jogador();
			jog = jogadoresNaPartida.get(i);
			
			//dar 5 cartas para cada jogador
			for (int j = 0; j < 5; j++) {
				Carta carta = new Carta();
				carta = deckcartas.GerarDeckCartas().get(j);
				jog.CartasJogador(carta);
			}	
		}
	}

	
}
