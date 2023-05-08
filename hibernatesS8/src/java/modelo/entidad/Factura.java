package modelo.entidad;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "factura", catalog = "fact")
public class Factura implements java.io.Serializable {
    private String noFactura;
    private Cliente cliente;
    private String descripcion;
    private Set<Detfact> detfacts = new HashSet(0);

    public Factura() {
    }

    public Factura(String noFactura) {
        this.noFactura = noFactura;
    }

    public Factura(String noFactura, Cliente cliente, String descripcion) {
        this.noFactura = noFactura;
        this.cliente = cliente;
        this.descripcion = descripcion;
    }

    @Id
    @Column(name = "noFactura", unique = true, nullable = false, length = 10)
    public String getNoFactura() {
        return this.noFactura;
    }

    public void setNoFactura(String noFactura) {
        this.noFactura = noFactura;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "idCliente")
    public Cliente getCliente() {
        return this.cliente;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Column(name = "descripcion", length = 100)
    public String getDescripcion() {
        return this.descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "factura", cascade=CascadeType.ALL)
    public Set<Detfact> getDetfacts() {
        return this.detfacts;
    }
    public void setDetfacts(Set<Detfact> detfacts) {
        this.detfacts = detfacts;
    }

}
