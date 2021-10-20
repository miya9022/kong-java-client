package com.mgt.kongclient.model.plugin.authentication.oauth2;

import com.squareup.moshi.Json;
import lombok.Data;

import java.util.List;

/**
 * Created by vaibhav on 17/06/17.
 * <p>
 * Updated by fanhua on 2017-08-04.
 */
@Deprecated
@Data
public class OAuth2Config {

  @Json(name = "provision_key")
  private String provisionKey;

  @Json(name = "scopes")
  List<String> scopes;

  @Json(name = "mandatory_scope")
  Boolean mandatoryScope;

  @Json(name = "token_expiration")
  Integer tokenExpiration;

  @Json(name = "enable_authorization_code")
  Boolean enableAuthorizationCode;

  @Json(name = "enable_client_credentials")
  Boolean enableClientCredentials;

  @Json(name = "enable_implicit_grant")
  Boolean enableImplicitGrant;

  @Json(name = "enable_password_grant")
  Boolean enablePasswordGrant;

  @Json(name = "hide_credentials")
  Boolean hideCredentials;

  @Json(name = "global_credentials")
  Boolean globalCredentials;

  @Json(name = "accept_http_if_already_terminated")
  Boolean acceptHttpIfAlreadyTerminated;

  @Json(name = "anonymous")
  String anonymous;

}
