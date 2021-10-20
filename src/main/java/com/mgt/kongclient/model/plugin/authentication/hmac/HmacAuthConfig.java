package com.mgt.kongclient.model.plugin.authentication.hmac;

import com.squareup.moshi.Json;
import lombok.Data;

/**
 * Created by vaibhav on 17/06/17.
 */
@Data
public class HmacAuthConfig {

  @Json(name = "hide_credentials")
  Boolean hideCredentials;

  @Json(name = "anonymous")
  String anonymous;

  @Json(name = "clock_skew")
  Integer clockSkew;
}
