package com.github.vaibhavsinha.kong.model.plugin.authentication.oauth2;

import com.squareup.moshi.Json;
import lombok.Data;

/**
 * Created by vaibhav on 15/06/17.
 */
@Deprecated
@Data
public class RefreshRequest {

  @Json(name = "refresh_token")
  private String refreshToken;

  @Json(name = "client_id")
  private String clientId;

  @Json(name = "client_secret")
  private String clientSecret;

  @Json(name = "grant_type")
  private String grantType = "refresh_token";
}
