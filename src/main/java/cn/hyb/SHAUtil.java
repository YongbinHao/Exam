package cn.hyb;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * SHA算法包装工具类
 */
public class SHAUtil {

    /**
     * SHA256摘要实现
     *
     * @param str 要进行摘要的字符串
     * @return 摘要算法产生的SHA256字符串
     */
    public static String getSHA256(String str) {
        //声明java自带的摘要算法工具类
        MessageDigest messageDigest;
        //摘要算法得到的字符串结果
        String encodeStr = "";
        try {
            //获取摘要算法工具类实例
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes(StandardCharsets.UTF_8));
            //将获得的sha256字节串转换为十六进制表示
            encodeStr = byte2Hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return encodeStr;
    }

    /**
     * 将byte转为16进制
     *
     * @param bytes SHA256字节串
     * @return 16进制表示的SHA256字符串
     */
    private static String byte2Hex(byte[] bytes) {
        //获取一个StringBuilder对象
        StringBuilder stringBuilder = new StringBuilder();
        //中间结果临时值
        String temp;
        for (byte aByte : bytes) {
            //获取SHA256字节串的低8位，转换为16进制值
            temp = Integer.toHexString(aByte & 0xFF);
            //如果获得的十六进制值只有一位，那就在前面补0
            if (temp.length() == 1) {
                stringBuilder.append("0");
            }
            //将每一字节的结果增加到返回值对象上
            stringBuilder.append(temp);
        }
        return stringBuilder.toString();
    }
}
