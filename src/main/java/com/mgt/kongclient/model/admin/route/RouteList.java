package com.mgt.kongclient.model.admin.route;

import java.util.List;

public record RouteList(List<Route> data,
                        String next) {
}
