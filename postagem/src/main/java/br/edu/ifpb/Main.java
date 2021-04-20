package br.edu.ifpb;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String input;
        String email;
        String messageTextContent;
        Pattern pattern;
        Matcher matcher;

        ConcreteGroup group = new ConcreteGroup();

        while (true) {
            input = read.nextLine();
            if (input.contains("exit")) break;
            pattern = Pattern.compile("\\s*\\S+@\\S+\\s*");
            matcher = pattern.matcher(input);
            if (matcher.find()) {
                email = matcher.group(0);
                email = email.strip();
            }
            else {
                System.out.println("missing email, try again");
                continue;
            }

            if (input.contains("add")) {
                group.addUser(new ConcreteObserver(email, group));
                group.listUsers();
            }
            else if (input.contains("del")) {
                group.delUser(email);
                group.listUsers();
            }
            else {
                pattern = Pattern.compile("\".*\"");
                matcher = pattern.matcher(input);
                if (matcher.find()) {
                    messageTextContent = matcher.group(0);
                    messageTextContent = messageTextContent.strip();
                    StringBuilder stringBuilder = new StringBuilder(messageTextContent);
                    stringBuilder.deleteCharAt(messageTextContent.length() - 1);
                    stringBuilder.deleteCharAt(0);
                    messageTextContent = stringBuilder.toString();
                    group.addMessage(new Message(email, messageTextContent));
                }
                else {
                    System.out.println("missing messageTextContent, try again");
                }
            }
        }
    }
}