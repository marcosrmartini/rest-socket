package br.com.martini.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import org.json.JSONObject;

public class Client {
	
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", 6969);			
			OutputStreamWriter writer = new OutputStreamWriter( socket.getOutputStream(), "UTF-8" );			
			BufferedReader reader = new BufferedReader (new InputStreamReader(socket.getInputStream(), "UTF-8")) ;
			
			JSONObject json = new JSONObject();
			json.put("message", "Marcos Martini");
			
			writer.write(json.toString() + "\n");
			writer.flush();
			
			String line = reader.readLine();
			JSONObject data = new JSONObject(line);
			
			System.out.println("Receive: " + data.toString());
			
			
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
