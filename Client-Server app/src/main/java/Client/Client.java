package Client;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Client {

    public static void main(String[] args){
clientConnection("netology.homework",8734);
    }



public static void clientConnection(String host, int port){

        try (Socket clientSocket = new Socket(host, port);
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true); //передаем имя клиента
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) { //получаем строку

            dialog(out,in);

        }catch (IOException e) {
            e.printStackTrace();

        }
    }


    public static void dialog(PrintWriter out, BufferedReader in) throws IOException {
        String clientName = "John";
        String positiveAnswer = "yes";
        String negativeAnswer = "no";

        List answers = new ArrayList();
        answers.add(clientName);
        answers.add(negativeAnswer);

        for (int i = 0; i<answers.size(); i++){
            String message = in.readLine();
            System.out.println(message);
            out.println(answers.get(i));
            System.out.println("ClientMessage: "+answers.get(i));
        }

        String lastMessage = in.readLine();
        System.out.println(lastMessage);
    }
}
