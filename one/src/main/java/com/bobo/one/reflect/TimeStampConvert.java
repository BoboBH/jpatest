package com.bobo.one.reflect;


import com.bobo.one.util.DateUtils;

public class TimeStampConvert implements ICSVConvert{

	@Override
	public String getValue(Object object){
		if(object == null)
			return null;
		if(object instanceof Long){
			return DateUtils.getDateString((Long)object);
		}
		return null;
	}
	
}
