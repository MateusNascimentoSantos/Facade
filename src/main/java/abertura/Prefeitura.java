package abertura;

public class Prefeitura extends Orgao {

    private static Prefeitura prefeitura = new Prefeitura();

    private Prefeitura() {};

    public static Prefeitura getInstancia() {
        return prefeitura;
    }

    public boolean emitirAlvara(Empresa empresa) {
        if (empresa.getCnpj() == null) {
            return false;
        }
        if (this.verificarImpedimento(empresa)) {
            return false;
        }
        empresa.setAlvara("Alvara 2026/0458");
        return true;
    }
}
