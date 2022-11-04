package models;

import java.net.InetAddress;

public class Student {
    private String nom;
    private String login;
    private int level;
    private boolean connxState;
    private InetAddress address;
    private int port;
    public Student(){}

    @Override
    public String toString() {
        return "Student{" +
                "nom='" + nom + '\'' +
                ", login='" + login + '\'' +
                ", level=" + level +
                ", connxState=" + connxState +
                ", address=" + address +
                ", port=" + port +
                '}';
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public boolean isConnxState() {
        return connxState;
    }

    public void setConnxState(boolean connxState) {
        this.connxState = connxState;
    }

    public InetAddress getAddress() {
        return address;
    }

    public void setAddress(InetAddress address) {
        this.address = address;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public Student(String nom, String login, int level, boolean connxState, InetAddress address, int port) {
        this.nom = nom;
        this.login = login;
        this.level = level;
        this.connxState = connxState;
        this.address = address;
        this.port = port;
    }
}
