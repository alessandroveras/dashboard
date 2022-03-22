package br.edu.infnet.dashboard.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import br.edu.infnet.dashboard.model.domain.Atividade;
import br.edu.infnet.dashboard.model.domain.Aula;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infnet.dashboard.model.domain.Log;
import br.edu.infnet.dashboard.model.service.LogService;
import br.edu.infnet.dashboard.model.service.AulaService;

@Controller
public class RelatorioController {
	
	@Autowired
	private AulaService aulaService;
	@Autowired
	private LogService logService;

	@GetMapping(value = "/generate")
	public String emissaoRelatorio(Model model) {
		
		Workbook workbook = new XSSFWorkbook();
		
		Sheet abaProdutos = workbook.createSheet("Produtos");
				
		String[] columns = {"Data", "Descrição", "Tipo", 
							"Nome do solicitante", "E-mail do solicitante", "CPF do solicitante", "UF solicitante",
							"Descrição do produto", "Valor do produto"};

		Row headerRow = abaProdutos.createRow(0);
		
		for(int i = 0; i < columns.length; i++) {
			headerRow.createCell(i).setCellValue(columns[i]);
		}
		
		List<Aula> aulas = aulaService.obterLista();
		
		int rowNum = 0;
		
		for(Aula aula : aulas) {
			
			for(Atividade atividade : aula.getAtividades()) {
				Row row = abaProdutos.createRow(++rowNum);
				
				row.createCell(0).setCellValue(
						aula.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
					);
				row.createCell(2).setCellValue(aula.getDuracao());
				row.createCell(3).setCellValue(aula.getProfessor().getNome());
				row.createCell(4).setCellValue(aula.getProfessor().getEmail());
				row.createCell(5).setCellValue(aula.getProfessor().getCpf());
				row.createCell(6).setCellValue(
						aula.getProfessor().getEndereco() != null ?
								aula.getProfessor().getEndereco().getUf() : ""
							);
				row.createCell(7).setCellValue(atividade.getDescricao());
				row.createCell(8).setCellValue(atividade.getDuracaoMinutos());
			}
		}
		
		LocalDateTime hoje = LocalDateTime.now(); 
		
		String arquivo = "produtos"+hoje.format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"))+".xlsx";		

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
