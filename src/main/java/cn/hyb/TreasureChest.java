package cn.hyb;

/**
 * 宝箱实体类
 */
public class TreasureChest {
    /**
     * 宝箱编号，从1开始
     */
    int id;

    /**
     * 开启宝箱时的时间戳
     */
    long timestamp;
    /**
     * 该宝箱的Hash值
     */
    String hash;
    /**
     * 上一个宝箱的Hash值
     */
    String laseTreasureHash;
    /**
     * 打开宝箱的神秘数字
     */
    long magicNum;

    /**
     * 构造一个新宝箱的构造方法
     *
     * @param id 该宝箱的编号
     */
    public TreasureChest(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getLaseTreasureHash() {
        return laseTreasureHash;
    }

    public void setLaseTreasureHash(String laseTreasureHash) {
        this.laseTreasureHash = laseTreasureHash;
    }

    public long getMagicNum() {
        return magicNum;
    }

    public void setMagicNum(long magicNum) {
        this.magicNum = magicNum;
    }

    /**
     * 方便展示用而重写的toString方法
     * @return 每个宝箱的String表示
     */
    @Override
    public String toString() {
        return "宝箱编号为：" + id + "\n" +
                "宝箱开启时间为：" + timestamp + "\n" +
                "宝箱Hash值为：" + hash + "\n" +
                "上一个宝箱的Hash值为：" + laseTreasureHash + "\n" +
                "打开宝箱的神秘数字为：" + magicNum + "\n";
    }
}
