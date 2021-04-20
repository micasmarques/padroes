package br.edu.ifpb;

import java.util.ArrayList;

public class ConcreteGroup extends ObservableGroup {
    private final ArrayList<Message> messages;

    ConcreteGroup () {
        messages = new ArrayList<>();
    }
    public ArrayList<Message> getMessages() {
        return this.messages;
    }
    public void addMessage (Message message) {
        if (userExists(message.getAuthor())) {
            messages.add(message);
            notifyUsers();
        }
        else System.out.println("message post fail, usuário " + message.getAuthor() + " não está cadastrado no grupo");
    }
    public void listUsers () {
        System.out.println("Usuários cadastrados no grupo");
        for (ObserverUser observerUser : this.users) {
            ConcreteObserver concreteUser = (ConcreteObserver) observerUser;
            System.out.println(concreteUser.getEmail());
        }
    }
}
