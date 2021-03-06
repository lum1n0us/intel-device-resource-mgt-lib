/*
* Copyright (C) 2020 Intel Corporation. All rights reserved.
* SPDX-License-Identifier: Apache-2.0
*/

/*
 * //******************************************************************
 * //
 * // Copyright 2016 Samsung Electronics All Rights Reserved.
 * //
 * //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
 * //
 * // Licensed under the Apache License, Version 2.0 (the "License");
 * // you may not use this file except in compliance with the License.
 * // You may obtain a copy of the License at
 * //
 * //      http://www.apache.org/licenses/LICENSE-2.0
 * //
 * // Unless required by applicable law or agreed to in writing, software
 * // distributed under the License is distributed on an "AS IS" BASIS,
 * // WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * // See the License for the specific language governing permissions and
 * // limitations under the License.
 * //
 * //-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
 */
package org.iotivity.cloud.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.cbor.CBORFactory;
import org.iotivity.cloud.base.exception.ServerException.BadRequestException;
import org.iotivity.cloud.base.exception.ServerException.InternalServerErrorException;
import java.io.IOException;

public class Cbor<T> {
  private CBORFactory f;
  private ObjectMapper mapper;

  public Cbor() {
    f = new CBORFactory();
    mapper = new ObjectMapper(f);
  }

  @SuppressWarnings("unchecked")
  public T parsePayloadFromCbor(byte[] cborPayload, Class<? extends Object> class1) {
    T payload = null;
    if (cborPayload == null) {
      throw new BadRequestException("cborPayload is null");
    }
    try {
      payload = (T) mapper.readValue(cborPayload, class1);
    } catch (IOException e) {
      e.printStackTrace();
    }

    return payload;
  }

  public byte[] encodingPayloadToCbor(Object payload) {
    byte[] cborData = null;
    if (payload == null) {
      throw new InternalServerErrorException("payload must be initialized");
    }
    try {
      cborData = mapper.writeValueAsBytes(payload);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
    }
    return cborData;
  }
}
