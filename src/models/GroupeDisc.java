package models;

import java.util.List;

public class GroupeDisc {
    private String title;
    private List<Student> studentList;
    private List<Message> messageList;
    public GroupeDisc(){}

    public GroupeDisc(String title, List<Student> studentList, List<Message> messageList) {
        this.title = title;
        this.studentList = studentList;
        this.messageList = messageList;
    }
    public GroupeDisc(String title){
        this.title=title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Message> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<Message> messageList) {
        this.messageList = messageList;
    }
}
