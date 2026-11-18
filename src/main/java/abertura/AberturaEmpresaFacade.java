package abertura;

public class AberturaEmpresaFacade {

    public static boolean abrir(Empresa empresa) {
        if (!JuntaComercial.getInstancia().registrarContratoSocial(empresa)) {
            return false;
        }
        if (!ReceitaFederal.getInstancia().emitirCnpj(empresa)) {
            return false;
        }
        if (!Prefeitura.getInstancia().emitirAlvara(empresa)) {
            return false;
        }
        if (!CorpoDeBombeiros.getInstancia().emitirAvcb(empresa)) {
            return false;
        }
        return true;
    }
}
