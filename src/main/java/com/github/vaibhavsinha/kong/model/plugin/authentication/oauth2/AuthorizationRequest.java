package com.github.vaibhavsinha.kong.model.plugin.authentication.oauth2;

import com.squareup.moshi.Json;
import lombok.Data;

/**
 * Created by vaibhav on 15/06/17.
 * <p>
 * Updated by fanhua on 2017-08-07.
 */
@Data
public class AuthorizationRequest {

  @Json(name = "id")
  private String id;

  @Json(name = "client_id")
  private String clientId;

  /**
   * The response type, "code" or "token".
   * "code" for Authorization Code process, "token" for implicit grant process.
   */
  @Json(name = "response_type")
  private String responseType;

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
}
