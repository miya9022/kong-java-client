package com.mgt.kongclient.model.admin.services;

import java.util.List;

public record ServiceList(List<Service> data,
                          String next) {
}
