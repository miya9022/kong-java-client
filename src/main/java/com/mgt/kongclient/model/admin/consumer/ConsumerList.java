package com.mgt.kongclient.model.admin.consumer;

import com.mgt.kongclient.model.common.AbstractEntityList;
import lombok.Data;

import java.util.List;

/**
 * Created by vaibhav on 13/06/17.
 */
@Data
public class ConsumerList extends AbstractEntityList {
  String next;
  List<Consumer> data;
}
