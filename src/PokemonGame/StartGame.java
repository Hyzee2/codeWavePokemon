package PokemonGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StartGame implements Game {
	List<String> pokemonList = new ArrayList<>();
	Pokemon myPokemon = new Pichu();

	public List<String> getPokemonList() {
		return pokemonList;
	}

	public void setPokemonList(List<String> pokemonList) {
		this.pokemonList = pokemonList;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StartGame startgame = new StartGame();
		boolean game = true;
		startgame.script();
		while (game) {
			System.out.println("무엇을 하시겠습니까?");
			System.out.println("1. 모험 떠나기 | 2. 포켓몬 도감보기 | 3. 종료");
			Scanner input = new Scanner(System.in); 
				int select = input.nextInt();
				switch (select) {
				case 1:
					System.out.println("몇 번 모험을 떠나시겠습니까?");
					int time =  input.nextInt();
					startgame.letsGo(time);
					break;
				case 2:
					System.out.println("현재까지의 포켓몬 도감");
					System.out.println(startgame.getPokemonList().toString());
					break;
				case 3:
					System.out.println("===========게임을 종료합니다===========");
					game = false;
				}
			} 
		

	}

	@Override
	public void dictionary(String name) {
		// TODO Auto-generated method stub
		pokemonList.add(name);
	}

	@Override
	public void script() {
		// TODO Auto-generated method stub
		System.out.println("오박사: 이제 나의 품을 떠날 때가 되었다... 모험을 떠나거라..!");
		System.out.println("====================게임 시작====================");

	}

	@Override
	public void levelup(int exp) {
		// TODO Auto-generated method stub
		if (20 == exp) {
			System.out.println("어어?!?어어어 " +myPokemon.getName()+"(이)가!!!!!! ");
			myPokemon = new Pikachu();
			System.out.println(myPokemon.getName()+"로 진화하였다!!! ");
		} else if (exp == 40) {
			System.out.println("어어?!?어어어 " +myPokemon.getName()+"(이)가!!!!!! ");
			myPokemon = new Laichu();
			System.out.println(myPokemon.getName()+"로 진화하였다!!! ");
		}
		

	}

	public void letsGo(int time) {
		// TODO Auto-generated method stub
		for (int i = 0; i < time; i++) {
			battle();
			System.out.println("현재 경험치는 : "+myPokemon.getExp());
		}
	}


	@Override
	public WildPokemon makeWild() {
		// TODO Auto-generated method stub
		String[] wildName = {"꼬부기", "잠만보", "파이리", "피죤", "이상해씨"};
		String[] wildSkills = {"물대포쏘기", "코골기", "불뿜기", "콕콕찌르기", "덩굴채찍"};
		int wildNameIndex = (int) (Math.random()*5);
		
		int randomHp = (int) (Math.random()*50);
		int randomPower = (int) (Math.random()*30);
	
		
		WildPokemon wild = new WildPokemon(wildName[wildNameIndex], randomHp, wildSkills[wildNameIndex], randomPower);
		System.out.println("야생 포켓몬 "+wild.getName()+"(이)가 나타났다!!!!");
		return wild;
	}

	@Override
	public void battle() {
		// TODO Auto-generated method stub
		WildPokemon wildpokemon = makeWild();
		
		// 우리 포켓몬이 공격한다
		while(wildpokemon.getHp()>0 || myPokemon.getHp()>0) {
			System.out.println("==================================");
			System.out.println("어떤 공격을 할까요?");
			System.out.println("==================================");
			for (String key : myPokemon.skills.keySet()) {
				System.out.println("- " + key);
	
			}
			Scanner select = new Scanner(System.in);
			int attack = myPokemon.attack(select.next());
			
			
			wildpokemon.attacked(attack);
			print(myPokemon.getHp(),wildpokemon.getHp());
			if(wildpokemon.getHp()<=0 || myPokemon.getHp()<=0) {
				hpReset(myPokemon.getName());
				break;
			}
			
			int wildAttack = wildpokemon.attack();
			myPokemon.attacked(wildAttack);
			
			
			print(myPokemon.getHp(),wildpokemon.getHp());
			if(wildpokemon.getHp()<=0 || myPokemon.getHp()<=0) {
				hpReset(myPokemon.getName());
				break;
			}
		}
		
		
		if(wildpokemon.getHp()<=0) {
			dictionary(wildpokemon.getName());
			myPokemon.setExp(myPokemon.getExp()+10);
			levelup(myPokemon.getExp());
		}
	}

	@Override
	public void print(int myHp, int wildHp) {
		// TODO Auto-generated method stub
		System.out.println("==================================");
		System.out.println("나의 포켓몬 hp : "+ myHp);
		System.out.println("야생 포켓몬 hp : "+wildHp);
		System.out.println("==================================");
		
	}

	@Override
	public void hpReset(String myPokemonName) {
		// TODO Auto-generated method stub
		int[] hp= {20, 40, 60};
		if(myPokemonName.equals("pichu")) {
			myPokemon.setHp(hp[0]);
		}else if(myPokemonName.equals("pikachu")) {
			myPokemon.setHp(hp[1]);
		}else {
			myPokemon.setHp(hp[2]);
		}
	}

}
