package com.mgt.kongclient.internal.admin;

import com.mgt.kongclient.model.admin.route.Route;
import com.mgt.kongclient.model.admin.route.RouteList;
import retrofit2.Call;
import retrofit2.http.*;

public interface RetrofitAdminServicesRouteService {

  @POST("services/{id}/routes")
  Call<Route> createRoute(@Path("id") String nameOrId, @Body Route route);

  @GET("services/{id}/routes")
  Call<RouteList> getRoutes(@Path("id") String nameOrId);

  @GET("services/{id}/routes/{routeId}")
  Call<Route> getRoute(@Path("id") String nameOrId, @Path("routeId") String routeNameOrId);

  @PUT("services/{id}/routes/{routeId}")
  Call<Route> upsertRoute(@Path("id") String nameOrId, @Path("routeId") String routeNameOrId, @Body Route route);

  @DELETE("services/{id}/routes/{routeId}")
  Call<Void> deleteRoute(@Path("id") String nameOrId, @Path("routeId") String routeNameOrId);
}
