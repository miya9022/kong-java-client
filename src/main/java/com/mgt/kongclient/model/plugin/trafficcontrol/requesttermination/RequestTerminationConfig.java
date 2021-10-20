package com.mgt.kongclient.model.plugin.trafficcontrol.requesttermination;

import com.squareup.moshi.Json;
import lombok.Data;

/**
 * Created by vaibhav on 18/06/17.
 */
@Data
public class RequestTerminationConfig {
  @Json(name = "status_code")
  Integer statusCode;

  @Json(name = "message")
  String message;

  @Json(name = "body")
  String body;

  @Json(name = "content_type")
  String contentType;
}
