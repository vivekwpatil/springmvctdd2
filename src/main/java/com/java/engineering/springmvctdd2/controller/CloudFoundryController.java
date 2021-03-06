package com.java.engineering.springmvctdd2.controller;

import com.java.engineering.springmvctdd2.model.CfInfo;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class CloudFoundryController {

    private RestTemplate restTemplate;

    private final String pivotalUrl = "http://api.run.pivotal.io/v2/info";

    private final String blueMixUrl = "http://api.ng.bluemix.net/v2/info";

    CloudFoundryController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @GetMapping(value = "/cf", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getProvider() {

        ResponseEntity<CfInfo> pivotalResponse = restTemplate.exchange(pivotalUrl, HttpMethod.GET, null, CfInfo.class);
        ResponseEntity<CfInfo> blueMixResponse = restTemplate.exchange(blueMixUrl, HttpMethod.GET, null, CfInfo.class);

        List<CfInfo> CfInfos = Arrays.asList(pivotalResponse.getBody(), blueMixResponse.getBody());
        return ResponseEntity.ok(CfInfos);

    }

    @GetMapping(value = "/cf/{provider}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getProviderByID(@PathVariable String provider) {

        ResponseEntity<CfInfo> response;
        switch (provider) {
            case "PWC":
                response = restTemplate
                    .exchange(pivotalUrl, HttpMethod.GET, null, CfInfo.class);
                break;
            case "BLU":
                response = restTemplate
                    .exchange(blueMixUrl, HttpMethod.GET, null, CfInfo.class);
                break;
            default:
                response = ResponseEntity.badRequest().build();
        }
        return response;
    }

}
