package br.edu.ifpb;

import java.util.ArrayList;

public class ConcreteObserver implements ObserverUser {
    private final String email;
    private final ConcreteGroup concreteGroup;
    private ArrayList<Message> groupMessages;

    ConcreteObserver(String email, ConcreteGroup concreteGroup) {
        this.email = email;
        this.concreteGroup = concreteGroup;
    }
    @Override
    public void updateGroupData() {
        this.groupMessages = this.concreteGroup.getMessages();
        showNewMessageReceived();
    }
    public String getEmail() {
        return email;
    }
    private void showNewMessageReceived () {
        Message message = groupMessages.get(groupMessages.size() - 1);
        if (message.getAuthor().equals(email)) System.out.println(email + " enviou a mensagem para o grupo");
        else System.out.println(email + ", recebeu uma menssagem pelo grupo");
        message.print();
    }
}
