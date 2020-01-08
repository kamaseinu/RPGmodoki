import java.util.*;

public class Hero {
	
	Random ran = new Random();
	
	public String name;
	public int hp = 0;
	public int max_hp;
	public int power = 10;
	public int guard = 5;
	public int mp = 10;
	public int max_mp;
	public int level = 1;
	public int exp = 0;
	public int total_exp;
	public int money = 0;
	public int death = 0;
	public int kill = 0;
	public ArrayList<String> Magic_name = new ArrayList<String>();
	public ArrayList<Integer> Magic_power = new ArrayList<Integer>();
	public ArrayList<Integer> Magic_energy = new ArrayList<Integer>();
	public Object[] item_box;
	
	
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
		this.total_exp = exp;
		this.money = money;
		this.death = death;
		this.kill = kill;
		Magic_name.add("火の玉");	Magic_power.add(10);	Magic_energy.add(10);
		Magic_name.add("吹雪");	Magic_power.add(15);	Magic_energy.add(20);
		Magic_name.add("雷");	Magic_power.add(20);	Magic_energy.add(30);
		Magic_name.add("台風");	Magic_power.add(30);	Magic_energy.add(40);
		Magic_name.add("地震");	Magic_power.add(40);	Magic_energy.add(50);
		Magic_name.add("津波");	Magic_power.add(50);	Magic_energy.add(60);
		Magic_name.add("隕石");	Magic_power.add(60);	Magic_energy.add(70);
		Magic_name.add("終焉");	Magic_power.add(10000);	Magic_energy.add(666);
		this.Magic_name = Magic_name;
		this.Magic_power = Magic_power;
		this.Magic_energy = Magic_energy;
	}
	
	//攻撃
	public void attack(Hero a, Enemy b) {
		System.out.println(a.name + "は" + b.name + "に攻撃した");
		int damage = a.power + ran.nextInt(4);
		int critical_hit = ran.nextInt(20);
		if (critical_hit == 0) {		//5%の確率でクリティカルヒット
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
	public void Magic (Hero a, Enemy b, int c) {
		System.out.println(a.name + "は" + a.Magic_name.get(c) + "を使った!");
		a.mp -= a.Magic_energy.get(c);
		System.out.println(b.name + "は" + a.Magic_power.get(c) + "のダメージ!");
		b.hp -= a.Magic_power.get(c);
		if (b.hp < 0) {
			b.hp = 0;
		}
		System.out.println("------------------------------------------------");
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
	
	
	public void level_check(Hero a) {
		while (a.exp > a.level*50) {
			if (a.exp >= a.level*50) {
				System.out.println(a.name + "はレベルが上がった!");
				System.out.printf("レベル\t%3d --> %3d", a.level, a.level+1);					System.out.println();
				System.out.printf("最大体力\t%3d --> %3d", a.max_hp, a.max_hp+a.level*10);	System.out.println();
				a.max_hp += a.level*10;
				System.out.printf("最大魔力\t%3d --> %3d", a.max_mp, a.max_mp+10);	System.out.println();
				a.max_mp += 10;
				System.out.printf("攻撃力\t%3d --> %3d", a.power, a.power+a.level*3);			System.out.println();
				a.power += a.level*3; 
				System.out.printf("防御力\t%3d --> %3d", a.guard, a.guard+a.level*3);			System.out.println();
				a.guard += a.level*3;
				a.exp -= a.level*50;
				a.level++;
			}
		}
	}
	
	
	
}
