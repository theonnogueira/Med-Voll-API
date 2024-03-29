package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.paciente.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {
    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid DadosCadastroPaciente dados) {
        repository.save(new Paciente(dados));

    }
    @GetMapping
    public Page<PatientListingData> list(@PageableDefault(size = 10, sort = {"nome"}) Pageable pagination) {
        return repository.findAllByAtivoTrue(pagination).map(PatientListingData::new);
    }
    @PutMapping
    @Transactional
    public void toUpdate(@RequestBody @Valid DadosAtualizarPaciente dados) {
    var paciente = repository.getReferenceById(dados.id());
    paciente.atualizarInformacoes(dados);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public void delet(@PathVariable Long id) {
    var paciente = repository.getReferenceById(id);
    paciente.delet();
    }
}
