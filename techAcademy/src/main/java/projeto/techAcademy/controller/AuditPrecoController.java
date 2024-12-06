package projeto.techAcademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projeto.techAcademy.dto.AuditPrecoRequestDTO;
import projeto.techAcademy.dto.ItemRequestDTO;
import projeto.techAcademy.model.AuditPreco;
import projeto.techAcademy.model.Item;
import projeto.techAcademy.repository.AuditPrecoRepository;
import projeto.techAcademy.repository.ItemRepository;

import java.util.List;

@RestController
@RequestMapping("/api/Auditpreco")
public class AuditPrecoController {
    @Autowired
    private AuditPrecoRepository repository;

    @GetMapping
    public ResponseEntity<List<AuditPreco>> findAll() {
        List<AuditPreco> auditPrecos = this.repository.findAll();
        return ResponseEntity.ok(auditPrecos);
    }

    @GetMapping("/{idAuditPreco}")
    public ResponseEntity<AuditPreco> findById(@PathVariable Integer idAuditPreco) {
        AuditPreco auditPreco = this.repository.findById(idAuditPreco)
                .orElseThrow(() -> new IllegalArgumentException("audit não foi encontrado"));
        return ResponseEntity.ok(auditPreco);
    }

}