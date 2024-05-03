package PokemonGame;

public class WildPokemon extends Pokemon{
	public WildPokemon(String name, int hp, String skillName, int attackPower) {
		super.name = name;
		super.hp = hp;
		skills.put(skillName, attackPower);
		
	}

	
	
	
}

