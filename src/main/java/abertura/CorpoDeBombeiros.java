package abertura;

public class CorpoDeBombeiros extends Orgao {

    private static CorpoDeBombeiros corpoDeBombeiros = new CorpoDeBombeiros();

    private CorpoDeBombeiros() {};

    public static CorpoDeBombeiros getInstancia() {
        return corpoDeBombeiros;
    }

    public boolean emitirAvcb(Empresa empresa) {
        if (empresa.getAlvara() == null) {
            return false;
        }
        if (this.verificarImpedimento(empresa)) {
            return false;
        }
        empresa.setAvcb("AVCB 7781");
        return true;
    }
}
