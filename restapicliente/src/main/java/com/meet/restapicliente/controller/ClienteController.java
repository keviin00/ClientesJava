package com.meet.restapicliente.controller;

import com.meet.restapicliente.dto.ClienteDto;
import com.meet.restapicliente.model.Cliente;
import com.meet.restapicliente.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping()
    public List<Cliente> mostrarTablaOriginal(){
        return clienteService.mostrarTodos() ;
    }

    @GetMapping("/{dni}")
    public ClienteDto mostrarDNI(@PathVariable int dni){
        return clienteService.mostrarClienteDNI(dni) ;
    }

    @GetMapping("/all")
    public List<ClienteDto>mostrarTablaEdad(){

        return clienteService.mostrarListaEdad();
    }

}
