package abertura;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmpresaTest {

    @Test
    void deveAbrirEmpresaSemImpedimento() {
        Empresa empresa = new Empresa("Padaria Central LTDA");

        assertEquals(true, empresa.abrir());
        assertEquals("NIRE 3120000001", empresa.getNire());
        assertEquals("CNPJ 12.345.678/0001-90", empresa.getCnpj());
        assertEquals("Alvara 2026/0458", empresa.getAlvara());
        assertEquals("AVCB 7781", empresa.getAvcb());
    }

    @Test
    void naoDeveEmitirCnpjSemNire() {
        assertEquals(false, ReceitaFederal.getInstancia().emitirCnpj(new Empresa("Oficina Souza LTDA")));
    }

    @Test
    void naoDeveEmitirAlvaraSemCnpj() {
        assertEquals(false, Prefeitura.getInstancia().emitirAlvara(new Empresa("Oficina Souza LTDA")));
    }

    @Test
    void naoDeveEmitirAvcbSemAlvara() {
        assertEquals(false, CorpoDeBombeiros.getInstancia().emitirAvcb(new Empresa("Oficina Souza LTDA")));
    }

    @Test
    void naoDeveAbrirEmpresaImpedidaNaJuntaComercial() {
        Empresa empresa = new Empresa("Mercado Boa Compra LTDA");
        JuntaComercial.getInstancia().addEmpresaImpedida(empresa);

        assertEquals(false, empresa.abrir());
        assertNull(empresa.getNire());
    }

    @Test
    void naoDeveAbrirEmpresaImpedidaNaReceitaFederal() {
        Empresa empresa = new Empresa("Mercado Boa Compra LTDA");
        ReceitaFederal.getInstancia().addEmpresaImpedida(empresa);

        assertEquals(false, empresa.abrir());
        assertNotNull(empresa.getNire());
        assertNull(empresa.getCnpj());
    }

    @Test
    void naoDeveAbrirEmpresaImpedidaNaPrefeitura() {
        Empresa empresa = new Empresa("Mercado Boa Compra LTDA");
        Prefeitura.getInstancia().addEmpresaImpedida(empresa);

        assertEquals(false, empresa.abrir());
        assertNotNull(empresa.getCnpj());
        assertNull(empresa.getAlvara());
    }

    @Test
    void naoDeveAbrirEmpresaImpedidaNoCorpoDeBombeiros() {
        Empresa empresa = new Empresa("Mercado Boa Compra LTDA");
        CorpoDeBombeiros.getInstancia().addEmpresaImpedida(empresa);

        assertEquals(false, empresa.abrir());
        assertNotNull(empresa.getAlvara());
        assertNull(empresa.getAvcb());
    }

    @Test
    void deveRetornarSempreAMesmaInstanciaDosOrgaos() {
        assertSame(JuntaComercial.getInstancia(), JuntaComercial.getInstancia());
        assertSame(ReceitaFederal.getInstancia(), ReceitaFederal.getInstancia());
        assertSame(Prefeitura.getInstancia(), Prefeitura.getInstancia());
        assertSame(CorpoDeBombeiros.getInstancia(), CorpoDeBombeiros.getInstancia());
    }
}
