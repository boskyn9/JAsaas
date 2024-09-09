package br.com.intersistemas.jasaas.util;

import com.google.gson.GsonBuilder;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author bosco
 */
public class JsonUtil {

	private static GsonBuilder gsonBuilder = null;

	public static Object parse(String json, Class clazz) {
		return parse(json, clazz, false);
	}

	public static Object parse(String json, Class clazz, Boolean showLog) {
		return parse(json, clazz, showLog, false);
	}

	public static Object parse(String json, Class clazz, Boolean showLog, Boolean verificaDataBR) {
		if (gsonBuilder == null) {
			gsonBuilder = new GsonBuilder()
					.excludeFieldsWithoutExposeAnnotation()
					.registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
					.registerTypeAdapter(ZonedDateTime.class, new ZonedDateTimeAdapter())
					.setDateFormat(DateFormat.SHORT);
		}
		try {
			return gsonBuilder.create().fromJson(json, clazz);
		} catch (Exception e) {
			if (showLog) {
				System.out.println("Error parse gson.fromJson\n" + json);
				e.printStackTrace();
			}
			return null;
		}
	}

	public static String toJSON(Object obj) {
		if (gsonBuilder == null) {
			gsonBuilder = new GsonBuilder()
					.excludeFieldsWithoutExposeAnnotation()
					.registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
					.registerTypeAdapter(ZonedDateTime.class, new ZonedDateTimeAdapter())
					.setDateFormat(DateFormat.SHORT);
		}
		return gsonBuilder.create().toJson(obj);
	}

	private static Boolean isDateBR(String json) {
		Pattern pattern = Pattern.compile("^[0-9]{2}/[0-9]{2}/[0-9]{4}$");
		Matcher matcher = pattern.matcher(json);
		return matcher.matches();
	}
}
