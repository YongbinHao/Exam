package cn.hyb;

import java.util.List;

public class Main {

    /**
     * 宝箱的数量
     */
    public static final int TREASURES_NUM = 10;

    /**
     * 声明一个放置宝箱的神秘人
     */
    static MysteryMan mysteryMan;
    /**
     * 声明神秘人留下的宝箱
     */
    static List<TreasureChest> treasureChests;

    /**
     * 让神秘人提前放好宝箱
     */
    public static void initTreasure() {
        //new一个神秘人出来
        mysteryMan = new MysteryMan();
        //让神秘人放好宝箱
        treasureChests = mysteryMan.placeTreasure(TREASURES_NUM);
    }

    public static void main(String[] args) {
        //放置宝箱
        initTreasure();
        //new一个解密人出来
        Breaker breaker = new Breaker(treasureChests);
        //让解密人打开宝箱
        breaker.openTreasure();
        //让解密人把打开的宝箱摆出来
        List<TreasureChest> treasureChests = breaker.getTreasureChests();
        //将每个宝箱的神秘数字展示出来
        treasureChests.forEach(System.out::println);
    }
}
