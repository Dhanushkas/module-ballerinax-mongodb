// Copyright (c) 2019 WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
//
// WSO2 Inc. licenses this file to you under the Apache License,
// Version 2.0 (the "License"); you may not use this file except
// in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package org.wso2.mongo.actions;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ballerinalang.jvm.values.HandleValue;
import org.wso2.mongo.MongoDBDataSource;

/**
 * {@code Delete} action to delete documents in a collection.
 *
 */

public class Delete extends AbstractMongoDBAction {
    private static Log log = LogFactory.getLog(Insert.class);

    public static long deleteData(HandleValue datasource, String collectionName, Object filter, boolean isMultiple) {
        MongoDBDataSource mongoDataSource = (MongoDBDataSource) datasource.getValue();
        try {
            long deletedCount = delete(mongoDataSource, collectionName, filter, isMultiple);
            log.info("Successfully retrieved data");
            return deletedCount;
        } catch (Throwable e) {
            log.info("Error occured while retrieving data", e);
        }
        return 0;
    }
}

