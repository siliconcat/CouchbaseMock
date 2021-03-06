/*
 * Copyright 2017 Couchbase, Inc.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.couchbase.mock.client;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CacheRequest extends KeyAccessRequest {
    public CacheRequest(@NotNull String key, @NotNull String value, long cas, boolean onMaster, int numReplicas) {
        this(key, value, cas, onMaster, numReplicas, "");
    }
    public CacheRequest(@NotNull String key, @NotNull String value, long cas, boolean onMaster, List<Integer> replicaIds) {
        this(key, value, cas, onMaster, replicaIds, "");
    }

    public CacheRequest(@NotNull String key, @NotNull String value, long cas, boolean onMaster, int numReplicas, @NotNull String bucket) {
        super(key, value, onMaster, numReplicas, cas, bucket);
        command.put("command", "cache");
    }
    public CacheRequest(@NotNull String key, @NotNull String value, long cas, boolean onMaster, List<Integer> replicaIds, @NotNull String bucket) {
        super(key, value, onMaster, replicaIds, cas, bucket);
        command.put("command", "cache");
    }
}
