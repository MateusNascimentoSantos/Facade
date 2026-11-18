package abertura;

public class ReceitaFederal extends Orgao {

    private static ReceitaFederal receitaFederal = new ReceitaFederal();

    private ReceitaFederal() {};

    public static ReceitaFederal getInstancia() {
        return receitaFederal;
    }

    public boolean emitirCnpj(Empresa empresa) {
        if (empresa.getNire() == null) {
            return false;
        }
        if (this.verificarImpedimento(empresa)) {
            return false;
        }
        empresa.setCnpj("CNPJ 12.345.678/0001-90");
        return true;
    }
}
