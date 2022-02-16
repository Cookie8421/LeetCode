package com.leetcode.Learning.SerializationL;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * 通过保护性拷贝实现安全的反序列化
 */
public class Period implements Serializable {

    private static final long serialVersionUID = -5903423647049446652L;

    private Date start ;

    private Date end;

    @Override
    public String toString() {
        return "PeriodA{" + "start=" + start + ", end=" + end + "}";
    }

    public Period(Date start, Date end) {
        if(start.after(end)){
            throw new IllegalArgumentException();
        }
        this.start = start;
        this.end = end;
    }


    public void readObject(ObjectInputStream stream) throws IOException,ClassNotFoundException {
        stream.defaultReadObject();
        //进行保护性拷贝，防止反序列化新建出来对象被恶意篡改
        start = new Date(start.getTime());
        end = new Date(end.getTime());
        if(start.after(end)){
            throw new IllegalArgumentException();
        }
    }

}
