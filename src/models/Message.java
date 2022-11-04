package models;

public class Message {
    private Student sender;
    private Student receiver;
    private String contenu;
    public Message(){}

    @Override
    public String toString() {
        return "Message{" +
                "sender=" + sender +
                ", receiver=" + receiver +
                ", contenu='" + contenu + '\'' +
                '}';
    }

    public Student getSender() {
        return sender;
    }

    public void setSender(Student sender) {
        this.sender = sender;
    }

    public Student getReceiver() {
        return receiver;
    }

    public void setReceiver(Student receiver) {
        this.receiver = receiver;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public Message(Student sender, Student receiver, String contenu) {
        this.sender = sender;
        this.receiver = receiver;
        this.contenu = contenu;
    }
}
