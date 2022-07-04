/* 
* * * * * * * * *
* 
* Author: Bradyo
* 
* * * * * * * * * 
*/

// Use The Package So The File Can Be Universal
package app.client;

import java.net.URI;
import java.net.URISyntaxException;

import org.java_websocket.client.WebSocketClient;

public class ClientApp {

	public static void main(String[] args) throws URISyntaxException{
		WebSocketClient client = new SocketClient(new URI("ws://" + ClientConstants.HOST_NAME + ":" + ClientConstants.PORT));
		client.connect();
	}
}
