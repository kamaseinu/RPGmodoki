import java.util.*;

public class Battle {
	
	Scanner sc = new Scanner(System.in);
	Random ran = new Random();
	Main main = new Main();
	
	public boolean flag = false;
	
	public void Battle (Hero a) {
		
		System.out.println("どの敵と戦いますか？");
		System.out.println("【 1:弱い敵 2:普通の敵 3:強い敵 4:ボス 5:戻る 】");
		//行動選択での戦いのループ
		boolean roop = false;
		while (roop == false) {
			String select1 = sc.next();
			if (select1.matches("[0-9]+")) {
				int select = Integer.parseInt(select1);
				if (select == 1 || select == 2 || select == 3 || select == 4) {
					Enemy monster = new Enemy();
					if (select == 1) {			//1:スライム
						monster.slime(monster);
					}else if (select == 2) {	//2:ゴブリン
						monster.goblin(monster);
					}else if (select == 3) {	//3:ドラゴン
						monster.doragon(monster);
					}else if (select == 4) {	//4:ボス
						monster.boss(monster);
					}
					System.out.println(monster.name + "が現れた！");
					//戦闘のループ
					boolean roop1 = false;
					while (roop1 == false) {
						//自分の行動のループ
						boolean roop2 = false;
						while (roop2 == false) {
							System.out.println(a.name + "のHP : " + a.hp);
							System.out.println(monster.name + "のHP : " + monster.hp);
							System.out.println("行動を選択してください");
							System.out.println("【 1:攻撃 2:魔法 3:眠る 4:アイテム 5:逃げる 】");
							String ans1 = sc.next();
							if (ans1.matches("[0-9]+")) {
								int ans = Integer.parseInt(ans1);
								if (ans == 1) {				//1:攻撃
									a.attack(a, monster);
									roop2 = true;
								}else if (ans == 2) {		//2:魔法
									if (a.level == 1) {
										System.out.println("まだ魔法を覚えていません");
										System.out.println("------------------------------------------------");
									}else {
										if (a.level - 1 <= a.Magic_name.size()) {
											for (int i = 0; i < a.level - 1; i++) {
												System.out.printf("%d %-4s\t%3dダメージ\t%2dmp", i+1, a.Magic_name.get(i), a.Magic_power.get(i), a.Magic_energy.get(i));
												System.out.println();
											}
										}else {
											for (int i = 0; i < a.Magic_name.size(); i++) {
												System.out.printf("%d %-4s\t%3dダメージ\t%2dmp", i+1, a.Magic_name.get(i), a.Magic_power.get(i), a.Magic_energy.get(i));
												System.out.println();
											}
										}
										System.out.println(a.name + "のMP : " + a.mp);
										System.out.println("魔法を選択してください(数字を入力してください)");
										String select55 = sc.next();
										if (select55.matches("[0-9]+")) {
											int select5 = Integer.parseInt(select55);
											if (select5 <= a.level - 1) {
												if (a.max_mp >= a.Magic_energy.get(select5 - 1)) {
													a.Magic(a, monster, select5 - 1);
												}else {
													System.out.println("魔力が足りません");
													System.out.println("------------------------------------------------");
												}
											}else {
												System.out.println("入力が読み取れませんでした");
												System.out.println("------------------------------------------------");
											}
										}else {
											System.out.println("入力が読み取れませんでした");
											System.out.println("------------------------------------------------");
										}
									}
									roop2 = true;
								}else if (ans == 3) {		//3:眠る
									a.sleep(a);
									roop2 = true;
								}else if (ans == 4) {		//4:アイテム
									
									
									System.out.println("まだ実装されていません");
									System.out.println("m(._.)m");
									System.out.println("------------------------------------------------");
									
									
									roop2 = true;
								}else if (ans == 5) {		//5:逃げる(50%の確率で成功)
									int run = ran.nextInt(100);
									if (run <= 50) {
										System.out.println("逃げられた！");
										System.out.println("------------------------------------------------");
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
									System.out.println("------------------------------------------------");
								}
							}else {
								System.out.println("入力が読み取れませんでした");
								System.out.println("------------------------------------------------");
							}
						}
						//自分のターンが終了した後
						if (roop1 == false) {
							//モンスターが生きてる場合
							if (monster.hp > 0) {
								//ランダムで行動する(90%の確率で攻撃を行う)
								int monster_action = ran.nextInt(10);
								if (monster_action <= 8) {
									monster.attack(a, monster);
								}else {
									monster.sleep(monster);
								}
								//勇者が死亡した場合
								if (a.hp <= 0) {
									System.out.println(a.name + "は死んだ...");
									a.death++;
									System.out.println("現在の死亡回数 : " + a.death);
									a.hp = a.max_hp;
									roop = true;
									roop1 = true;
									System.out.println("------------------------------------------------");
									System.out.println("------------------------------------------------");
								}
							}else {	//モンスターを倒した場合
								//ボスを倒した場合
								if (monster.max_hp == 1000 ) {
									System.out.println(a.name + "はボスを倒した！");
									System.out.println("ゲームクリアです");
									System.out.println("おめでとうございます");
									System.out.println("------------------------------------------------");
									System.out.println("------------------------------------------------");
									roop = true;
									roop1 = true;
									flag = true;
								}else {		//ボス以外の敵を倒した場合
									System.out.println(monster.name + "を倒した！");
									a.kill++;
									System.out.println(monster.name + "は" + monster.money + "ゴールドを落とした！");
									a.money += monster.money;
									
									/* 50%の確率で倒した敵のステータスの半分パワーアップする仕様の場合
									int ok1 = ran.nextInt(2);
									if (ok1 == 0) {
										System.out.println("<<" + a.name + "の最大体力は" + (monster.max_hp/2) + "増えた！>>");
										a.max_hp += monster.max_hp/2;
									}
									int ok2 = ran.nextInt(2);
									if (ok2 == 0) {
										System.out.println("<<" + a.name + "の攻撃力は" + monster.power/2 + "増えた！>>");
										a.power += monster.power/2;
									}
									int ok3 = ran.nextInt(2);
									if (ok3 == 0) {
										if (monster.guard/2 > 0) {
											System.out.println("<<" + a.name + "の防御力は" + monster.guard/2 + "増えた！>>");
											a.guard += monster.guard/2;
										}
									}
									*/
									
									System.out.println(a.name + "は" + monster.exp + "の経験値を手に入れた!");
									a.exp += monster.exp;
									a.total_exp += monster.exp;
									a.level_check(a);
									System.out.println("次のレベルアップに必要な経験値 : " + (a.level*50 - a.exp));
									
									System.out.println("------------------------------------------------");
									System.out.println("------------------------------------------------");
									roop = true;
									roop1 = true;
								}
							}
						}
					}
				}else if(select == 5){		//5:戻る
					System.out.println("------------------------------------------------");
					System.out.println("------------------------------------------------");
					roop = true;
				}else {
					System.out.println("入力が読み取れませんでした");
					System.out.println("------------------------------------------------");
				}
			}else {
				System.out.println("入力が読み取れませんでした");
				System.out.println("------------------------------------------------");
			}
		}
		
	}
	
}
