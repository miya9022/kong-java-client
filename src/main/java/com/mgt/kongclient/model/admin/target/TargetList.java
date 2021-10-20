package com.mgt.kongclient.model.admin.target;

import com.mgt.kongclient.model.common.AbstractEntityList;
import lombok.Data;

import java.util.List;

/**
 * Created by vaibhav on 13/06/17.
 */
@Data
public class TargetList extends AbstractEntityList {
  Long total;
  String next;
  List<Target> data;
}
