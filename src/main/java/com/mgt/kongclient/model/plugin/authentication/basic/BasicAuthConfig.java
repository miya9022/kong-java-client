package com.mgt.kongclient.model.plugin.authentication.basic;

import com.squareup.moshi.Json;
import lombok.Data;

/**
 * Created by vaibhav on 17/06/17.
 */
@Data
public class BasicAuthConfig {

  @Json(name = "hide_credentials")
  Boolean hideCredentials;

  @Json(name = "anonymous")
  String anonymous;
}
