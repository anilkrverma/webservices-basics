package com.anil.rest.webservicesbasics.user;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@ApiModel(description = "User API details")
@JsonFilter("My Filter") //Useed for defining dynamic filtering
public class UserWithFiltering {

    private Integer id;

    @Size(min = 2, message = "Name must have at least 2 characters") //this message is triggered when validation fails.
    @ApiModelProperty(notes = "Name must have at least 2 characters ")
    private String name;

    @Past
    @ApiModelProperty(notes = "Date must be in the past")
    @JsonIgnore //To filter field from api response
    private Date creationDate;

    public UserWithFiltering(int id, String name, Date creationDate) {
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                '}';
    }
}
