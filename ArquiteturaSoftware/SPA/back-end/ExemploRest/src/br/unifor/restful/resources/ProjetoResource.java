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

import br.unifor.restful.model.ProjetoVO;

@Path("/projeto")
public class ProjetoResource {

	static private Map<Integer, ProjetoVO> projetosMap;

	static {
		
		projetosMap = new HashMap<Integer, ProjetoVO>();

		ProjetoVO p1 = new ProjetoVO();
		p1.setId(1L);
		p1.setNome("Projeto X");
		p1.setDescricao("Projeto X - 1989");
		projetosMap.put(p1.getId().intValue(), p1);

		ProjetoVO p2 = new ProjetoVO();
		p2.setId(2L);
		p2.setNome("Projeto Y");
		p2.setDescricao("Projeto Y - 1959");
		projetosMap.put(p2.getId().intValue(), p2);

	}
	
	@GET
	@Produces("application/json")
	public Collection<ProjetoVO> lista() {
		return new ArrayList<ProjetoVO>(projetosMap.values());
	}

	@GET
	@Path("{id}")
	@Produces("application/json")
	public ProjetoVO busca(@PathParam("id") Long id) {
		System.out.println("ID: "+id);		
		return projetosMap.get(id.intValue());
	}

	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String insere(ProjetoVO projetoVO) {
		projetoVO.setId(projetosMap.size() + 1L);
		projetosMap.put(projetoVO.getId().intValue(), projetoVO);
		return "Projeto " + projetoVO.getNome() + " adicionado.";

	}

	@PUT
	@Consumes("application/json")
	@Produces("text/plain")
	public String altera(ProjetoVO projetoVO) {

		projetosMap.put(projetoVO.getId().intValue(), projetoVO);
		
		return "Projeto " + projetoVO.getNome() + "atualizado";
	
	}

	@Path("{id}")
	@DELETE
	@Produces("text/plain")
	public String remove(@PathParam("id") Long id) {
		
		projetosMap.remove(id.intValue());
		
		return "Projeto id: " + id.toString() + "removido" ;
	}

}
