package com.mgt.kongclient.model.plugin.authentication.oauth2;

import com.squareup.moshi.Json;
import lombok.Data;

/**
 * Created by vaibhav on 15/06/17.
 */
@Data
public class Token {

  @Json(name = "id")
  private String id;

  @Json(name = "credential_id")
  private String credentialId;

  @Json(name = "token_type")
  private String tokenType;

  @Json(name = "access_token")
  private String accessToken;

  @Json(name = "refresh_token")
  private String refreshToken;

  @Json(name = "created_at")
  private Long createdAt;

  @Json(name = "expires_in")
  private Long expiresIn;

  @Json(name = "scope")
  private String scope;

  @Json(name = "authenticated_userid")
  private String authenticatedUserid;
}
