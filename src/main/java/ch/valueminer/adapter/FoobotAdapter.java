package ch.valueminer.adapter;

import ch.valueminer.model.FoobotData;
import ch.valueminer.model.valueminer.ValueMinerInputFactory;
import ch.valueminer.service.DataPublisherService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by thomas on 20.01.18.
 */
@Component
public class FoobotAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(FoobotAdapter.class);

    @Value("${foobot.api.url}")
    private String url;

    @Value("${foobot.api.key}")
    private String apiKey;

    @Value("${foobot.api.secret}")
    private String apiSecret;

    @Autowired
    private RestTemplate rest;

    @Autowired
    private DataPublisherService dataPublisherService;

    @Scheduled(initialDelay = 10_000, fixedDelay = 600_000)
    public void getDataFromFoobotApi() throws URISyntaxException {
        LOG.info("Scheduled: getting data from Foobot API");

        ResponseEntity<String> response = callFoobotApi();
        FoobotData foobotData = extractFoobotData(response.getBody());
        dataPublisherService.publish(ValueMinerInputFactory.from(foobotData));
    }

    private ResponseEntity<String> callFoobotApi() throws URISyntaxException {
        RequestEntity<Void> request = RequestEntity
                .get(new URI(url))
                .accept(MediaType.APPLICATION_JSON)
                .header("X-API-KEY-TOKEN", apiSecret)
                .build();
        return rest.exchange(request, String.class);
    }

    private static FoobotData extractFoobotData(String json) {

        try {
            JsonNode rootNode = new ObjectMapper().readTree(json);
            long timestamp = rootNode.get("start").asLong() * 1_000;
            String deviceId = rootNode.get("uuid").asText();
            return new FoobotData(deviceId, timestamp, json);

        } catch (IOException e) {
            LOG.error("Error parsing Foobot Response: " + json, e);
            return null;
        }

    }

}
