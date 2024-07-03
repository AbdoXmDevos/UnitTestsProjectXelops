package com.abdoxm.xelops;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final String URL = "https://api.awanllm.com/v1/chat/completions";
    private static final String MODEL_NAME = "Awanllm-Llama-3-8B-Dolfin";
    private static final String AWANLLM_API_KEY = "c9317adf-5b1a-498f-ba8d-e0be5cfc35ed\t";
    public static void main(String[] args) {
        try {
            JSONObject payload = new JSONObject();
            payload.put("model", MODEL_NAME);
            payload.put("prompt","hello there !");
            payload.put("repetition_penalty", 1.1);
            payload.put("temperature", 0.7);
            payload.put("top_p", 0.9);
            payload.put("top_k", 40);
            payload.put("messages", new JSONObject[]{
                    new JSONObject().put("role", "system").put("content", "You are a java developer, and AbdoXm is the creator of this app !"),
                    new JSONObject().put("role","user").put("content","create me a java method to calculate the depth of a cube and write the unit tests of it")
            });
            payload.put("max_tokens", 500);
            payload.put("stream", false);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL))
                    .header("Content-Type", "application/json")
                    .header("Authorization", "Bearer " + AWANLLM_API_KEY)
                    .POST(HttpRequest.BodyPublishers.ofString(payload.toString(), StandardCharsets.UTF_8))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            JSONObject json = new JSONObject(response.body());

            // Extract the "content" field from the choices array
            String content = json.getJSONArray("choices").getJSONObject(0)
                    .getJSONObject("message").getString("content");

            // Print the extracted content
            System.out.println(content);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
