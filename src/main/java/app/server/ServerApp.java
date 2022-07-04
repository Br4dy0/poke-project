/* 
* * * * * * * * *
* 
* Author: Bradyo
* 
* * * * * * * * * 
*/

// Use The Package So The File Can Be Universal
package app.server;

import java.net.InetSocketAddress;

import org.java_websocket.server.WebSocketServer;

public class ServerApp{
	public static void main(String[] args) {
		WebSocketServer server = new SocketServer(new InetSocketAddress(ServerConstants.HOST_NAME, ServerConstants.PORT));
		server.run();
	}
}