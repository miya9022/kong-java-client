package com.mgt.kongclient.api.admin;

import com.mgt.kongclient.model.admin.plugin.Plugin;
import com.mgt.kongclient.model.admin.plugin.PluginList;
import com.mgt.kongclient.model.admin.route.Route;
import com.mgt.kongclient.model.admin.route.RouteList;

public interface RouteService {

  Route createRoute(Route route);

  RouteList getRoutes();

  Route getRoute(String routeNameOrId);

  Route updateRoute(String routeNameOrId, Route route);

  Route upsertRoute(String routeNameOrId, Route route);

  Void deleteRoute(String routeNameOrId);

  PluginList getPluginsByRoute(String routeNameOrId);

  Plugin getPluginByRoute(String routeNameOrId, String pluginNameOrId);
}
