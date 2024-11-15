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
@RequestMapping("/api/Auditprecoitem")
public class AuditPrecoController {
    @Autowired
    private AuditPrecoRepository repository;

    @GetMapping
    public ResponseEntity<List<AuditPreco>> findAll() {
        List<AuditPreco> auditPrecos = this.repository.findAll();
        return ResponseEntity.ok(auditPrecos);
    }

    @GetMapping("/{idAuditPrecoItem}")
    public ResponseEntity<AuditPreco> findById(@PathVariable Integer idAuditPrecoItem) {
        AuditPreco auditPreco = this.repository.findById(idAuditPrecoItem)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não foi encontrado"));
        return ResponseEntity.ok(auditPreco);
    }

    @PostMapping
    public ResponseEntity<AuditPreco> save(@RequestBody AuditPrecoRequestDTO dto) {
        if (dto.nome().isEmpty()) {
            return ResponseEntity.status(400).build();
        }

        AuditPreco auditPreco = new AuditPreco();
        auditPreco.setMotivo(dto.nome());

        this.repository.save(auditPreco);
        return ResponseEntity.ok(auditPreco);
    }

    @DeleteMapping("/{idAuditPrecoItem}")
    public ResponseEntity<Void> delete(@PathVariable Integer idAuditPreco) {
        AuditPreco auditPreco = this.repository.findById(idAuditPreco)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não foi encontrado"));

        this.repository.delete(auditPreco);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{idAuditPrecoItem}")
    public ResponseEntity<AuditPreco> update(@PathVariable Integer idAuditPrecoItem, @RequestBody AuditPrecoRequestDTO dto) {
        if (dto.nome().isEmpty()) {
            return ResponseEntity.status(400).build();
        }

        AuditPreco auditPreco = this.repository.findById(idAuditPrecoItem)
                .orElseThrow(() -> new IllegalArgumentException("Usuário não foi encontrado"));

        auditPreco.setMotivo(dto.nome());
        this.repository.save(auditPreco);
        return ResponseEntity.ok(auditPreco);
    }
}
