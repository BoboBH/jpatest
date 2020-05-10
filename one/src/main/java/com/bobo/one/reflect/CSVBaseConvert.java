package com.bobo.one.reflect;


public class CSVBaseConvert implements ICSVConvert{
	
	@Override
	public String getValue(Object object){
		if(object != null)
			return object.toString();
		return "";
	}

}
