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
@Table(name = "cliente", catalog = "fact")
public class Cliente implements java.io.Serializable {

    private int idCliente;
    private String nombre;
    private String apellido;
    private Set<Factura> facturas = new HashSet(0);

    public Cliente() {
    }

    public Cliente( String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name = "idCliente", unique = true, nullable = false)
    public int getIdCliente() {
        return this.idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    @Column(name = "nombre", length = 100)
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "apellido", length = 100)
    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cliente")
    public Set<Factura> getFacturas() {
        return this.facturas;
    }

    public void setFacturas(Set<Factura> facturas) {
        this.facturas = facturas;
    }

}
