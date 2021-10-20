package com.mgt.kongclient.model.plugin.authentication.key;

import com.squareup.moshi.Json;
import lombok.Data;

import java.util.List;

/**
 * Created by vaibhav on 17/06/17.
 */
@Data
public class KeyAuthConfig {

  @Json(name = "hide_credentials")
  Boolean hideCredentials;

  @Json(name = "anonymous")
  String anonymous;

  @Json(name = "key_names")
  List<String> keyNames;

  @Json(name = "key_in_body")
  Boolean keyInBody;
}
