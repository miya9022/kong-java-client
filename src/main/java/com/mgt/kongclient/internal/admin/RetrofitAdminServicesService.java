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
}
