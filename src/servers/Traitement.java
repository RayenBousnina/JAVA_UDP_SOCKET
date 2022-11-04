package servers;

import models.GroupeDisc;
import models.Message;
import models.Student;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.List;

public class Traitement {
    public static List<Student> studentList;
    public static List<Message> messageList;
    public static List<GroupeDisc> groupeDiscs;
    public static void main(String[] args) throws IOException {
        DatagramSocket sc = new DatagramSocket(3000);
        DatagramPacket packet = new DatagramPacket(new byte[1024],1024);
        sc.receive(packet);
        String command = new String(packet.getData());
        if (command.startsWith("##")){
            String pseudo = command.substring(2);
            int port = packet.getPort();
            InetAddress address = packet.getAddress();
            Student std = new Student();
            std.setLogin(pseudo);
            std.setPort(port);
            std.setAddress(address);
            std.setConnxState(true);
            //System.out.println(std);
            studentList.add(std);
        }else if (command.startsWith("@#")){
            String[] tabMsg = command.split("@#");
            String loginDest = tabMsg[1];
            String contenu = tabMsg[2];
            for (Student std : studentList){
                if (std.getLogin().equals(loginDest)){
                    DatagramPacket sendDgp = new DatagramPacket(contenu.getBytes(),contenu.length(), InetAddress.getLocalHost(),3000);
                    sc.send(sendDgp);
                }
            }
        }else if (command.equals("#LISTE_EDTS")){
            System.out.println("the conncted students are: ");
            for (Student std : studentList){
                if (std.isConnxState()){
                    System.out.println(std);
                    break;
                }
            }
        }else if (command.equals("GROUPS")){
            System.out.println("the private groups are: ");
            for (GroupeDisc grp : groupeDiscs){
                System.out.println(grp);
            }
        }else if (command.startsWith("#GROUP#")){
            String msgTab[] = command.split("#");
            String groupTitle = msgTab[2];
            GroupeDisc grp = new GroupeDisc(groupTitle);
            groupeDiscs.add(grp);
            System.out.println("private group "+grp.getTitle()+" is created");
        }else if (command.startsWith("#EDTS#")){
            String msgTab[] = command.split("#");
            String groupTitle = msgTab[2];
            for (GroupeDisc grp : groupeDiscs){
                if (grp.getTitle().equals(groupTitle)){
                    System.out.println("students in this group are: ");
                    for (Student std : grp.getStudentList()){
                        System.out.println(std);
                    }
                    break;
                }
            }
        }else if (command.startsWith("@>")){
            String msgTable[] = command.split("@>");
            String grpTitle = msgTable[1];
            String contenu = msgTable[2];
            for (GroupeDisc grp : groupeDiscs){
                if (grp.getTitle().equals(grpTitle)){
                    for (Student std : grp.getStudentList()){
                        DatagramPacket dgp = new DatagramPacket(contenu.getBytes(),contenu.length(),std.getAddress(),std.getPort());
                        sc.send(dgp);
                    }
                }
                break;
            }
        }else if (command.equals("#HISTO")){
            InetAddress currentAdress = InetAddress.getLocalHost();
            for (Student std : studentList){
                if (std.getAddress().equals(currentAdress)){
                    for (Message msg : messageList){
                        System.out.println("these are your historic messages");
                        if (msg.getSender().equals(std) || msg.getReceiver().equals(std)){
                            System.out.println(msg);
                        }
                    }
                    break;
                }

            }
        }else if (command.startsWith("#>")){
            String grpTitle = command.substring(2);
            //Student newStd = new Student();
            for (GroupeDisc grp : groupeDiscs){
                if (grp.getTitle().equals(grpTitle)){
                    for (Student std : studentList){
                        if (std.getAddress().equals(InetAddress.getLocalHost())){
                            List<Student> students = grp.getStudentList();
                            students.add(std);
                            grp.setStudentList(students);
                            break;
                        }
                    }
                    break;
                }
            }
        }
    }
}
