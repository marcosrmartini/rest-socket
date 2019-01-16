package br.com.martini.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import org.json.JSONObject;

public class Server {

	public void start() {
		try {
			ServerSocket server = new ServerSocket(6969);

			try {
				while (true) {
					Socket socket = server.accept();
					startHandle(socket);
				}
			} finally {
				server.close();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void startHandle(Socket socket) {
		Thread thread = new Thread() {
			@Override
			public void run() {
				try {
					OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream(), "UTF-8");
					BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

					String line = reader.readLine();
					
					JSONObject json = new JSONObject(line);
					
					writer.write(json.toString() + "\n");
					writer.flush();
					
					System.out.println("Conectado!");
					socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		
		thread.start();

	}

}
