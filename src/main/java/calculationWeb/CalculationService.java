package calculationWeb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import calculationWeb.CalculationEntity;

@Stateless
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CalculationService {
	@PersistenceContext
    private EntityManager entityManager;
	private ArrayList<CalculationEntity> list = new ArrayList<CalculationEntity>();
	@POST
	@Path("/calc")
	public Response setoperation(CalculationEntity c) {
		Response.ResponseBuilder builder = null;
		
		entityManager.persist(c);
		int number1 = c.getNumber1();
        int number2 = c.getNumber2();
        String operation = c.getOperation();
		double result = 0;
		if(c.getOperation().equals("+")) {
			result = number1+number2;
		}else if (c.getOperation().equals("-")) {
			result = number1-number2;
		}else if(c.getOperation().equals("*")) {
			result = number1*number2;
		}else if(c.getOperation().equals("/")) {
			result = number1/number2;
		}
		builder = Response.ok();
		builder = Response.accepted(result);
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("Result", result);
		return Response.ok(map).build();
	}
	
	@GET
    @Path("/calculations")
    public List<CalculationEntity> getAllCalculations() {
        TypedQuery<CalculationEntity> query = entityManager.createQuery("SELECT c FROM CalculationEntity c",CalculationEntity.class);
        return query.getResultList();
    }
	
	
}
