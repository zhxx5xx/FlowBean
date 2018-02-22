package com.zhxx.mapreduce;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class FlowCountReducer extends Reducer<Text, FlowBean, Text, FlowBean>{

	FlowBean v = new FlowBean();
	long sumUp;
	long sumDown;
	
	@Override
	protected void reduce(Text k, Iterable<FlowBean> beans, Context context)
			throws IOException, InterruptedException {
		sumUp = 0;
		sumDown = 0;
		for (FlowBean bean : beans) {
			sumUp+=bean.getUpFlow();
			sumDown+=bean.getDownFlow();
		}
		
		v.setSum(sumUp, sumDown);
		
		context.write(k, v);
	}
	
}
