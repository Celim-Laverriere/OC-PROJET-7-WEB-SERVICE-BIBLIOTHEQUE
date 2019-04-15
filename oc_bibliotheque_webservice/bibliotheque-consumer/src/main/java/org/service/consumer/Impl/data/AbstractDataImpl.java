package org.service.consumer.Impl.data;

import javax.sql.DataSource;

public abstract class AbstractDataImpl {

    private DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}

