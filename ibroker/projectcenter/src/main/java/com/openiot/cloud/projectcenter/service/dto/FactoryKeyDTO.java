/*
 * Copyright (C) 2020 Intel Corporation. All rights reserved. SPDX-License-Identifier: Apache-2.0
 */

package com.openiot.cloud.projectcenter.service.dto;

import lombok.Data;

@Data
public class FactoryKeyDTO {
  private String keyName;
  private String keyType;
  private String keyValue;
  private String domain;
}
