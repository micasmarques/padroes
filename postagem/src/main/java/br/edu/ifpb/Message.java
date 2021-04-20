package br.edu.ifpb;

public class Message {
    private final String author;
    private final String textContent;

    Message (String author, String textContent) {
        this.author = author;
        this.textContent = textContent;
    }
    public String getTextContent() {
        return textContent;
    }
    public String getAuthor() {
        return author;
    }
    public void print () {
        System.out.println(author);
        System.out.println(textContent);
    }
}