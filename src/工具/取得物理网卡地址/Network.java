package 工具.取得物理网卡地址;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;

public class Network {
    public static boolean checkMac(String mac) throws Exception {
    	boolean validMac = false;
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while(networkInterfaces.hasMoreElements()) {
        	String macTemp = "";
            NetworkInterface interface1 = networkInterfaces.nextElement();
            if (interface1.getParent() == null && interface1.getInetAddresses() != null && interface1.getHardwareAddress() != null){
                Enumeration<InetAddress> inetAddrs = interface1.getInetAddresses();
                System.out.print("网卡名称：");
                System.out.println(interface1.getName() + " " + interface1.getDisplayName());
                
                System.out.print("MAC：");
                byte[] btMac = interface1.getHardwareAddress();
                for (int i = 0; i < btMac.length; i++) {
                	macTemp += Integer.toHexString(btMac[i] & 0xff).toUpperCase();
                    System.out.print(Integer.toHexString(btMac[i] & 0xff).toUpperCase());
                    if(i < btMac.length - 1) {
                    	System.out.print(":");	
                    	macTemp += ":";
                    }
                }
                System.out.println();
                System.err.println(macTemp);
                if (mac.equals(macTemp)) {
					return true;
				}
                System.out.println();
                
                System.out.println("网卡IP：");
                while (inetAddrs.hasMoreElements())
                    System.out.println(inetAddrs.nextElement());
                System.out.println();
                System.out.println();
            }
        }
        return validMac;
    }
    
    public static void main(String[] args) {
		String mac = "10:60:4B:81:80:17";
		try {
			boolean validMac = checkMac(mac);
			System.err.println(validMac);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}