package abertura;

public class Empresa {

    private String razaoSocial;
    private String nire;
    private String cnpj;
    private String alvara;
    private String avcb;

    public Empresa(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public String getNire() {
        return nire;
    }

    public void setNire(String nire) {
        this.nire = nire;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getAlvara() {
        return alvara;
    }

    public void setAlvara(String alvara) {
        this.alvara = alvara;
    }

    public String getAvcb() {
        return avcb;
    }

    public void setAvcb(String avcb) {
        this.avcb = avcb;
    }

    public boolean abrir() {
        return AberturaEmpresaFacade.abrir(this);
    }
}
