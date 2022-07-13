package com.meet.restapicliente.service;

import com.meet.restapicliente.dto.ClienteDto;
import com.meet.restapicliente.model.Cliente;

import java.util.List;

public interface ClienteService {
    List<Cliente> mostrarTodos();

    ClienteDto mostrarClienteDNI(int dni);

    List<ClienteDto>mostrarListaEdad();
}
