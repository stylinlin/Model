package com.jonlin.common.utils;

import java.util.Random;

/**
 * 随机数工具包
 * @author admin
 *
 */
public class RandomUtil {

    private static Random random = new Random();

    /**
     * 生成随机数字(0-9)
     * @param length
     *            随机数长度
     * @return 结果
     */
    public static String randomNumber(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(random.nextInt(10));
        }
        return sb.toString();
    }

    /**
     * 得到一个长度为length的随机数
     * @param maxLength 最大长度
     * @return long
     */
    public static long getRandom(long maxLength) {
        if (maxLength < 1) { return 0; }

        long temp = 1;
        for (int i = 0; i < maxLength; i++) {
            temp *= 10;
        }
        return getRandom(0, temp - 1);
    }

    /**
     * 得到一个随机数，大于或等于beginNumber且小于或等于endNumber
     * @param beginNumber 大于或等于此值
     * @param endNumber 小于或等于此值
     * @return long
     */
    public static long getRandom(long beginNumber, long endNumber) {
        if (beginNumber >= endNumber) { return beginNumber; }

        double randomInDouble = random.nextDouble();
        long result = beginNumber + (long) ((endNumber - beginNumber + 1) * randomInDouble);

        return result;
    }

    /**
     * 得到长度为length的随机字符串，由数字和大写字母组成
     * @param length 随机数长度
     * @return String
     */
    public static String getRandomString(long length) {
        String result = "";
        for (int i = 0; i < length; i++) {
            long num = getRandom(0, 35);
            if (num < 10) {
                result += String.valueOf(num);
            } else {
                char ch = (char) (num - 10 + 65);
                result += ch;
            }
        }

        return result;

    }

    /**
     * 得到长度为length的随机字符串，由数字和A～F大写字母组成.
     * @param length 随机数长度
     * @return String
     */
    public static String getRandomHex(long length) {
        String result = "";
        for (int i = 0; i < length; i++) {
            long num = getRandom(0, 15);
            if (num < 10) {
                result += String.valueOf(num);
            } else {
                char ch = (char) (num - 10 + 65);
                result += ch;
            }
        }

        return result;

    }
}
