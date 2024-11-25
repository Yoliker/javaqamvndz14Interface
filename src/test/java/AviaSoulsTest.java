import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AviaSoulsTest {

    Ticket ticket1 = new Ticket("Moskow", "Milan", 5_500, 8, 14);   //  6
    Ticket ticket2 = new Ticket("Sochi", "Rome", 4_500, 10, 13);
    Ticket ticket3 = new Ticket("Moskow", "Paris", 6_000, 9, 15);
    Ticket ticket4 = new Ticket("Moskow", "Milan", 5_800, 14, 18);  //  4
    Ticket ticket5 = new Ticket("Sochi", "Milan", 4_500, 10, 14);
    Ticket ticket6 = new Ticket("Moskow", "Milan", 5_500, 19, 23);  //  4
    Ticket ticket7 = new Ticket("Moskow", "Milan", 5_300, 5, 10);  //   5

    @Test
    public void shouldCheckIfAddsAllTickets() {
        AviaSouls aviaSouls = new AviaSouls();

        Ticket ticket8 = new Ticket("Sochi", "Rome", 4_700, 16, 19);

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);
        aviaSouls.add(ticket8);

        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6, ticket7, ticket8};
        Ticket[] actual = aviaSouls.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldGetTicketPrice() {

        Assertions.assertEquals(5_500, ticket1.getPrice());
        Assertions.assertEquals(4_500, ticket2.getPrice());
        Assertions.assertEquals(6_000, ticket3.getPrice());
        Assertions.assertEquals(5_800, ticket4.getPrice());
        Assertions.assertEquals(4_500, ticket5.getPrice());
        Assertions.assertEquals(5_500, ticket6.getPrice());
        Assertions.assertEquals(5_300, ticket7.getPrice());

    }

    @Test
    public void shouldCompareTicketPrice() {

        Assertions.assertEquals(1, ticket1.compareTo(ticket2));
        Assertions.assertEquals(-1, ticket1.compareTo(ticket3));
        Assertions.assertEquals(0, ticket2.compareTo(ticket5));
    }

    @Test
    public void shouldSortTicketsBySearch() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);

        Ticket[] expected = {ticket7, ticket1, ticket6, ticket4};
        Ticket[] actual = aviaSouls.search("Moskow", "Milan");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortTicketsBySearchIfZero() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);

        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.search("Sochi", "Paris");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortTicketsBySearchIfOne() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);

        Ticket[] expected = {ticket5};
        Ticket[] actual = aviaSouls.search("Sochi", "Milan");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCompareFlightSpeed() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket[] expected = {ticket4, ticket6, ticket7, ticket1};
        Ticket[] actual = aviaSouls.searchAndSortBy("Moskow", "Milan", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCompareFlightSpeedIfZero() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.searchAndSortBy("Sochi", "Paris", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldCompareFlightSpeedIfOne() {
        AviaSouls aviaSouls = new AviaSouls();
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);
        aviaSouls.add(ticket7);

        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket[] expected = {ticket2};
        Ticket[] actual = aviaSouls.searchAndSortBy("Sochi", "Rome", timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

}
