package com.github.vaibhavsinha.kong.model.admin.plugin;

import com.squareup.moshi.Json;
import lombok.Data;

/**
 * Created by vaibhav on 13/06/17.
 * <p>
 * You can add a plugin in four different ways:
 * For every API and Consumer. Don't set api_id and consumer_id.
 * For every API and a specific Consumer. Only set consumer_id.
 * For every Consumer and a specific API. Only set api_id.
 * For a specific Consumer and API. Set both api_id and consumer_id.
 * Note that not all plugins allow to specify consumer_id. Check the plugin documentation.
 */
@Data
public class Plugin {

  @Json(name = "id")
  private String id;

  @Json(name = "api_id")
  private String apiId;

  @Json(name = "consumer_id")
  private String consumerId;

  @Json(name = "name")
  private String name;    //must

  @Json(name = "config")
  private Object config;  //must

  @Json(name = "enabled")
  private Boolean enabled;

  @Json(name = "created_at")
  private Long createdAt;
}
