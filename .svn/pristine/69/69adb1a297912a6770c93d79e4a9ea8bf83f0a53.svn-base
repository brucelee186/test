package framework.tool;

public class ComUtil {
	
	// 将byte数组转换成16制字符串并打印
	public static String[] byte2HexString(byte[] b) {
		String[] arrString = new String[40];
		for (int i = 0; i < b.length; i++) {
			String hex = Integer.toHexString(b[i] & 0xFF) + " ";
			if (hex.length() == 2) {
				hex = '0' + hex;
			}
			arrString[i] = hex.toUpperCase();
		}
		return arrString;
	} 
	
	// 字符串转成十六进制byte[] 类型数组；
    public static byte[] HEXString2Byte(String src) {
        if (null == src || 0 == src.length()) {
            return null;
        }
        byte[] ret = new byte[src.length() / 2];
        byte[] tmp = src.getBytes();
        for (int i = 0; i < (tmp.length / 2); i++) {
            ret[i] = uniteBytes(tmp[i * 2], tmp[i * 2 + 1]);
        }
        return ret;
    }
    
    // byte类型数据，转成十六进制形式；
    public static byte uniteBytes(byte src0, byte src1) {
        byte _b0 = Byte.decode("0x" + new String(new byte[] { src0 }))
                .byteValue();
        _b0 = (byte) (_b0 << 4);
        byte _b1 = Byte.decode("0x" + new String(new byte[] { src1 }))
                .byteValue();
        byte ret = (byte) (_b0 ^ _b1);
        return ret;
    }

}
