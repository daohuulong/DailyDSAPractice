package main.java.Util.Network;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public class HttpClientExample {



    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException, ExecutionException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .uri(new URI("https://www.google.com"))
                .build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenAccept(response -> {
                    System.out.println(response.body());
                });

        System.out.println("END OF FUNCTION!!!!");

        Thread.sleep(1000);



    }
}
