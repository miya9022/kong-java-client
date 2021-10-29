package com.mgt.kongclient.api.admin;

import com.mgt.kongclient.model.admin.plugin.Plugin;
import com.mgt.kongclient.model.admin.plugin.PluginList;

public interface RoutePluginService {

  Plugin addPlugin(String routeId, Plugin request);

  Plugin getPlugin(String routeId, String nameOrId);

  Plugin updatePlugin(String routeId, String nameOrId, Plugin request);

  Plugin upsertPlugin(String routeId, String nameOrId, Plugin request);

  Void deletePlugin(String routeId, String nameOrId);

  PluginList listPlugins(String routeId);
}
