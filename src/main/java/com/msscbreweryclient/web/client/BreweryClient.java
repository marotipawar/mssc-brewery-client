package com.msscbreweryclient.web.client;

import com.msscbreweryclient.web.model.BeerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "com.brewery", ignoreUnknownFields = false)
public class BreweryClient {

    public static final String BEER_PATH_V1="/api/v1/beer/";
    private String apihost;
    private RestTemplate restTemplate;

    public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public void setApihost(String apihost) {
        this.apihost = apihost;
    }

    public BeerDto getBeerId(UUID id){
        return restTemplate.getForObject(apihost+BEER_PATH_V1+id.toString(), BeerDto.class);
    }

    public URI saveBeerObject(BeerDto beerDto){
        return restTemplate.postForLocation(apihost+BEER_PATH_V1,beerDto);
    }

    public void updateBeer(BeerDto beerDto){
        restTemplate.put(apihost+BEER_PATH_V1+beerDto.getId(), beerDto);
    }
    public void deleteBeer(UUID uuid){
        restTemplate.delete(apihost+BEER_PATH_V1+uuid);
    }
}
