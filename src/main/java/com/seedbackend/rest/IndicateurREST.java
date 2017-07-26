/**
 * 
 */
package com.seedbackend.rest;

import java.io.IOException;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.Session;
import com.seedbackend.model.Indice;
import com.seedbackend.service.IndiceService;
import com.seedbackend.util.HibernateUtils;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Produces;


/**
 * @author Abdenour BAHLOUL
 *
 */
@Path("/indicateur")
@ManagedBean
public class IndicateurREST {

	@Inject
	private IndiceService serviceIndice;

	@GET
	@Path("/")
	public Response getDefault() {

		String output  = serviceIndice.getAll().get(5).getChampA() + "--" +  serviceIndice.getAll().get(4).getChampB();

		return Response
				.status(200)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Headers",
						"origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", 
						"GET, POST, PUT, DELETE, OPTIONS, HEAD")
				.entity(output)
				.build();
	}

	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) throws JsonGenerationException, JsonMappingException, IOException {

		Indice indice = new Indice();

		indice.setChampA("A0");
		indice.setChampB("B0");
		indice.setChampC("C0");
		indice.setChampD("D0");

		Session session = HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(indice);
		session.getTransaction().commit();
		session.close();

		String output  = serviceIndice.bouchonDonnee().get(0).getChampA();

		return Response
				.status(200)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Headers",
						"origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", 
						"GET, POST, PUT, DELETE, OPTIONS, HEAD")
				.entity(output)
				.build();
	}

	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMsgJson() throws JsonGenerationException, JsonMappingException, IOException {

		ObjectMapper mapper = new ObjectMapper();

		String output = "[";
		String jsonInString;

		// Décommenter ce code si la base de données n'a pas été crée 
		/*  
			for (Indice indice : serviceIndice.bouchonDonnees()) {
				jsonInString = mapper.writeValueAsString(indice);
				output += jsonInString + ","; 
			}
		 */

		for (Indice indice : serviceIndice.getAll()) {
			jsonInString = mapper.writeValueAsString(indice);
			output += jsonInString + ","; 
		}

		output = output.substring(0, output.length() - 1) + "]";

		return Response
				.status(200)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Headers",
						"origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", 
						"GET, POST, PUT, DELETE, OPTIONS, HEAD")
				.entity(output)
				.build();
	}

	@GET
	@Path("/get/{param}")
	public Response getIndice(@PathParam("param") String msg) throws JsonGenerationException, JsonMappingException, IOException {

		Indice indice = null;
		String output = null;

		try {
			indice = serviceIndice.get(Long.parseLong(msg));
		} catch (NumberFormatException e) {
			output = "Pas d indicateur pour cette valeur";  
		}

		if (indice != null )
			output  = indice.toString(); 

		return Response
				.status(200)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Headers",
						"origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", 
						"GET, POST, PUT, DELETE, OPTIONS, HEAD")
				.entity(output)
				.build();
	}

	
	/**
	 * Cette 
	 */
	@GET
	@Path("/update/{param}")
	public Response updateIndice(@PathParam("param") String msg) throws JsonGenerationException, JsonMappingException, IOException {

		Indice indice = new Indice(7l, "champA", "champB", "champC", "champD", "indicateur1", "modif1"," indicateur2", "modif2");
		String output = null;

		try {
			
			//indice.setChampA("ZZZZZ");
			serviceIndice.update(indice);
		} catch (NumberFormatException e) {
			output = "Pas d indicateur pour cette valeur";  
		}

		if (indice != null )
			output  = indice.toString(); 

		return Response
				.status(200)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Credentials", "true")
				.header("Access-Control-Allow-Headers",
						"origin, content-type, accept, authorization")
				.header("Access-Control-Allow-Methods", 
						"GET, POST, PUT, DELETE, OPTIONS, HEAD")
				.entity(output)
				.build();
	}

	@Path("/listAll")
	@GET
	@Produces( "application/json")
	public List<Indice> listAll() {
		
		final List<Indice> results = serviceIndice.getAll();
		return results;
	}



	/*

    @GET
    @Produces({"application/xml", "application/json"})
    public List<Book> listAll(@QueryParam("start") Integer startPosition,
                              @QueryParam("max") Integer maxResult) {
        TypedQuery<Book> findAllQuery = em
                .createQuery(
                        "SELECT DISTINCT b FROM Book b LEFT JOIN FETCH b.category LEFT JOIN FETCH b.authors LEFT JOIN FETCH b.publisher ORDER BY b.id",
                        Book.class);
        if (startPosition != null) {
            findAllQuery.setFirstResult(startPosition);
        }
        if (maxResult != null) {
            findAllQuery.setMaxResults(maxResult);
        }
        final List<Book> results = findAllQuery.getResultList();
        return results;
    }


	 * */

}
