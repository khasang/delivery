package io.delivery.office;

import io.delivery.entity.Office;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * Created by NortT on 19.04.2017.
 */
public class OfficeIntegrationTest {
    private final String ROOT = "http://localhost:8080/office";
    private final String ADD = "/add";
    private final String DELETE = "/delete/{id}";
    private final String GET_ALL = "/all";

    @Test
    public void addOffice(){
        createOffice();
    }

    private Office createOffice() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Office office = prefillOffice();
        HttpEntity<Office> httpEntity = new HttpEntity<>(office, headers);

        RestTemplate restTemplate = new RestTemplate();
        Office createdOffice = restTemplate.exchange(
                ROOT+ADD,
                HttpMethod.POST,
                httpEntity,
                Office.class
        ).getBody();
        assertNotNull(createdOffice);
        assertEquals(office.getCoords(), createdOffice.getCoords());
        return office;
    }

    private Office prefillOffice() {
        Office office = new Office();
        office.setAddress("test");
        office.setCoords("1.0,1.0");
        office.setDescription("test description");
        return office;
    }

    @Test
    public void getAllOffices(){
        RestTemplate restTemplate = new RestTemplate();
        createOffice();
        createOffice();
        ResponseEntity<List<Office>> result = restTemplate.exchange(
                ROOT+GET_ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Office>>(){
                }
        );
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
    }

    @Test
    public void deleteOffice(){
        Office office = createOffice();
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Office> deleteDocument = restTemplate.exchange(
                ROOT + DELETE,
                HttpMethod.DELETE,
                null,
                Office.class,
                office.getId()
        );

        assertNotNull(deleteDocument.getBody());
        assertEquals(office.getId(), deleteDocument.getBody().getId());
    }
}
