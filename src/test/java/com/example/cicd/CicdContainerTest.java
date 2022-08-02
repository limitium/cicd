package com.example.cicd;

import org.junit.jupiter.api.Test;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.wait.strategy.Wait;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CicdContainerTest {
    @Container
    public GenericContainer httpServer = new GenericContainer(DockerImageName.parse("limitium/cicd-demo"))
            .withExposedPorts(8080);

    @Test
    public void testHttp() throws IOException, InterruptedException {
        httpServer.start();
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(
                        URI.create("http://" + httpServer.getHost() + ":" + httpServer.getFirstMappedPort()))
                .build();
        var response     = client.send(request, HttpResponse.BodyHandlers.ofString());

        assertEquals("hey!", response.body());
    }
}
