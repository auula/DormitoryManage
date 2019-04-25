package me.codegc.manage.utils;

import cn.hutool.crypto.digest.HMac;
import cn.hutool.crypto.digest.HmacAlgorithm;

/**
 * 加密工具类
 * 
 * @author DING
 *
 */
public class EncryptionUtil {
	/**
	 * key 是本人QQ哦😯
	 */
	private static final String KEY = "2420498526";

	/**
	 * 传入明文 返回密文
	 * 
	 * @param str 需要加密的字符串
	 * @return 密文
	 */
	public static String encrypted(String str) {
		return new HMac(HmacAlgorithm.HmacMD5, KEY.getBytes()).digestHex(str);
	}
	/**
	 * 传入明文和密码 判断是否一致
	 * @param clear 明文
	 * @param cipher 密文
	 * @return boolean类型
	 */
	public static Boolean validation(String clear, String cipher) {
		
		if (encrypted(clear).equals(cipher)) {
			return true;
		}
		return false;
	}

	/**
	 * 获取key
	 * 
	 * @return keystr
	 */
	public static String getKey() {
		return KEY;
	}
}
