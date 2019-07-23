package com.jonlin.common.fastdfs;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

/**
 * Copyright (C), 2017-2018, 上海阁为信息科技有限公司
 * FileName: TrackerServerFactory.java
 * Author:   hyz
 * Date:     2018-05-30 14:03
 * Description: TrackerServer 工厂类，创建对象池需要 BasePooledObjectFactory 对象或子类.
 */
public class TrackerServerFactory extends BasePooledObjectFactory<TrackerServer> {
    @Override
    public TrackerServer create() throws Exception {
        // TrackerClient
        TrackerClient trackerClient = new TrackerClient();
        // TrackerServer
        TrackerServer trackerServer = trackerClient.getConnection();

        return trackerServer;
    }

    @Override
    public PooledObject<TrackerServer> wrap(TrackerServer trackerServer) {

        return new DefaultPooledObject<TrackerServer>(trackerServer);
    }
}