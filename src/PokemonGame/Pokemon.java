package PokemonGame;
import java.util.HashMap;

abstract class Pokemon {
	String name;
	int hp;
	int exp;
	HashMap<String, Integer> skills = new HashMap<>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public HashMap<String, Integer> getSkills() {
		return skills;
	}
	public void setSkills(HashMap<String, Integer> skills) {
		this.skills = skills;
	}
	public int attack(String skillname) {
		System.out.println(this.name+"(이)가 "+skillname+"(을)를 시전했다!");
		return skills.get(skillname);

	}
	public int attack() {
		String skill = "";
		for (String key : skills.keySet()) {
			skill = key;
		}
		System.out.println(this.name+"(이)가 "+skill+"(을)를 시전했다!");
		return skills.get(skill);
	}
	
	public void attacked(int attackPower) {
		this.hp-=attackPower;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	

}

class Pichu extends Pokemon {
	
	public Pichu() {
		super.exp = 0;
		super.name = "pichu";
		super.hp = 20;
		skills.put("10만볼트", 10);
		skills.put("발차기", 5);
	}
}

class Pikachu extends Pichu {
	
	public Pikachu() {
		super.exp = 20;
		super.name = "Pikachu";
		super.hp = 40;
		skills.put("100만볼트", 20);
		skills.put("슈퍼발차기", 10);
	}
}

class Laichu extends Pikachu {

	public Laichu() {
		super.exp = 40;
		super.name = "Laichu";
		super.hp = 60;
		skills.put("1000만볼트", 30);
		skills.put("핵슈퍼발차기", 15);
	}
	
}