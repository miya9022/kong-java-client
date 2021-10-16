package com.github.vaibhavsinha.kong.model.plugin.authentication.jwt;

import com.squareup.moshi.Json;
import lombok.Data;

import java.util.List;

/**
 * Created by vaibhav on 17/06/17.
 */
@Data
public class JwtConfig {

  @Json(name = "key_claim_name")
  String keyClaimName;

  @Json(name = "anonymous")
  String anonymous;

  @Json(name = "claims_to_verify")
  List<String> claimsToVerify;

  @Json(name = "uri_param_names")
  List<String> uriParamNames;

  @Json(name = "secret_is_base64")
  Boolean secretIsBase64;
}
