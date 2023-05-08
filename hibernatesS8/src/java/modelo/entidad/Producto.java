package modelo.entidad;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "producto", catalog = "fact")
public class Producto implements java.io.Serializable {
    private int idProducto;
    private String nomProducto;
    private Set<Detfact> detfacts = new HashSet(0);

    public Producto() {
    }

    public Producto(String nomProducto) {
        this.nomProducto = nomProducto;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idProducto", unique = true, nullable = false)
    public int getIdProducto() {
        return this.idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    @Column(name = "nomProducto", length = 100)
    public String getNomProducto() {
        return this.nomProducto;
    }

    public void setNomProducto(String nomProducto) {
        this.nomProducto = nomProducto;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "producto")
    public Set<Detfact> getDetfacts() {
        return this.detfacts;
    }

    public void setDetfacts(Set<Detfact> detfacts) {
        this.detfacts = detfacts;
    }

}
