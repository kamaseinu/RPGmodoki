import java.util.*;

public class Battle {
	
	Scanner sc = new Scanner(System.in);
	Random ran = new Random();
	
	public boolean flag = false;
	
	public void Battle (Hero a) {
		
		System.out.println("どの敵と戦いますか？");
		System.out.println("【 1:弱い敵 2:普通の敵 3:強い敵 4:ボス 5:戻る 】");
		boolean roop = false;
		while (roop == false) {						//行動選択での戦いのループ
			
			String select1 = sc.next();
			if (select1.matches("[0-9]+")) {
				int select = Integer.parseInt(select1);
				if (select == 1 || select == 2 || select == 3 || select == 4) {
					Enemy monster = new Enemy();
					if (select == 1) {
						monster.slime(monster);
					}else if (select == 2) {
						monster.goblin(monster);
					}else if (select == 3) {
						monster.doragon(monster);
					}else if (select == 4) {
						monster.boss(monster);
					}
					System.out.println(monster.name + "が現れた！");
					boolean roop1 = false;
					while (roop1 == false) {					//戦闘のループ
						
						boolean roop2 = false;
						while (roop2 == false) {				//自分の行動のループ
							System.out.println(a.name + "のHP : " + a.hp);
							System.out.println(monster.name + "のHP : " + monster.hp);
							System.out.println("行動を選択してください");
							System.out.println("【 1:攻撃 2:魔法 3:眠る 4:逃げる 】");
							String ans1 = sc.next();
							if (ans1.matches("[0-9]+")) {
								int ans = Integer.parseInt(ans1);
								if (ans == 1) {
									a.attack(a, monster);
									roop2 = true;
								}else if (ans == 2) {
									
									System.out.println("まだ実装されていません");
									System.out.println("m(._.)m");
									System.out.println("------------------------------------------------");
									
									/*
									if (a.Magic.isEmpty() == true) {
										System.out.println(a.name + "はまだ魔法を覚えていない");
										System.out.println("------------------------");
									}else {
										System.out.println(a.name + "のMP : " + a.mp);
										System.out.println("魔法を選択してください");
										System.out.println("【 1:攻撃 2:魔法 3:眠る 4:逃げる 】");
										System.out.println("------------------------");
										roop2 = true;
									}
									*/
									
								}else if (ans == 3) {
									a.sleep(a);
									roop2 = true;
								}else if (ans == 4) {
									int run = ran.nextInt(100);
									if (run <= 50) {
										System.out.println("逃げられた！");
										System.out.println("------------------------------------------------");
										roop1 = true;
										roop = true;
									}else {
										System.out.println("逃げられなかった...");
										System.out.println("------------------------------------------------");
									}
									roop2 = true;
								}else {
									System.out.println("入力が読み取れませんでした");
									System.out.println("もう一度入力してください");
									System.out.println("------------------------------------------------");
								}
							}else {
								System.out.println("入力が読み取れませんでした");
								System.out.println("もう一度入力してください");
								System.out.println("------------------------------------------------");
							}
						}
						
						if (roop1 == false) {
							//モンスターが生きてる場合
							if (monster.hp > 0) {
								int monster_action = ran.nextInt(100);
								if (monster_action <= 80) {
									monster.attack(a, monster);
								}else {
									monster.sleep(monster);
								}
								//勇者が死亡した場合
								if (a.hp <= 0) {
									System.out.println(a.name + "は死んだ...");
									a.death++;
									System.out.println("現在の死亡回数 : " + a.death);
									roop = true;
									roop1 = true;
									System.out.println("------------------------------------------------");
								}
							}//モンスターを倒した場合
							else if (monster.hp <= 0) {
								int ok1 = ran.nextInt(1);
								if (ok1 == 0) {
									System.out.println("<<" + a.name + "の最大体力は" + monster.max_hp + "増えた！>>");
									a.max_hp += monster.max_hp;
								}
								int ok2 = ran.nextInt(1);
								if (ok2 == 0) {
									System.out.println("<<" + a.name + "の攻撃力は" + monster.power + "増えた！>>");
									a.power += monster.power;
								}
								int ok3 = ran.nextInt(1);
								if (ok3 == 0) {
									System.out.println("<<" + a.name + "の防御力は" + monster.guard + "増えた！>>");
									a.guard += monster.guard;
								}
								System.out.println(monster.name + "は" + monster.money + "ゴールドを落とした！");
								a.money += monster.money;
								System.out.println("------------------------------------------------");
								roop = true;
								roop1 = true;
							}
						}
					}
				}else if(select == 5){
					System.out.println("------------------------------------------------");
					roop = true;
				}else {
					System.out.println("入力が読み取れませんでした");
					System.out.println("もう一度入力してください");
					System.out.println("------------------------------------------------");
				}
			}else {
				System.out.println("入力が読み取れませんでした");
				System.out.println("もう一度入力してください");
				System.out.println("------------------------------------------------");
			}
		}
			
	}
		
}
