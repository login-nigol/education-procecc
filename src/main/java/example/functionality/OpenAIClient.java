package example.functionality;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OpenAIClient {

    private static final String API_URL = "https://api.openai.com/v1/completions";
    private static final String API_KEY = "sk-proj-uclgAEQzN8jvvDMKJIZoT3BlbkFJH1Pb5g4FNHl59eglUaru";

    public static String analyzeAnswer(String question, String answer) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(API_URL);

        httpPost.setHeader("Content-Type", "application/json");
        httpPost.setHeader("Authorization", "Bearer " + API_KEY);

        Map<String, Object> params = new HashMap<>();
        params.put("model", "text-davinci-003");
        params.put("prompt", "Question: " + question + "\nAnswer: " + answer + "\nIs the answer correct?");
        params.put("max_tokens", 50);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(params);

        StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);

        CloseableHttpResponse response = httpClient.execute(httpPost);
        String responseString = EntityUtils.toString(response.getEntity());

        response.close();
        httpClient.close();

        return responseString;
    }

    public static void main(String[] args) {
        try {
            String question = "What is the capital of France?";
            String answer = "Paris";
            String result = analyzeAnswer(question, answer);
            System.out.println("Response from OpenAI: " + result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
