package abertura;

public class JuntaComercial extends Orgao {

    private static JuntaComercial juntaComercial = new JuntaComercial();

    private JuntaComercial() {};

    public static JuntaComercial getInstancia() {
        return juntaComercial;
    }

    public boolean registrarContratoSocial(Empresa empresa) {
        if (this.verificarImpedimento(empresa)) {
            return false;
        }
        empresa.setNire("NIRE 3120000001");
        return true;
    }
}
