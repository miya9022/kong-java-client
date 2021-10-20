package com.mgt.kongclient.internal.admin;

import com.mgt.kongclient.model.admin.plugin.Plugin;
import com.mgt.kongclient.model.admin.plugin.PluginList;
import com.mgt.kongclient.model.admin.route.Route;
import com.mgt.kongclient.model.admin.route.RouteList;
import retrofit2.Call;
import retrofit2.http.*;

public interface RetrofitRouteService {

  @POST("routes/")
  Call<Route> createRoute(@Body Route route);

  @GET("routes/")
  Call<RouteList> getRoutes();

  @GET("routes/{id}")
  Call<Route> getRoute(@Path("id") String routeNameOrId);

  @PATCH("routes/{id}")
  Call<Route> updateRoute(@Path("id") String routeNameOrId, @Body Route route);

  @PUT("routes/{id}")
  Call<Route> upsertRoute(@Path("id") String routeNameOrId, @Body Route route);

  @DELETE("routes/{id}")
  Call<Void> deleteRoute(@Path("id") String routeNameOrId);

  @GET("routes/{id}/plugins")
  Call<PluginList> getPluginsByRoute(@Path("id") String routeNameOrId);

  @GET("routes/{id}/plugins/{pluginId}")
  Call<Plugin> getPluginByRoute(@Path("id") String routeNameOrId, @Path("id") String pluginNameOrId);
}
