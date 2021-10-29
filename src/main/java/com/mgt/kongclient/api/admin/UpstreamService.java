package com.mgt.kongclient.api.admin;

import com.mgt.kongclient.model.admin.upstream.Upstream;
import com.mgt.kongclient.model.admin.upstream.UpstreamList;
import retrofit2.Call;
import retrofit2.http.*;

/**
 * Created by vaibhav on 13/06/17.
 */
public interface UpstreamService {
  Upstream createUpstream(Upstream request);

  UpstreamList listAllUpstreams();

  Upstream getUpstream(String nameOrId);

  Upstream updateUpstream(String nameOrId, Upstream request);

  Upstream createOrUpdateUpstream(String nameOrId, Upstream request);

  Void deleteUpstream(String nameOrId);
}
