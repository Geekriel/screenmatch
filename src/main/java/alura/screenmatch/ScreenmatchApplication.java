package alura.screenmatch;

import alura.screenmatch.model.DadosSerie;
import alura.screenmatch.service.ConsumindoApi;
import alura.screenmatch.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		var consumoApi = new ConsumindoApi();
		var json = consumoApi.obterDados("http://www.omdbapi.com/?t=gilmore+girls&apikey=187c8763");
		System.out.println(json);
		ConverteDados conversor = new ConverteDados();
		DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
		System.out.println(dados);
	}
}
