package com.mgt.kongclient.model.admin.api;

import com.mgt.kongclient.model.common.AbstractEntityList;
import lombok.Data;

import java.util.List;

@Deprecated
/**
 * Created by vaibhav on 13/06/17.
 */
@Data
public class ApiList extends AbstractEntityList {
  Long total;
  String next;
  List<Api> data;
}