package abertura;

import java.util.ArrayList;
import java.util.List;

public abstract class Orgao {

    private List<Empresa> empresasImpedidas = new ArrayList<Empresa>();

    public void addEmpresaImpedida(Empresa empresa) {
        this.empresasImpedidas.add(empresa);
    }

    public boolean verificarImpedimento(Empresa empresa) {
        return this.empresasImpedidas.contains(empresa);
    }

}
