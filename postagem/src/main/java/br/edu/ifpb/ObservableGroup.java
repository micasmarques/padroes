package br.edu.ifpb;

import java.util.ArrayList;
import java.util.List;

public class ObservableGroup {
    protected List<ObserverUser> users;

    ObservableGroup () {
        users = new ArrayList<>();
    }
    public void addUser (ObserverUser user) {
        ConcreteObserver concreteUser = (ConcreteObserver) user;
        if (!userExists(concreteUser.getEmail())) {
            users.add(user);
        }
        else System.out.println("add user fail, usuário " + concreteUser.getEmail() + " já está cadastrado no grupo");
    }
    public void delUser (String userEmail) {
        for (ObserverUser observerUser : users) {
            ConcreteObserver concreteUser = (ConcreteObserver) observerUser;
            if (userEmail.equals(concreteUser.getEmail())) {
                users.remove(observerUser);
                return;
            }
        }
        System.out.println("remove user fail, usuário " + userEmail + " não está cadastrado no grupo");
    }
    protected void notifyUsers () {
        for (ObserverUser observerUser : users) {
            observerUser.updateGroupData();
        }
    }
    protected boolean userExists (String email) {
        for (ObserverUser observerUser : users) {
            ConcreteObserver concreteUser = (ConcreteObserver) observerUser;
            if (email.equals(concreteUser.getEmail())) return true;
        }
        return false;
    }
}