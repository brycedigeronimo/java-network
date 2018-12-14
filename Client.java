import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class Client {
    private static final int PORT = 6879;
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList();
        Socket socket = null;
        ObjectOutputStream outputStream = null;
        ObjectInputStream inputStream = null;
        String sentence;
        int number;
        try {
            InetAddress address = InetAddress.getLocalHost();
            socket = new Socket(address, PORT);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.flush();
            inputStream = new ObjectInputStream(socket.getInputStream());
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            while(true) {
                System.out.println("Enter an integer (\"!\" to send):");
                sentence = inFromUser.readLine();
                if(sentence.equals("!")) {
                    System.out.println("Send:" + arrayList);
                    //send data within arrayList to server
                    outputStream.writeObject(arrayList);
                    //Use flush to ensure all data is written
                    outputStream.flush();
                    break;
                }
                //if not "!", add integer to arrayList
                number = Integer.parseInt(sentence);
                arrayList.add(number);

            }
            //read arrayList of prime numbers sent back from the server
            ArrayList<Integer> object = (ArrayList<Integer>) inputStream.readObject();
            System.out.println("Receive: " + object);
        }


        catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) {
                    socket.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
