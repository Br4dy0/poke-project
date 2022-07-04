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
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import org.java_websocket.handshake.ClientHandshake;
import org.java_websocket.server.WebSocketServer;
import org.java_websocket.WebSocket;

// Server Initializer
public class SocketServer extends WebSocketServer {

	public SocketServer(InetSocketAddress address) {
		super(address);
	}

	// On A Client Connected To The Server
	@Override
	public void onOpen(WebSocket conn, ClientHandshake handshake) {
		conn.send("[Server] Welcome to the server!");                                 // This method sends a message to the new client
		broadcast("[Server] Latest Connection: " + conn.getRemoteSocketAddress());    // This method sends a message to all clients connected
		System.out.println("[Server] A New Connection Has Been Made From " 
			+ conn.getRemoteSocketAddress()); 																		      // Log The Connection To The Console
	}

	// On A Client Closing It's Connection To The Server
	@Override
	public void onClose(WebSocket conn, int code, String reason, boolean remote) {
		System.out.println("[Server] Closed " + conn.getRemoteSocketAddress() 		    // Log The Closing Of A Connection To The Console
			+ " With Exit Code " + code + ". Additional Info: " + reason);
	}

	// On A String Message From The Client
	@Override
	public void onMessage(WebSocket conn, String message) {
		System.out.println("[Server] Received A Message From "									   	  // Log A String Message To The Console	
			+ conn.getRemoteSocketAddress() + " : " + message);
	}

	// On A Btye Message From The Client
	@Override
	public void onMessage( WebSocket conn, ByteBuffer message ) {
		String decodedBtyeBuffer = StandardCharsets.UTF_8.decode(message).toString(); // Log A Buffer Message To The Server			
		System.out.println("[Server] Received A ByteBuffer From "	
		+ conn.getRemoteSocketAddress() + ". Message: " + decodedBtyeBuffer);	    			 
	}

	// On A Server Error
	@Override
	public void onError(WebSocket conn, Exception ex) {
		System.err.println("[Server] An Error Has Occurred On Connection "				    // Log And Error To The Console
			+ conn.getRemoteSocketAddress()  + " : " + ex);
	}
	
	// Upon The Server Starting
	@Override
	public void onStart() {
		System.out.println("[Server] Started Sucessfully");												    // Log Starting Message To The Console
	}
}