package pl.sda.learnjava.LearnJava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import pl.sda.learnjava.LearnJava.model.Question;
import pl.sda.learnjava.LearnJava.model.Role;
import pl.sda.learnjava.LearnJava.model.Student;
import pl.sda.learnjava.LearnJava.repository.QuestionRepository;
import pl.sda.learnjava.LearnJava.repository.RoleRepository;
import pl.sda.learnjava.LearnJava.repository.StudentRepository;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashSet;

@Controller
public class Mocker {
    private StudentRepository studentRepository;
    private QuestionRepository questionRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public Mocker(StudentRepository studentRepository, QuestionRepository questionRepository, RoleRepository roleRepository,
                  PasswordEncoder passwordEncoder) {
        this.studentRepository = studentRepository;
        this.questionRepository = questionRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void mockData() {
        Role student = new Role("student");
        Role admin = new Role("admin");

        roleRepository.save(student);
        roleRepository.save(admin);


        Student student1 = new Student();
        student1.setLogin("kowalski");
        student1.setPassword(passwordEncoder.encode("kowalski1"));
        student1.setName("andrzej");
        student1.setLastName("kowalski");
        student1.setRoles(new HashSet<>(Arrays.asList(student)));


        Student student2 = new Student();
        student2.setLogin("nowak");
        student2.setPassword(passwordEncoder.encode("haslo2"));
        student2.setName("Stefan");
        student2.setLastName("Nowak");
        student2.setRoles(new HashSet<>(Arrays.asList(student)));


        Student admin1 = new Student();
        admin1.setName("admin");
        admin1.setLogin("admin");
        admin1.setPassword(passwordEncoder.encode("admin"));
        admin1.setLastName("admin");
        admin1.setRoles(new HashSet<>(Arrays.asList(admin)));


        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(admin1);


        Question question1 = new Question("Pytanie 1", "W deklaracji metody, wymienione elementy występują w następującej kolejności:");
        question1.setLevel(1);
        question1.setAnswer1("a) Modyfikator dostępu - zwracany typ - nazwa metody - parametry");
        question1.setAnswer2("b) Nazwa metody - zwracany typ - parametry - modyfikator dostępu");
        question1.setAnswer3("c) Modyfikator dostępu - nazwa metody - zwracany typ - parametry");
        question1.setAnswer4("d) Parametry - zwracany typ - modyfikator dostępu - nazwa metody");
        question1.setCorrectAnswer(question1.getAnswer1());

        Question question2 = new Question("Pytanie 2", "Jakie mamy w Javie modyfikatory dostępu:"); //TO-DO
        question2.setLevel(1);
        question2.setAnswer1("a) protected, private, public, (brak deklaracji - package)");
        question2.setAnswer2("b) private, public, protected");
        question2.setAnswer3("c) private, public, project, (brak deklaracji - package)");
        question2.setAnswer4("d) private, protected, package, project");
        question2.setCorrectAnswer(question2.getAnswer1());

        Question question3 = new Question("Pytanie 3", "Do metod interfejsu List należą: ");
        question3.setLevel(2);
        question3.setAnswer1("a) add, get, delete");
        question3.setAnswer2("b) put, get, remove");
        question3.setAnswer3("c) put, add, delete");
        question3.setAnswer4("d) add, get, remove");
        question3.setCorrectAnswer(question3.getAnswer4());

        Question question4 = new Question("Pytanie 4", "Instrukcje warunkowe to:");
        question4.setLevel(1);
        question4.setAnswer1("a) for, while, do..while");
        question4.setAnswer2("b) if..else, switch..case");
        question4.setAnswer3("c) for, if..else");
        question4.setAnswer4("d) if..elif");
        question4.setCorrectAnswer(question4.getAnswer2());

        Question question5 = new Question("Pytanie 5", "Do typów prymitywnych należą:");
        question5.setLevel(1);
        question5.setAnswer1("a) int, String, double");
        question5.setAnswer2("b) char, int, double");
        question5.setAnswer3("c) int, char, Object");
        question5.setAnswer4("d) Integer, String, Double");
        question5.setCorrectAnswer(question5.getAnswer2());

        Question question6 = new Question("Pytanie 6", "Jaką rolę pełnią pakiety w projekcie?");
        question6.setLevel(1);
        question6.setAnswer1("a) służą do agregacji klas projektu");
        question6.setAnswer2("b) nie mają znaczącej roli w projekcie");
        question6.setAnswer3("c) posiadają własne deklaracje ścieżek dostępu");
        question6.setAnswer4("d) mogą przechowywać wyłącznie pliki z rozszerzeniem .java");
        question6.setCorrectAnswer(question6.getAnswer1());

        Question question7 = new Question("Pytanie 7", "W którym typie danych mogą znaleźć się metody abstrakcyjne (deklaracja metody, bez implementacji):");
        question7.setLevel(1);
        question7.setAnswer1("a) Klasa, interfejs");
        question7.setAnswer2("b) Typ prymitywny, Object");
        question7.setAnswer3("c) Klasa abstrakcyjna, interfejs");
        question7.setAnswer4("d) Klasa finalna, klasa abstrakcyjna, interfejs");
        question7.setCorrectAnswer(question7.getAnswer3());

        Question question8 = new Question("Pytanie 8", "Typy posortowane rosnąco wg zakresu ich wartości, to:");
        question8.setLevel(2);
        question8.setAnswer1("a) int, double, float, boolean");
        question8.setAnswer2("b) boolean, char, int, double");
        question8.setAnswer3("c) float, char, int, double");
        question8.setAnswer4("d) int, byte, double, float");
        question8.setCorrectAnswer(question8.getAnswer2());

        Question question9 = new Question("Pytanie 9", "Typy możemy podzielić w Javie na:");
        question9.setLevel(2);
        question9.setAnswer1("a) Klasy, interfejsy, metody");
        question9.setAnswer2("b) Interfejsy, klasy, typy prymitywne, adnotacje");
        question9.setAnswer3("c) Pola, metody, konstruktory");
        question9.setAnswer4("d) Interfejsy, klasy");
        question9.setCorrectAnswer(question9.getAnswer2());

        Question question10 = new Question("Pytanie 10", "Które stwierdzenie jest nieprawdziwe:");
        question10.setLevel(2);
        question10.setAnswer1("a) W klasie możemy mieć wiele metod o tej samej nazwie.");
        question10.setAnswer2("b) W klasie możemy mieć wiele konstruktorów.");
        question10.setAnswer3("c) W klasie możemy mieć wiele pól o tej samej nazwie.");
        question10.setAnswer4("d) Parametr metody w danej klasie może mieć taką samą nazwę, jak pole tej klasy.");
        question10.setCorrectAnswer(question10.getAnswer3());

        Question question11 = new Question("Pytanie 11", "Instrukcja, która nie będzie powodowała błędu, to:");
        question11.setLevel(2);
        question11.setAnswer1("a) int[10] intArray = new int[]();");
        question11.setAnswer2("b) int intArray[10] = new[10] int;");
        question11.setAnswer3("c) int intArray[] = new int[](10);");
        question11.setAnswer4("d) int[] intArray = new int[10];");
        question11.setCorrectAnswer(question11.getAnswer4());

        Question question12 = new Question("Pytanie 12", "Dyrektywa default w instrukcji switch:");
        question12.setLevel(1);
        question12.setAnswer1("a) ustawia domyślną wartość dla sprawdzanej zmiennej");
        question12.setAnswer2("b) jest konieczna w instrukcji switch..case");
        question12.setAnswer3("c) służy do zdefiniowania instrukcji wykonywanych gdy kompilator nie znajdzie odpowiedniej wartości");
        question12.setAnswer4("d) wykonuje instrukcje przed sprawdzeniem warunków spełnienia");
        question12.setCorrectAnswer(question12.getAnswer3());

        Question question13 = new Question("Pytanie 13", "Jaka jest różnica pomiędzy typami int a Integer:");
        question13.setLevel(1);
        question13.setAnswer1("a) nie ma żadnej różnicy");
        question13.setAnswer2("b) Integer jest klasą osłonową, a int jest typem prostym");
        question13.setAnswer3("c) wykorzystując typ int możemy dokonywać operacji arytmetycznych, w przypadku typu Integer nie mamy takiej możliwości");
        question13.setAnswer4("d) wykorzystując klasę Integer musimy koniecznie użyć konstruktora do deklaracji wartości zmiennej");
        question13.setCorrectAnswer(question13.getAnswer2());

        Question question14 = new Question("Pytanie 14", "Operator \"+\" jest operatorem:");
        question14.setLevel(2);
        question14.setAnswer1("a) dodawania");
        question14.setAnswer2("b) konkatenacji");
        question14.setAnswer3("c) konkatenacji i dodawania");
        question14.setAnswer4("d) sklejania");
        question14.setCorrectAnswer(question14.getAnswer3());

        Question question15 = new Question("Pytanie 15", "Która z poniższych implementacji kolekcji jest zaprojektowana do przechowywania tylko unikalnych wartości?");
        question15.setLevel(2);
        question15.setAnswer1("a) ConcurrentSkipListMap");
        question15.setAnswer2("b) HashMap");
        question15.setAnswer3("c) PriorityQueue");
        question15.setAnswer4("d) TreeSet");
        question15.setCorrectAnswer(question15.getAnswer4());

        Question question16 = new Question("Pytanie 16", "Która klasa lub interfejs definiuje metody wait(), notify() i notifyAll()?");
        question16.setLevel(3);
        question16.setAnswer1("a) Object");
        question16.setAnswer2("b) Thread");
        question16.setAnswer3("c) Runnable");
        question16.setAnswer4("d) Class");
        question16.setCorrectAnswer(question16.getAnswer1());

        Question question17 = new Question("Pytanie 17", "Który z poniższych stanów wątków jest niepoprawny?");
        question17.setLevel(3);
        question17.setAnswer1("a) TIMED_WAITING");
        question17.setAnswer2("b) SUSPENDED");
        question17.setAnswer3("c) BLOCKED");
        question17.setAnswer4("d) RUNNABLE");
        question17.setCorrectAnswer(question17.getAnswer2());

        Question question18 = new Question("Pytanie 18", "Rekord to:");
        question18.setLevel(2);
        question18.setAnswer1("a) miejsce w systemie operacyjnym, gdzie fizycznie przechowywane są pliki bazy danych");
        question18.setAnswer2("b) długie pole w bazach danych");
        question18.setAnswer3("c) wiersz w tabeli baz danych zawierająca wszystkie pola");
        question18.setAnswer4("d) polecenie filtrujące dane numeryczne");
        question18.setCorrectAnswer(question18.getAnswer3());

        Question question19 = new Question("Pytanie 19", "Które polecenie usunie wszystkie dane z tabeli user? *");
        question19.setLevel(2);
        question19.setAnswer1("a) REMOVE * FROM user;");
        question19.setAnswer2("b) UPDATE user SET null WHERE 1=1;");
        question19.setAnswer3("c) DELETE FROM user;");
        question19.setAnswer4("d) DROP * FROM user;");
        question19.setCorrectAnswer(question19.getAnswer3());

        Question question20 = new Question("Pytanie 20", "Który język służy do tworzenia obiektów bazy danych takich jak np. tabele?");
        question20.setLevel(3);
        question20.setAnswer1("a) DML");
        question20.setAnswer2("b) DQL");
        question20.setAnswer3("c) DDL");
        question20.setAnswer4("d) RDBMS");
        question20.setCorrectAnswer(question20.getAnswer3());

        Question question21 = new Question("Pytanie 21", "Przykładowe typy danych w MySQL to:");
        question21.setLevel(2);
        question21.setAnswer1("a) INTEGER, DOUBLE, STRING, BINARY");
        question21.setAnswer2("b) DATETIME, CALENDAR, BLOB, INT");
        question21.setAnswer3("c) IMAGE, CHAR, DOUBLE, TIMESTAMP");
        question21.setAnswer4("d) DATE, VARCHAR, BLOB, TINYINT");
        question21.setCorrectAnswer(question21.getAnswer4());

        Question question22 = new Question("Pytanie 22", "Które polecenie wyświetli obecną datę i godzinę?");
        question22.setLevel(3);
        question22.setAnswer1("a) SELECT currentdate();");
        question22.setAnswer2("b) SELECT curtime();");
        question22.setAnswer3("c) SELECT now();");
        question22.setAnswer4("d) SELECT currentdate(„dd-mm-yyyy hh:ii:ss”);");
        question22.setCorrectAnswer(question22.getAnswer3());

        Question question23 = new Question("Pytanie 23", "Które polecenie służy do zwracania tylko różnych wartości? ");
        question23.setLevel(3);
        question23.setAnswer1("a) DISTINCT");
        question23.setAnswer2("b) UNIQUE");
        question23.setAnswer3("c) ORDER BY");
        question23.setAnswer4("d) RESTRICT");
        question23.setCorrectAnswer(question23.getAnswer1());

        Question question24 = new Question("Pytanie 24", "Która z poniższych funkcji NIE jest agregująca?");
        question24.setLevel(1);
        question24.setAnswer1("a) MAX");
        question24.setAnswer2("b) MIN");
        question24.setAnswer3("c) OR");
        question24.setAnswer4("d) SUM");
        question24.setCorrectAnswer(question24.getAnswer3());

        Question question25 = new Question("Pytanie 25", "Czy można jednym poleceniem pobrać i wstawić dane z jednej tabeli do drugiej?");
        question25.setLevel(2);
        question25.setAnswer1("a) Tak, ale trzeba użyć tabeli widokowej (view)");
        question25.setAnswer2("b) Tak, przy użyciu UNION lub UNION ALL");
        question25.setAnswer3("c) Tak, przy użyciu INSERT INTO i SELECT");
        question25.setAnswer4("d) Nie, bo jest to proces dwuetapowy");
        question25.setCorrectAnswer(question25.getAnswer3());

        Question question26 = new Question("Pytanie 26", "Założenie indeksów na kolumny:");
        question26.setLevel(1);
        question26.setAnswer1("a) może poprawić szybkość wstawianie danych");
        question26.setAnswer2("b) może poprawić szybkość wyszukiwania danych");
        question26.setAnswer3("c) wymaga przechowywania unikalnych danych w kolumnie");
        question26.setAnswer4("d) możliwe jest tylko na kolumny o typach numerycznych");
        question26.setCorrectAnswer(question26.getAnswer2());

        Question question27 = new Question("Pytanie 27", "Instrukcja ALTER TABLE służy do:");
        question27.setLevel(2);
        question27.setAnswer1("a) tworzenia tabeli");
        question27.setAnswer2("b) usuwania tabeli");
        question27.setAnswer3("c) zmiany schematu tabeli");
        question27.setAnswer4("d) aktualizacji indeksów założonych na tabeli");
        question27.setCorrectAnswer(question27.getAnswer3());

        Question question28 = new Question("Pytanie 28", "Instrukcja GRANT służy do:");
        question28.setLevel(3);
        question28.setAnswer1("a) przyznawania uprawnień");
        question28.setAnswer2("b) odbierania uprawnień");
        question28.setAnswer3("c) zatwierdzania zmian");
        question28.setAnswer4("d) aktualizacji indexów");
        question28.setCorrectAnswer(question28.getAnswer1());

        Question question29 = new Question("Pytanie 29", "Instrukcja ROLLBACK służy do:");
        question29.setLevel(1);
        question29.setAnswer1("a) odbierania uprawnień");
        question29.setAnswer2("b) przewijania kursora na początek wyników");
        question29.setAnswer3("c) ponownego wywołania (poprzedniego) zapytania");
        question29.setAnswer4("d) wycofywania zmian");
        question29.setCorrectAnswer(question29.getAnswer4());

        Question question30 = new Question("Pytanie 30", "Tabela User ma kolumnę sign. Jaka liczba może być wynikiem zapytania SELECT count(*) FROM User WHERE sign<sign ?");
        question30.setLevel(3);
        question30.setAnswer1("a) 1");
        question30.setAnswer2("b) 0");
        question30.setAnswer3("c) dowolna liczba całkowita");
        question30.setAnswer4("d) dokładnie taka ile jest krotek w tabeli User");
        question30.setCorrectAnswer(question30.getAnswer2());

        Question question31 = new Question("Pytanie 31", "Encji w bazie danych odpowiada:");
        question31.setLevel(1);
        question31.setAnswer1("a) wiersz");
        question31.setAnswer2("b) kolumna");
        question31.setAnswer3("c) tabela");
        question31.setAnswer4("d) klucz obcy");
        question31.setCorrectAnswer(question31.getAnswer3());

        Question question32 = new Question("Pytanie 32", "Atrybutowi w bazie danych odpowiada:");
        question32.setLevel(1);
        question32.setAnswer1("a) kolumna");
        question32.setAnswer2("b) wiersz");
        question32.setAnswer3("c) tabela");
        question32.setAnswer4("d) indeks");
        question32.setCorrectAnswer(question32.getAnswer1());

        Question question33 = new Question("Pytanie 33", "Kod HTML najlepiej umieścić w:");
        question33.setLevel(1);
        question33.setAnswer1("a) servlecie");
        question33.setAnswer2("b) filtrze");
        question33.setAnswer3("c) stronie JSP");
        question33.setAnswer4("d) dispatcherze");
        question33.setCorrectAnswer(question33.getAnswer3());

        Question question34 = new Question("Pytanie 34", "Metoda servletu obsługująca żądanie GET to:");
        question34.setLevel(1);
        question34.setAnswer1("a) doGet");
        question34.setAnswer2("b) perform");
        question34.setAnswer3("c) getResponse");
        question34.setAnswer4("d) execute");
        question34.setCorrectAnswer(question34.getAnswer1());

        Question question35 = new Question("Pytanie 35", "Obiekt odpowiedzi w servlecie to:");
        question35.setLevel(2);
        question35.setAnswer1("a) ResponseServlet");
        question35.setAnswer2("b) ResponseController");
        question35.setAnswer3("c) MVCForwarder");
        question35.setAnswer4("d) ServletResponse");
        question35.setCorrectAnswer(question35.getAnswer4());

        Question question36 = new Question("Pytanie 36", "Kod w znacznikach <% %> oznacza:");
        question36.setLevel(1);
        question36.setAnswer1("a) dyrektywę");
        question36.setAnswer2("b) skryptlet");
        question36.setAnswer3("c) komentarz widoczny w przeglądarce");
        question36.setAnswer4("d) komentarz niewidoczny w przeglądarce");
        question36.setCorrectAnswer(question36.getAnswer2());

        Question question37 = new Question("Pytanie 37", "Jaki kod statusu HTTP odpowiada za nieznaleziony zasób:");
        question37.setLevel(1);
        question37.setAnswer1("a) 301");
        question37.setAnswer2("b) 400");
        question37.setAnswer3("c) 404");
        question37.setAnswer4("d) 500");
        question37.setCorrectAnswer(question37.getAnswer3());

        Question question38 = new Question("Pytanie 38", "Jakie są trzy zasady programowania obiektowego:");
        question38.setLevel(3);
        question38.setAnswer1("a) serializacja, hermetyzacja, polimorfizm");
        question38.setAnswer2("b) enkapsulacja, polimorfizm, hermetyzacja");
        question38.setAnswer3("c) hermetyzacja, dziedziczenie, polimorfizm");
        question38.setAnswer4("d) dziedziczenie, abstrakcja, enkapsulacja");
        question38.setCorrectAnswer(question38.getAnswer3());

        Question question39 = new Question("Pytanie 39", "Który z poniższych identyfikatorów zmiennych jest nieprawidłowy:");
        question39.setLevel(3);
        question39.setAnswer1("a) my_variable_");
        question39.setAnswer2("b) $variable");
        question39.setAnswer3("c) _variable");
        question39.setAnswer4("d) 1variable");
        question39.setCorrectAnswer(question39.getAnswer4());

        Question question40 = new Question("Pytanie 40", "Typy sparametryzowane są tak ważne, ponieważ umożliwiają tworzenie kodu, który:");
        question40.setLevel(3);
        question40.setAnswer1("a) jest bezpieczny z punktu widzenia zgodności typów");
        question40.setAnswer2("b) może być wykorzystywany wielokrotnie i jest niezawodny");
        question40.setAnswer3("c) adpowiedzi a i b są prawdziwe");
        question40.setAnswer4("d) odpowiedzi a i b są fałszywe");
        question40.setCorrectAnswer(question40.getAnswer3());

        Question question41 = new Question("Pytanie 41", "Która procedura wysyłania zmian do zdalnego repozytorium zadziała poprawnie:");
        question41.setLevel(1);
        question41.setAnswer1("a) git push, git commit -m \"message\", git add .");
        question41.setAnswer2("b) git pull, git commit -m \"message\", git push");
        question41.setAnswer3("c) git commit -m \"message\", git add ., git push");
        question41.setAnswer4("d) git add ., git commit -m \"message\", git push");
        question41.setCorrectAnswer(question41.getAnswer4());

        Question question42 = new Question("Pytanie 42", "Co oznacza skrót WORA:");
        question42.setLevel(1);
        question42.setAnswer1("a) Write Object, Rest After");
        question42.setAnswer2("b) Web Oracle Repository Analyzation");
        question42.setAnswer3("c) Write Once, Run Anywhere");
        question42.setAnswer4("d) Wirtual Oracle Runtime Association");
        question42.setCorrectAnswer(question42.getAnswer3());

        Question question43 = new Question("Pytanie 43", "Który ciąg zawiera tylko unchecked exceptions, czyli wyjątki, których programista nie musi obsługiwać i które dziedziczą po Runtime Exeption:");
        question43.setLevel(1);
        question43.setAnswer1("a) NullPointerExeption, IllegalArgumentExeption, IndexOutOfBoundsExeption");
        question43.setAnswer2("b) IOExeption, SQLExeption, FileNotFoundExeption");
        question43.setAnswer3("c) OutOfMemoryError, StackOverflowError, SocketExeption");
        question43.setAnswer4("d) 400 Bad Request, 403 Forbidden, 404 Not Found");
        question43.setCorrectAnswer(question43.getAnswer1());

        Question question44 = new Question("Pytanie 44", "Co to jest SOLID:");
        question44.setLevel(2);
        question44.setAnswer1("a) biblioteka wykorzystywana w TDD oparta na obiektowo zorientowanym języku Solidity");
        question44.setAnswer2("b) skrót od Singleton, Observer, Lock, Iterator, Decorator, czyli zbiór najczęściej stosowanych wzorców projektowych");
        question44.setAnswer3("c) zbiór zasad pisania czystego kodu, żeby był łatwo rozszerzalny, testowalny i czytelny");
        question44.setAnswer4("d) SOL ID to jeden z rodzajów LOG ID stosowanych w protokole HTTP");
        question44.setCorrectAnswer(question44.getAnswer3());

        Question question45 = new Question("Pytanie 45", "Pojęcie widoku (view) może się odnosić do:");
        question45.setLevel(2);
        question45.setAnswer1("a) tabeli wirtualnej w SQL tworzonej przez komendę: create view");
        question45.setAnswer2("b) Spring MVC");
        question45.setAnswer3("c) klasy View z pakietu java.lang.Object");
        question45.setAnswer4("d) wszystkie odpowiedzi są poprawne");
        question45.setCorrectAnswer(question45.getAnswer4());

        Question question46 = new Question("Pytanie 46", "CRUD oznacza:");
        question46.setLevel(2);
        question46.setAnswer1("a) Code Run Until Deadline");
        question46.setAnswer2("b) create read update delate – czyli podstawowe operacje do zarządzania danymi w bazie danych");
        question46.setAnswer3("c) interfejs w Springu");
        question46.setAnswer4("d) odpowiedzi b i c są poprawne");
        question46.setCorrectAnswer(question46.getAnswer2());

        Question question47 = new Question("Pytanie 47", "Co to jest trigger:");
        question47.setLevel(2);
        question47.setAnswer1("a) to obiekt związany z tablicą bazy danych, który aktywuje się w sytuacji kiedy jest wykonywane zapytanie do tablicy");
        question47.setAnswer2("b) wyzwalacz encji");
        question47.setAnswer3("c) polecenie, które wywołuje funkcję DROP");
        question47.setAnswer4("d) żadna z powyższych odpowiedzi nie jest poprawna");
        question47.setCorrectAnswer(question47.getAnswer1());

        Question question48 = new Question("Pytanie 48", "Poleceniu SELECT w bazie danych SQL odpowiada w protokole HTTP polecenie:");
        question48.setLevel(2);
        question48.setAnswer1("a) PUT");
        question48.setAnswer2("b) GET");
        question48.setAnswer3("c) POST");
        question48.setAnswer4("d) DELETE");
        question48.setCorrectAnswer(question48.getAnswer2());

        Question question49 = new Question("Pytanie 49", "Skrót ACID oznacza:");
        question49.setLevel(2);
        question49.setAnswer1("a) Niepodzielność, Spójność, Izolację, Trwałość");
        question49.setAnswer2("b) zbiór właściwości gwarantujących poprawne przetwarzanie transakcji w bazie danych SQL");
        question49.setAnswer3("c) Atomicity, Consistensity, Isolation, Durability");
        question49.setAnswer4("d) wszystkie powyższe odpowiedzi są poprawne");
        question49.setCorrectAnswer(question49.getAnswer4());

        Question question50 = new Question("Pytanie 50", "Teoria CAP nie oznacza:");
        question50.setLevel(2);
        question50.setAnswer1("a) Consistency, Availability, Partition Tolerance");
        question50.setAnswer2("b) spójność, dostępność, odporność na podział");
        question50.setAnswer3("c) teorii w myśl której każda baza danych może spełnić wszystkie z trzech jej założeń");
        question50.setAnswer4("d) teorii w myśl której każda baza danych może spełnić tylko dwie z trzech jej założeń");
        question50.setCorrectAnswer(question50.getAnswer3());

        Question question51 = new Question("Pytanie 51", "BASE to:");
        question51.setLevel(3);
        question51.setAnswer1("a) Basically Available, Soft state, Eventual consistency");
        question51.setAnswer2("b) kompromis, który osiągają bazy NoSQL, nie mogąc spełnić ACID");
        question51.setAnswer3("c) jedna z implementacji teorii CAP");
        question51.setAnswer4("d) odpowiedzi a i b są poprawne");
        question51.setCorrectAnswer(question51.getAnswer4());

        Question question52 = new Question("Pytanie 52", "Do typów baz danych NoSQL nie należą:");
        question52.setLevel(3);
        question52.setAnswer1("a) bazy danych klucz-wartość");
        question52.setAnswer2("b) bazy danych obiektowe");
        question52.setAnswer3("c) bazy danych grafowe");
        question52.setAnswer4("d) bazy danych kolumnowe");
        question52.setCorrectAnswer(question52.getAnswer2());

        Question question53 = new Question("Pytanie 53", "Podstawowe interfejsy JDBC to:");
        question53.setLevel(3);
        question53.setAnswer1("a) Connection, Statement, PreparedStatement, ResultSet");
        question53.setAnswer2("b) Runtime, Serializable, ResultSet");
        question53.setAnswer3("c) JDBCConnector, JDBCUpload, JDBCRuntime");
        question53.setAnswer4("d) JDBC nie korzysta z interfejsów, tylko z klas abstrakcyjnych");
        question53.setCorrectAnswer(question53.getAnswer1());

        Question question54 = new Question("Pytanie 54", "Co to jest SQL Injection:");
        question54.setLevel(3);
        question54.setAnswer1("a) wstrzykiwanie zależności do SQL-a");
        question54.setAnswer2("b) wstrzykiwanie zapytań SQL-owych do bazy NoSQL-owej");
        question54.setAnswer3("c) rodzaj ataku, który opiera się na nieodpowiednim filtrowaniu znaków ucieczki z danych wejściowych, co może doprowadzić do zniszczenia danych");
        question54.setAnswer4("d) to jeden z poziomów izolacji transakcji, który w praktyce powoduje ignorowanie założonych blokad na transakcji");
        question54.setCorrectAnswer(question54.getAnswer3());

        Question question55 = new Question("Pytanie 55", "Co to jest ORM:");
        question55.setLevel(3);
        question55.setAnswer1("a) mapowanie obiektowo-ralacyjne");
        question55.setAnswer2("b) Object Runtime Management, czyli sposób zarządzania wykonywaniem metod przez obiekty");
        question55.setAnswer3("c) jedno z rozszerzeń plików ukrytych w Javie");
        question55.setAnswer4("d) część jądra JVM");
        question55.setCorrectAnswer(question55.getAnswer1());

        Question question56 = new Question("Pytanie 56", "Z jakich komponentów nie składa się Hibernate:");
        question56.setLevel(3);
        question56.setAnswer1("a) encji");
        question56.setAnswer2("b) konstruktorów");
        question56.setAnswer3("c) meta informacji obiektowo-relacyjnych (adnotacje lub plik .xml)");
        question56.setAnswer4("d) języka HQL");
        question56.setCorrectAnswer(question56.getAnswer2());

        Question question57 = new Question("Pytanie 57", "HATEOAS to nie jest:");
        question57.setLevel(3);
        question57.setAnswer1("a) Hypermedia As The Engine Of Application State");
        question57.setAnswer2("b) jeden z constrainów aplikacji tworzonych w architekturze REST");
        question57.setAnswer3("c) standard mówiący, że aplikacja powinna pozwalać na sterowanie poprzez dodatkowe informacje pozwalające na poruszanie się po API REST-owym");
        question57.setAnswer4("d) idea mówiąca o przekazywaniu z obiektem adresu IP obiektów powiązanych");
        question57.setCorrectAnswer(question57.getAnswer4());

        Question question58 = new Question("Pytanie 58", "Które stwierdzenie dotyczące REST jest nieprawdziwe:");
        question58.setLevel(3);
        question58.setAnswer1("a) skrót REST tłumaczy się, jako zmiana stanu poprzez reprezentacje");
        question58.setAnswer2("b) REST to styl architektury oprogramowania wywiedziony z doświadczeń przy pisaniu specyfikacji protokołu HTTP dla systemów rozproszonych");
        question58.setAnswer3("c) REST to Relational Exchange Software Transfer");
        question58.setAnswer4("d) REST wykorzystuje m.in. jednorodny interfejs, bezstanową komunikację, zasoby, reprezentacje, hipermedia, HATEOAS");
        question58.setCorrectAnswer(question58.getAnswer3());

        Question question59 = new Question("Pytanie 59", "Co to jest P2P:");
        question59.setLevel(3);
        question59.setAnswer1("a) rodzaj umowy biznesowej między programistą a firmą na zasadzie działalności gospodarczej");
        question59.setAnswer2("b) P2P to pair programming, czyli praktyka programowania w parach wywodząca się z metodyki extreme programming");
        question59.setAnswer3("c) odmiana architektury klient-serwer, w której każdy host może pełnić jednocześnie rolę klienta i rolę serwera");
        question59.setAnswer4("d) rodzaj serwera, który mapuje nazwy domenowe na IP");
        question59.setCorrectAnswer(question59.getAnswer3());

        Question question60 = new Question("Pytanie 60", "Singleton, prototype, request, session, application, websocket to:");
        question60.setLevel(3);
        question60.setAnswer1("a) atrubuty Beana");
        question60.setAnswer2("b) zasięgi Beana");
        question60.setAnswer3("c) scope Beana");
        question60.setAnswer4("d) odpowiedzi b i c są poprawne");
        question60.setCorrectAnswer(question60.getAnswer4());

        questionRepository.save(question1);
        questionRepository.save(question2);
        questionRepository.save(question3);
        questionRepository.save(question4);
        questionRepository.save(question5);
        questionRepository.save(question6);
        questionRepository.save(question7);
        questionRepository.save(question8);
        questionRepository.save(question9);
        questionRepository.save(question10);
        questionRepository.save(question11);
        questionRepository.save(question12);
        questionRepository.save(question13);
        questionRepository.save(question14);
        questionRepository.save(question15);
        questionRepository.save(question16);
        questionRepository.save(question17);
        questionRepository.save(question18);
        questionRepository.save(question19);
        questionRepository.save(question20);
        questionRepository.save(question21);
        questionRepository.save(question22);
        questionRepository.save(question23);
        questionRepository.save(question24);
        questionRepository.save(question25);
        questionRepository.save(question26);
        questionRepository.save(question27);
        questionRepository.save(question28);
        questionRepository.save(question29);
        questionRepository.save(question30);
        questionRepository.save(question31);
        questionRepository.save(question32);
        questionRepository.save(question33);
        questionRepository.save(question34);
        questionRepository.save(question35);
        questionRepository.save(question36);
        questionRepository.save(question37);
        questionRepository.save(question38);
        questionRepository.save(question39);
        questionRepository.save(question40);
        questionRepository.save(question41);
        questionRepository.save(question42);
        questionRepository.save(question43);
        questionRepository.save(question44);
        questionRepository.save(question45);
        questionRepository.save(question46);
        questionRepository.save(question47);
        questionRepository.save(question48);
        questionRepository.save(question49);
        questionRepository.save(question50);
        questionRepository.save(question51);
        questionRepository.save(question52);
        questionRepository.save(question53);
        questionRepository.save(question54);
        questionRepository.save(question55);
        questionRepository.save(question56);
        questionRepository.save(question57);
        questionRepository.save(question58);
        questionRepository.save(question59);
        questionRepository.save(question60);
    }
}