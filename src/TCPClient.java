import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
 
 
public class TCPClient {
 
	public static void main(String[] args) {
 
		int serverPort = 10001;
		Socket sock;
		
		try {
			sock = new Socket("localhost", serverPort);
 
			BufferedReader in = new BufferedReader(new InputStreamReader(
					sock.getInputStream(),Charset.forName("UTF-8")));

			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
					sock.getOutputStream(),Charset.forName("UTF-8")));

			out.write("Hello Java TCP Server!!!! \n");
			out.flush();
 
			String inputLine = in.readLine();
			System.out.println("Data : " + inputLine);
 
			in.close();
			out.close();
			sock.close();
 
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
 
	}
 
}