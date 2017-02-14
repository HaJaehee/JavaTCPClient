import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
 
 
public class TCPClient {
 
	public static void main(String[] args) {
 
		try {
			Socket socket = new Socket("localhost", 10000);
 
			BufferedReader in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));

			OutputStream out = socket.getOutputStream();
 
			out.write("Hello Java Tcp Client!!!! \n".getBytes());
			out.flush();
 
			String line = in.readLine();
			System.out.println("Reply : "+line);
 
			in.close();
			out.close();
			socket.close();
 
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
 
	}
 
}