package ovh.devnote.ksiegarnia.entity;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "kategorie")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "nazwa")
    private String nazwa;
    @OneToMany(mappedBy = "kategoria")
    private List<Book> ksiazki;

    public Category() { }

//    public Kategoria(String nazwa) {
//        this.nazwa = nazwa;
//    }

    public Category(String id) {
        this.id = Integer.parseInt(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public List<Book> getKsiazki() {
        return ksiazki;
    }

    public void setKsiazki(List<Book> ksiazki) {
        this.ksiazki = ksiazki;
    }

    @Override
    public String toString() {
        return "Kategoria{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                '}';
    }
}
