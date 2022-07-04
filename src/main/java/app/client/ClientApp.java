/* 
* * * * * * * * *
* 
* Author: Bradyo
* Date  : 7/2022
* 
* * * * * * * * * 
*/

package app.client;

import java.net.URI;
import java.net.URISyntaxException;
import org.java_websocket.client.WebSocketClient;

// Client Starter
public class ClientApp {
	public static void main(String[] args) throws URISyntaxException{
		WebSocketClient client = new SocketClient(
			new URI("ws://" + ClientConstants.HOST_NAME + ":" + ClientConstants.PORT)); // Initialized Websocket For Client
		client.connect();																													    // Connect To The Server
	}
}
