import java.util.*;

public class Hero {
	
	Random ran = new Random();
	
	public String name;
	public int hp = 0;
	public int max_hp;
	public int power = 10;
	public int guard = 3;
	public int mp = 0;
	public int max_mp;
	public int level = 1;
	public int exp = 0;
	public int money = 0;
	public int death = 0;
	public int kill = 0;
	public ArrayList<String> Magic = new ArrayList<String>();
	public Object[] item_box;
	public String weapon;
	
	public Hero () {
		this.name = name;
		this.hp = hp;
		this.max_hp = hp;
		this.power = power;
		this.guard = guard;
		this.mp = mp;
		this.max_mp = mp;
		this.level = level;
		this.exp = exp;
		this.money = money;
		this.death = death;
		this.kill = kill;
	}
	
	//攻撃
	public void attack(Hero a, Enemy b) {
		System.out.println(a.name + "は" + b.name + "に攻撃した");
		int damage = a.power + ran.nextInt(4);
		int critical_hit = ran.nextInt(20);
		if (critical_hit == 0) {		//5%nの確率でクリティカルヒット
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
	
	//魔法
	public void magic () {
		
	}
	
	//眠る(最大体力の3分の1回復)
	public void sleep(Hero a) {
		System.out.println(a.name + "は眠った");
		int cure = a.max_hp/3;
		if (a.hp + cure <= a.max_hp) {
			System.out.println(a.name + "はHPが" + cure + "回復した");
			a.hp += cure;
		}else if (a.hp + cure > a.max_hp) {
			System.out.println(a.name + "はHPが" + (a.max_hp - a.hp) + "回復した");
			a.hp = a.max_hp;
		}
		System.out.println("------------------------------------------------");
	}
	
	//隠れる
	public void hide() {
		
	}
	
}
