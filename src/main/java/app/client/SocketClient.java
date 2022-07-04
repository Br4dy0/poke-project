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
import java.nio.ByteBuffer;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.handshake.ServerHandshake;

// Client Initializer
public class SocketClient extends WebSocketClient{

	// Socket Client Overload With URI and Draft
	public SocketClient(URI serverUri, Draft draft){
		super(serverUri, draft); 
	}

	// Socket Client Overload With Just URI
	public SocketClient(URI serverURI){
		super(serverURI);
	}

	//On The Openning Of The Connection
	@Override
	public void onOpen(ServerHandshake handshakedata){
		byte[] hiBtye = "Hello".getBytes();
		send(hiBtye);							 									          				// Send A Btye Message To The Server
		System.out.println("[Client] Connected To Websocket Server"); // Log Connection To Client
	}

	// On The Closing Of The Connection, Log The Closing Information
	@Override
	public void onClose(int code, String reason, boolean remote) {
		System.out.println("[Client] Closed With Exit Code " + code + 
			". Additional Info: " + reason);
	}

	// On The Recieving Of A Message (String Overload), Print Message
	@Override
	public void onMessage(String message) {
		System.out.println("[Client] Received A Message: " + message);
	}

	// On The Receiving Of A Message (Btye Overload), Log The Receiving Of The Btye
	@Override
	public void onMessage(ByteBuffer message) {
		System.out.println("[Client] Received A ByteBuffer: " + message);
	}

	// On An Error, Log It
	@Override
	public void onError(Exception ex) {
		System.err.println("[Client] An Error Has Occurred: " + ex);
	}
}