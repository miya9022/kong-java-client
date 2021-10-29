package com.mgt.kongclient.api.admin;

import com.mgt.kongclient.model.admin.route.Route;
import com.mgt.kongclient.model.admin.route.RouteList;

public interface AdminServicesRouteService {

  Route createRoute(String nameOrId, Route route);

  RouteList getRoutes(String nameOrId);

  Route getRoute(String nameOrId, String routeNameOrId);

  Route upsertRoute(String nameOrId, String routeNameOrId, Route route);

  Void deleteRoute(String nameOrId, String routeNameOrId);
}
