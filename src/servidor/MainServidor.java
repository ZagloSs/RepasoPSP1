package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MainServidor {

	public static void main(String[] args) {
		try (ServerSocket serverSocket = new ServerSocket(6564)){
			String msgSrvr = "";
				Socket socketCliente = serverSocket.accept();
				DataInputStream dis = new DataInputStream(socketCliente.getInputStream());
				DataOutputStream dos = new DataOutputStream(socketCliente.getOutputStream());
				
				ArrayList<Integer> listaNumerosEnterosValidos = new ArrayList<Integer>();
					
				while(!msgSrvr.equals("FIN")) {
					msgSrvr = dis.readUTF();
					System.out.println(msgSrvr);
					try {
						int numValido = Integer.parseInt(msgSrvr);
						listaNumerosEnterosValidos.add(numValido);
					}catch(Exception e) {
						System.out.println("Num no valido");
					}
				}
				
				dos.writeUTF(listaNumerosEnterosValidos.toString());
				
				dos.close();
				dis.close();
				socketCliente.close();
				serverSocket.close();
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
