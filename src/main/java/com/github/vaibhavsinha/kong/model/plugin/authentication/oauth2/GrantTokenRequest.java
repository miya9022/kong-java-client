package com.github.vaibhavsinha.kong.model.plugin.authentication.oauth2;


import com.squareup.moshi.Json;
import lombok.Data;

/**
 * Created by fanhua on 2017-08-07.
 */
@Data
public class GrantTokenRequest {

  @Json(name = "id")
  private String id;

  @Json(name = "client_id")
  private String clientId;

  @Json(name = "client_secret")
  private String clientSecret;

  /**
   * The grant type: "authorization_code", "password", "client_credentials", or "refresh_token".
   * "authorization_code" for Authorization Code process, the response will contain both access_token & refresh_token.
   * "password" for Password Credentials process, the response will contain both access_token & refresh_token.
   * "client_credentials" for Client Credentials process, the response will contain access_token only.
   * "refresh_token" for Refresh Token process, the response will contain both access_token & refresh_token.
   */
  @Json(name = "grant_type")
  private String grantType;

  @Json(name = "created_at")
  private Long createdAt;

  @Json(name = "provision_key")
  private String provisionKey;

  @Json(name = "scope")
  private String scope;

  @Json(name = "authenticated_userid")
  private String authenticatedUserid;

  @Json(name = "username")
  private String username;

  @Json(name = "password")
  private String password;

  /**
   * Only used in "Authorization Code" process
   */
  @Json(name = "code")
  private String code;

  /**
   * Only used in "Refresh Token" process
   */
  @Json(name = "refresh_token")
  private String refreshToken;

}
