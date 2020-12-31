package cn.hyb;

import java.util.List;

/**
 * 宝箱解密人实体类
 */
public class Breaker {

    /**
     * 声明解密人拿到的宝箱实体列表
     */
    private final List<TreasureChest> treasureChests;

    /**
     * 创建一个新解密人的构造方法
     *
     * @param treasureChests 解密人拿到的宝箱列表
     */
    public Breaker(List<TreasureChest> treasureChests) {
        this.treasureChests = treasureChests;
    }

    /**
     * 解密人打开宝箱
     *
     * @return 打开宝箱需要的神秘数字数组
     */
    public long[] openTreasure() {
        //创建一个要返回的神秘数字数组，长度为宝箱数
        long[] magicNums = new long[treasureChests.size()];
        //对宝箱依次解密
        for (int i = 0; i < treasureChests.size(); i++) {
            //获取一个宝箱
            TreasureChest treasureChest = treasureChests.get(i);
            //设置打开宝箱的时间戳
            treasureChest.setTimestamp(System.currentTimeMillis());
            //计算神秘数字产生符合要求的Hash
            calculateMagicNumberOfHash(treasureChest);
            //将该宝箱的神秘数字放入结果数组
            magicNums[i] = treasureChest.getMagicNum();
            //将该宝箱的hash赋予下一个宝箱的“上一个宝箱的Hash值”
            if (i != treasureChests.size() - 1) {
                treasureChests.get(i + 1).setLaseTreasureHash(treasureChest.getHash());
            }
        }
        return magicNums;
    }

    /**
     * 计算神秘数字，产生符合要求的Hash
     *
     * @param treasureChest 要打开的宝箱实体
     */
    private void calculateMagicNumberOfHash(TreasureChest treasureChest) {
        //规则要求的hash源字符串前面的固定部分
        String hashPrefix = "" + treasureChest.getId() + treasureChest.getTimestamp() + treasureChest.getLaseTreasureHash();
        //遍历正整数神秘数字，寻找符合规则的正整数
        for (long i = 0; i < Long.MAX_VALUE; i++) {
            //获取一个StringBuilder对象，用来构造每次计算hash的字符串
            StringBuilder testStr = new StringBuilder();
            //将要计算hash的字符串前面的部分和神秘数字拼接起来
            testStr.append(hashPrefix);
            testStr.append(i);
            //计算字符串的hash值
            String hash = SHAUtil.getSHA256(testStr.toString());
            //验证是否符合字符串hash值前面为5个0的规则
            if (hash.startsWith("00000")) {
                //如果符合规则，那就把宝箱的神秘数字设置成循环当前值
                treasureChest.setMagicNum(i);
                //把宝箱的hash值也设置一下
                treasureChest.setHash(hash);
                //算一个值就行了，不用再算了
                break;
            }
        }
    }

    /**
     * 获取到该解密人的宝箱列表
     *
     * @return 宝箱列表
     */
    public List<TreasureChest> getTreasureChests() {
        return treasureChests;
    }
}
