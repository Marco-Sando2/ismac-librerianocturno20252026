package com.distribuida.controler;

import ch.qos.logback.core.net.server.Client;
import com.distribuida.model.Cliente;
import com.distribuida.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

        @Autowired
    private ClienteService clienteService;

        @GetMapping
    public ResponseEntity<List<Cliente>> findAll() {
            List<Cliente> clientes = clienteService.findAll();
            return ResponseEntity.ok(clientes);
        }

        @GetMapping("/{id}")
    public ResponseEntity<Cliente> findOne(@PathVariable int id){
           Cliente cliente = clienteService.findOne(id);
        if (cliente == null){
            return ResponseEntity.notFound().build();
        }
            return ResponseEntity.ok(cliente);
        }

        @PostMapping
    public ResponseEntity<Cliente> save(@RequestBody Cliente cliente){
            Cliente cLienteNuevo=clienteService.save(cliente);
            return ResponseEntity.ok(cLienteNuevo);
        }

    @PutMapping("/{id}")
    public ResponseEntity <Cliente> update(@PathVariable int id, @RequestBody Cliente cliente){
        Cliente  clienteActulizado = clienteService.update(id, cliente);
        if (clienteActulizado == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(clienteActulizado);
    }

        @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
            clienteService.delete(id);
            return ResponseEntity.noContent().build();
        }

}
