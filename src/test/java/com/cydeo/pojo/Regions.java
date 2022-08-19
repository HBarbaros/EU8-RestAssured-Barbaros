package com.cydeo.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true) // this is from jackson
@Getter // from lombok dependency
@Setter // from lombok dependency
@ToString // from lombok dependency


public class Regions {

    private List<Region> items;
    private int count;

}
