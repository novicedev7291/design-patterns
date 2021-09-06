package com.coding.saga.behavioural.command.advanced.client;

import java.util.List;

record RequestContext(String requestName, List<String> params) {
}
