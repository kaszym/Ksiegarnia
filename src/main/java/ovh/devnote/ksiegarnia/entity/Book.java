package ovh.devnote.ksiegarnia.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "ksiazki")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "nazwa")
    private String nazwa;
    @Column(name = "wydawnictwo")
    private String wydawnictwo;
    @Column(name = "cena")
    private float cena;
    @ManyToOne
    @JoinColumn(name="kategoria_id")
    private Category kategoria;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "autorzy_to_ksiazki",
            joinColumns = @JoinColumn(name = "ksiazka_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private Set<Author> autorzy;
    public Book() { }
    public Book(String nazwa, String wydawnictwo, float cena) {
        this.nazwa = nazwa;
        this.wydawnictwo = wydawnictwo;
        this.cena = cena;
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
    public String getWydawnictwo() {
        return wydawnictwo;
    }
    public void setWydawnictwo(String wydawnictwo) {
        this.wydawnictwo = wydawnictwo;
    }
    public float getCena() {
        return cena;
    }
    public void setCena(float cena) {
        this.cena = cena;
    }
    public Category getKategoria() {
        return kategoria;
    }
    public void setKategoria(Category kategoria) {
        this.kategoria = kategoria;
    }
    public Set<Author> getAutorzy() {
        return autorzy;
    }
    public void setAutorzy(Set<Author> autorzy) {
        this.autorzy = autorzy;
    }
    public void addAutor(Author autor) {
        if (autorzy == null)
            autorzy = new HashSet<>();
        autorzy.add(autor);
    }
    @Override
    public String toString() {
        return "Ksiazka{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                ", wydawnictwo='" + wydawnictwo + '\'' +
                ", cena=" + cena +
//                ", kategoria=" + kategoria +
                '}';
    }
}
