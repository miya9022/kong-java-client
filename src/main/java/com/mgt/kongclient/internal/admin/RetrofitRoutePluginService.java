package com.mgt.kongclient.internal.admin;

import com.mgt.kongclient.model.admin.plugin.Plugin;
import com.mgt.kongclient.model.admin.plugin.PluginList;
import retrofit2.Call;
import retrofit2.http.*;

public interface RetrofitRoutePluginService {

  @POST("routes/{routeId}/plugins/")
  Call<Plugin> addPlugin(@Path("routeId") String routeId, @Body Plugin request);

  @GET("routes/{routeId}/plugins/{id}")
  Call<Plugin> getPlugin(@Path("routeId") String routeId, @Path("id") String nameOrId);

  @PATCH("routes/{routeId}/plugins/{id}")
  Call<Plugin> updatePlugin(@Path("routeId") String routeId, @Path("id") String nameOrId, @Body Plugin request);

  @PUT("routes/{routeId}/plugins/{id}")
  Call<Plugin> upsertPlugin(@Path("routeId") String routeId, @Path("id") String nameOrId, @Body Plugin request);

  @DELETE("routes/{routeId}/plugins/{id}")
  Call<Void> deletePlugin(@Path("routeId") String routeId, @Path("id") String nameOrId);

  @GET("routes/{routeId}/plugins/")
  Call<PluginList> listPlugins(@Path("routeId") String routeId);
}
