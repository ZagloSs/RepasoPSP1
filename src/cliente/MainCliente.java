package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MainCliente {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 6564);
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Por favor, ve introduciendo numeros");
			String msg = "";
				
			while(!msg.equals("FIN")) {
				msg = sc.nextLine();
				dos.writeUTF(msg);
			}

			
			String respuesta = dis.readUTF();
			System.out.println(respuesta);
			
			dis.close();
			dos.close();
			socket.close();
			
			
			
			
		}catch(IOException e) {
			
		}
		
		
		

	}

}
