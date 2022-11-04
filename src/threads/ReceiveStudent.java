package threads;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class ReceiveStudent extends Thread{
    DatagramSocket sc;
    public ReceiveStudent(DatagramSocket sc){
        this.sc=sc;
    }
    public void run(){
        while (true){
            DatagramPacket packet = new DatagramPacket(new byte[1024],1024);
            try {
                sc.receive(packet);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
