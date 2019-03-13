//o jogador é criado com 100 de cash.
public class Jogador {
	private float cash = 100;
	
	public float getCash() {
		return cash;
	}
	
	public void setCash(float cash) {
		this.cash = cash;
	}
	
	//jogador tem 5 cartas
	public Carta[] CartasJogador(Carta carta) {
		Carta[] cartasJogador = new Carta[5];
		for(int i = 0; i < 5; i++) {
			cartasJogador[i] = new Carta();
		}
		return cartasJogador;
	}
}
