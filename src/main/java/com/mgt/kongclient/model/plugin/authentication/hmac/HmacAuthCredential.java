package com.mgt.kongclient.model.plugin.authentication.hmac;

import com.squareup.moshi.Json;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by vaibhav on 15/06/17.
 */
@Data
@NoArgsConstructor
public class HmacAuthCredential {

  @Json(name = "id")
  private String id;

  @Json(name = "username")
  private String username;

  @Json(name = "secret")
  private String secret;

  @Json(name = "consumer_id")
  private String consumerId;

  @Json(name = "created_at")
  private Long createdAt;

  public HmacAuthCredential(String username, String secret) {
    this.username = username;
    this.secret = secret;
  }
}
