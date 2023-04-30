package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Utils {
    public static String getHttpResponse(String requestUrl, String requestData) throws IOException {
        URL url = new URL(requestUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.setDoOutput(true);

        try (OutputStream outputStream = connection.getOutputStream()) {
            outputStream.write(("data=" + requestData).getBytes(StandardCharsets.UTF_8));
        }

        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            StringBuilder response = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            return response.toString();
        }
    }

    public static int randomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static <T> List<T> sampleNodes(Set<T> nodes, int count) {
        List<T> nodeList = new ArrayList<>(nodes);
        Collections.shuffle(nodeList);
        return nodeList.subList(0, Math.min(count, nodeList.size()));
    }
}

