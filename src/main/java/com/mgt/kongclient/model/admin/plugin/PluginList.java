package com.mgt.kongclient.model.admin.plugin;

import com.mgt.kongclient.model.common.AbstractEntityList;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * Created by vaibhav on 13/06/17.
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PluginList extends AbstractEntityList {
  String next;
  List<Plugin> data;
}
