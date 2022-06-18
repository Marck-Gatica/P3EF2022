
package inicio.controlador;

/**
 *
 * @author Edwin
 */
public class clsVentas { 
 private int codproducto;
 private int cantidadventa;
 private int costoventa;
 private int precioventa;
 
public clsVentas() {
}

    public clsVentas(int codproducto, int cantidadventa, int costoventa, int precioventa) {
        this.codproducto = codproducto;
        this.cantidadventa = cantidadventa;
        this.costoventa = costoventa;
        this.precioventa = precioventa;
    }

    public int getCodproducto() {
        return codproducto;
    }

    public void setCodproducto(int codproducto) {
        this.codproducto = codproducto;
    }

    public int getCantidadventa() {
        return cantidadventa;
    }

    public void setCantidadventa(int cantidadventa) {
        this.cantidadventa = cantidadventa;
    }

    public int getCostoventa() {
        return costoventa;
    }

    public void setCostoventa(int costoventa) {
        this.costoventa = costoventa;
    }

    public int getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(int precioventa) {
        this.precioventa = precioventa;
    }

    @Override
    public String toString() {
        return "clsVentas{" + "codproducto=" + codproducto + ", cantidadventa=" + cantidadventa + ", costoventa=" + costoventa + ", precioventa=" + precioventa + '}';
    }

} 