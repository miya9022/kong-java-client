package com.mgt.kongclient.internal.admin;

import com.mgt.kongclient.model.admin.upstream.Upstream;
import com.mgt.kongclient.model.admin.upstream.UpstreamList;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * Created by vaibhav on 12/06/17.
 */
public interface RetrofitUpstreamService {

  @POST("upstreams/")
  Call<Upstream> createUpstream(@Body Upstream request);

  @GET("upstreams/")
  Call<Upstream> listAllUpstreams();

  @GET("upstreams/{id}")
  Call<Upstream> getUpstream(@Path("id") String nameOrId);

  @PATCH("upstreams/{id}")
  Call<Upstream> updateUpstream(@Path("id") String nameOrId, @Body Upstream request);

  @PUT("upstreams/{id}")
  Call<Upstream> createOrUpdateUpstream(@Path("id") String nameOrId, @Body Upstream request);

  @DELETE("upstreams/{id}")
  Call<Void> deleteUpstream(@Path("id") String nameOrId);
}
