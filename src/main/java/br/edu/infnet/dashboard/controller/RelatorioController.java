package br.edu.infnet.dashboard.controller;

import br.edu.infnet.dashboard.model.domain.Atividade;
import br.edu.infnet.dashboard.model.domain.Aula;
import br.edu.infnet.dashboard.model.domain.Log;
import br.edu.infnet.dashboard.model.service.AulaService;
import br.edu.infnet.dashboard.model.service.LogService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class RelatorioController {

    @Autowired
    private AulaService aulaService;
    @Autowired
    private LogService logService;

    @GetMapping(value = "/generate")
    public String emissaoRelatorio(Model model) {

        Workbook workbook = new XSSFWorkbook();

        Sheet abaAtividades = workbook.createSheet("Atividades");

        String[] columns = {"Data", "Duracao",
                "NomeProfessor", "EmailProfessor", "CPFProfessor", "UFProfessor",
                "DescricaoAtividade", "IntensidadeAtividade"
        };

        Row headerRow = abaAtividades.createRow(0);

        for (int i = 0; i < columns.length; i++) {
            headerRow.createCell(i).setCellValue(columns[i]);
        }

        List<Aula> aulas = aulaService.obterLista();

        int rowNum = 0;

        for (Aula aula : aulas) {

            for (Atividade atividade : aula.getAtividades()) {
                Row row = abaAtividades.createRow(++rowNum);

                row.createCell(0).setCellValue(
                        aula.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
                );
                row.createCell(1).setCellValue(aula.getDuracao());
                row.createCell(2).setCellValue(aula.getProfessor().getNome());
                row.createCell(3).setCellValue(aula.getProfessor().getEmail());
                row.createCell(4).setCellValue(aula.getProfessor().getCpf());
                row.createCell(5).setCellValue(
                        aula.getProfessor().getEndereco() != null ?
                                aula.getProfessor().getEndereco().getUf() : ""
                );
                row.createCell(6).setCellValue(atividade.getDescricao());
                row.createCell(7).setCellValue(atividade.getIntensidade());
            }
        }

        LocalDateTime hoje = LocalDateTime.now();

        String arquivo = "atividades" + hoje.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")) + ".xlsx";

        String mensagem = null;
        try {
            workbook.write(new FileOutputStream(arquivo));

            workbook.close();

            mensagem = "A planilha gerada está disponível no diretório padrão!!!";

        } catch (IOException e) {
            mensagem = "Problemas na geração da planilha!!!";

            e.printStackTrace();
        }

        Log log = new Log();
        log.setData(hoje);
        log.setNome(mensagem);

        logService.incluir(log);

        return "redirect:/";
    }
}
