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

    //进行保护性拷贝，客户端不应该获得对象内属性的真实引用
    public Date getStart(){
        return new Date(this.start.getTime());
    }

    //进行保护性拷贝，客户端不应该获得对象内属性的真实引用
    public Date getEnd(){
        return new Date(this.end.getTime());
    }


    public void readObject(ObjectInputStream stream) throws IOException,ClassNotFoundException {
        stream.defaultReadObject();
        //进行保护性拷贝，客户端不应该获得对象内属性的真实引用
        start = new Date(start.getTime());
        end = new Date(end.getTime());
        if(start.after(end)){
            throw new IllegalArgumentException();
        }
    }

}
