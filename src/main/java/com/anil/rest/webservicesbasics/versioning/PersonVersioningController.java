package com.anil.rest.webservicesbasics.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

    @GetMapping("/v1/person") //handle versioning using URI path
    public PersonV1 getPerson1(){
        return new PersonV1("Anil Verma");
    }

    @GetMapping("/v2/person")
    public PersonV2 getPerson2(){
        return new PersonV2(new Name("Anil", "Verma"));
    }

    @GetMapping(value = "/person", params = "version=1") //handle versioning using request params
    public PersonV1 getPersonParam1(){
        return new PersonV1("Anil Verma");
    }

    @GetMapping(value = "/person", params = "version=2")
    public PersonV2 getPersonParam2(){
        return new PersonV2(new Name("Anil", "Verma"));
    }

    @GetMapping(value = "/person", headers = "version=1") //handle versioning using header params
    //@GetMapping(value = "/person", headers = "X_API-VERSION=1")
    public PersonV1 getPersonByHeader1(){
        return new PersonV1("Anil Verma");
    }

    @GetMapping(value = "/person", headers = "version=2")
    public PersonV2 getPersonByHeader2(){
        return new PersonV2(new Name("Anil", "Verma"));
    }


    @GetMapping(value = "/person", produces = "application/vnd.api-v1+json") //handle versioning using produces header params i.e. response json format
    public PersonV1 getPersonByResponseFormat1(){
        return new PersonV1("Anil Verma");
    }

    @GetMapping(value = "/person", produces = "application/vnd.api-v2+json")
    public PersonV2 getPersonByResponseFormat2(){
        return new PersonV2(new Name("Anil", "Verma"));
    }

}
