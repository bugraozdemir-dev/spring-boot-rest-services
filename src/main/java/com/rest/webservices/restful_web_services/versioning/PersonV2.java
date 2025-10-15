package com.rest.webservices.restful_web_services.versioning;


public class PersonV2 {
    private PersonDetail personDetail;

    public PersonV2(PersonDetail personDetail) {
        this.personDetail = personDetail;
    }

    public PersonDetail getPersonDetail() {
        return personDetail;
    }

    @Override
    public String toString() {
        return "PersonV2{" +
                "personDetail=" + personDetail +
                '}';
    }
}
