package com.shop.bookstore.services;

import com.shop.bookstore.domain.*;
import com.shop.bookstore.domain.enums.PaymentStatus;
import com.shop.bookstore.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private GenreRepository genreRepository;
    @Autowired
    private AuthorRepository authorRepository;

    public void instantiateTestDatabase() throws ParseException {
        //Date formatter
        SimpleDateFormat fullDateFormatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        SimpleDateFormat birthDateFormatter = new SimpleDateFormat("dd/MM/yyyy");

        Genre genre1 = new Genre(null, "Fantasy");
        Genre genre2 = new Genre(null, "Thriller");
        Genre genre3 = new Genre(null, "Drama");
        Genre genre4 = new Genre(null, "Horror");

        genreRepository.saveAll(Arrays.asList(genre1, genre2, genre3, genre4));

        Author author1 = new Author(null, "Stephen King", birthDateFormatter.parse("21/09/1947"));
        Author author2 = new Author(null, "Stephenie Meyer", birthDateFormatter.parse("24/12/1973"));
        Author author3 = new Author(null, "J.K. Rowling", birthDateFormatter.parse("31/12/1965"));

        authorRepository.saveAll(Arrays.asList(author1, author2, author3));

        Book book1 = new Book(null, "Harry Potter and the Sorcerer's Stone", 25.99,
                "Harry Potter thinks he is an ordinary boy - until he is rescued by a beetle-eyed giant of a man, enrols at Hogwarts School of Witchcraft and Wizardry, learns to play Quidditch and does battle in a deadly duel. The reason: Harry Potter is a wizard!",
                309, 2003, author3);
        book1.getGenres().add(genre1);

        Book book2 = new Book(null, "Twilight", 18.95,
                "On the first day of her school, Bella sits next to Edward in biology class, but he seems to be utterly repulsed by her, much to her bewilderment. He disappears for a few days but when he returns, he is unexpectedly friendly to Bella.",
                498, 2005, author2);
        book2.getGenres().addAll(Arrays.asList(genre1, genre3));

        Book book3 = new Book(null, "It", 44.90,
                "IT tells the story of seven friends who face an evil shape shifting entity that feeds on the fears of children. One of IT’s favorite disguises is a circus clown called Pennywise, otherwise known as 'Bob Gray'.",
                1138, 1986, author1);
        book3.getGenres().add(genre4);

        bookRepository.saveAll(Arrays.asList(book1, book2, book3));

        author1.getBooks().add(book3);
        author2.getBooks().add(book2);
        author3.getBooks().add(book1);

        State st1 = new State(null, "São Paulo");
        State st2 = new State(null, "Rio de Janeiro");
        State st3 = new State(null, "Acre");
        State st4 = new State(null, "Espirito Santo");

        City c1 = new City(null, "São Paulo", st1);
        City c2 = new City(null, "Guarulhos", st1);
        City c3 = new City(null, "Campinas", st1);
        City c4 = new City(null, "Rio de Janeiro", st2);
        City c5 = new City(null, "São Gonçalo", st2);
        City c6 = new City(null, "Duque de Caixas", st2);
        City c7 = new City(null, "Acrelândia", st3);
        City c8 = new City(null, "Assis Brasil", st3);
        City c9 = new City(null, "Serra", st4);
        City c10 = new City(null, "Vila Velha", st4);
        City c11 = new City(null, "Cariacica", st4);

        st1.getCities().addAll(Arrays.asList(c1, c2, c3));
        st2.getCities().addAll(Arrays.asList(c4, c5, c6));
        st3.getCities().addAll(Arrays.asList(c7, c8));
        st4.getCities().addAll(Arrays.asList(c9, c10, c11));

        stateRepository.saveAll(Arrays.asList(st1, st2, st3, st4));
        cityRepository.saveAll(Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11));

        User u1 = new User(null, "Roberto", "Oliveira", "roberto@email.com");
        User u2 = new User(null, "Alexa", "Amazon", "alexa@email.com");
        User u3 = new User(null, "Gertrudes", "Silva", "gertr@email.com");

        u1.getPhones().addAll(Arrays.asList("123456789", "14456744"));
        u2.getPhones().addAll(Arrays.asList("143424243"));
        u3.getPhones().addAll(Arrays.asList("756865543", "57352424"));

        Address ad1 = new Address(null, "Rua do exemplo", "Limoeiro", "134A", null, "09876000", st1, c2, u1);
        Address ad2 = new Address(null, "Rua do canário", "Pássaros", "98", "Apto. 92", "09312945", st1, c2, u1);
        Address ad3 = new Address(null, "Avenida Paulista", "Centro", "804", "Conj 25", "87654020", st1, c2, u2);
        Address ad4 = new Address(null, "Paz de Espirito Santo", "Formosura", "222", null, "65436872", st4, c10, u3);
        Address ad5 = new Address(null, "Rua de Janeiro", "Donzelas", "181B", null, "85463098", st2, c6, u3);

        u1.getAddresses().addAll(Arrays.asList(ad1, ad2));
        u2.getAddresses().add(ad3);
        u3.getAddresses().addAll(Arrays.asList(ad4, ad5));

        userRepository.saveAll(Arrays.asList(u1, u2, u3));
        addressRepository.saveAll(Arrays.asList(ad1, ad2, ad3, ad4, ad5));

        Order ord1 = new Order(null, fullDateFormatter.parse("18/08/2022 10:32"), u1, ad1);
        Order ord2 = new Order(null, fullDateFormatter.parse("19/09/2022 12:01"), u3, ad4);

        Payment pay1 = new PaymentWithBoleto(null, PaymentStatus.PAID, ord1, fullDateFormatter.parse("20/08/2022 11:34"), fullDateFormatter.parse("24/08/2022 23:59"));
        ord1.setPayment(pay1);

        Payment pay2 = new PaymentWithCreditCard(null, PaymentStatus.PENDING, ord2, 3);
        ord2.setPayment(pay2);

        u1.getOrders().add(ord1);
        u3.getOrders().add(ord2);

        orderRepository.saveAll(Arrays.asList(ord1, ord2));
        paymentRepository.saveAll(Arrays.asList(pay1, pay2));
    }
}