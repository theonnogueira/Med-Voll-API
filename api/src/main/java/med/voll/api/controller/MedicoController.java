package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.endereco.Endereco;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.DoctorListingData;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {
    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid DadosCadastroMedico dados) {
        repository.save(new Medico(dados));

    }

    @GetMapping
    public Page<DoctorListingData> list(@PageableDefault(size = 10, sort = {"nome"}) Pageable pagination) {
    return repository.findAll(pagination).map(DoctorListingData::new);
    }
}
