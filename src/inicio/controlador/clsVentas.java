
package inicio.controlador;

/**
 *
 * @author Edwin
 */
public class clsVentas { 
 private int conid; 
 private int comid;
 private int provid;
 private int cuentasaldo;
 private int cuentavalor;
 private int cuentareferencia;
 private String cuentafechaemi;
 private String cuentafechavenci;
 
public clsVentas() {
}

    public clsVentas (int conid, int comid, int provid, int cuentadoc, int cuentasaldo, int cuentavalor, int cuentareferencia, String cuentafechaemi, String cuentafechavenci) {
        
        this.conid = conid;
        this.comid = comid;
        this.provid = provid;
        this.cuentasaldo = cuentasaldo;
        this.cuentavalor = cuentavalor;
        this.cuentareferencia = cuentareferencia;
        this.cuentafechaemi = cuentafechaemi;
        this.cuentafechavenci = cuentafechavenci;   
    }
    
    public int getConid() {
        return conid;
    }

    public void setConid(int conid) {
        this.conid = conid;
    }
    
    public int getComid() {
        return comid;
    }

    public void setComid(int comid) {
        this.comid = comid;
    }

    public int getProvid() {
        return provid;
    }

    public void setProvid(int provid) {
        this.provid = provid;
    }

    public int getCuentasaldo() {
        return cuentasaldo;
    }

    public void setCuentasaldo(int cuentasaldo) {
        this.cuentasaldo = cuentasaldo;
    }

    public int getCuentavalor() {
        return cuentavalor;
    }

    public void setCuentavalor(int cuentavalor) {
        this.cuentavalor = cuentavalor;
    }

    public int getCuentareferencia() {
        return cuentareferencia;
    }

    public void setCuentareferencia(int cuentareferencia) {
        this.cuentareferencia = cuentareferencia;
    }

    public String getCuentafechaemi () {
        return cuentafechaemi;
    }
    
    public void setCuentafechaemi(String cuentafechaemi) {
        this.cuentafechaemi = cuentafechaemi;
    }
    
    public String getCuentafechavenci () {
        return cuentafechavenci;
    }
    
    public void setCuentafechavenci(String cuentafechavenci) {
        this.cuentafechavenci = cuentafechavenci;
    }
    
    
    @Override
    public String toString() {
        return "clsCuentasPorPagar{" + ", conid=" + conid + ", comid=" + comid + ", provid=" + provid + ", cuentasaldo=" + cuentasaldo + ", cuentavalor=" + cuentavalor + ", cuentareferencia=" + cuentareferencia + ", cuentafechaemi=" + cuentafechaemi + ", cuentafechavenci=" + cuentafechavenci + '}';
    }
}
