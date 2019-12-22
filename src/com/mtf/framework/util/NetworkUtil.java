package com.mtf.framework.util;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class NetworkUtil {
    public static boolean checkMac(String mac){
    	boolean validMac = false;
        try {
			Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
			while(networkInterfaces.hasMoreElements()) {
				String macTemp = "";
			    NetworkInterface interface1 = networkInterfaces.nextElement();
			    if (interface1.getParent() == null && interface1.getInetAddresses() != null && interface1.getHardwareAddress() != null){
			        byte[] btMac = interface1.getHardwareAddress();
			        for (int i = 0; i < btMac.length; i++) {
			        	String  subMac = Integer.toHexString(btMac[i] & 0xff).toUpperCase();
			        	if (1 == subMac.length()) {
							subMac = "0" + subMac;
						}
			        	macTemp += subMac;
			            if(i < btMac.length - 1) {
			            	macTemp += "-";
			            }
			        }
			        if (mac.equals(macTemp)) {
						return true;
					}
			    }
			}
		} catch (SocketException e) {
			e.printStackTrace();
			return false;
		}
        return validMac;
    }
    
}