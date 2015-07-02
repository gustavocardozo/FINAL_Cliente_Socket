package Program;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cliente;

public class Guest {
	
	private static String host = "localhost";
	private static int port = 4000;
	
	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException{
		
		List<Cliente> clientes = new ArrayList<>();		
		
		Socket socket = new Socket(host, port);
		DataOutputStream toServer = null;
		ObjectInputStream inFromServer = null;
		
		try {			
		
			toServer = new DataOutputStream(socket.getOutputStream());
			inFromServer = new ObjectInputStream(socket.getInputStream());

			toServer.writeUTF("Clientes");
			while(true)
	        {
	        	Cliente c = (Cliente)inFromServer.readObject();
	        	
	        	System.out.println(c.getId());
	        	clientes.add(c);
	        }
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			FrmListadoClientes FormCliente = new FrmListadoClientes(clientes);
			FormCliente.setVisible(true);
			socket.close();
		}
	}	
}
