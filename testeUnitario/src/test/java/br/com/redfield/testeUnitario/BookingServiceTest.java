package br.com.redfield.testeUnitario;

import br.com.redfield.testeUnitario.model.BookingModel;
import br.com.redfield.testeUnitario.repository.BookingRepository;
import br.com.redfield.testeUnitario.service.BookingService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
public class BookingServiceTest {

    @TestConfiguration
    static class BookingServiceTestConfiguration {

        @Bean
        public BookingService bookingService() {
            return new BookingService();
        }
    }

    @MockBean
    BookingRepository bookingRepository;

    @Autowired
    BookingService bookingService;

    @Test
    public void bookingTestServiceCalculatorDays() {
        String name = "Pirlo";
        int days = bookingService.daysCalculatorWithDatabase(name);

        Assertions.assertEquals(days, 10);

    }

    @Before
    public void setUp()
    {
        LocalDate checkIn = LocalDate.parse("2021-03-10");
        LocalDate checkOut = LocalDate.parse("2021-03-20");
        BookingModel bookingModel = new BookingModel("1","Pirlo",checkIn,checkOut,3);

        Mockito.when(bookingRepository.findByReserveName(bookingModel.getReserveName()))
            .thenReturn(java.util.Optional.of(bookingModel));
    }
}
