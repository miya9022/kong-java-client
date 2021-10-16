package com.github.vaibhavsinha.kong.model.plugin.authentication.basic;

import com.squareup.moshi.Json;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by vaibhav on 15/06/17.
 */
@Data
@NoArgsConstructor
public class BasicAuthCredential {

  @Json(name = "id")
  private String id;

  @Json(name = "username")
  private String username;

  @Json(name = "password")
  private String password;

  @Json(name = "consumer_id")
  private String consumerId;

  @Json(name = "created_at")
  private Long createdAt;

  public BasicAuthCredential(String username, String password) {
    this.username = username;
    this.password = password;
  }
}
