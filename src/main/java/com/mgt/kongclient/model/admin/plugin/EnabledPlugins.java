package com.mgt.kongclient.model.admin.plugin;

import com.squareup.moshi.Json;
import lombok.Data;

import java.util.List;

/**
 * Created by vaibhav on 14/06/17.
 */
@Data
public class EnabledPlugins {

  @Json(name = "enabled_plugins")
  List<String> enabledPlugins;

}
