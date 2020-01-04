import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		Battle battle = new Battle();
		
		
		//始まり
		System.out.println("これから勇者を召喚します");
		System.out.println("勇者の【HP】と【パワー】はランダムに決まります");
		System.out.println("体力は 50~100, 攻撃力は 3~10 で決まります");
		System.out.println("勇者は3回だけ召喚できます");
		Hero me = new Hero();
		boolean flag = false;
		int count = 0;
		while(flag == false) {
			if (count == 2) {
				System.out.println("勇者の名前を入力してください");
				String name1 = sc.next();
				me.name = name1;
				me.hp = ran.nextInt(51) + 50;
				me.power = ran.nextInt(8) + 3;
				me.max_hp = me.hp;
				System.out.println("勇者"+me.name+"(体力:" + me.hp + "攻撃力:" + me.power + ")を召喚します");
				System.out.println("< 冒険の始まりです！ >");
				System.out.println("------------------------------------------------");
				flag = true;
			}else {
				System.out.println("勇者の名前を入力してください");
				String name1 = sc.next();
				me.name = name1;
				me.hp = ran.nextInt(51) + 50;
				me.power = ran.nextInt(8) + 3;
				System.out.println("勇者" + me.name + "(体力:" + me.hp + " 攻撃力:" + me.power + ")を召喚しますか？");
				boolean flag2 = false;
				while (flag2 == false) {
					System.out.println("【 1:はい 0:いいえ 】");
					String ans = sc.next();
					if (ans.matches("0")) {
						System.out.println("もう一度召喚します");
						System.out.println("------------------------------------------------");
						flag2 = true;
					}else if (ans.matches("1")) {
						System.out.println("冒険の始まりです！");
						System.out.println("------------------------------------------------");
						flag = true;
						flag2 = true;
					}else {
						System.out.println("入力が読み込めませんでした");
						System.out.println("もう一度入力してください");
						System.out.println("------------------------------------------------");
						System.out.println("勇者"+me.name+"(HP:"+me.hp+"パワー:"+me.power+")を召喚してもよろしいですか？");
					}
				}
				count++;
			}
		}
		
		boolean end = false;
		while (end == false) {
			System.out.println("行動を選択してください");
			System.out.println("【 1:戦う 2:回復する 3:アイテムショップに行く 4:ステータス確認 5:終わる 】");
			String action1 = sc.next();
			if (action1.matches("[0-9]+")) {
				int action = Integer.parseInt(action1);
				if (action == 4) {
					System.out.println(me.name + "のステータス一覧");
					System.out.println("レベル\t" + me.level);
					System.out.println("最大HP\t" + me.max_hp);
					System.out.println("攻撃力\t" + me.power);
					System.out.println("防御力\t" + me.guard);
					//System.out.println("MP\t" + me.mp);
					System.out.println("お金\t" + me.money);
					System.out.println("死亡回数\t" + me.death);
					System.out.println("------------------------------------------------");
				}else if (action == 3) {
					
					System.out.println("まだ実装されていません");
					System.out.println("m(._.)m");
					System.out.println("------------------------------------------------");
					
					/*
					System.out.println("所持金 : " + me.money);
					System.out.println("何を買いますか");
					System.out.println("【 1:武器 2:防具 3:アイテム 4:戻る 】");
					boolean roop = false;
					while (roop == false) {
						String select1 = sc.next();
						if (select1.matches("[0-9]+")) {
							int select = Integer.parseInt(select1);
							if (select == 1) {
								
								System.out.println("まだ実装できていません");
								System.out.println("m(._.)m");
								System.out.println("------------------------------------------------");
								
								roop = true;
							}else if(select == 2){
								
								System.out.println("まだ実装できていません");
								System.out.println("m(._.)m");
								System.out.println("------------------------------------------------");
								
								roop = true;
							}else if(select == 3){
								
								System.out.println("まだ実装できていません");
								System.out.println("m(._.)m");
								System.out.println("------------------------------------------------");
								
								roop = true;
							}else if(select == 4){
								System.out.println("お店を出ます");
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
					
					*/
					
				}else if (action == 1) {
					battle.Battle(me);
					end = battle.flag;
				}else if (action == 5) {
					System.out.println("お疲れ様でした");
					System.out.println("ゲームを終了します");
					end = true;
				}else if (action == 2) {
					System.out.println("体力を回復した！");
					me.hp = me.max_hp;
					System.out.println("------------------------------------------------");
				}else if (action == 6) {
					
				}else if (action == 7) {
					
				}else if (action == 8) {
					
				}else if (action == 9) {
					
				}else {
					System.out.println("入力が読み込めませんでした");
					System.out.println("もう一度入力してください");
					System.out.println("------------------------------------------------");
				}
				
				
				
				
				
			}else if (action1.matches("win")) {
				System.out.println("隠しコマンドが入力されました");
				System.out.println("ゲームクリアです");
				System.out.println("おめでとうございます");
				end = true;
			}else {
				System.out.println("入力が読み込めませんでした");
				System.out.println("もう一度入力してください");
				System.out.println("------------------------------------------------");
			}
			
			
		}
		
		
	}

}
