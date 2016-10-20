package br.unifor.restful.resources;


import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import br.unifor.restful.model.EstacionamentoVO;

@Path("/estacionamento")
public class EstacionamentoResource {

	
	static private Map<Integer, EstacionamentoVO> estacionamentoMap;

	static {
		
		estacionamentoMap = new HashMap<Integer, EstacionamentoVO>();

		EstacionamentoVO e1 = new EstacionamentoVO();
		e1.setId(1L);
		e1.setCodigo("1L2123123");
		estacionamentoMap.put(e1.getId().intValue(), e1);

		EstacionamentoVO e2 = new EstacionamentoVO();
		e2.setId(2L);
		e2.setCodigo("2Leewqe22");
		estacionamentoMap.put(e2.getId().intValue(), e2);

	}
	
	@GET
	@Produces("application/json")
	public Collection<EstacionamentoVO> lista() {
		return new ArrayList<EstacionamentoVO>(estacionamentoMap.values());
	}

	@GET
	@Path("{id}")
	@Produces("application/json")
	public EstacionamentoVO busca(@PathParam("id") Long id) {
		System.out.println("ID: "+id);		
		return estacionamentoMap.get(id.intValue());
	}

	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String insere(EstacionamentoVO estacionamentoVO) {
		estacionamentoVO.setId(estacionamentoMap.size() + 1L);
		estacionamentoMap.put(estacionamentoVO.getId().intValue(), estacionamentoVO);
		return "Estacionamento " + estacionamentoVO.getCodigo() + " adicionado.";

	}

	@PUT
	@Consumes("application/json")
	@Produces("text/plain")
	public String altera(EstacionamentoVO estacionamentoVO) {

		estacionamentoMap.put(estacionamentoVO.getId().intValue(), estacionamentoVO);
		
		return "Estacionamento " + estacionamentoVO.getCodigo() + "atualizado";
	
	}

	@Path("{id}")
	@DELETE
	@Produces("text/plain")
	public String remove(@PathParam("id") Long id) {
		
		estacionamentoMap.remove(id.intValue());
		
		return "Estacionamento id: " + id.toString() + "removido" ;
	}

	
}
