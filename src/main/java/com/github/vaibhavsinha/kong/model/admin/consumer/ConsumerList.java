package com.github.vaibhavsinha.kong.model.admin.consumer;

import com.github.vaibhavsinha.kong.model.common.AbstractEntityList;
import lombok.Data;

import java.util.List;

/**
 * Created by vaibhav on 13/06/17.
 */
@Data
public class ConsumerList extends AbstractEntityList {
  Long total;
  String next;
  List<Consumer> data;
}
