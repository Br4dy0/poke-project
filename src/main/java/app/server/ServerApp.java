/* 
* * * * * * * * *
* 
* Author: Bradyo
* Date  : 7/2022
* 
* * * * * * * * * 
*/

package app.server;

import java.net.InetSocketAddress;
import org.java_websocket.server.WebSocketServer;

// Server Starter
public class ServerApp{
	public static void main(String[] args) {
		WebSocketServer server = new SocketServer(new InetSocketAddress(ServerConstants.HOST_NAME, ServerConstants.PORT)); // Create A New Websocket Server On A Specific Host And Port
		server.run();																																																			 // Run The Server 
	}
}