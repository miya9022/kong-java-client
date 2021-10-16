package com.github.vaibhavsinha.kong.model.admin.plugin;

import com.squareup.moshi.Json;
import lombok.Data;

import java.util.List;

/**
 * Created by fanhua on 2017-8-28
 */
@Data
public class OAuth2Config {

  @Json(name = "provision_key")
  private String provisionKey;

  @Json(name = "scopes")
  private List<String> scopes;

  @Json(name = "mandatory_scope")
  private boolean mandatoryScope;

  @Json(name = "token_expiration")
  private int tokenExpiration;

  @Json(name = "anonymous")
  private String anonymous;

  @Json(name = "accept_http_if_already_terminated")
  private boolean acceptHttpIfAlreadyTerminated;

  @Json(name = "enable_authorization_code")
  private boolean enableAuthorizationCode;

  @Json(name = "enable_implicit_grant")
  private boolean enableImplicitGrant;

  @Json(name = "enable_password_grant")
  private boolean enablePasswordGrant;

  @Json(name = "enable_client_credentials")
  private boolean enableClientCredentials;

  @Json(name = "global_credentials")
  private boolean globalCredentials;

  @Json(name = "hide_credentials")
  private boolean hideCredentials;

}
