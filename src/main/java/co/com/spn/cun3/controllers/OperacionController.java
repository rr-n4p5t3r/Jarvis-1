package co.com.spn.cun3.controllers;

import co.com.spn.cun3.db.entities.Operacion;
import co.com.spn.cun3.db.repositories.OperacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/operacion")
public class OperacionController {

    @Autowired
    private OperacionRepository operacionRepository;


    @GetMapping("/operaciones/usuario/{usuario}")
    public List<Operacion> getOperacionesPorUsuario(@PathVariable String usuario) {
        return operacionRepository.operacionesPorUsuario(usuario);
    }

    @GetMapping("/operaciones/nit/{nit}")
    public List<Operacion> getOperacionesPorNit(@PathVariable String nit) {
        return operacionRepository.operacionesPorNit(nit);
    }

}
