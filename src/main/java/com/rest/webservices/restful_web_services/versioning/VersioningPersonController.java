package com.rest.webservices.restful_web_services.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson() {
        return new PersonV1("Buğra Özdemir");
    }
    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson() {
        PersonDetail personDetail = new PersonDetail("Buğra", "Özdemir");
        return new PersonV2(personDetail);
    }

    @GetMapping(path = "/person", params = "version=1")
    public PersonV1 getFirstVersionOfPersonRequestParameter() {
        return new PersonV1("Buğra Özdemir");
    }

    @GetMapping(path = "/person", params = "version=2")
    public PersonV2 getSecondVersionOfPersonRequestParameter() {
        PersonDetail personDetail = new PersonDetail("Buğra", "Özdemir");
        return new PersonV2(personDetail);
    }

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionOfPersonHeaders() {
        return new PersonV1("Buğra Özdemir");
    }

    @GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionOfPersonHeaders() {
        PersonDetail personDetail = new PersonDetail("Buğra", "Özdemir");
        return new PersonV2(personDetail);
    }
}
