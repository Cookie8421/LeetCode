package com.leetcode.Learning.SerializationL;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * 通过序列化代理实现安全的反序列化
 */
public class PeriodProxyVer implements Serializable {

    private static final long serialVersionUID = -6192473336078553940L;

    private Date start;

    private Date end;

    @Override
    public String toString() {
        return "PeriodA{" + "start=" + start + ", end=" + end + "}";
    }

    public PeriodProxyVer(Date start, Date end) {
        if(start.after(end)){
            throw new IllegalArgumentException();
        }
        this.start = start;
        this.end = end;
    }

    public void readObject(ObjectInputStream stream) throws IOException,ClassNotFoundException {
        throw new InvalidObjectException("只允许通过代理实现反序列化！");
    }

    private class SerializationProxy implements Serializable{

        private final Date start;

        private final Date end;

        public SerializationProxy(PeriodProxyVer periodProxyVer){
            this.start = periodProxyVer.start;
            this.end = periodProxyVer.end;
        }

        public Object readObject(){
            return new PeriodProxyVer(start, end);
        }
    }
}
