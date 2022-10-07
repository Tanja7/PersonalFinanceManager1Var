import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8989)) {
            System.out.println("Server started!");
            Analysis analysis = new Analysis();

            while (true) {
                try (Socket socket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                     PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
                    // обработка одного подключения
                    out.println("Введите информацию о покупке: наименование покупки, дата и сумма покупки через пробел");
                    String message = in.readLine();
                    out.println(analysis.readMessage(message));
                }
            }
        } catch (IOException e) {
            System.out.println("Не могу стартовать сервер");
            e.printStackTrace();
        }
    }
}