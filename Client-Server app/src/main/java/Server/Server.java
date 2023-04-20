package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        System.out.println("Server started");
      serverStart(8734);

    }

    public static void serverStart(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port); // порт можете выбрать любой в доступном диапазоне 0-65536. Но чтобы не нарваться на уже занятый - рекомендуем использовать около 8080
        Socket clientSocket = serverSocket.accept(); // ждем подключения
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        System.out.println("New connection accepted");
        dialog(out,in);


    }


        public static void dialog(PrintWriter out, BufferedReader in) throws IOException {

            out.println("ServerMessage: Write your name");
            final String name = in.readLine();

            out.println("ServerMessage: " + name + ", are you child? (yes/no)");
            String answer = in.readLine();


            if (answer.equals("yes")) {
                out.println(String.format("ServerMessage: Welcome to the kids area, %s! Let's play!", name));
            } else if (answer.equals("no")) {
                out.println(String.format("ServerMessage: Welcome to the adult zone, %s! Have a good rest, or a good working day!", name));
            }
        }

}
