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
        student1.setLevel(1);
        student1.setRoles(new HashSet<>(Arrays.asList(student)));


       Student student2 = new Student();
        student2.setLevel(2);
        student2.setLogin("nowak");
        student2.setPassword(passwordEncoder.encode("haslo2"));
        student2.setName("Stefan");
        student2.setLastName("Nowak");
        student2.setRoles(new HashSet<>(Arrays.asList(student)));


        Student admin1 = new Student();
        admin1.setName("admin");
        admin1.setLogin("admin");
        admin1.setLevel(3);
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

        Question question13 = new Question("Pytanie 13", "Jaka jest różnica pomiędzy typami int, a Integer:");
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
        question25.setAnswer1("a) TAK, ale trzeba użyć tabeli widokowej (view)");
        question25.setAnswer2("b) TAK, przy użyciu UNION lub UNION ALL");
        question25.setAnswer3("c) TAK, przy użyciu INSERT INTO i SELECT");
        question25.setAnswer4("d) NIE, bo jest to proces dwuetapowy");
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
        question37.setCorrectAnswer(question33.getAnswer3());

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
    }

}