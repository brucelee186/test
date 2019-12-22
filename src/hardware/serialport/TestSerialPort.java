package hardware.serialport;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import framework.tool.ComUtil;
import gnu.io.CommPort;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;

public class TestSerialPort {

	// http://www.cnblogs.com/Dreamer-1/p/5523046.html
	// http://blog.csdn.net/linghao00/article/details/6852739
	//http://blog.csdn.net/zhouyingge1104/article/details/44674841
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//getSerialInfor();
		getHumiture();
	}
	// ['hjʊmɪtʃɚ]
	private static void getHumiture() {
		 try {
				final CommPortIdentifier  portIdentifier = CommPortIdentifier.getPortIdentifier("COM2");
				final String PORT_OWER = "MonitorApp"; 
				//SerialPort serialPort = (SerialPort) portIdentifier.open("test", 4800);
				//CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier("COM4");//COM4是串口名字
				CommPort commPort = portIdentifier.open("COM2", 2000);    //2000是打开超时时间
				SerialPort serialPort = (SerialPort) commPort;
				// 必须设定参数,否则会乱码
				serialPort.setSerialPortParams(4800, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
				//System.err.println(portIdentifier);
				// 取得读取数据
				OutputStream outputStream = serialPort.getOutputStream();
				// 电表串口交互发送命令 01 03 00 48 00 08 C4 1A
				String strWriteTo = "010300480008C41A";
				//char sendDec[] = {0x01, 0x03, 0x00, 0x48, 0x00, 0x08, 0xC4, 0x1A};
				char sendDec[] = {0x01, 0x03, 0x00, 0x48, 0x00, 0x08, 0xC4, 0x1A};
				new Thread().sleep(1000);
				//byte[] byteSendData = new byte[] {'0', '1', '0', '3', '0', '0', '4', '8', '0', '0', '0', '8', 'C', '4', '1', 'A'};
				//DataOutputStream outputStream = new DataOutputStream(serialPort.getOutputStream());
				byte[] byteSendData = ComUtil.HEXString2Byte(strWriteTo);
				byte[] bytes = null;
				
	                while (true) {
	                	new Thread().sleep(1000);
	                	outputStream.write(byteSendData);
	    				
	    				InputStream inputStream = serialPort.getInputStream();
	    				// 取得读取数据长度.
	    				long inputBufferSize = inputStream.available();
	    				//System.err.println(inputBufferSize);
	    				if (inputBufferSize > 0 && inputBufferSize == 37) {
	    					//System.err.println(inputBufferSize);
	    					int bufflenth = inputStream.available();
	    					//System.err.println("bufflenth:" + bufflenth);
	    					// 初始化byte数组为buffer中数据的长度
	    					bytes = new byte[bufflenth];
	    					inputStream.read(bytes);
	    					//StringToHex sHex = new StringToHex();
	    					String[] arrRec = ComUtil.byte2HexString(bytes);
	    					/*if(null != arrRec && arrRec.length > 0) {
	    						for (int i = 0; i < arrRec.length; i++) {
									System.err.print(arrRec[i]);
								}
	    					}*/
	    					int[] strRec = new int[100];
	    					int j =0;
	    					//if(arrRec.length != 37)continue;
	    					for(int i=0;i<arrRec.length;i++){
	    						//Serial.println(dataRec[i],HEX);
	    						int tmp = 0;
	    						String recString = arrRec[i];
	    						if(null == recString)continue;
	    						recString = recString.replace(" ", "");
	    						if(recString.startsWith("0")) {
	    							recString = recString.substring(1,2);
	    						}
	    						//System.err.println(recString);
	    						tmp = Integer.parseInt(recString, 16);
	    						int hex0 = tmp&15; 
	    						tmp >>= 4;
	    						int hex1 = tmp&15;
	    						strRec[j]=hex1;
	    						j++;
	    						strRec[j]=hex0;
	    						j++;
	    					}
	    					long valTemp = 0;
	    					j = 8;
	    					for(int i=0;i<6;i++){
	    						int valInt =  strRec[i+j];
	    						double valLong = Math.pow(16, 5-i)*valInt;
	    						valTemp += valLong;
	    					}
	    					float val  =  (float)valTemp/10000;
	    					System.err.println("voltage:" + val);
	    					bufflenth = inputStream.available();
	    					new Thread().sleep(1000);
	    				}
	                }
				//serialPort.close();
				//inputStream.close();
				//outputStream.close();
			} catch (NoSuchPortException e) {
				e.printStackTrace();
			} catch (PortInUseException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} 
	}
	
	
	
	private static void getSerialInfor() {
		 try {
				final CommPortIdentifier  portIdentifier = CommPortIdentifier.getPortIdentifier("COM2");
				final String PORT_OWER = "MonitorApp"; 
				SerialPort serialPort = (SerialPort) portIdentifier.open("test", 4800);
				DataInputStream inputStream = new DataInputStream(serialPort.getInputStream());
				System.err.println(portIdentifier);
				OutputStream outputStream = serialPort.getOutputStream();
				// 电表串口交互发送命令 01 03 00 48 00 08 C4 1A
				String strOutput = "010300480008C41A";
				
				//char sendDec[] = {0x01, 0x03, 0x00, 0x48, 0x00, 0x08, 0xC4, 0x1A};
				char sendDec[] = {0x01, 0x03, 0x00, 0x48, 0x00, 0x08, 0xC4, 0x1A};
				outputStream.write(strOutput.getBytes());
				serialPort.close();
				inputStream.close();
				outputStream.close();
			} catch (NoSuchPortException e) {
				e.printStackTrace();
			} catch (PortInUseException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
    // 字符串转成十六进制byte[] 类型数组；
    public static byte[] hexString2Bytes(String src) {
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