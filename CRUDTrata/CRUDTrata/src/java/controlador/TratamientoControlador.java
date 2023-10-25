/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package controlador;

import entidades.Tratamiento;
import facades.TratamientoFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author ACER
 */
@Named(value = "tratamientoControlador")
@SessionScoped
public class TratamientoControlador implements Serializable {

    //Entidades(importar als entidades)
    Tratamiento tratamiento;
    //Bean(importar el facade)
    @EJB
    private TratamientoFacade tratamientoFacade;
    
    @PostConstruct
    public void init(){
        tratamiento = new Tratamiento();
    }
    
    public TratamientoControlador() {
    }

    public Tratamiento getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(Tratamiento tratamiento) {
        this.tratamiento = tratamiento;
    }
    
    //METODOS DEL CRUD
    
    //REGISTRAR
    
    public String resgistrar(){
        tratamientoFacade.registrar(tratamiento);
        tratamiento = new Tratamiento();
        return "consultarTratamiento";
    }
    
    //ELIMINAR
    public void eliminar(Tratamiento tratamiento){
        tratamientoFacade.eliminar(tratamiento);
    }
    
    //PRE-ACTUALIZAR
    public String preActualizar(Tratamiento tratamiento){
        this.tratamiento = tratamiento;
        return "actualizarTratamiento";
    }
    
    //ACTUALIAR
    public String actualizar(){
        tratamientoFacade.editar(tratamiento);
        tratamiento = new Tratamiento();
        return "consultarTratamiento";
    }
    
    //CONSULTAR POR ID
    public Tratamiento buscarId(int idTratamiento){
        return tratamientoFacade.buscarId(idTratamiento);
    }
    
    //CONSTULTAR TODOS
    public List<Tratamiento> consultarTodos(){
        return tratamientoFacade.consultarTodo();
    }
    
}
