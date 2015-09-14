package cn.scu01.hadoop.rpc;


import java.net.InetSocketAddress;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

public class RPCClient {

	public static void main(String[] args) throws Exception {
		Bizable proxy = RPC.getProxy(Bizable.class, 10010, new InetSocketAddress("172.16.85.1", 9527),new Configuration());
		String result =  proxy.sayHi("tomcat");
		System.out.println(result);
		RPC.stopProxy(proxy);
	}

}
