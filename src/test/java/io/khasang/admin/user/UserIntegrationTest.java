package io.khasang.admin.user;

import io.delivery.entity.User;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class UserIntegrationTest {
    private final String ROOT = "http://localhost:8080/admin/users";
    private final String GET_ID = "/get/id/";
    private final String ADD = "/add";
    private final String UPDATE = "/update";
    private final String DELETE = "/delete/";
    private final String ALL = "/get/all";
    private final String GET_LOGIN = "/get/login/";

    @Test
    public void getUserById() {
        addUserAndGet();
    }

    @Test
    public void getUserByLogin() {
        User user = createUser();

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<User>> result = restTemplate.exchange(
                ROOT + GET_LOGIN + "{login}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<User>>() {
                },
                user.getLogin()
        );

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
        List<User> list = result.getBody();
        assertNotNull(list.get(0));
    }

    @Test
    public void addUserAndGet() {
        User user = createUser();

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<User> responseEntity = restTemplate.exchange(
                ROOT + GET_ID + "{id}",
                HttpMethod.GET,
                null,
                User.class,
                user.getId()
        );

        User resultUser = responseEntity.getBody();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertNotNull(resultUser);
    }

    private User createUser() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        User user = prefillUser();
        HttpEntity<User> httpEntity = new HttpEntity<>(user, headers);
        RestTemplate restTemplate = new RestTemplate();
        User createdUser = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.POST,
                httpEntity,
                User.class
        ).getBody();
        assertNotNull(createdUser);
        assertEquals(user.getLogin(), createdUser.getLogin());
        assertEquals(user.getPassword(), createdUser.getPassword());
        assertEquals(user.getRole(), createdUser.getRole());
        assertEquals(user.getActive(), createdUser.getActive());
        return createdUser;
    }

    private User prefillUser() {
        User user = new User();
        user.setLogin("Вася");
        user.setPassword("$2a$10$iWZqh3OUvPVNPRNkboVdSuAF6dN0BrAZcIcPUycLURHfy871EntQm");
        user.setRole("ROLE_ADMIN");
        user.setActive(true);
        return user;
    }

    @Test
    public void getAllUsers(){
        RestTemplate restTemplate = new RestTemplate();
        createUser();
        createUser();

        ResponseEntity<List<User>> result = restTemplate.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<User>>() {
                }
        );
        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertNotNull(result.getBody());
        List<User> list = result.getBody();
        assertNotNull(list.get(0));
    }

    @Test
    public void deleteUser(){
        User user = createUser();
        assertNotNull(user);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                ROOT + DELETE + "{id}",
                HttpMethod.DELETE,
                null,
                String.class,
                user.getId()
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

        ResponseEntity<User> checkDocumentById = restTemplate.exchange(
                ROOT + GET_ID + "{id}",
                HttpMethod.GET,
                null,
                User.class,
                user.getId()
        );

        assertEquals(HttpStatus.OK, checkDocumentById.getStatusCode());
        assertNull(checkDocumentById.getBody());
    }

    @Test
    public void updateUser(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        RestTemplate restTemplate = new RestTemplate();
        User user = createUser();
        assertNotNull(user);

        user.setLogin("Петя");
        user.setActive(false);

        HttpEntity<User> httpEntity = new HttpEntity<>(user, headers);
        User resultUpdate = restTemplate.exchange(
                ROOT + UPDATE,
                HttpMethod.PUT,
                httpEntity,
                User.class
        ).getBody();

        assertNotNull(resultUpdate);
        assertNotNull(resultUpdate.getId());
        assertEquals(user.getLogin(), resultUpdate.getLogin());
        assertEquals(user.getActive(), resultUpdate.getActive());
    }

}
