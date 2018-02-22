package com.zhxx.mapreduce;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.Writable;

public class FlowBean implements Writable{
	
	private long upFlow;
	private long downFlow;
	private long sumFlow;
	
	public void setSum(long up,long down) {
		this.upFlow=up;
		this.downFlow=down;
		this.sumFlow=up+down;
	}
	
	public FlowBean() {
		super();
	}
	

	public long getUpFlow() {
		return upFlow;
	}

	public void setUpFlow(long upFlow) {
		this.upFlow = upFlow;
	}

	public long getDownFlow() {
		return downFlow;
	}

	public void setDownFlow(long downFlow) {
		this.downFlow = downFlow;
	}

	public long getSumFlow() {
		return sumFlow;
	}

	public void setSumFlow(long sumFlow) {
		this.sumFlow = sumFlow;
	}
	
	

	@Override
	public String toString() {
		return upFlow + "\t" + downFlow + "\t" + sumFlow;
	}

	@Override
	public void write(DataOutput out) throws IOException {
		out.writeLong(upFlow);
		out.writeLong(downFlow);
		out.writeLong(sumFlow);
		
	}
	
	@Override
	public void readFields(DataInput in) throws IOException {
		this.upFlow=in.readLong();
		this.downFlow=in.readLong();
		this.sumFlow=in.readLong();
		
	}
	

}
