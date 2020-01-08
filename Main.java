import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		Battle battle = new Battle();
		Shop shop = new Shop();
		
		
		//始まり
		System.out.println("これから勇者を召喚します");
		System.out.println("勇者の「体力」と「攻撃力」はランダムに決まります");
		System.out.println("体力は 50~100, 攻撃力は 3~10 で決まります");
		System.out.println("勇者の召喚は2回やり直せます");
		Hero me = new Hero();
		//召喚のループ
		boolean flag = false;
		int count = 0;
		while(flag == false) {
			if (count == 2) {				//リセット可能な場合
				System.out.println("勇者の名前を入力してください");
				String name1 = sc.next();
				me.name = name1;
				me.hp = ran.nextInt(51) + 50;
				me.power = ran.nextInt(8) + 3;
				me.max_hp = me.hp;
				System.out.println("勇者"+me.name+"(体力:" + me.max_hp + "攻撃力:" + me.power + ")を召喚します");
				System.out.println("< 冒険の始まりです！ >");
				System.out.println("------------------------------------------------");
				System.out.println("------------------------------------------------");
				flag = true;
			}else {							//リセットできない場合
				System.out.println("勇者の名前を入力してください");
				String name1 = sc.next();
				me.name = name1;
				me.hp = ran.nextInt(51) + 50;
				me.power = ran.nextInt(8) + 3;
				System.out.println("勇者" + me.name + "(体力:" + me.hp + " 攻撃力:" + me.power + ")を召喚しますか？");
				//召喚するかどうかの判断
				boolean flag2 = false;
				while (flag2 == false) {
					System.out.println("リセット可能回数 : " + (2-count) + "回");
					System.out.println("【 1:はい 0:いいえ 】");
					String ans = sc.next();
					if (ans.matches("0")) {
						System.out.println("もう一度召喚します");
						System.out.println("------------------------------------------------");
						flag2 = true;
					}else if (ans.matches("1")) {
						System.out.println("冒険の始まりです！");
						System.out.println("------------------------------------------------");
						System.out.println("------------------------------------------------");
						flag = true;
						flag2 = true;
					}else {
						System.out.println("入力が読み込めませんでした");
						System.out.println("------------------------------------------------");
						System.out.println("勇者"+me.name+"(HP:"+me.hp+"パワー:"+me.power+")を召喚してもよろしいですか？");
					}
				}
				count++;
			}
		}
		//メイン行動
		boolean end = false;
		while (end == false) {
			System.out.println("行動を選択してください");
			System.out.println("【 1:戦う 2:全回復する 3:ショップに行く 4:ステータス確認 5:終わる 】");
			String action1 = sc.next();
			if (action1.matches("[0-9]+")) {
				int action = Integer.parseInt(action1);
				if (action == 1) {			//1:戦う
					battle.Battle(me);
					end = battle.flag;
				}else if (action == 2) {	//2:全回復
					System.out.println("体力を全回復した！");
					me.hp = me.max_hp;
					System.out.println("------------------------------------------------");
					System.out.println("------------------------------------------------");
				}else if (action == 3) {	//3:ショップに行く
					shop.Shop(me);
				}if (action == 4) {			//4:ステータス確認
					System.out.println(me.name + "のステータス一覧");
					//System.out.println("レベル\t" + me.level);
					System.out.println("最大HP\t" + me.max_hp);
					System.out.println("攻撃力\t" + me.power);
					System.out.println("防御力\t" + me.guard);
					//System.out.println("MP\t" + me.mp);
					System.out.println("お金\t" + me.money);
					System.out.println("倒した敵の数\t" + me.kill);
					System.out.println("死亡回数\t" + me.death);
					System.out.println("------------------------------------------------");
					System.out.println("------------------------------------------------");
				}else if (action == 5) {	//5:終わる
					System.out.println("お疲れ様でした");
					System.out.println("ゲームを終了します");
					end = true;
				}else {
					System.out.println("入力が読み込めませんでした");
					System.out.println("------------------------------------------------");
				}
			}else if (action1.matches("win")) {		//win:隠しコマンド（ゲームクリア）
				System.out.println("隠しコマンドが入力されました");
				System.out.println("ゲームクリアです");
				System.out.println("おめでとうございます");
				System.out.println("------------------------------------------------");
				System.out.println("------------------------------------------------");
				end = true;
			}else {
				System.out.println("入力が読み込めませんでした");
				System.out.println("------------------------------------------------");
			}
			
		}
		
	}

}
