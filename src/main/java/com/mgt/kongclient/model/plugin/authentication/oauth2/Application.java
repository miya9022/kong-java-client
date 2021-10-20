package com.mgt.kongclient.model.plugin.authentication.oauth2;

import com.squareup.moshi.Json;
import lombok.Data;

import java.util.List;

/**
 * Created by vaibhav on 15/06/17.
 */
@Data
public class Application {

  @Json(name = "id")
  private String id;

  @Json(name = "name")
  private String name;

  @Json(name = "client_secret")
  private String clientSecret;

  @Json(name = "client_id")
  private String clientId;

  @Json(name = "redirect_uri")
  private List<String> redirectUri;

  @Json(name = "created_at")
  private Long createdAt;

  public Application(String name, List<String> redirectUri, String clientId, String clientSecret) {
    this.name = name;
    this.redirectUri = redirectUri;
    this.clientId = clientId;
    this.clientSecret = clientSecret;
  }

  public Application(String name, List<String> redirectUri) {
    this(name, redirectUri, null, null);
  }
}
