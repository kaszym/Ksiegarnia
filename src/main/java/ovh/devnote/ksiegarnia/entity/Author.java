package ovh.devnote.ksiegarnia.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "autorzy")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "imie")
    private String imie;
    @Column(name = "nazwisko")
    private String nazwisko;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "autorzy_to_ksiazki",
            joinColumns = @JoinColumn(name = "autor_id"),
            inverseJoinColumns = @JoinColumn(name = "ksiazka_id")
    )
    private Set<Book> ksiazki;
    public Author() {}
    public Author(String imie, String nazwisko) {
        this.imie = imie;
        this.nazwisko = nazwisko;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getImie() {
        return imie;
    }
    public void setImie(String imie) {
        this.imie = imie;
    }
    public String getNazwisko() {
        return nazwisko;
    }
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }
    public Set<Book> getKsiazki() {
        return ksiazki;
    }
    public void setKsiazki(Set<Book> ksiazki) {
        this.ksiazki = ksiazki;
    }
    public void addKsiazka(Book ksiazka) {
        if (ksiazki == null) {
            ksiazki = new HashSet<>();
        }
        ksiazki.add(ksiazka);
    }

    @Override
    public String toString() {
        return  imie + " " + nazwisko;
    }
}