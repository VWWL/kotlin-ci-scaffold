package com.example.scaffold.frameworks.test.web;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import javax.annotation.Resource;

import static com.example.scaffold.frameworks.test.web.ResponseBodyMatcher.*;
import static com.example.scaffold.frameworks.test.web.ResponseBodyMultiValuesMatcher.*;
import static com.example.scaffold.frameworks.test.web.ResponseMatcher.*;

@IntegrationTest
public class TestResponseTest {
    private @Resource TestRequestTemplate restTemplate;

    @Test
    void should_be_able_to_validate_ok_and_body_eq_when_giving_right_json_rest_api_request() {
        restTemplate.get("/test").is(ok())
                .is(body("$.list", size(3)))
                .is(body("$.list", contains("1", "2")))
                .is(body("$.list", containsExactly("1", "2", "3")))
                .is(body("$.id", isNotNull()))
                .is(body("$.id", eq("123")))
                .is(body("$.id", isNotEmpty()))
                .is(body("$.empty", isEmpty()))
                .is(body("$.id", hasSize(3)))
                .is(body("$.id", notEq("1234")))
                .is(textBody(eq("{\"null\":null,\"id\":\"123\",\"list\":[\"1\",\"2\",\"3\"],\"empty\":\"\"}")))
                .is(body("$.null", isNull()));
    }

    @Test
    void should_be_able_to_validate_bad_request_when_giving_bad_request() {
        restTemplate.get("/test/bad").is(bad())
                .is(statusCode(ResponseStatusMatcher.eq(HttpStatus.BAD_REQUEST)));
    }

    @Test
    void should_be_able_to_validate_bad_request_when_giving_error_request() {
        restTemplate.get("/test/error").is(error());
    }

    @Test
    void should_be_able_to_validate_bad_request_when_giving_created() {
        restTemplate.get("/test/created").is(created());
    }

    @Test
    void should_be_able_to_validate_not_found_request_when_giving_not_found_path() {
        restTemplate.get("/test/not-found-path").is(notFound());
    }

    @Test
    void should_be_able_to_validate_forbidden_request_when_giving_forbidden_path() {
        restTemplate.get("/test/forbidden").is(forbidden());
    }

    @Test
    void should_be_able_to_validate_unauthorized_request_when_giving_unauthorized_path() {
        restTemplate.get("/test/unauthorized").is(unauthorized());
    }
}
