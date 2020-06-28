package org.elsys.mbenov.imageclient;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ImageClient {
    private HttpClient httpClient;
    private URI apiUri;

    public ImageClient(String apiURI) {
        httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();
        apiUri = URI.create(apiURI);
    }

    public ImageData requestImage() throws IOException, InterruptedException, ParseException {
        HttpRequest req = HttpRequest.newBuilder()
                .uri(apiUri)
                .header("Content-Type", "application/json")
                .GET()
                .build();
        HttpResponse<String> response = httpClient.send(req, HttpResponse.BodyHandlers.ofString());
        return ImageData.fromJSONString(response.body());
    }

    public void sendImage(ImageData image) throws IOException, InterruptedException {
        HttpRequest req = HttpRequest.newBuilder()
                .uri(apiUri)
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(image.toJSONString()))
                .build();
        httpClient.send(req, HttpResponse.BodyHandlers.ofString());
    }
}
