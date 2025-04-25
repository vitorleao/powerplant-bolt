package dev.bolt.powerplant.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String datGeracaoConjuntoDados;
    private String datRalie;
    private String ideNucleoCEG;
    private String codCEG;
    private String sigUFPrincipal;
    private String dscOrigemCombustivel;
    private String sigTipoGeracao;
    private String nomEmpreendimento;
    private Double mdaPotenciaOutorgadaKw;
    private String dscPropriRegimePariticipacao;
    private String dscTipoConexao;
    private String nomConexao;
    private String mdaTensaoConexao;
    private String nomEmpresaConexao;
    private String numCnpjEmpresaConexao;
    private String dscViabilidade;
    private String dscSituacaoObra;
    private LocalDate datPrevisaoInicioObra;
    private LocalDate datContratoEPCOutorgado;
    private LocalDate datRecursoFinanceiroOutorgado;
    private LocalDate datCanteiroObraOutorgado;
    private LocalDate datCanteiroObraRealizado;
    private LocalDate datInicioObraOutorgado;
    private LocalDate datInicioObraRealizado;
    private LocalDate datConcretagemOutorgado;
    private LocalDate datConcretagemRealizado;
    private LocalDate datDesvioRioOutorgado;
    private LocalDate datDesvioRioRealizado;
    private LocalDate datMontagemOutorgado;
    private LocalDate datMontagemRealizado;
    private LocalDate datConclusaoTorresOutorgado;
    private LocalDate datConclusaoTorresRealizado;
    private LocalDate datEnchimentoOutorgado;
    private LocalDate datEnchimentoRealizado;
    private LocalDate datComissionamentoUGRealizado;
    private LocalDate datSisTransmissaoOutorgado;
    private LocalDate datSisTransmissaoRealizado;
    private LocalDate datConclusaoSisTransOutorgado;
    private LocalDate datConclusaoSisTransRealizado;
    private String dscJustificativaPrevisao;
    private String dscComercializacaoEnergia;
    private String dscSistema;
    private LocalDate datConclusaoTransporteRealizado;
    private String dscSituacaoCronograma;
    private String datRapeel;
    private String idcComplexo;
    private String nomComplexo;
    private LocalDate datEmissaoLP;
    private LocalDate datValidadeLP;
    private String dscSituacaoLP;
    private LocalDate datEmissaoLI;
    private LocalDate datValidadeLI;
    private String dscSituacaoLI;
    private LocalDate datSolicitacaoLO;
    private LocalDate datPrevistaEmissaoLO;
    private LocalDate datPrevMaxEmissaoLO;
    private LocalDate datEmissaoLO;
    private LocalDate datValidadeLO;
    private String dscSituacaoLO;
    private String nomSituacaoParAcesso;
    private LocalDate datSolicitacaoParAcesso;
    private LocalDate datEmissaoParAcesso;
    private String dscSitCCD;
    private LocalDate datValidadeCCD;
    private LocalDate datAssinaturaCCD;
    private String dscSitCCT;
    private LocalDate datValidadeCCT;
    private LocalDate datAssinaturaCCT;
    private String dscSituacaoCusd;
    private LocalDate datValidadeCusd;
    private LocalDate datAssinaturaCusd;
    private String dscSitCust;
    private LocalDate datValidadeCust;
    private LocalDate datAssinaturaCust;
    private String dscAtoOutorga;
    private String dscNumeroAto;
    private String nomOrgaoOutorgante;
    private String dscTipoOutorga;
    private LocalDate datEmissaoAto;

}