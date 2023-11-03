package pt.ipleiria.estg.dei.ei.dae.backend.ws;


import jakarta.ejb.EJB;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import pt.ipleiria.estg.dei.ei.dae.backend.dtos.ProdutoDTO;
import pt.ipleiria.estg.dei.ei.dae.backend.ejbs.ProdutoBean;
import pt.ipleiria.estg.dei.ei.dae.backend.entities.Produto;

import java.util.List;
import java.util.stream.Collectors;

@Path("/produtos")
@Produces({MediaType.APPLICATION_JSON}) // injects header “Content-Type: application/json”
@Consumes({MediaType.APPLICATION_JSON}) // injects header “Accept: application/json”
public class ProdutoService {
    @EJB
    private ProdutoBean produtoBean;

    // Converts an entity Student to a DTO Student class
    private ProdutoDTO toDTO(Produto produto) {
        return new ProdutoDTO(
                produto.getId(),
                produto.getNomeProduto(),
                produto.getFabricante().getId()
        );
    }
    // converts an entire list of entities into a list of DTOs
    private List<ProdutoDTO> toDTOs(List<Produto> produtos) {
        return produtos.stream().map(this::toDTO).collect(Collectors.toList());
    }
    @GET // means: to call this endpoint, we need to use the HTTP GET method
    @Path("/") // means: the relative url path is “/api/students/”
    public List<ProdutoDTO> getAllProducts() {
        return toDTOs(produtoBean.getAllProducts());
    }
}
