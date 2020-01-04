import java.util.*;

public class Enemy {
	
	Random ran = new Random();
	
	public String name;
	public int hp = 100;
	public int power = 10;
	public int guard = 5;
	public int mp = 0;
	public int exp = 0;
	public int money = 0;
	public int max_hp = hp;
	
	
	public Enemy () {
		this.name = name;
		this.hp = hp;
		this.max_hp = hp;
		this.power = power;
		this.guard = guard;
		this.mp = mp;
		this.exp = exp;
		this.money = money;
	}
	
	public void slime(Enemy a) {
		a.name = "スライム";
		a.hp = 25 + ran.nextInt(10);
		a.max_hp = a.hp;
		a.power = 1 + ran.nextInt(1);
		a.guard = 1 + ran.nextInt(1);
		a.mp = 0;
		a.exp = 5;
		a.money = 10;
	}
	
	public void goblin(Enemy a) {
		a.name = "ゴブリン";
		a.hp = 100 + ran.nextInt(30);
		a.max_hp = a.hp;
		a.power = 10 + ran.nextInt(5);
		a.guard = 4 + ran.nextInt(3);
		a.mp = 10 + ran.nextInt(2);
		a.exp = 15;
		a.money = 30;
	}
	
	public void doragon(Enemy a) {
		a.name = "ドラゴン";
		a.hp = 150 + ran.nextInt(20);
		a.max_hp = a.hp;
		a.power = 10 + ran.nextInt(5);
		a.guard = 10 + ran.nextInt(5);
		a.mp = 30 + ran.nextInt(5);
		a.exp = 50;
		a.money = 100;
	}
	
	public void boss(Enemy a) {
		a.name = "ボス";
		a.hp = 500;
		a.max_hp = a.hp;
		a.power = 30;
		a.guard = 30;
		a.mp = 100;
		//a.exp = 500;
		//a.money = 525;
	}
	
	
    public void attack(Hero b, Enemy a) {
    	System.out.println(a.name + "は" + b.name + "に攻撃した");
		int damage = a.power + ran.nextInt(3);
		int critical_hit = ran.nextInt(19);
		if (critical_hit == 0) {
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
    
    public void sleep(Enemy a) {
    	System.out.println(a.name + "は眠った");
		if (a.hp + 30 <= a.max_hp) {
			System.out.println(a.name + "はHPが20回復した");
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
