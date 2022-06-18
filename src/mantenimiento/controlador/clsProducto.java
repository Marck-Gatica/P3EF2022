
package mantenimiento.controlador;

/**
 *
 * @author Edwin
 */
public class clsProducto {
    private int prodid;   
 private int provid;
 private String prodnombre;
 private String prodmarca;
 private String prodlinea;
 private int prodprecio;
 private String prodexistencia;
 
 

    public clsProducto() {
    }

    public clsProducto(int prodid, int provid, String prodnombre, String prodmarca, String prodlinea, int prodprecio, String prodexistencia) {
        this.prodid = prodid;
        this.provid = provid;
        this.prodnombre = prodnombre;
        this.prodmarca = prodmarca;
        this.prodlinea = prodlinea;
        this.prodprecio = prodprecio;
        this.prodexistencia = prodexistencia;
    }



    public int getProdid() {
        return prodid;
    }

    public void setProdid(int prodid) {
        this.prodid = prodid;
    }
 

    public int getProvid() {
        return provid;
    }

    public void setProvid(int provid) {
        this.provid = provid;
    }

    public String getProdnombre() {
        return prodnombre;
    }

    public void setProdnombre(String prodnombre) {
        this.prodnombre = prodnombre;
    }

    public String getProdmarca() {
        return prodmarca;
    }

    public void setProdmarca(String prodmarca) {
        this.prodmarca = prodmarca;
    }

    public int getProdprecio() {
        return prodprecio;
    }

    public void setProdprecio(int prodprecio) {
        this.prodprecio = prodprecio;
    }

    public String getProdlinea() {
        return prodlinea;
    }

    public void setProdlinea(String prodlinea) {
        this.prodlinea = prodlinea;
    }

    public String getProdexistencia() {
        return prodexistencia;
    }

    public void setProdexistencia(String prodexistencia) {
        this.prodexistencia = prodexistencia;
    }

    @Override
    public String toString() {
        return "clsProducto{" + "prodid=" + prodid + ", provid=" + provid + ", prodnombre=" + prodnombre + ", prodmarca=" + prodmarca + ", prodlinea=" + prodlinea + ", prodprecio=" + prodprecio + ", prodexistencia=" + prodexistencia + '}';
    }
    

    


 
 
}
