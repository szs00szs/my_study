package cc.hansam.tools;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.junit.Test;

/**
 * @author hansam 945210972@qq.com
 * @date 2017年9月13日上午10:13:18
 */
public class Hex2Float {
	/**
	 * 测试十六进制字符串转float.
	 * 
	 * @throws DecoderException
	 */
	@Test
	public final void testHex2Float() throws DecoderException {
		String hexStr = "0000C841";
		Float result = hexStr2Float(hexStr);
		System.out.println(result);
	}

	/**
	 * 十六进制字符串转float.
	 * 
	 * @param hexStr
	 * @return
	 * @throws DecoderException
	 */
	public static Float hexStr2Float(String hexStr) throws DecoderException {
		Float result = null;
		// 先通过apahce的 hex类转换十六进制字符串为byte数组. 也可以自己用JDK原声的方法来循环转
		// Character.digit(ch, 16);
		byte[] decodes = Hex.decodeHex(hexStr.toCharArray());
		// 获得byte转float的结果
		result = getFloat(decodes, 0);
		return result;
	}

	/**
	 * 通过byte数组取得float
	 * 
	 * @param b
	 * @param index
	 *            第几位开始取.
	 * @return
	 */
	public static float getFloat(byte[] b, int index) {
		int l;
		l = b[index + 0];
		l &= 0xff;
		l |= ((long) b[index + 1] << 8);
		l &= 0xffff;
		l |= ((long) b[index + 2] << 16);
		l &= 0xffffff;
		l |= ((long) b[index + 3] << 24);
		return Float.intBitsToFloat(l);
	}
}
