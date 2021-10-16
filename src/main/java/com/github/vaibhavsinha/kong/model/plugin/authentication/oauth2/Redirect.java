package com.github.vaibhavsinha.kong.model.plugin.authentication.oauth2;

import com.squareup.moshi.Json;
import lombok.Data;

/**
 * Created by vaibhav on 15/06/17.
 */
@Data
public class Redirect {
  @Json(name = "redirect_uri")
  String redirectUri;
}
