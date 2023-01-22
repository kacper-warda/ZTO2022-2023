package org.example;

//to mogę przechowywać w bazie
public class Joke {
    public Long id;
    public String setup;
    public String punchline;
    public String type;
    public Person person;

    public String toString() {
        return this.setup + " " + this.punchline;
    }
}
