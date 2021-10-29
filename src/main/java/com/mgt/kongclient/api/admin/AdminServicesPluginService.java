package com.mgt.kongclient.api.admin;

import com.mgt.kongclient.model.admin.plugin.Plugin;
import com.mgt.kongclient.model.admin.plugin.PluginList;

public interface AdminServicesPluginService {

  Plugin addPlugin(String serviceNameOrId, Plugin request);

  Plugin getPlugin(String serviceNameOrId, String nameOrId);

  Plugin updatePlugin(String serviceNameOrId, String nameOrId, Plugin request);

  Plugin upsertPlugin(String serviceNameOrId, String nameOrId, Plugin request);

  Void deletePlugin(String serviceNameOrId, String nameOrId);

  PluginList listPlugins(String serviceNameOrId);
}
