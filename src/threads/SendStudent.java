package threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.Buffer;

public class SendStudent extends Thread{
    DatagramSocket sc;
    public SendStudent(DatagramSocket sc){
        this.sc = sc;
    }
    public void run(){
        System.out.println("enter command here: ");
        BufferedReader inC = new BufferedReader(new InputStreamReader(System.in));
        try {
            String msg = inC.readLine();
            DatagramPacket packet = new DatagramPacket(msg.getBytes(),msg.length(), InetAddress.getLocalHost(),3000);
            sc.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
