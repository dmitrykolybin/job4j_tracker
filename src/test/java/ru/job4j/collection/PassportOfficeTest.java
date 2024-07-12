package ru.job4j.collection;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PassportOfficeTest {
    @Test
    void whenTestAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    void whenTestAddMethodFailed() {
        Citizen firstCitizen = new Citizen("2f44a", "Petr Arsentev");
        Citizen secondCitizen = new Citizen("2f44a", "Dmitry Kolybin");
        PassportOffice office = new PassportOffice();
        office.add(firstCitizen);
        assertThat(office.add(secondCitizen)).isFalse();
    }
}