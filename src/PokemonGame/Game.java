package PokemonGame;

public interface Game {
	public void dictionary(String name);
	
	public void script();
	
	public void levelup(int exp);
	
	public void letsGo(int time);
	
	public WildPokemon makeWild();
	
	public void battle();
	
	public void print(int myHp, int wildHp);
	
	public void hpReset(String myPokemonName);
	

	

}
