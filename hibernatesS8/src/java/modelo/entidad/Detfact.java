package modelo.entidad;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detfact", catalog = "fact")
public class Detfact implements java.io.Serializable {
    private int idDet;
    private Factura factura;
    private Producto producto;
    private Integer cantidad;

    public Detfact() {
    }

    public Detfact(Factura factura, Producto producto, Integer cantidad) {
        this.factura = factura;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    @Id @GeneratedValue(strategy=IDENTITY)
    @Column(name = "idDet", unique = true, nullable = false)
    public int getIdDet() {
        return this.idDet;
    }

    public void setIdDet(int idDet) {
        this.idDet = idDet;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "noFactura")
    public Factura getFactura() {
        return this.factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "idProducto")
    public Producto getProducto() {
        return this.producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Column(name = "cantidad")
    public Integer getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

}
