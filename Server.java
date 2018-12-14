import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
    private static final int PORT = 6879;
    public static void main(String[] args){
        ArrayList<Integer> arrayList = new ArrayList<>();
        ServerSocket serverSocket = null;
        Socket socket = null;
        ObjectOutputStream outputStream = null;
        ObjectInputStream inputStream = null;
        try {
            serverSocket = new ServerSocket(PORT);
            socket = serverSocket.accept();
            outputStream = new ObjectOutputStream(socket.getOutputStream()); // create output stream before input stream
            outputStream.flush();
            inputStream = new ObjectInputStream(socket.getInputStream());
            ArrayList<Integer> object = (ArrayList<Integer>) inputStream.readObject();
            //check if each number sent from client is prime and if it is, add it to arrayList
            for(Integer integer: object) {
                if(isPrime(integer)) {
                    arrayList.add(integer);
                }
            }
            //send arrayList back to client
            outputStream.writeObject(arrayList);


        } catch (IOException e1) {
            e1.printStackTrace();
        }   catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }





    public static boolean isPrime(int number) {
        if(number < 2) {
            return false;
        }
        for(int i = 2; i <= Math.sqrt(number); i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
