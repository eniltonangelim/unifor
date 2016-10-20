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

import br.unifor.restful.model.DepartamentoVO;

@Path("departamento")
public class DepartamentoResource {

	static private Map<Integer, DepartamentoVO> departamentoMap;

	static {
		
		departamentoMap = new HashMap<Integer, DepartamentoVO>();

		DepartamentoVO d1 = new DepartamentoVO();
		d1.setId(1L);
		d1.setNome("Financeiro");
		d1.setCodigo("1Lfinanceiro");
		departamentoMap.put(d1.getId().intValue(), d1);

		DepartamentoVO d2 = new DepartamentoVO();
		d2.setId(2L);
		d2.setNome("Recursos Humanos");
		d2.setCodigo("2Lrh");
		departamentoMap.put(d2.getId().intValue(), d2);

	}
	
	@GET
	@Produces("application/json")
	public Collection<DepartamentoVO> lista() {
		return new ArrayList<DepartamentoVO>(departamentoMap.values());
	}

	@GET
	@Path("{id}")
	@Produces("application/json")
	public DepartamentoVO busca(@PathParam("id") Long id) {
		System.out.println("ID: "+id);		
		return departamentoMap.get(id.intValue());
	}

	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String insere(DepartamentoVO departamentoVO) {
		departamentoVO.setId(departamentoMap.size() + 1L);
		departamentoMap.put(departamentoVO.getId().intValue(), departamentoVO);
		return "Departamento " + departamentoVO.getCodigo() + " adicionado.";

	}

	@PUT
	@Consumes("application/json")
	@Produces("text/plain")
	public String altera(DepartamentoVO departamentoVO) {

		departamentoMap.put(departamentoVO.getId().intValue(), departamentoVO);
		
		return "Departamento " + departamentoVO.getCodigo() + "atualizado";
	
	}

	@Path("{id}")
	@DELETE
	@Produces("text/plain")
	public String remove(@PathParam("id") Long id) {
		
		departamentoMap.remove(id.intValue());
		
		return "Departamento id: " + id.toString() + "removido" ;
	}

	
}
