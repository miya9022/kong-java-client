package com.mgt.kongclient.model.admin.plugin;

import com.squareup.moshi.Json;
import lombok.Data;

import java.util.List;

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
public record Plugin(
  String id,
  String name,
  String service,
  String consumer,
  Boolean enabled,
  Object config,
  @Json(name = "created_at") Long createdAt,
  List<String> tags,
  @Json(name = "enabled_plugins") List<String> enabledPlugins,
  String [] protocols,
  Object route
) {

  public Plugin(String name) {
    this(null, name, null, null, null, null, null, null, null, new String[0], null);
  }

  public Plugin(String id, String name) {
    this(id, name, null, null, null, null, null, null, null, new String[0], null);
  }

  public Plugin(String id, String name, Long createdAt) {
    this(id, name, null, null, null, null, createdAt, null, null, new String[0], null);
  }

  public Plugin(String id, String name, Object config) {
    this(id, name, null, null, null, config, null, null, null, new String[0], null);
  }
}
