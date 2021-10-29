package com.mgt.kongclient.api.admin;

import com.mgt.kongclient.model.admin.plugin.Plugin;
import com.mgt.kongclient.model.admin.plugin.PluginList;

public interface ConsumerPluginService {

  Plugin addPlugin(String consumerId, Plugin request);

  Plugin getPlugin(String consumerId, String nameOrId);

  Plugin updatePlugin(String consumerId, String nameOrId, Plugin request);

  Plugin upsertPlugin(String consumerId, String nameOrId, Plugin request);

  Void deletePlugin(String consumerId, String nameOrId);

  PluginList listPlugins(String consumerId);
}
