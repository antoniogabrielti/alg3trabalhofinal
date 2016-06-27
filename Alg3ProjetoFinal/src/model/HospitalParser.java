
package model;
import java.util.Locale;
import java.util.Scanner;
import util.CSVParser;

public class HospitalParser implements CSVParser<Hospital> {
    @Override
	public Hospital parseObject(String csvdata) {
		// garante que o scanner sera fechado ao encerrar.
		try (Scanner scanner = new Scanner(csvdata)) {
			scanner.useDelimiter(";");
                        scanner.useLocale(Locale.ITALY);
                        Hospital hospital = new Hospital();
			hospital.setNome(scanner.next());
                        hospital.setLatitude(scanner.nextDouble());
                        hospital.setLongitude(scanner.nextDouble());
			return hospital;
		}
	}
}
