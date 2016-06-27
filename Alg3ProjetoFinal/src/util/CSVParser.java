package util;

public interface CSVParser<T> {
	T parseObject(String csvdata);
}
