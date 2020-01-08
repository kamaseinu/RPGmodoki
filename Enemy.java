import java.util.*;

public class Enemy {
	
	Random ran = new Random();
	
	public String name;
	public int hp = 100;
	public int max_hp = hp;
	public int power = 10;
	public int guard = 5;
	public int mp = 0;
	public int max_mp;
	public int exp = 0;
	public int money = 0;
	
	//敵の基本データ
	public Enemy () {
		this.name = name;
		this.hp = hp;
		this.max_hp = hp;
		this.power = power;
		this.guard = guard;
		this.mp = mp;
		this.max_mp = mp;
		this.exp = exp;
		this.money = money;
	}
	
	//スライムのステータス
	public void slime(Enemy a) {
		a.name = "スライム";
		a.hp = 25 + ran.nextInt(10);
		a.max_hp = a.hp;
		a.power = 2 + ran.nextInt(2);
		a.guard = 1 + ran.nextInt(2);
		a.mp = 0;
		a.max_mp = a.mp;
		a.exp = 10 + ran.nextInt(3);
		a.money = 10 + ran.nextInt(3);
	}
	
	//ゴブリンのステータス
	public void goblin(Enemy a) {
		a.name = "ゴブリン";
		a.hp = 300 + ran.nextInt(50);
		a.max_hp = a.hp;
		a.power = 15 + ran.nextInt(5);
		a.guard = 10 + ran.nextInt(5);
		a.mp = 30 + ran.nextInt(5);
		a.max_mp = a.mp;
		a.exp = 50 + ran.nextInt(15);
		a.money = 30 + ran.nextInt(10);
	}
	
	//ドラゴンのステータス
	public void doragon(Enemy a) {
		a.name = "ドラゴン";
		a.hp = 500 + ran.nextInt(100);
		a.max_hp = a.hp;
		a.power = 75 + ran.nextInt(10);
		a.guard = 50 + ran.nextInt(10);
		a.mp = 75 + ran.nextInt(10);
		a.max_mp = a.mp;
		a.exp = 300 + ran.nextInt(50);
		a.money = 100 + ran.nextInt(30);
	}
	
	//ボスのステータス
	public void boss(Enemy a) {
		a.name = "ボス";
		a.hp = 1000;
		a.max_hp = a.hp;
		a.power = 150;
		a.guard = 125;
		a.mp = 100;
		a.max_mp = a.mp;
		//a.exp = 500;
		//a.money = 525;
	}
	
	//攻撃
    public void attack(Hero b, Enemy a) {
    	System.out.println(a.name + "は" + b.name + "に攻撃した");
		int damage = a.power + ran.nextInt(4);
		int critical_hit = ran.nextInt(20);
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
    
    //眠る(最大体力の3分の1回復)
    public void sleep(Enemy a) {
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
