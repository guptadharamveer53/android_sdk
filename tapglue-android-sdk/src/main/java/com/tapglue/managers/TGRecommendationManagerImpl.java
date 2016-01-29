/*
 * Copyright (c) 2015-2016 Tapglue (https://www.tapglue.com/). All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.tapglue.managers;

import android.support.annotation.NonNull;

import com.tapglue.Tapglue;
import com.tapglue.model.TGRecommendedUsers.TGRecommendationPeriod;
import com.tapglue.model.TGRecommendedUsers.TGRecommendationType;
import com.tapglue.model.TGUsersList;
import com.tapglue.networking.requests.TGRequestCallback;
import com.tapglue.networking.requests.TGRequestErrorType;

public class TGRecommendationManagerImpl extends AbstractTGManager implements TGRecommendationManager {

    public TGRecommendationManagerImpl(Tapglue tgInstance) {
        super(tgInstance);
    }

    /**
     * Get the recommended active users for the last day
     *
     * @param callback
     */
    public void getUsers(TGRecommendationType type, TGRecommendationPeriod period, @NonNull final TGRequestCallback<TGUsersList> callback) {
        if (instance.getUserManager().getCurrentUser() == null) {
            callback.onRequestError(new TGRequestErrorType(TGRequestErrorType.ErrorType.USER_NOT_LOGGED_IN));
            return;
        }

        instance.createRequest().getRecommendedUsers(type, period, callback);
    }
}
