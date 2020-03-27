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
package org.iotivity.cloud.base.device;

import io.netty.channel.ChannelHandlerContext;
import org.iotivity.cloud.base.protocols.IResponse;

public class HttpDevice extends Device {
  public HttpDevice(ChannelHandlerContext ctx) {
    super(ctx);
  }

  @Override
  public void sendResponse(IResponse response) {
    // This message must converted to HttpResponse
  }

  @Override
  public void onConnected() {
    // TODO Auto-generated method stub

  }

  @Override
  public void onDisconnected() {
    // TODO Auto-generated method stub

  }

  @Override
  public String getDeviceId() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getUserId() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getAccessToken() {
    // TODO Auto-generated method stub
    return null;
  }
}