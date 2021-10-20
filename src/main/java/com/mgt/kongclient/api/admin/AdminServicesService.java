package com.mgt.kongclient.api.admin;

import com.mgt.kongclient.model.admin.plugin.PluginList;
import com.mgt.kongclient.model.admin.services.Service;
import com.mgt.kongclient.model.admin.services.ServiceList;

public interface AdminServicesService {

  Service createService(Service request);

  Service getService(String nameOrId);

  Service updateService(String nameOrId, Service request);

  Service upsertService(String nameOrId, Service request);

  Void deleteService(String nameOrId);

  ServiceList listServices(String tags);

  PluginList listServicePlugins(String nameOrId);
}
