package org.example;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class JokeRESTClient {
    public final static String API_ADDRESS = "https://official-joke-api.appspot.com/random_joke";
    CloseableHttpClient client;

    public JokeRESTClient() {
        client = HttpClients.createDefault();
    }

    public String getRandomJokeString() {
        HttpGet request = new HttpGet(API_ADDRESS);
        CloseableHttpResponse response;
        String jokeString = null;

        try {
            response = client.execute(request);
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            jokeString = rd.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jokeString;
    }

    public JSONObject getRandomJokeJSON() {
        String joke = getRandomJokeString();
        JSONParser parser = new JSONParser();
        JSONObject jsonJoke = null;

        try {
            jsonJoke = (JSONObject) parser.parse(joke);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return jsonJoke;
    }

    public Joke getRandomJoke() {
        JSONObject jokeJSON = getRandomJokeJSON();

        Joke joke = new Joke();
        joke.id = (Long) jokeJSON.get("id");
        joke.type = (String) jokeJSON.get("type");
        joke.setup = (String) jokeJSON.get("setup");
        joke.punchline = (String) jokeJSON.get("punchline");

        return joke;
    }
}
