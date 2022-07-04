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
import java.nio.ByteBuffer;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.drafts.Draft;
import org.java_websocket.handshake.ServerHandshake;

public class SocketClient extends WebSocketClient {
	public SocketClient(URI serverUri, Draft draft) {
		super(serverUri, draft);
	}

	public SocketClient(URI serverURI) {
		super(serverURI);
	}

	@Override
	public void onOpen(ServerHandshake handshakedata) {
		send("Hello, it is me. Mario :)");
		System.out.println("new connection opened");
	}

	@Override
	public void onClose(int code, String reason, boolean remote) {
		System.out.println("closed with exit code " + code + " additional info: " + reason);
	}

	@Override
	public void onMessage(String message) {
		System.out.println("received message: " + message);
	}

	@Override
	public void onMessage(ByteBuffer message) {
		System.out.println("received ByteBuffer");
	}

	@Override
	public void onError(Exception ex) {
		System.err.println("an error occurred:" + ex);
	}
}