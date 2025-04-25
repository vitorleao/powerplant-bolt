package dev.bolt.powerplant.service;

import com.opencsv.CSVReader;
import dev.bolt.powerplant.model.Usina;
import dev.bolt.powerplant.repository.UsinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;

@Service
public class CsvJobService {

    @Autowired
    private UsinaRepository repository;

    private static final String CSV_URL = "https://dadosabertos.aneel.gov.br/dataset/57e4b8b5-a5db-40e6-9901-27ca629d0477/resource/4a615df8-4c25-48fa-bbea-873a36a79518/download/ralie-usina.csv";

    @Scheduled(cron = "0 */2 * * * *")
    public void baixarECadastrarCSV() {
        System.out.println("Iniciando o job de download e cadastro do CSV...");
        try (InputStream in = new URL(CSV_URL).openStream();
             Reader reader = new InputStreamReader(in);
             CSVReader csvReader = new CSVReader(reader)) {

            List<String[]> linhas = csvReader.readAll();
            System.out.println("Total de linhas lidas: " + linhas.size());
            linhas.stream().skip(1).forEach(linha -> {
                try {
                    Usina usina = new Usina();
                    usina.setDatGeracaoConjuntoDados(linha[0]);
                    usina.setDatRalie(linha[1]);
                    usina.setIdeNucleoCEG(linha[2]);
                    usina.setCodCEG(linha[3]);
                    usina.setSigUFPrincipal(linha[4]);
                    usina.setDscOrigemCombustivel(linha[5]);
                    usina.setSigTipoGeracao(linha[6]);
                    usina.setNomEmpreendimento(linha[7]);
                    usina.setMdaPotenciaOutorgadaKw(Double.parseDouble(linha[8].replace(",", ".")));
                    usina.setDscPropriRegimePariticipacao(linha[9]);
                    usina.setDscTipoConexao(linha[10]);
                    usina.setNomConexao(linha[11]);
                    usina.setMdaTensaoConexao(linha[12]);
                    usina.setNomEmpresaConexao(linha[13]);
                    usina.setNumCnpjEmpresaConexao(linha[14]);
                    usina.setDscViabilidade(linha[15]);
                    usina.setDscSituacaoObra(linha[16]);
                    usina.setDatPrevisaoInicioObra(parseDate(linha[17]));
                    usina.setDatContratoEPCOutorgado(parseDate(linha[18]));
                    usina.setDatRecursoFinanceiroOutorgado(parseDate(linha[19]));
                    usina.setDatCanteiroObraOutorgado(parseDate(linha[20]));
                    usina.setDatCanteiroObraRealizado(parseDate(linha[21]));
                    usina.setDatInicioObraOutorgado(parseDate(linha[22]));
                    usina.setDatInicioObraRealizado(parseDate(linha[23]));
                    usina.setDatConcretagemOutorgado(parseDate(linha[24]));
                    usina.setDatConcretagemRealizado(parseDate(linha[25]));
                    usina.setDatDesvioRioOutorgado(parseDate(linha[26]));
                    usina.setDatDesvioRioRealizado(parseDate(linha[27]));
                    usina.setDatMontagemOutorgado(parseDate(linha[28]));
                    usina.setDatMontagemRealizado(parseDate(linha[29]));
                    usina.setDatConclusaoTorresOutorgado(parseDate(linha[30]));
                    usina.setDatConclusaoTorresRealizado(parseDate(linha[31]));
                    usina.setDatEnchimentoOutorgado(parseDate(linha[32]));
                    usina.setDatEnchimentoRealizado(parseDate(linha[33]));
                    usina.setDatComissionamentoUGRealizado(parseDate(linha[34]));
                    usina.setDatSisTransmissaoOutorgado(parseDate(linha[35]));
                    usina.setDatSisTransmissaoRealizado(parseDate(linha[36]));
                    usina.setDatConclusaoSisTransOutorgado(parseDate(linha[37]));
                    usina.setDatConclusaoSisTransRealizado(parseDate(linha[38]));
                    usina.setDscJustificativaPrevisao(linha[39]);
                    usina.setDscComercializacaoEnergia(linha[40]);
                    usina.setDscSistema(linha[41]);
                    usina.setDatConclusaoTransporteRealizado(parseDate(linha[42]));
                    usina.setDscSituacaoCronograma(linha[43]);
                    usina.setDatRapeel(linha[44]);
                    usina.setIdcComplexo(linha[45]);
                    usina.setNomComplexo(linha[46]);
                    usina.setDatEmissaoLP(parseDate(linha[47]));
                    usina.setDatValidadeLP(parseDate(linha[48]));
                    usina.setDscSituacaoLP(linha[49]);
                    usina.setDatEmissaoLI(parseDate(linha[50]));
                    usina.setDatValidadeLI(parseDate(linha[51]));
                    usina.setDscSituacaoLI(linha[52]);
                    usina.setDatSolicitacaoLO(parseDate(linha[53]));
                    usina.setDatPrevistaEmissaoLO(parseDate(linha[54]));
                    usina.setDatPrevMaxEmissaoLO(parseDate(linha[55]));
                    usina.setDatEmissaoLO(parseDate(linha[56]));
                    usina.setDatValidadeLO(parseDate(linha[57]));
                    usina.setDscSituacaoLO(linha[58]);
                    usina.setNomSituacaoParAcesso(linha[59]);
                    usina.setDatSolicitacaoParAcesso(parseDate(linha[60]));
                    usina.setDatEmissaoParAcesso(parseDate(linha[61]));
                    usina.setDscSitCCD(linha[62]);
                    usina.setDatValidadeCCD(parseDate(linha[63]));
                    usina.setDatAssinaturaCCD(parseDate(linha[64]));
                    usina.setDscSitCCT(linha[65]);
                    usina.setDatValidadeCCT(parseDate(linha[66]));
                    usina.setDatAssinaturaCCT(parseDate(linha[67]));
                    usina.setDscSituacaoCusd(linha[68]);
                    usina.setDatValidadeCusd(parseDate(linha[69]));
                    usina.setDatAssinaturaCusd(parseDate(linha[70]));
                    usina.setDscSitCust(linha[71]);
                    usina.setDatValidadeCust(parseDate(linha[72]));
                    usina.setDatAssinaturaCust(parseDate(linha[73]));
                    usina.setDscAtoOutorga(linha[74]);
                    usina.setDscNumeroAto(linha[75]);
                    usina.setNomOrgaoOutorgante(linha[76]);
                    usina.setDscTipoOutorga(linha[77]);
                    usina.setDatEmissaoAto(parseDate(linha[78]));

                    repository.save(usina);
                    System.out.println("Usina salva: " + usina.getNomEmpreendimento());
                } catch (Exception e) {
                    System.err.println("Erro ao processar linha: " + String.join(", ", linha));
                    e.printStackTrace();
                }
            });

        } catch (Exception e) {
            System.err.println("Erro ao baixar ou processar o CSV:");
            e.printStackTrace();
        }
        System.out.println("Job concluído.");
    }

    private LocalDate parseDate(String date) {
        try {
            return date == null || date.isEmpty() ? null : LocalDate.parse(date);
        } catch (Exception e) {
            System.err.println("Erro ao converter data: " + date);
            return null;
        }
    }
}