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
package org.iotivity.cloud.base.resource;

import org.iotivity.cloud.base.device.Device;
import org.iotivity.cloud.base.device.IRequestEventHandler;
import org.iotivity.cloud.base.exception.ServerException;
import org.iotivity.cloud.base.exception.ServerException.InternalServerErrorException;
import org.iotivity.cloud.base.protocols.IRequest;
import java.util.concurrent.ConcurrentHashMap;

public class ResourceManager implements IRequestEventHandler {

  private URIPathNode mPathList = new URIPathNode();

  private ConcurrentHashMap<String, IRequestEventHandler> mCachedQuery = new ConcurrentHashMap<>();

  public void addResource(Resource resource) {
    mPathList.addHandler(resource.getUriPathSegments(), resource);
  }

  @Override
  public void onRequestReceived(Device srcDevice, IRequest request) throws ServerException {
    // get path and forward to relevant handler
    IRequestEventHandler requestHandler = null;

    String uriPath = request.getUriPath();
    if (mCachedQuery.containsKey(uriPath)) {
      requestHandler = mCachedQuery.get(uriPath);
    } else {
      requestHandler = mPathList.findPathHandler(request.getUriPathSegments());
      mCachedQuery.put(uriPath, requestHandler);
    }

    if (requestHandler == null)
      throw new InternalServerErrorException("Unsupport URI: " + request.getUriPath());

    // Allocate new token and forward to other handler.
    // Only some handlers required to have new token.
    requestHandler.onRequestReceived(srcDevice, request);
  }
}
