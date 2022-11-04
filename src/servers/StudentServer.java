package servers;

import threads.ReceiveStudent;
import threads.SendStudent;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramSocket;
import java.net.SocketException;

public class StudentServer {
    public static void main(String[] args) throws SocketException {
        DatagramSocket sc = new DatagramSocket(3000);
        SendStudent sendStudent = new SendStudent(sc);
        ReceiveStudent receiveStudent = new ReceiveStudent(sc);
        sendStudent.start();
        receiveStudent.start();
    }
}
