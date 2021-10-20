package com.mgt.kongclient.api.admin;

import com.mgt.kongclient.model.admin.plugin.EnabledPlugins;

public interface PluginRepoService {

  EnabledPlugins retrieveEnabledPlugins();

  Object retrievePluginSchema(String pluginName);
}
