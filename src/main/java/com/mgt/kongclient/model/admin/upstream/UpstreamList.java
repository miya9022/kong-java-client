package com.mgt.kongclient.model.admin.upstream;

import com.mgt.kongclient.model.common.AbstractEntityList;
import lombok.Data;

import java.util.List;

/**
 * Created by vaibhav on 13/06/17.
 */
@Data
public class UpstreamList extends AbstractEntityList {
  String next;
  List<Upstream> data;
}
