package mvctest.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import mvctest.domain.Endereco;
import mvctest.domain.Hotel;
import mvctest.service.ClienteRepository;

@RestController
@RequestMapping("/rest/hotels")
public class RestHotelController {

	Consulta consulta = new Consulta();

	RestTemplate template = new RestTemplate();

	Endereco idCidade = new Endereco();

	String latLong = "https://www.metaweather.com/api/location/search/?lattlong=" + consulta.endereco.getLoc();
	
	  
	
	
	ResponseEntity<List<Endereco>> listaLatitudeLong = template.exchange(latLong, HttpMethod.GET, null,
			new ParameterizedTypeReference<List<Endereco>>() {
			});
	List<Endereco> listaCodigoCidade = listaLatitudeLong.getBody();

	private ClienteRepository clienteRepository;

	
	
	@Autowired
	public RestHotelController(ClienteRepository clienteRepository) {
		this.clienteRepository = clienteRepository;
	}
	/** Método para criar novo funcionario
	 * POST /rest/hotels – cria um novo cliente
	* {
    * "nome": "Inserir nome do cliente",
    *  "idade": "inserir idade do cliente"
	*	}
     */
	@RequestMapping(method = RequestMethod.POST)
	public Hotel create(@RequestBody @Valid Hotel cliente) {

		for (Endereco codigoCidade : listaCodigoCidade) {
			idCidade.setWoeid(codigoCidade.getWoeid());
			System.out.println(idCidade.getWoeid());
		}
		String url2 = "https://www.metaweather.com/api/location/" + idCidade.getWoeid() + "/"; // objeto
		Endereco temperatura = template.getForObject(url2, Endereco.class);

		for (Endereco quote1 : temperatura.getConsolidated_weather()) {
			cliente.setTemperaturaMax(quote1.getMax_temp().substring(0, 4));
			cliente.setTemperaturaMin(quote1.getMin_temp().substring(0, 4));
		}
			cliente.setCidade(consulta.endereco.getCity());
				
		return this.clienteRepository.save(cliente);
	}

	/** Método Para listar todos os clientes salvos
	* GET /rest/hotels

     */
	@RequestMapping(method = RequestMethod.GET)
	public List<Hotel> list() {
		return this.clienteRepository.findAll();
	}

	
	/** Método Para listar todos os clientes salvos
	* 
	* Para consultar um cliente por id
	*GET /rest/hotels/:id
     */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Hotel get(@PathVariable("id") long id) {
		return this.clienteRepository.findOne(id);
	}

	/** Método Para listar todos os clientes salvos
	* 
	* Para atualizar um cliente por id
	* PUT /rest/hotels/:id
	* 
	* {
	* "id": inserir id cliente,
	* "nome": "insira nome",
	* "idade": "inserir idade",
	*  "cidade": " ",
	*   "temperaturaMax": "27.8",
	*   "temperaturaMin": "17.7"
	*   } 
     */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public Hotel update(@PathVariable("id") long id, @RequestBody @Valid Hotel hotel) {
		return clienteRepository.save(hotel);
	}

	
	/** Método Remover Cliente por id
	*DELETE /rest/hotels/:id
     */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Boolean> delete(@PathVariable("id") long id) {
		this.clienteRepository.delete(id);
		return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
	}

	public class Consulta {

		WebUtils ip = new WebUtils();
		BuscarIp client = new BuscarIp();
		Endereco endereco = client.buscaEnderecoPor(ip.getClientIp());

		@Component
		public class BuscarIp {
			public Endereco buscaEnderecoPor(String ip) {
				RestTemplate template = new RestTemplate();
				return template.getForObject("http://ipinfo.io/" + ip + "/geo", Endereco.class, ip);
			}
		}

		@Component
		public class WebUtils {

			private HttpServletRequest request;

			@Autowired
			public void setRequest(HttpServletRequest request) {
				this.request = request;
			}

			public String getClientIp() {

				String remoteAddr = "";

				if (request != null) {
					remoteAddr = request.getHeader("X-FORWARDED-FOR");
					if (remoteAddr == null || "".equals(remoteAddr)) {
						remoteAddr = request.getRemoteAddr();
					}
				}
				return remoteAddr;
			}
		}
	}
}
