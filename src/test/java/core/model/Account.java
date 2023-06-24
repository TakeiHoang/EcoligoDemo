package core.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Account {
    @JsonProperty("username")
    public String Username;
    @JsonProperty("password")
    public String Password;
    @JsonProperty("email")
    public String Email;
}
