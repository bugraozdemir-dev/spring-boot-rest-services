package com.rest.webservices.restful_web_services.versioning;

public class PersonV1 {
    private String fullname;
    public PersonV1(String fullname) {
        this.fullname = fullname;
    }

    public String getFullname() {
        return fullname;
    }

    @Override
    public String toString() {
        return "PersonV1{" +
                "fullname='" + fullname + '\'' +
                '}';
    }
}
