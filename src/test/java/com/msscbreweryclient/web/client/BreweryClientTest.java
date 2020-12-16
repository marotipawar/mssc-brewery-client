package com.msscbreweryclient.web.client;

import com.msscbreweryclient.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BreweryClientTest {

    @Autowired
    private BreweryClient client;

    @Test
    public void getBeerId(){
        BeerDto dto = client.getBeerId(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    public void saveBeer(){
        BeerDto dto1=BeerDto.builder().id(UUID.randomUUID())
                .beerName("Tuburg 5000")
                .beerType("Super Strong")
                .build();
        URI uri =client.saveBeerObject(dto1);
        assertNotNull(uri);
        System.out.println(uri.toString());
    }

    @Test
    public void updateBeer(){
        BeerDto btd = BeerDto.builder()
                .id(UUID.randomUUID())
                .beerName("Maroti")
                .build();
        client.updateBeer(btd);
    }
    @Test
    public void deleteTest(){
        client.deleteBeer(UUID.randomUUID());
    }
}