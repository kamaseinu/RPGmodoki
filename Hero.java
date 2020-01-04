import java.util.*;

public class Hero {
	
	Random ran = new Random();
	
	public String name;
	public int hp = 0;
	public int power = 10;
	public int guard = 3;
	public int mp = 0;
	public int level = 1;
	public int exp = 0;
	public int money = 0;
	public int death = 0;
	public ArrayList<String> Magic = new ArrayList<String>();
	public int max_hp; 
	
	public Hero () {
		this.name = name;
		this.hp = hp;
		this.max_hp = hp;
		this.power = power;
		this.guard = guard;
		this.mp = mp;
		this.level = level;
		this.exp = exp;
		this.money = money;
		this.death = death;
	}
	
	public void attack(Hero a, Enemy b) {
		System.out.println(a.name + "は" + b.name + "に攻撃した");
		int damage = a.power + ran.nextInt(3);
		int critical_hit = ran.nextInt(19);
		if (critical_hit == 0) {
			System.out.println("クリティカルヒット！！！");
			damage *= 2;
		}
		if (b.guard >= damage) {
			System.out.println(b.name + "は1のダメージ！");
			b.hp -= 1;
		}else {
			System.out.println(b.name + "は" + (damage - b.guard) + "のダメージ！");
			b.hp -= damage - b.guard;
		}
		System.out.println("------------------------------------------------");
	}
	
	public void magic () {
		
	}
	
	public void sleep(Hero a) {
		System.out.println(a.name + "は眠った");
		if (a.hp + 30 <= a.max_hp) {
			System.out.println(a.name + "はHPが30回復した");
			a.hp += 30;
		}else if (a.hp + 30 > a.max_hp) {
			System.out.println(a.name + "はHPが" + (a.max_hp - a.hp) + "回復した");
			a.hp = a.max_hp;
		}
		System.out.println("------------------------------------------------");
	}
	
	public void hide() {
		
	}
	
}
