package com.github.tsvetilian.ty.hmsmapkitcluster.algo;

/*
 * Copyright 2020 Google Inc.
 * Modified by: Tsvetilian Yankov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.github.tsvetilian.ty.hmsmapkitcluster.ClusterItem;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Base Algorithm class that implements lock/unlock functionality.
 */
public abstract class AbstractAlgorithm<T extends ClusterItem> implements Algorithm<T> {

    private final ReadWriteLock mLock = new ReentrantReadWriteLock();

    @Override
    public void lock() {
        mLock.writeLock().lock();
    }

    @Override
    public void unlock() {
        mLock.writeLock().unlock();
    }
}
