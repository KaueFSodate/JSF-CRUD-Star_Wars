package br.com.backend.Controller;


import br.com.backend.dao.PlanetaDAO;
import br.com.backend.models.Planeta;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.util.List;


@ManagedBean(name = "planetaController")
@RequestScoped
public class PlanetaController {

    @Inject
    private PlanetaDAO planetaDAO = new PlanetaDAO();

    private Planeta planeta;

    public PlanetaController() {
        planeta = new Planeta();
    }

    public PlanetaDAO getPlanetaDAO() {
        return planetaDAO;
    }

    public void setPlanetaDAO(PlanetaDAO planetaDAO) {
        this.planetaDAO = planetaDAO;
    }

    public Planeta getPlaneta() {
        return planeta;
    }

    public void setPlaneta(Planeta planeta) {
        this.planeta = planeta;
    }


    public void salvarPlaneta(Planeta planeta) {
        try {
            planeta.atualizarAparicoes();
            planetaDAO.salvar(planeta);

            // Redirecionar para a página index.xhtml
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext externalContext = facesContext.getExternalContext();
            externalContext.redirect("/backendkaue/views/index.xhtml");
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public List<Planeta> listarPlanetas() {
        try {
            List<Planeta> planetas = planetaDAO.buscarTodos();
            return planetas;
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }

    public void atualizarPlaneta(Planeta planeta) {
        try {
            planetaDAO.atualizar(planeta);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public List<Planeta> buscarPlanetasPorNome(String nome) {
        try {
            List<Planeta> planetas = planetaDAO.buscarPorNome(nome);
            return planetas;
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }

    public Planeta buscarPlanetaPorId(Long id) {
        try {
            Planeta planeta = planetaDAO.buscarPorId(id);
            return planeta;
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }
    }

    public void excluirPlaneta(Long id) {
        try {
            planetaDAO.excluir(id);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
