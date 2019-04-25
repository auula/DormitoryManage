import java.io.UnsupportedEncodingException;

import org.junit.Test;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.digest.HMac;
import cn.hutool.crypto.digest.HmacAlgorithm;

public class crypto {
	@Test
	public void test() throws UnsupportedEncodingException {
		String testStr = "test中文";

		byte[] key = "password".getBytes();
		HMac mac = new HMac(HmacAlgorithm.HmacMD5, key);

		String macHex1 = mac.digestHex(testStr);//b977f4b13f93f549e06140971bded384
		System.out.println(macHex1);
		//MTIzNDU2
		String str = "MTIzNDU2";
		System.out.println(Base64.decodeStr(str));
	}
}
