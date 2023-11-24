package br.com.intersistemas.jasaas.util;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateAdapter extends TypeAdapter<LocalDate> {

	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	@Override
	public void write(JsonWriter out, LocalDate value) throws IOException {
		if (value == null) {
			out.nullValue();
		} else {
			out.value(formatter.format(value));
		}
	}

	@Override
	public LocalDate read(JsonReader in) throws IOException {
		if (in.peek() == JsonToken.NULL) {
			in.nextNull();
			return null;
		} else {
			String dateString = in.nextString();
			return LocalDate.parse(dateString, formatter);
		}
	}
}