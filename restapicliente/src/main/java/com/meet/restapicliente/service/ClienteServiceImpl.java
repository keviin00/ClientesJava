package com.meet.restapicliente.service;

import com.meet.restapicliente.dto.ClienteDto;
import com.meet.restapicliente.model.Cliente;
import com.meet.restapicliente.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
@Service
public class ClienteServiceImpl implements ClienteService{
    @Autowired
    ClienteRepository clienteRepository;

    Cliente cliente;
    int edad;
    List<Cliente> copialista;
    List<ClienteDto> listaamostar = new ArrayList<>();

    @Override
    public List<Cliente> mostrarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public ClienteDto mostrarClienteDNI(int dni) {
        cliente= clienteRepository.findById(dni).orElse(null);
       if(cliente!=null) {
           edad = cacularedad(cliente);
           ClienteDto clienteamostrar = new ClienteDto(cliente.getDni(), cliente.getNombre(), cliente.getApellido(), edad);
           return clienteamostrar;
       }
       return null;
    }

    @Override
    public List<ClienteDto> mostrarListaEdad() {
        copialista=clienteRepository.findAll();
        int finalLista = copialista.size();
        for(int i=0;i<finalLista;i++){
            cliente=copialista.get(i);
            edad=cacularedad(cliente);
            ClienteDto clienteamostrar = new ClienteDto(cliente.getDni(), cliente.getNombre(), cliente.getApellido(), edad);
            listaamostar.add(clienteamostrar);
        }
        return listaamostar;
    }

    private int cacularedad(Cliente cliente) {
        Date fecha= cliente.getFechanacimiento();
        String fechaString = fecha.toString();
        int anio = Integer.parseInt(fechaString.substring(0,4));
        int mes = Integer.parseInt(fechaString.substring(5,7));
        int dia = Integer.parseInt(fechaString.substring(8,10));
        int edad = Period.between(LocalDate.of(anio,mes,dia),LocalDate.now()).getYears();
        return edad;
    }


}
