package org.example;

import org.json.simple.JSONObject;

public class Main {
    public static void main(String[] args) {
        JokeRESTClient jokeClient = new JokeRESTClient();

        String jokeString = jokeClient.getRandomJokeString();
        JSONObject jokeJSON = jokeClient.getRandomJokeJSON();
        Joke joke = jokeClient.getRandomJoke();

        System.out.println(jokeString);
        System.out.println(jokeJSON);
        System.out.println(joke);
    }
}