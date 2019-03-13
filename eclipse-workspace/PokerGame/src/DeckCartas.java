import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Gera as cartas do baralho.
public class DeckCartas {
		
	//criar o baralho 
	public List<Carta> GerarDeckCartas() {
		List<Carta> baralho = new ArrayList<Carta>();
		//vetores com os valores que serão passados para as cartas
		String numeros[] = {"A,1,2,3,4,5,6,7,8,9,J,Q,K"};
		String naipes[] = {"valete, espada, copa, ouro"};
		//valores para as cartas
		String num, naipe;

		//gerando as cartas	
		for(int i = 0; i < naipes.length; i++) {
			naipe = naipes[i];
			for(int j = 0; j < numeros.length; j++) {
				num = numeros[j];
				Carta carta = new Carta();
				carta.setNumCarta(num);
				carta.setNaipeCarta(naipe);
				baralho.add(carta);
			}
		}	
		
		//embaralhando as cartas
		Collections.shuffle(baralho);
		
		//retorna o baralho
		return baralho;
	}

}
