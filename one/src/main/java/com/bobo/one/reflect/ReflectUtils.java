package com.bobo.one.reflect;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;




public class ReflectUtils {
	
	public static List<Field> getAllField(Class<?> clazz){
		List<Field> fields = new ArrayList<Field>();
		Class<?> tmpClazz = clazz;
		while(tmpClazz != null){
			fields.addAll(Arrays.asList(tmpClazz.getDeclaredFields()));
			tmpClazz = tmpClazz.getSuperclass();
		}
		return fields;
	}
	
	public static Field getField(Class<?> clazz, String fieldName){
		List<Field> fields = getAllField(clazz);		
		Optional<Field> result = fields.stream().filter(f->f.getName().equals(fieldName)).findFirst();
		if(result.isPresent())
			return result.get();
		return null;
	}
	
	public static <T> String getCSVRow(T obj, List<String> fields){
		
		StringBuffer sb=new StringBuffer();
		int index = 0;
		for(String fieldName : fields){
			index++;
			Field field = getField(obj.getClass(), fieldName);
			field.setAccessible(true);
			if(field != null)
				try {
					CSVField csvField = field.getAnnotation(CSVField.class);
					if(csvField != null){
						ICSVConvert convert =(ICSVConvert) csvField.convert().getConstructors()[0].newInstance(null);
						String val = convert.getValue(field.get(obj));					
						sb.append(val);
					}else
						sb.append(field.get(obj));
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch(Exception ex){
					ex.printStackTrace();
				}
			if(index != fields.size())
				sb.append("\t");
		}
		return sb.toString();
	}
	
	public static <T> String getCSVHeader(T object,List<String> fields){
		StringBuffer sb = new StringBuffer();
		int index = 0;
		for(String fieldName : fields){
			index++;
			try{
				Field field = getField(object.getClass(), fieldName);
				String finalFieldName = fieldName;
				if(field != null){
					field.setAccessible(true);
					CSVField csvField = field.getAnnotation(CSVField.class);
					if(csvField != null)
						finalFieldName = csvField.value();					
				}
				sb.append(finalFieldName);
			}
			catch(Exception exception){
				exception.printStackTrace();
			}
			if(index != fields.size())
				sb.append("\t");
		}
		return sb.toString();
	}

	public static <T> String getCSVContent(List<T> objects, List<String> fields, List<String> titles){
		StringBuffer sb = new StringBuffer();
		if(titles != null && !titles.isEmpty()){
			int index = 0;
			for(String title : titles){
				index++;
				sb.append(title);
				if(index != titles.size())
					sb.append("\t");
			}
		}
		else {
			sb.append(getCSVHeader(objects.get(0), fields));
		}
		sb.append("\r\n");
		for(T item : objects){
			sb.append(getCSVRow(item, fields)).append("\r\n");
		}
		return sb.toString();
	}
}
