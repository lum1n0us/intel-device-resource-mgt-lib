/*
* Copyright (C) 2020 Intel Corporation. All rights reserved.
* SPDX-License-Identifier: Apache-2.0
*/

package com.intel.iot.ams.api;

import org.eclipse.californium.core.CoapResource;

public class ConfigResource extends CoapResource {

  public ConfigResource() {
    super("c");
  }
}
