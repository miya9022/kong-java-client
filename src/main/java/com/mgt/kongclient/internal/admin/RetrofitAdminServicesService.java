package com.mgt.kongclient.internal.admin;

import com.mgt.kongclient.model.admin.plugin.PluginList;
import com.mgt.kongclient.model.admin.route.Route;
import com.mgt.kongclient.model.admin.route.RouteList;
import com.mgt.kongclient.model.admin.services.Service;
import com.mgt.kongclient.model.admin.services.ServiceList;
import retrofit2.Call;
import retrofit2.http.*;

public interface RetrofitAdminServicesService {

  @POST("services/")
  Call<Service> createService(@Body Service request);

  @GET("services/{id}")
  Call<Service> getService(@Path("id") String nameOrId);

  @PATCH("services/{id}")
  Call<Service> updateService(@Path("id") String nameOrId, @Body Service request);

  @PUT("services/{id}")
  Call<Service> upsertService(@Path("id") String nameOrId, @Body Service request);

  @DELETE("services/{id}")
  Call<Void> deleteService(@Path("id") String nameOrId);

  @GET("services/")
  Call<ServiceList> listServices(@Query("tags") String tags);

  // plugin associated apis
  @GET("services/{id}/plugins")
  Call<PluginList> listServicePlugins(@Path("id") String nameOrId);

  // routes associated apis
  @POST("services/{id}/routes")
  Call<Route> createRouteByService(@Path("id") String nameOrId, @Body Route route);

  @GET("services/{id}/routes")
  Call<RouteList> getRoutesByService(@Path("id") String nameOrId);

  @GET("services/{id}/routes/{routeId}")
  Call<Route> getRouteByService(@Path("id") String nameOrId, @Path("routeId") String routeNameOrId);

  @PUT("services/{id}/routes/{routeId}")
  Call<Route> upsertRouteByService(@Path("id") String nameOrId, @Path("routeId") String routeNameOrId, @Body Route route);

  @DELETE("services/{id}/routes/{routeId}")
  Call<Void> deleteRouteByService(@Path("id") String nameOrId, @Path("routeId") String routeNameOrId);
}
