package servicios;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import modelo.dao.daoCliente;

@Path("cliente")
public class servicioCliente {

    @Context
    private UriInfo context;

    public servicioCliente() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getClientes() {
        daoCliente dc = new daoCliente();
        return Response.ok(dc.getAll()).build();
    }

//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void putJson(String content) {
//    }
}
