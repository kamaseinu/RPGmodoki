import java.util.*;

public class Shop {
	
	
	Scanner sc = new Scanner(System.in);
	
	
	public void Shop(Hero a) {
		
		ArrayList<String> weapon_name = new ArrayList<String>();	ArrayList<Integer> weapon_money = new ArrayList<Integer>();	ArrayList<Integer> weapon_power = new ArrayList<Integer>();
		ArrayList<String> armor_name = new ArrayList<String>();		ArrayList<Integer> armor_money = new ArrayList<Integer>();	ArrayList<Integer> armor_guard = new ArrayList<Integer>();
		ArrayList<String> item_name = new ArrayList<String>();		ArrayList<Integer> item_money = new ArrayList<Integer>();
		
		weapon_name.add("木の棒  ");	weapon_money.add(50);	weapon_power.add(5);
		weapon_name.add("木の剣  ");	weapon_money.add(100);	weapon_power.add(10);
		weapon_name.add("鉄の剣  ");	weapon_money.add(200);	weapon_power.add(20);
		weapon_name.add("銅の剣  ");	weapon_money.add(300);	weapon_power.add(30);
		weapon_name.add("銀の剣  ");	weapon_money.add(400);	weapon_power.add(40);
		weapon_name.add("金の剣  ");	weapon_money.add(500);	weapon_power.add(50);
		weapon_name.add("ダイヤの剣");weapon_money.add(600);	weapon_power.add(60);
		
		armor_name.add("皮の鎧  ");		armor_money.add(50);	armor_guard.add(5);
		armor_name.add("木の鎧  ");		armor_money.add(100);	armor_guard.add(10);
		armor_name.add("鉄の鎧  ");		armor_money.add(200);	armor_guard.add(20);
		armor_name.add("銅の鎧  ");		armor_money.add(300);	armor_guard.add(30);
		armor_name.add("銀の鎧  ");		armor_money.add(400);	armor_guard.add(40);
		armor_name.add("金の鎧  ");		armor_money.add(500);	armor_guard.add(50);
		armor_name.add("ダイヤの鎧");		armor_money.add(600);	armor_guard.add(60);
		
		item_name.add("薬草  ");		item_money.add(30);
		item_name.add("力の種 ");		item_money.add(50);
		item_name.add("守りの種");	item_money.add(50);
		item_name.add("煙玉  ");		item_money.add(30);
		
		//ショップでの行動
		boolean roop = false;
		while (roop == false) {
			System.out.println("所持金 : " + a.money + "ゴールド");
			System.out.println("何を買いますか");
			System.out.println("【 1:武器 2:防具 3:道具 4:お店を出る 】");
			String select1 = sc.next();
			if (select1.matches("[0-9]+")) {
				int select = Integer.parseInt(select1);
				if (select == 1) {		//1:武器
					for (int i=0; i<weapon_name.size(); i++) {
						System.out.printf("%2d %-5s\t%4dゴールド", i+1, weapon_name.get(i), weapon_money.get(i));
						System.out.println();
					}
					System.out.println("どれを買いますか？(数字を入力してください)");
					String select22 = sc.next();
					if (select22.matches("[0-9]+")) {
						int select2 = Integer.parseInt(select22);
						int select3 = select2 - 1;
						if (a.money >= weapon_money.get(select3)) {
							//買うかどうかの判断
							boolean flag4 = false;
							while (flag4 == false) {
								System.out.println(weapon_name.get(select3) + "(" + weapon_money.get(select3) + "ゴールド)でいいですか？");
								System.out.println("【 1:はい 2:いいえ 】");
								String select44 = sc.next();
								if (select44.matches("[0-9]+")) {
									int select4 = Integer.parseInt(select44);
									if (select4 == 1) {			//1:買う
										System.out.println(weapon_name.get(select3) + "を買いました！");
										System.out.println(a.name + "は" + weapon_name.get(select3) + "を装備した");
										System.out.println("攻撃力が" + weapon_power.get(select3) + "上がった");
										a.power += weapon_power.get(select3);
										a.money -= weapon_money.get(select3);
										System.out.println("------------------------------------------------");
										flag4 = true;
									}else if (select4 == 2) {	//2:買わない
										System.out.println("------------------------------------------------");
										flag4 = true;
									}else {
										System.out.println("入力が読み取れませんでした");
										System.out.println("------------------------------------------------");
									}
								}else {
									System.out.println("入力が読み取れませんでした");
									System.out.println("------------------------------------------------");
								}
							}
						}else {
							System.out.println("ゴールドが足りません");
							System.out.println("------------------------------------------------");
						}
					}else {
						System.out.println("入力が読み取れませんでした");
						System.out.println("------------------------------------------------");
					}
				}else if(select == 2){		//2:防具
					for (int i=0; i<armor_name.size(); i++) {
						System.out.printf("%2d %-5s\t%4dゴールド", i+1, armor_name.get(i), armor_money.get(i));
						System.out.println();
					}
					System.out.println("どれを買いますか？(数字を入力してください)");
					String select22 = sc.next();
					if (select22.matches("[0-9]+")) {
						int select2 = Integer.parseInt(select22);
						int select3 = select2 - 1;
						if (a.money >= armor_money.get(select3)) {
							//買うかどうかの判断
							boolean flag4 = false;
							while (flag4 == false) {
								System.out.println(armor_name.get(select3) + "(" + armor_money.get(select3) + "ゴールド)でいいですか？");
								System.out.println("【 1:はい 2:いいえ 】");
								String select44 = sc.next();
								if (select44.matches("[0-9]+")) {
									int select4 = Integer.parseInt(select44);
									if (select4 == 1) {
										System.out.println(armor_name.get(select3) + "を買いました！");
										System.out.println(a.name + "は" + armor_name.get(select3) + "を装備した");
										System.out.println("防御力が" + armor_guard.get(select3) + "上がった");
										a.guard += armor_guard.get(select3);
										a.money -= armor_money.get(select3);
										System.out.println("------------------------------------------------");
										flag4 = true;
									}else if (select4 == 2) {
										System.out.println("------------------------------------------------");
										flag4 = true;
									}else {
										System.out.println("入力が読み取れませんでした");
										System.out.println("------------------------------------------------");
									}
								}else {
									System.out.println("入力が読み取れませんでした");
									System.out.println("------------------------------------------------");
								}
							}
						}else {
							System.out.println("ゴールドが足りません");
							System.out.println("------------------------------------------------");
						}
					}else {
						System.out.println("入力が読み取れませんでした");
						System.out.println("------------------------------------------------");
					}
				}else if(select == 3){		//アイテム
					for (int i=0; i<item_name.size(); i++) {
						System.out.printf("%2d %-5s\t%4dゴールド", i+1, item_name.get(i), item_money.get(i));
						System.out.println();
					}
					System.out.println("どれを買いますか？(数字を入力してください)");
					String select22 = sc.next();
					if (select22.matches("[0-9]+")) {
						int select2 = Integer.parseInt(select22);
						int select3 = select2 - 1;
						if (a.money >= item_money.get(select3)) {
							//買うかどうかの判断
							boolean flag4 = false;
							while (flag4 == false) {
								System.out.println(item_name.get(select3) + "(" + item_money.get(select3) + "ゴールド)でいいですか？");
								System.out.println("【 1:はい 2:いいえ 】");
								String select44 = sc.next();
								if (select44.matches("[0-9]+")) {
									int select4 = Integer.parseInt(select44);
									if (select4 == 1) {
										System.out.println(item_name.get(select3) + "を買いました！");
										a.money -= item_money.get(select3);
										System.out.println("------------------------------------------------");
										flag4 = true;
									}else if (select4 == 2) {
										System.out.println("------------------------------------------------");
										flag4 = true;
									}else {
										System.out.println("入力が読み取れませんでした");
										System.out.println("------------------------------------------------");
									}
								}else {
									System.out.println("入力が読み取れませんでした");
									System.out.println("------------------------------------------------");
								}
							}
						}else {
							System.out.println("ゴールドが足りません");
							System.out.println("------------------------------------------------");
						}
					}else {
						System.out.println("入力が読み取れませんでした");
						System.out.println("------------------------------------------------");
					}
				}else if(select == 4){		//4:店を出る
					System.out.println("お店を出ます");
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
