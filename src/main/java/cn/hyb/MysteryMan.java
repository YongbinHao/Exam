package cn.hyb;

import java.util.ArrayList;
import java.util.List;

/**
 * 放置宝箱的神秘人实体类
 */
public class MysteryMan {

    /**
     * 第一个宝箱在数组中的位置常量
     */
    public static final int FIRST_TREASURE_ID = 0;
    /**
     * 第一个宝箱的”上一个宝箱Hash值“
     */
    public static final String LASE_TREASURE_HASH_OF_FIRST_TREASURE = "0";

    /**
     * 一个神秘人放置了若干个宝箱
     *
     * @param treasuresNum 宝箱数量
     * @return 宝箱列表
     */
    public List<TreasureChest> placeTreasure(int treasuresNum) {
        //防止出现放置-1个宝箱这种情况
        if (treasuresNum <= 0) {
            return new ArrayList<>();
        }
        //声明宝箱列表
        List<TreasureChest> treasureChests = new ArrayList<>();
        //new出来若干个宝箱
        for (int i = 0; i < treasuresNum; i++) {
            treasureChests.add(new TreasureChest(i + 1));
        }
        //将第一个宝箱的”上一个宝箱Hash值“设置成常量中的值
        treasureChests.get(FIRST_TREASURE_ID).setLaseTreasureHash(LASE_TREASURE_HASH_OF_FIRST_TREASURE);
        //返回宝箱列表
        return treasureChests;
    }
}
